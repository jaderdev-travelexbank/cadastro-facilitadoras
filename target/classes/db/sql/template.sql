--liquibase formatted sql
--changeset jaderdev-travelexbank:template logicalFilePath:template.sql
--comment: Ajuste para execução dos scripts iniciais

select * from databaseChangelog;