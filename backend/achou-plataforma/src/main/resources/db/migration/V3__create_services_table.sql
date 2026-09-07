CREATE TABLE services (
    id UUID PRIMARY KEY,
    provider_profile_id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(150) NOT NULL,
    duration_minutes INT DEFAULT 0,
    price DECIMAL(10, 2) NOT NULL,

    CONSTRAINT uq_provider_profile_id UNIQUE (provider_profile_id),
    CONSTRAINT fk_provider_profile_id FOREIGN KEY (provider_profile_id)
        REFERENCES provider_profile (id) ON DELETE CASCADE
)