--liquibase formatted sql
--changeset deal.orlando:FAC-118-00 logicalFilePath:FAC-118-00
--comment: Ajuste para execução dos scripts iniciais

--comment:TABELA PAÍS REGISTRO
CREATE TABLE facilitadoras.dbo.pais_registro (

    id bigint IDENTITY(1,1) ,
    descricao varchar(100) NOT NULL
);

--comment: FOREIGN KEY PAÍS REGISTRO
ALTER TABLE facilitadoras.dbo.pais_registro add constraint "PK_paisRegistro_id" primary key (id);

--TABELA STATUS
CREATE TABLE facilitadoras.dbo.status (

    id bigint IDENTITY(1,1),
    descricao varchar(100) NOT NULL,
    status varchar(100),
    data datetime
);

--comment: FOREIGN KEY STATUS
ALTER TABLE facilitadoras.dbo.status add constraint "PK_status_id" primary key (id);

--comment: TABELA CATEGORIA
CREATE TABLE facilitadoras.dbo.categoria (

    id bigint IDENTITY(1,1) ,
    descricao varchar(100) NOT NULL
);

--comment: FOREIGN KEY CATEGORIA
ALTER TABLE facilitadoras.dbo.categoria add constraint "PK_categoria_id" primary key (id);


--comment: TABELA NOTORIEDADE
CREATE TABLE facilitadoras.dbo.notoriedade (

    id bigint IDENTITY(1,1) ,
    descricao varchar(100) NOT NULL
);

--comment: FOREIGN KEY NOTORIEDADE
ALTER TABLE facilitadoras.dbo.notoriedade add constraint "PK_notoriedade_id" primary key (id);


--comment: TABELA MERCHANT
CREATE TABLE facilitadoras.dbo.merchant (
    id bigint IDENTITY(1,1) ,
    nome_fantasia varchar(100) NOT NULL,
    nome_registro varchar(100) NOT NULL,
    pais_registro bigint FOREIGN KEY REFERENCES pais_registro(id),
    url varchar(100) NOT NULL,
    categoria bigint FOREIGN KEY REFERENCES categoria(id),
    notoriedade bigint FOREIGN KEY REFERENCES notoriedade(id),
    nif varchar(100),
    telefone varchar(20),
    email varchar(50),
    socios varchar(300),
    status bigint FOREIGN KEY REFERENCES status(id),
    facilitadora bigint FOREIGN KEY REFERENCES facilitadoras(id),
    data_hora smalldatetime not null,
    lista_restritiva varchar(100),
    limite varchar(100),
    grau_risco varchar(100),
    tempo_validade_cadastro varchar(100)
);
--comment: FOREIGN KEY MERCHANT
ALTER TABLE facilitadoras.dbo.merchant add constraint "PK_merchant_id" primary key (id);

