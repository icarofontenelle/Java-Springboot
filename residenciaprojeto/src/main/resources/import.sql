INSERT INTO tb_clinic(name, cnpj, phone, email, address, deleted) VALUES ('Clinica da Mulher', '000-000', '(00)0000-0000', 'clinicadamulher@gmail.com', 'Rua do nunca', 'false');
INSERT INTO tb_doctor(name, crm, phone, email, clinic_id, deleted) VALUES ('Manuela', '00000000-0-BR', '(11)1111-1111', 'manuela@gmail.com', 1, 'false');
INSERT INTO tb_patient(name, password, cpf, address, phone, email, deleted) VALUES ('Marcovina', '123456', '000.000.000-00','Rua do Nunca','(22)2222-2222', 'marcovina@gmail.com', 'false');

