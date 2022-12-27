INSERT INTO tb_user (`id`, `username`, `password`, `algorithm`, role)
VALUES ('1', 'john', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT', 'ROLE_ADMIN');
INSERT INTO tb_user (`id`, `username`, `password`, `algorithm`, role)
VALUES ('2', 'jane', '$2a$12$WrRwIpUC5towxz6eTBCEC.T38Ig.0NzsOrTNTYEYHlfezXss6SC3u', 'BCRYPT', 'ROLE_MANAGER');

INSERT INTO authority (`id`, `name`, `user_id`) VALUES ('1', 'READ', '1');
INSERT INTO authority (`id`, `name`, `user_id`) VALUES ('2', 'WRITE', '1');
INSERT INTO authority (`id`, `name`, `user_id`) VALUES ('3', 'READ', '2');
