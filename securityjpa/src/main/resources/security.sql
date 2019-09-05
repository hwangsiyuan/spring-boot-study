CREATE DATABASE IF NOT EXISTS `springboot` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

insert into `tb_role`(`authority`) values('ROLE_USER'),('ROLE_ADMIN'),('ROLE_DBA');

insert into `tb_user`(`login_name`,`password`,`user_name`)
values('张无忌','$2a$10$YSn2eomKKQdx9XPuBLjAqOlMDXpvhW1YpfcZQpA3xuyBw9sOFNPWa','迪米特里'),
      ('admin','$2a$10$Re6al3c2vBRP.zca82hLD.9HGW2utgkM9q1.7tik4RW5BOMMwpzKi','admin');

insert into `tb_user_role`(`role_id`,`user_id`) values(1,1),(2,2),(3,2);