package com.dev.achou_plataforma.entity.enums;

public enum Category {
    // Serviços e Manutenção Residencial
    PLUMBER("PLUMBER"),
    ELECTRICIAN("ELECTRICIAN"),
    MASON("MASON"),
    PAINTER("PAINTER"),
    CLEANER("CLEANER"),
    GARDENER("GARDENER"),

    // Tecnologia e Digital
    DEVELOPER("DEVELOPER"),
    DESIGNER("DESIGNER"),
    TECHNICAL_SUPPORT("TECHNICAL_SUPPORT"),
    DIGITAL_MARKETING("DIGITAL_MARKETING"),

    // Saúde, Bem-estar e Beleza
    CAREGIVER("CAREGIVER"),
    PERSONAL_TRAINER("PERSONAL_TRAINER"),
    HAIRDRESSER("HAIRDRESSER"),
    MANICURIST("MANICURIST"),
    MASSAGE_THERAPIST("MASSAGE_THERAPIST"),

    // Educação e Consultoria
    PRIVATE_TUTOR("PRIVATE_TUTOR"),
    CONSULTANT("CONSULTANT"),
    TRANSLATOR("TRANSLATOR"),

    // Automotivo
    MECHANIC("MECHANIC"),
    TOW_TRUCK("TOW_TRUCK"),

    // Outro
    OTHER("OTHER");

    final String name;
    Category(String name){
        this.name = name;
    }
}

