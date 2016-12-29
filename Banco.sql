create database zsuperBD;

CREATE TABLE login
(
  id serial NOT NULL,
  nome character varying(36) NOT NULL,
  senha character varying(36) NOT NULL,
  CONSTRAINT login_pkey PRIMARY KEY (id)
);
CREATE TABLE cliente
(
  codigo serial NOT NULL,
  nome character varying(36) NOT NULL,
  senha character varying(36) NOT NULL,
  CONSTRAINT cliente_pkey PRIMARY KEY (codigo)
);
CREATE TABLE produto
(
  codigo serial NOT NULL,
  codigo_adm integer NOT NULL,
  descricao character varying(40) NOT NULL,
  preco double precision NOT NULL,
  promocao character varying(5),
  CONSTRAINT produto_pkey PRIMARY KEY (codigo),
  CONSTRAINT produto_codigo_adm_fkey FOREIGN KEY (codigo_adm)
      REFERENCES login (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE mercado
(
  codigo serial NOT NULL,
  nome character varying(50) NOT NULL,
  codigo_adm integer NOT NULL,
  endereco character varying(50) NOT NULL,
  CONSTRAINT mercado_pkey PRIMARY KEY (codigo),
  CONSTRAINT mercado_codigo_adm_fkey FOREIGN KEY (codigo_adm)
      REFERENCES login (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE carrinho
(
  codigocarrinho serial NOT NULL,
  codigo_produto integer,
  codigo_cliente integer,
  valor_total double precision,
  CONSTRAINT carrinho_pkey PRIMARY KEY (codigocarrinho),
  CONSTRAINT carrinho_codigo_cliente_fkey FOREIGN KEY (codigo_cliente)
      REFERENCES cliente (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT carrinho_codigo_produto_fkey FOREIGN KEY (codigo_produto)
      REFERENCES produto (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);