--liquibase formatted sql
--changeset deal.orlando:FAC-118-02 logicalFilePath:FAC-118-02
--comment: Ajuste para execução dos scripts iniciais

ALTER TABLE facilitadoras.dbo.merchant(

ALTER COLUMN socios (bigint FOREIGN KEY REFERENCES socios(id) )

);
