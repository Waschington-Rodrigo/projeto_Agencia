/* Lógico_AgenciaViagens: */
CREATE DATABASE agenciaviagem;

use agenciaviagem;

CREATE TABLE Usuario (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    telefone VARCHAR(12),
    endereco VARCHAR(50),
    estado VARCHAR(15),
    cidade VARCHAR(40),
    email VARCHAR(40),
    nome VARCHAR(50),
    cpf VARCHAR(11),
    dataNascimento DATE
);

CREATE TABLE Hospedagem (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cidade VARCHAR(40),
    estado VARCHAR(15),
    tipo VARCHAR(30),
    valorDiaria FLOAT,
    endereco VARCHAR(50),
    telefone VARCHAR(12),
    nome VARCHAR(40)
);

CREATE TABLE Destino (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cidade VARCHAR(30),
    estado VARCHAR(15),
    localDestino VARCHAR(40)
    
);

CREATE TABLE Passagem (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pacotePromo INT,
    dataViagem DATE,
    fk_Usuario_id INT,
    fk_Destino_id INT
);

CREATE TABLE Reserva (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    qtdDias INT,
    dataReserva DATE,
    fk_Hospedagem_id INT,
    fk_Usuario_id INT,
    pacotePromo INT,
    valorTotal FLOAT
);
 
ALTER TABLE Passagem ADD CONSTRAINT FK_Usuario_Passagem
    FOREIGN KEY (fk_Usuario_id)
    REFERENCES Usuario (id)
    ON DELETE SET NULL;
 
ALTER TABLE Passagem ADD CONSTRAINT FK_Destino_Passagem
    FOREIGN KEY (fk_Destino_id)
    REFERENCES Destino (id)
    ON DELETE SET NULL;
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Usuario_Reserva
    FOREIGN KEY (fk_Usuario_id)
    REFERENCES Usuario (id)
    ON DELETE SET NULL;
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Hospedagem_Reserva
    FOREIGN KEY (fk_Hospedagem_id)
    REFERENCES Hospedagem (id)
    ON DELETE SET NULL;