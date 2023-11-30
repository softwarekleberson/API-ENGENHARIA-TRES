CREATE TABLE cartoes (
  id BIGINT NOT NULL AUTO_INCREMENT,
  principal BOOLEAN NOT NULL,
  nome_impresso VARCHAR(255) NOT NULL,
  codigo VARCHAR(4) NOT NULL,
  numero_cartao VARCHAR(16) NOT NULL,
  bandeira VARCHAR(500) DEFAULT 'UNSPECIFIED', -- Change data type to VARCHAR(500)
  clientes_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT clientes_id_fk FOREIGN KEY (clientes_id) REFERENCES clientes (id)
);
