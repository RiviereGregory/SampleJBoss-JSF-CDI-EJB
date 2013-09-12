USE jeedatabase;

CREATE TABLE users (nom VARCHAR(255) NOT NULL , password VARCHAR(255),enabled BOOLEAN ,PRIMARY KEY (nom));
CREATE TABLE roles (nom VARCHAR(255) NOT NULL , role VARCHAR(255),PRIMARY KEY (nom,role));
ALTER TABLE roles ADD CONSTRAINT fk_roles_user_nom FOREIGN KEY (nom) REFERENCES users (nom);

INSERT INTO users (nom , password,enabled) VALUES ('user','user',true),('admin','admin',true);
INSERT INTO roles (nom , role) VALUES ('user','ROLE_USER'),('admin','ROLE_USER'),('admin','ROLE_ADMIN');