CREATE DATABASE FitZoneStudio;
USE FitZoneStudio;

CREATE TABLE Administradores(
			 codigo INT(8) PRIMARY KEY,
             nome VARCHAR(50),
             cpf VARCHAR(50),
             dta_nascimento DATE,
             telefone VARCHAR(50),
             email VARCHAR(50),
             sexo VARCHAR(20),
             estado VARCHAR(50),
             cidade VARCHAR(50),
             cep VARCHAR(50),
             bairro VARCHAR(50),
             complemento VARCHAR(50));
             
CREATE TABLE Atendentes(
			 codigo INT(8) PRIMARY KEY,
             nome VARCHAR(50),
             cpf VARCHAR(50),
             rg VARCHAR(50),
             dta_nascimento DATE,
             telefone VARCHAR(50),
             email VARCHAR(50),
             sexo VARCHAR(20),
             salario DECIMAL(10,2),
             situacao VARCHAR(20),
             estado VARCHAR(50),
             cidade VARCHAR(50),
             cep VARCHAR(50),
             bairro VARCHAR(50),
             complemento VARCHAR(50));
             
CREATE TABLE Instrutores(
			 codigo INT(8) PRIMARY KEY,
             nome VARCHAR(50),
             cpf VARCHAR(50),
             rg VARCHAR(50),
             dta_nascimento DATE,
             telefone VARCHAR(50),
             email VARCHAR(50),
             sexo VARCHAR(20),
             salario DECIMAL(10,2),
             situacao VARCHAR(20),
             estado VARCHAR(50),
             cidade VARCHAR(50),
             cep VARCHAR(50),
             bairro VARCHAR(50),
             complemento VARCHAR(50));
             
CREATE TABLE Alunos(
			 matricula INT(8) PRIMARY KEY,
             nome VARCHAR(50),
             cpf VARCHAR(50),
             dta_nascimento DATE,
             dta_matricula DATE,
             telefone VARCHAR(50),
             email VARCHAR(50),
             sexo VARCHAR(20),
             situacao VARCHAR(20),
             estado VARCHAR(50),
             cidade VARCHAR(50),
             cep VARCHAR(50),
             bairro VARCHAR(50),
             complemento VARCHAR(50));

CREATE TABLE Planos(
			 id INT PRIMARY KEY AUTO_INCREMENT,
             nome VARCHAR(50),
             duracao VARCHAR(50),
             valor DECIMAL(10,2));
             
CREATE TABLE Mensalidades(
             id INT PRIMARY KEY AUTO_INCREMENT,
             dta_pagamento DATE,
             dta_vencimento DATE,
             situacao CHAR(20),
             matricula INT(8),
             id INT,
             FOREIGN KEY (matricula) REFERENCES Alunos (matricula),
             FOREIGN KEY (id) REFERENCES Planos (id));
             
CREATE TABLE Treinos(
			id INT PRIMARY KEY AUTO_INCREMENT,
            nome VARCHAR(50),
            exercicios VARCHAR(100),
            grupo_muscular VARCHAR(100),
            series INT(20),
            repeticoes INT(20),
            matricula INT(8),
            FOREIGN KEY (matricula) REFERENCES Alunos (matricula));
            
CREATE TABLE Aulas(
             id INT PRIMARY KEY AUTO_INCREMENT,
             modalidade VARCHAR(50),
             horario TIME,
             dia ENUM('SEG','TER','QUA','QUI','SEX','SAB'),
             codigo INT(8),
             FOREIGN KEY (codigo) REFERENCES Instrutores (codigo));

CREATE TABLE Turmas(
			 id INT PRIMARY KEY AUTO_INCREMENT,
             nome VARCHAR(50),
             dta_inicio DATE,
             id INT,
             FOREIGN KEY (id) REFERENCES Aulas (id));
             
CREATE TABLE Despesas(
		     id INT PRIMARY KEY AUTO_INCREMENT,
             descricao VARCHAR(50),
             dta_pagamento DATE,
             valor DECIMAL(10,2));