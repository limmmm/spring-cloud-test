create table org
(
  id     bigint(64)  not null comment '主键ID'
    primary key,
  name   varchar(30) null comment '姓名',
  status tinyint(1)  null comment '状态'
);

INSERT INTO test.org (id, name, status) VALUES (1316941130838859771, '机构1', null);
INSERT INTO test.org (id, name, status) VALUES (1316941130838859772, '机构2', 1);
INSERT INTO test.org (id, name, status) VALUES (1316941130838859773, '机构3', 1);
INSERT INTO test.org (id, name, status) VALUES (1316941130838859774, '机构4', 0);
INSERT INTO test.org (id, name, status) VALUES (1316942123269902338, '机构2', 0);
create table role
(
  id   bigint(64)           not null comment '主键ID'
    primary key,
  code varchar(30)          null comment '编码',
  name varchar(30)          null comment '名称',
  flag tinyint(1) default 0 null comment '删除标记',
  type int                  null comment '类别'
);

INSERT INTO test.role (id, code, name, flag, type) VALUES (1316941130838859661, 'admin', '管理员3', 1, 3);
INSERT INTO test.role (id, code, name, flag, type) VALUES (1316941130838859662, 'admin', '管理员2', 1, 2);
INSERT INTO test.role (id, code, name, flag, type) VALUES (1316941130838859663, 'admin', '管理员1', 1, 1);
INSERT INTO test.role (id, code, name, flag, type) VALUES (1316941130838859664, 'super_admin', '超级管理员', 1, 2);
INSERT INTO test.role (id, code, name, flag, type) VALUES (1316942909282451458, 'admin', '管理员1', 0, 1);
create table user
(
  id    bigint(64)  not null comment '主键ID'
    primary key,
  name  varchar(30) null comment '姓名',
  age   int         null comment '年龄',
  email varchar(50) null comment '邮箱'
)
  comment '用户表';

INSERT INTO test.user (id, name, age, email) VALUES (1316941130838859771, 'Jone', 18, 'test1@baomidou.com');
INSERT INTO test.user (id, name, age, email) VALUES (1316941130838859772, 'Jack', 20, 'test2@baomidou.com');
INSERT INTO test.user (id, name, age, email) VALUES (1316941130838859773, 'Tom', 28, 'test3@baomidou.com');
INSERT INTO test.user (id, name, age, email) VALUES (1316941130838859774, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO test.user (id, name, age, email) VALUES (1316941130838859775, 'Billie', 24, 'test5@baomidou.com');