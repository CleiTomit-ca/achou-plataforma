CREATE TABLE provider_profile (
    id UUID PRIMARY KEY,
    user_id UUID PRIMARY KEY,
    bio TEXT NOT NULL,
    category VARCHAR(100) NOT NULL,
    city VARCHAR(150) NOT NULL,
    average_rating decimal(3, 2) NOT NULL DEFAULT 0,

    CONSTRAINT uq_provider_profiles_user_id UNIQUE (user_id),
    CONSTRAINT fk_provider_profiles_user_id FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE CASCADE
)