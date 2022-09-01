--liquibase formatted sql
--changeset jaderdev-travelexbank:historico-moedas logicalFilePath:1.0.0/historico-moedas.sql
--comment: Ajuste para execução dos scripts iniciais

if not exists (select * from sysobjects where name='historico_moedas' and xtype='U')
    create table historico_moedas (
        id bigint identity(1,1) not null,
        abe varchar(10),
        cod varchar(10) not null,
        codg varchar(10),
        dsc varchar(64),
        fec varchar(10),
        ho2 varchar(10),
        hrf varchar(64),
        hrs varchar(64),
        nom varchar(64),
        ocp varchar(10),
        ovd varchar(10),
        ult varchar(10),
        var varchar(10),
        data_hora varchar(64) not null,
    )
go