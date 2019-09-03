CREATE DATABASE IF NOT EXISTS `springboottest` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;


CREATE TABLE `tb_student` (
  `id` int(24) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生表';


insert into `tb_student`(name,sex,age,address)
values ('孙悟空','男',72,'花果山'),
       ('牛魔王','男',92,'火焰山'),
       ('猪八戒','男',102,'高老庄')

