CREATE TABLE note(
    id int PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(1000) NOT NULL,
    content VARCHAR(1000) NOT NULL);

CREATE TABLE users (
username VARCHAR(50) NOT NULL PRIMARY KEY,
password VARCHAR(100) NOT NULL,
enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
username VARCHAR(50) NOT NULL,
authority VARCHAR(50) NOT NULL,
CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

INSERT INTO users (username, password, enabled) VALUES (
'user',
'$2a$10$HdsVRMWt4DVlsLdanDQkvefBhOCgmfhblDiqHZknI2hJS7rWEk.nO',
true
);
                                                       );


INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
