CREATE TABLE estado
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 50 CACHE 1 ),
    sigla character varying(2) NOT NULL,
    nome character varying(50) NOT NULL,
    CONSTRAINT pk_estado PRIMARY KEY (id)
);

INSERT INTO estado(sigla,nome) VALUES('AC','ACRE');
INSERT INTO estado(sigla,nome) VALUES('AL','ALAGOAS');
INSERT INTO estado(sigla,nome) VALUES('AM','AMAZONAS');
INSERT INTO estado(sigla,nome) VALUES('AP','AMAPÁ');
INSERT INTO estado(sigla,nome) VALUES('BA','BAHIA');
INSERT INTO estado(sigla,nome) VALUES('BR','CONSELHO FEDERAL DE MEDICINA');
INSERT INTO estado(sigla,nome) VALUES('CE','CEARÁ');
INSERT INTO estado(sigla,nome) VALUES('DF','DISTRITO FEDERAL');
INSERT INTO estado(sigla,nome) VALUES('ES','ESPÍRITO SANTO');
INSERT INTO estado(sigla,nome) VALUES('GO','GOIÁS');
INSERT INTO estado(sigla,nome) VALUES('MA','MARANHÃO');
INSERT INTO estado(sigla,nome) VALUES('MG','MINAS GERAIS');
INSERT INTO estado(sigla,nome) VALUES('MS','MATO GROSSO DO SUL');
INSERT INTO estado(sigla,nome) VALUES('MT','MATO GROSSO');
INSERT INTO estado(sigla,nome) VALUES('PA','PARÁ');
INSERT INTO estado(sigla,nome) VALUES('PB','PARAÍBA');
INSERT INTO estado(sigla,nome) VALUES('PE','PERNAMBUCO');
INSERT INTO estado(sigla,nome) VALUES('PI','PIAUÍ');
INSERT INTO estado(sigla,nome) VALUES('PR','PARANÁ');
INSERT INTO estado(sigla,nome) VALUES('RJ','RIO DE JANEIRO');
INSERT INTO estado(sigla,nome) VALUES('RN','RIO GRANDE DO NORTE');
INSERT INTO estado(sigla,nome) VALUES('RO','RONDÔNIA');
INSERT INTO estado(sigla,nome) VALUES('RR','RORAIMA');
INSERT INTO estado(sigla,nome) VALUES('RS','RIO GRANDE DO SUL');
INSERT INTO estado(sigla,nome) VALUES('SC','SANTA CATARINA');
INSERT INTO estado(sigla,nome) VALUES('SE','SERGIPE');
INSERT INTO estado(sigla,nome) VALUES('SP','SÃO PAULO');
INSERT INTO estado(sigla,nome) VALUES('TO','TOCANTINS');

CREATE TABLE colaborador
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999999999 CACHE 1 ),
    registro character varying(25) NOT NULL,
    nome character varying(50) NOT NULL,
    CONSTRAINT pk_colaborador PRIMARY KEY (id)
);

CREATE TABLE estado_civil
(
    id int NOT NULL,
	nome varchar(10) not null,
	CONSTRAINT pk_estado_civil PRIMARY KEY (id)
);


CREATE TABLE pessoa_fisica
(
    id bigint NOT NULL,
    nascimento DATE NOT NULL,	
    genero char NOT NULL,	
	id_estado_civil int not null,
    nacionalidade char NOT NULL,		
	nascimento_exterior boolean not null,
	categoria char not null,	
    rg character varying(10),
	rg_expedicao date,
	rg_orgao character varying(50),	
    titulo character varying(50),
	titulo_zona character varying(10),
	titulo_secao character varying(10),	
    CONSTRAINT pk_pessoa_fisica PRIMARY KEY (id),
    CONSTRAINT fk_pessoa_fisica_colaborador FOREIGN KEY (id) REFERENCES colaborador(id)	,
    CONSTRAINT fk_pessoa_fisica_estado FOREIGN KEY (id_estado_civil) REFERENCES estado(id),	
    CONSTRAINT fk_pessoa_fisica_estado_civil FOREIGN KEY (id) REFERENCES estado_civil(id),	
    CONSTRAINT ck_pessoa_fisica_genero CHECK (genero in ('M','F','N')),
    CONSTRAINT ck_pessoa_fisica_categoria CHECK (categoria in ('C','M','V')),		
    CONSTRAINT ck_pessoa_fisica_nacionalidade CHECK (nacionalidade in ('B','N','E')),
    CONSTRAINT ck_pessoa_fisica_nascimento_ext CHECK ((nacionalidade = 'B' and nascimento_exterior = FALSE)or		
	                                                 (nacionalidade <> 'B' and nascimento_exterior = TRUE))
);

CREATE TABLE funcionario
(
    id bigint NOT NULL,
	matricula varchar(10) not null,
    admissao DATE NOT NULL,	
    desligamento DATE,
    CONSTRAINT pk_funcionario PRIMARY KEY (id),
    CONSTRAINT fk_funcionario_pessoa_fisica FOREIGN KEY (id) REFERENCES pessoa_fisica(id)	
);



CREATE TABLE pre_medico
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999999999 CACHE 1 ),
	id_estado int NOT NULL,
    registro character varying(25) NOT NULL,
    nome character varying(50) NOT NULL,
    nascimento DATE NOT NULL,	
    genero char NOT NULL,	
	id_estado_civil int not null,
    nacionalidade char NOT NULL,		
	nascimento_exterior boolean not null,
	categoria char not null,	
    rg character varying(10),
	rg_expedicao date,
	rg_orgao character varying(50),	
    titulo character varying(50),
	titulo_zona character varying(10),
	titulo_secao character varying(10),	
	
    CONSTRAINT pk_pre_medico PRIMARY KEY (id),
    CONSTRAINT fk_pre_medico_estado FOREIGN KEY (id_estado_civil) REFERENCES estado(id),	
    CONSTRAINT fk_pre_medico_estado_civil FOREIGN KEY (id) REFERENCES estado_civil(id),		
    CONSTRAINT ck_pre_medico_genero CHECK (genero in ('M','F','N')),
    CONSTRAINT ck_pre_medico_categoria CHECK (categoria in ('C','M','V')),	
    CONSTRAINT ck_pre_medico_nacionalidade CHECK (nacionalidade in ('B','N','E')),
    CONSTRAINT ck_pre_medico_nascimento_ext CHECK ((nacionalidade = 'B' and nascimento_exterior = FALSE)or		
	                                               (nacionalidade <> 'B' and nascimento_exterior = TRUE))	
);

CREATE TABLE pessoa_juridica
(
    id bigint NOT NULL,
	nome_fantasia character varying(100),
    CONSTRAINT pk_pessoa_juridica PRIMARY KEY (id),
    CONSTRAINT fk_pessoa_juridica_colaborador FOREIGN KEY (id) REFERENCES colaborador(id)	
);