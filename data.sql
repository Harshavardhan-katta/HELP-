-- Default Agents with BCrypt passwords

INSERT INTO agents (username, password, role)
VALUES ('agent1', '$2a$10$Dow1uPvS8N1bK9GXlAx7Ou9wxW13JW.S9qVafN5F35trX2wNqG8Mu', 'ROLE_AGENT');

INSERT INTO agents (username, password, role)
VALUES ('agent2', '$2a$10$bpXNk6K0D5zq0kdTxrwPQONhmSz7N7cF.C.IZ.gboPpCk1v48Tv3O', 'ROLE_AGENT');

INSERT INTO agents (username, password, role)
VALUES ('admin', '$2a$10$g0YkEsXIpOJXjKZtH6t7Se5/axr6VObHgi0UIIBbGS2M28bm6rXAi', 'ROLE_ADMIN');
