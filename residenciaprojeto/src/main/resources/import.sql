INSERT INTO tb_clinica(nome, cnpj, telefone, email, endereco) VALUES ('Clinica do tio Helyon', '000-000', '8888-9999','TitioSalva@gmail.com', 'Rua do Talvez');
INSERT INTO tb_clinica(nome, cnpj, telefone, email, endereco) VALUES ('Clinica do tio Junior', '111-111', '9999-8888','SalvaReclamando@gmail.com', 'Rua da Reclamacao');

INSERT INTO tb_medico(clinica_id, nome, sexo, telefone, nascimento, cpf, email, endereco) VALUES (1, 'Joaquina','f','0000-0000', '1990-10-10','000.000.000-00', 'Joaquina@gmail.com', 'Rua do nunca');
INSERT INTO tb_medico(clinica_id, nome, sexo, telefone, nascimento, cpf, email, endereco) VALUES (2, 'Lord Vader','m','1111-1111', '1990-05-05','111.111.111-11', 'Vader@gmail.com', 'EstrelaDaMorte');

INSERT INTO tb_paciente(nome, email, cpf, telefone, nascimento, endereco) VALUES ('Maria', 'Maria@gmail.com', '999.999.999-99','5555-6666', '1992-08-09', 'Rua do sempre');
INSERT INTO tb_paciente(nome, email, cpf, telefone, nascimento, endereco) VALUES ('Evertina', 'Evertina@gmail.com', '888.888.888-88','4321-8765', '1992-07-03', 'Rua do Pastel');
INSERT INTO tb_paciente(nome, email, cpf, telefone, nascimento, endereco) VALUES ('Fabiola', 'Fabiola@gmail.com', '777.777.777-77','1234-5678', '1994-02-04', 'Rua do quemsabe');




