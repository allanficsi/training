INSERT INTO sc_usr.tbl_usr(cd_usr, usr_nome,usr_email,usr_senha) VALUES(1,'Aluno', 'aluno@email.com', '123456');

INSERT INTO sc_crs.tbl_crs(cd_crs, crs_nome,crs_categoria) VALUES(1,'Spring Boot', 'Programação');
INSERT INTO sc_crs.tbl_crs(cd_crs, crs_nome,crs_categoria) VALUES(2,'HTML 5', 'Front-end');

INSERT INTO sc_tpc.tbl_tpc(cd_tpc, tpc_ttl, tpc_msg, dt_crc, stt_tpc, cd_usr, cd_crs) VALUES(1,'Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO sc_tpc.tbl_tpc(cd_tpc, tpc_ttl, tpc_msg, dt_crc, stt_tpc, cd_usr, cd_crs) VALUES(2,'Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO sc_tpc.tbl_tpc(cd_tpc, tpc_ttl, tpc_msg, dt_crc, stt_tpc, cd_usr, cd_crs) VALUES(3,'Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);