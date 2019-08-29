CREATE TABLE `tb_student` (
  `id` int(24) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `clazz_id` int COMMENT '班级ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生表';

CREATE TABLE `tb_clazz` (
  `id` int(24) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '班级名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='班级表';

insert into `tb_clazz`(name) values('三年级1班'),('五年级2班')

insert into `tb_student`(name,sex,age,address,class_id)
values ('孙悟空','男',72,'花果山',100),
       ('牛魔王','男',92,'火焰山',101),
       ('猪八戒','男',102,'高老庄',101)