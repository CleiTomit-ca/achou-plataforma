# Requisitos — Achou! Plataforma de Agendamento de Serviços Locais

## 1. Visão geral

O Achou! é uma plataforma onde **clientes** encontram e agendam horários com **prestadores de serviço** (eletricista, diarista, manicure, etc.), com confirmação, cancelamento e avaliação pós-atendimento.

## 2. Atores

| Ator | Descrição |
|---|---|
| **Cliente** | Busca prestadores, agenda serviços, avalia atendimentos |
| **Prestador** | Cadastra serviços e disponibilidade, gerencia seus agendamentos |
| **Admin** | Modera cadastros e resolve disputas |

## 3. Requisitos Funcionais (RF)

### Autenticação e conta
- **RF01** — O sistema deve permitir cadastro de Usuario com papel CLIENTE ou PRESTADOR.
- **RF02** — O sistema deve autenticar via login (email/senha) e retornar um token JWT.
- **RF03** — O sistema deve restringir cada endpoint conforme o papel do usuário autenticado.

### Prestador
- **RF04** — O Prestador deve poder criar, editar e remover Servicos que oferece (nome, descrição, duração, preço).
- **RF05** — O Prestador deve poder cadastrar sua Disponibilidade (dias/horários em que atende).
- **RF06** — O Prestador deve poder visualizar os Agendamentos recebidos.
- **RF07** — O Prestador deve poder confirmar ou recusar um Agendamento pendente.

### Cliente
- **RF08** — O Cliente deve poder consultar os horários disponíveis de um Prestador para um Servico.
- **RF09** — O Cliente deve poder criar um Agendamento em um horário disponível.
- **RF10** — O Cliente deve poder cancelar um Agendamento antes da data marcada.
- **RF11** — O Cliente deve poder avaliar (nota + comentário) um Agendamento com status CONCLUIDO.

### Regras de conflito
- **RF12** — O sistema não deve permitir dois Agendamentos para o mesmo Prestador no mesmo horário.
- **RF13** — Uma Avaliacao só pode ser criada se o Agendamento correspondente estiver CONCLUIDO.

## 4. Requisitos Não Funcionais (RNF)

- **RNF01** — Autenticação stateless via JWT (sem sessão em servidor).
- **RNF02** — Consultas de disponibilidade devem usar cache (Redis) para reduzir carga no banco.
- **RNF03** — A criação de Agendamento deve ser protegida contra condição de corrida (lock distribuído no Redis).
- **RNF04** — O ambiente completo (API, Postgres, Redis) deve subir com um único comando via Docker Compose.
- **RNF05** — Todo o schema do banco deve ser versionado via Flyway — proibido uso de `ddl-auto: update` em produção.
- **RNF06** — O código deve manter cobertura de testes nas regras de negócio críticas (conflito de horário, regra de avaliação).
- **RNF07** — Todo push deve disparar pipeline (Jenkins) com build, testes e análise de qualidade (SonarQube), com Quality Gate obrigatório.
- **RNF08** — A aplicação deve ser publicada em ambiente de produção (Railway), com configuração externa por ambiente (Spring Cloud Config).
- **RNF09** — Erros de autenticação/autorização devem retornar 401/403 com corpo de erro padronizado (sem stack trace exposto).

## 5. Regras de negócio (resumo)

| Regra | Descrição |
|---|---|
| RN01 | Um Prestador não pode ter dois Agendamentos sobrepostos no mesmo horário |
| RN02 | Um Agendamento só pode ser avaliado se `status = CONCLUIDO` |
| RN03 | Só o Cliente dono do Agendamento pode avaliá-lo |
| RN04 | Só o Prestador dono do Servico pode editar/remover esse Servico |
| RN05 | Um Agendamento cancelado libera o horário para novo agendamento |

## 6. Fora de escopo (v1)

- Pagamento online (fica para uma fase futura)
- Chat entre cliente e prestador
- Notificações push/e-mail (pode entrar como evolução do domínio de Notificações via Spring Cloud/mensageria)
