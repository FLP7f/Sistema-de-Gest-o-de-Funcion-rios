CREATE DATABASE IF NOT EXISTS gestao_funcionarios
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_0900_ai_ci;

USE gestao_funcionarios;

CREATE TABLE IF NOT EXISTS funcionarios (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    ano_nascimento INT NOT NULL,
    cargo VARCHAR(30) NOT NULL,
    salario DOUBLE NOT NULL,
    saldo_inicial DOUBLE DEFAULT 0,
    saldo_fechamento DOUBLE DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;