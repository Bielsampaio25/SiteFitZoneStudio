CREATE DATABASE FitZoneStudio;
USE FitZoneStudio;

CREATE TABLE Administradores(
			 codigo INT PRIMARY KEY AUTO_INCREMENT,
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
             
CREATE TABLE Funcionarios(
	         codigo INT PRIMARY KEY AUTO_INCREMENT,
             nome VARCHAR(50),
             cpf VARCHAR(50),
             rg VARCHAR(50),
             dta_nascimento DATE,
             telefone VARCHAR(50),
             email VARCHAR(50),
             sexo VARCHAR(20),
             cargo VARCHAR(50),
             salario DECIMAL(10,2),
             situacao VARCHAR(20),
             dta_admissao DATE,
             turno VARCHAR(20),
             estado VARCHAR(50),
             cidade VARCHAR(50),
             cep VARCHAR(50),
             bairro VARCHAR(50),
             endereco VARCHAR(100),
             numero VARCHAR(20),
             complemento VARCHAR(50),
             nome_usuario VARCHAR(50),
             senha VARCHAR(50));
             
CREATE TABLE Alunos(
			 matricula INT PRIMARY KEY AUTO_INCREMENT,
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
			 id_plano INT PRIMARY KEY AUTO_INCREMENT,
             nome VARCHAR(50),
             duracao VARCHAR(50),
             valor DECIMAL(10,2));
             
CREATE TABLE Mensalidades(
             id_mensalidade INT PRIMARY KEY AUTO_INCREMENT,
             dta_pagamento DATE,
             dta_vencimento DATE,
             situacao CHAR(20),
             matricula INT(8),
             id_plano INT,
             FOREIGN KEY (matricula) REFERENCES Alunos (matricula),
             FOREIGN KEY (id_plano) REFERENCES Planos (id_plano));
             
CREATE TABLE Treinos(
			id_treino INT PRIMARY KEY AUTO_INCREMENT,
            nome VARCHAR(50),
            exercicios VARCHAR(100),
            grupo_muscular VARCHAR(100),
            series INT(20),
            repeticoes INT(20),
            matricula INT(8),
            FOREIGN KEY (matricula) REFERENCES Alunos (matricula));
            
CREATE TABLE Aulas(
             id_aula INT PRIMARY KEY AUTO_INCREMENT,
             modalidade VARCHAR(50),
             horario TIME,
             dia ENUM('SEG','TER','QUA','QUI','SEX','SAB'),
             codigo INT(8),
             FOREIGN KEY (codigo) REFERENCES Funcionarios (codigo));

CREATE TABLE Turmas(
			 id_turma INT PRIMARY KEY AUTO_INCREMENT,
             nome VARCHAR(50),
             dta_inicio DATE,
             id_aula INT,
             FOREIGN KEY (id_aula) REFERENCES Aulas (id_aula));
             
CREATE TABLE Despesas(
		     id_despesa INT PRIMARY KEY AUTO_INCREMENT,
             descricao VARCHAR(50),
             dta_pagamento DATE,
             valor DECIMAL(10,2));
             
DELIMITER //

CREATE TRIGGER gerar_codigo_funcionario
BEFORE INSERT ON funcionarios
FOR EACH ROW
BEGIN
    SET NEW.codigo = LPAD(FLOOR(RAND() * 10000000), 7, '0');
END //

DELIMITER ;