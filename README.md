# Spacex (exemplo de integração com spring-boot e postgres)

### Iniciando o postgres

```cmd
docker run -d -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=postgres postgres:9.6.11
docker exec -it postgres bash
```

```sql
-- Inclusão de base
create database spacex;

-- Inclusão de tabelas
CREATE TABLE pessoa
( id bigserial NOT NULL,
nome character varying(100) NOT NULL,
datanascimento date,
cpf character varying(14),
funcionario boolean,
CONSTRAINT pk_pessoa PRIMARY KEY (id));

CREATE TABLE projeto (
id bigserial NOT NULL,
nome VARCHAR(200) NOT NULL,
data_inicio DATE ,
data_previsao_fim DATE ,
data_fim DATE ,
descricao VARCHAR(5000) ,
status VARCHAR(45) ,
orcamento FLOAT ,
risco VARCHAR(45) ,
idgerente bigserial NOT NULL,
CONSTRAINT pk_projeto PRIMARY KEY (id),
CONSTRAINT fk_gerente FOREIGN KEY (idgerente)
REFERENCES pessoa (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION);

INSERT INTO public.projetos
(nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco)
VALUES('Projeto X', '2020-06-06', '2021-06-06', null, 
'Projeto destinado ao entendimento do universo', 'INICIADO', 100000.00, 'ALTO_RISCO');

CREATE TABLE membros
( idprojeto bigserial NOT NULL,
idpessoa bigint NOT NULL,
CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto),
CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa)
REFERENCES projeto (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT fk_pessoa FOREIGN KEY (idpessoa)
REFERENCES pessoa (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION);

INSERT INTO public.membros
(idpessoa, idprojeto )
VALUES(1,1);
```

```sql
-- Popular a base
INSERT INTO public.pessoa
(nome, datanascimento, cpf, funcionario)
VALUES('Judith Miranda', '1990-09-28', '111.111.111-11', true);
INSERT INTO public.pessoa
(nome, datanascimento, cpf, funcionario)
VALUES('João Pedro', '1980-01-15', '222.222.222-22', false);
INSERT INTO public.pessoa
(nome, datanascimento, cpf, funcionario)
VALUES('Mariaza de Souza', '1992-01-14', '333.333.333-33', true);

INSERT INTO public.projeto
(nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco, idgerente)
VALUES('Projeto X', '2020-06-06', '2021-06-06', null, 'Projeto destinado ao entendimento do universo', 
'INICIADO', 10000000, 'BAIXO_RISCO', 3);

INSERT INTO public.membros
(idpessoa, idprojeto )
VALUES(1, 1);
```

### Iniciando o app