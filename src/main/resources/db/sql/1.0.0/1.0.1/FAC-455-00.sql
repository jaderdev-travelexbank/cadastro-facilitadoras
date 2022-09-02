--liquibase formatted sql
--changeset deal.msiqueira:FAC-455-00 logicalFilePath:FAC-455-00
--comment: Ajuste para execução dos scripts iniciais

--create table log
CREATE TABLE facilitadoras.dbo.log (
    id int IDENTITY(1,1) ,
    tipo_consulta varchar(200) NOT NULL,
    data_consulta datetime NOT NULL,
    usuario varchar(200),
    sistema varchar(200),
    request varchar(max) NOT NULL,
    response varchar(max) NOT NULL,
);
alter table facilitadoras.dbo.log add constraint "PK_log_id" primary key (id);

--create table facilitadoras
    CREATE TABLE facilitadoras.dbo.facilitadoras (
    id bigint identity(1,1) NOT NULL,
    nome_fantasia varchar(200) NOT NULL,
    nome_registro varchar(200) NOT NULL,
    documento varchar(200) NOT NULL,
    ativo bit NOT NULL default 0 ,
    data_alteracao datetime NOT NULL,
    usuario varchar(200) NOT NULL
);
alter table facilitadoras.dbo.facilitadoras add constraint "PK_facilitadoras_id" primary key (id);

--create table moeda
create table facilitadoras.dbo.moedas (
   id bigint identity(1,1) NOT NULL,
   nome varchar(50) NOT NULL,
   descricao varchar(200) NOT NULL,
   codigo varchar(50) NOT NULL,
   unique_symbols_cod varchar(50) NOT NULL,
   ativo bit NOT NULL default 0
);
alter table facilitadoras.dbo.moedas add constraint "PK_moedas_id" primary key (id);

--create table deflator
CREATE TABLE facilitadoras.dbo.deflator (
    id bigint IDENTITY(1,1) ,
    id_moeda bigint NOT NULL,
    ativo bit NOT NULL default 0 ,
    usuario_alteracao varchar(200) NOT NULL,
    data_alteracao datetime NOT NULL,
    compra decimal(10,6) NOT NULL,
    venda decimal(10,6) NOT NULL
);
alter table facilitadoras.dbo.deflator add constraint "PK_deflator_id" primary key (id);
alter table facilitadoras.dbo.deflator add constraint "PK_deflator_id_moeda" foreign key (id_moeda) references moedas(id);
