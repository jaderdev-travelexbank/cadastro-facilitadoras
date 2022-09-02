--liquibase formatted sql
--changeset deal.msiqueira:template logicalFilePath:template
--comment: Ajuste para execução dos scripts iniciais

select * from databaseChangelog;