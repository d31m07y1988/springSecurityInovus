--DELETE FROM user_roles;
--DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- user
INSERT INTO users (login, password)
VALUES ('User', 'ba036d99c58a0bd2ebbc14d62e12abbabcca3143');
-- Zaq12wsx

-- admin
INSERT INTO users (login, password)
VALUES ('Admin', 'cc9f816a42431cf852cdc7a3fad42a6f65ffce24');
-- Qwerty123

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);