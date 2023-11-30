CREATE TABLE cobrancas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  logradouro VARCHAR(255) NOT NULL,
  numero VARCHAR(255) NOT NULL,
  bairro VARCHAR(255) NOT NULL,
  cep VARCHAR(20) NOT NULL,
  observacao VARCHAR(255),
  tipo_logradouro VARCHAR(255) NOT NULL,
  tipo_residencia VARCHAR(255) NOT NULL,
  cidade VARCHAR(255) NOT NULL,
  estado VARCHAR(255) NOT NULL,
  pais VARCHAR(255) NOT NULL,
  clientes_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (clientes_id) REFERENCES clientes (id)
);

