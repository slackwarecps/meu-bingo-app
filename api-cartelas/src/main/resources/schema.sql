-- src/main/resources/schema.sql
-- CREATE TABLE cartelas (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     nome VARCHAR(255) NOT NULL
-- );

DROP TABLE IF EXISTS cartelas;
CREATE TABLE cartelas(ID INT PRIMARY KEY, NOME VARCHAR(255));
