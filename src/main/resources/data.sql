CREATE TABLE IF NOT EXISTS PESSOA
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR,
    matricula INTEGER,
    endereco  VARCHAR,
    curso     VARCHAR
);


insert into PESSOA (nome, matricula, endereco, curso)
values ('Antony William', '33323233', 'Avendia Rio Grando do Sul', 'Sistemas para Internet');