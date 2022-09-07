--liquibase formatted sql
--changeset deal.orlando:FAC-118-02 logicalFilePath:FAC-118-02
--comment: Ajuste para execução dos scripts iniciais

CREATE TABLE facilitadoras.dbo.socios (

    id bigint IDENTITY(1,1) ,
    merchant_id bigint,
    nome varchar(100) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (merchant_id) REFERENCES merchant(id);
);
