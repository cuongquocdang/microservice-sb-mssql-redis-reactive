CREATE TABLE sessions
(
    "id"                 BIGINT      NOT NULL IDENTITY(1,1) PRIMARY KEY,
    "session_id"         VARCHAR(36) NOT NULL UNIQUE
);

CREATE INDEX idx_sessions_session_id ON sessions (session_id);