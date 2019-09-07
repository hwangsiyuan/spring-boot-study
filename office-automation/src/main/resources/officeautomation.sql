CREATE DATABASE IF NOT EXISTS `officeautomation` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

 create table tb_oa_dept (id bigint not null, create_time datetime, modify_time datetime, name varchar(128), remark varchar(1024), creator varchar(50), modifier varchar(50), primary key (id))ENGINE=InnoDB DEFAULT CHARSET=utf8
 create table tb_oa_job (code varchar(100) not null, name varchar(128), remark varchar(1024), primary key (code))ENGINE=InnoDB DEFAULT CHARSET=utf8
 create table tb_oa_module (code varchar(100) not null, create_time datetime, modify_time datetime, name varchar(128), remark varchar(1024), url varchar(128), creator varchar(50), modifier varchar(50), primary key (code))ENGINE=InnoDB DEFAULT CHARSET=utf8
 create table tb_oa_popedom (id bigint not null, create_time datetime, creator varchar(50), module_code varchar(100), operate_code varchar(100), role_id bigint, primary key (id))ENGINE=InnoDB DEFAULT CHARSET=utf8
 create table tb_oa_role (id bigint not null, create_time datetime, modify_time datetime, name varchar(128), remark varchar(1024), creator varchar(50), modifier varchar(50), primary key (id))ENGINE=InnoDB DEFAULT CHARSET=utf8
 create table tb_oa_user (user_id varchar(50) not null, answer varchar(200), check_time datetime, create_time datetime, email varchar(128), modify_time datetime, name varchar(128), password varchar(128), qq_num varchar(20), question_num smallint, sex smallint, status smallint, telephone varchar(20), check_user varchar(50), creator varchar(50), dept_id bigint, job_code varchar(100), modifier varchar(50), primary key (user_id))ENGINE=InnoDB DEFAULT CHARSET=utf8
 create table tb_oa_user_role (role_id bigint not null, user_id varchar(50) not null, primary key (role_id, user_id))ENGINE=InnoDB DEFAULT CHARSET=utf8
 alter table tb_oa_dept add constraint fk_oa_dept_creator foreign key (creator) references tb_oa_user (user_id)
 alter table tb_oa_dept add constraint fk_oa_dept_modifier foreign key (modifier) references tb_oa_user (user_id)
 alter table tb_oa_module add constraint fk_oa_module_creator foreign key (creator) references tb_oa_user (user_id)
 alter table tb_oa_module add constraint fk_oa_module_modifier foreign key (modifier) references tb_oa_user (user_id)
 alter table tb_oa_popedom add constraint fk_oa_popedom_creator foreign key (creator) references tb_oa_user (user_id)
 alter table tb_oa_popedom add constraint fk_oa_popedom_module foreign key (module_code) references tb_oa_module (code)
 alter table tb_oa_popedom add constraint fk_oa_popedom_operate foreign key (operate_code) references tb_oa_module (code)
 alter table tb_oa_popedom add constraint fk_oa_popedom_role foreign key (role_id) references tb_oa_role (id)
 alter table tb_oa_role add constraint fk_oa_role_creator foreign key (creator) references tb_oa_user (user_id)
 alter table tb_oa_role add constraint fk_oa_role_modifier foreign key (modifier) references tb_oa_user (user_id)
 alter table tb_oa_user add constraint fk_oa_user_check_user foreign key (check_user) references tb_oa_user (user_id)
 alter table tb_oa_user add constraint fk_oa_user_creator foreign key (creator) references tb_oa_user (user_id)
 alter table tb_oa_user add constraint fk_oa_user_dept foreign key (dept_id) references tb_oa_dept (id)
 alter table tb_oa_user add constraint fk_oa_user_job foreign key (job_code) references tb_oa_job (code)
 alter table tb_oa_user add constraint fk_oa_user_modifier foreign key (modifier) references tb_oa_user (user_id)
 alter table tb_oa_user_role add constraint FKrnhqpi6118ojcty2qed6bx4s8 foreign key (user_id) references tb_oa_user (user_id)
 alter table tb_oa_user_role add constraint FKpkub7bo4qhprt05b0veq8f8as foreign key (role_id) references tb_oa_role (id)
