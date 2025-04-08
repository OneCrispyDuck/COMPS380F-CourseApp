CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles(
    user_roles_id INTEGER GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(50) NOT NULL,
      role VARCHAR(50) NOT NULL,
      PRIMARY KEY (user_role_id),
      FOREIGN KEY (username) REFERENCES users(username)
);

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles (
  user_role_id INTEGER GENERATED ALWAYS AS IDENTITY,
  username VARCHAR(50) NOT NULL,
  role VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_role_id),
  FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users VALUES ('keith', '{noop}keithpw');
INSERT INTO user_roles(username, role) VALUES ('keith', 'ROLE_ADMIN');