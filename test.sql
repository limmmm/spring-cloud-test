create table org
(
  id     char(32)    not null comment '主键ID'
    primary key,
  name   varchar(30) null comment '姓名',
  status smallint(6) null comment '状态'
);

INSERT INTO test.org (id, name, status) VALUES ('097ab9297af8f7b52ef43a213713fc47', '机构2', 0);
INSERT INTO test.org (id, name, status) VALUES ('2a42f922253accbf67a6b698fccbbadf', '机构1', 1);
INSERT INTO test.org (id, name, status) VALUES ('8bcb5c51e22f22cad77fdaa08ed1e8d9', '机构2', 1);
INSERT INTO test.org (id, name, status) VALUES ('deadc0877449e22e2588bda007e45900', '机构2', null);
create table role
(
  id   char(32)    not null comment '主键ID'
    primary key,
  code varchar(30) null comment '编码',
  name varchar(30) null comment '名称',
  flag smallint(6) null comment '删除标记',
  type int         null comment '类别'
);

INSERT INTO test.role (id, code, name, flag, type) VALUES ('1', 'super_admin', '1', 1, 2);
INSERT INTO test.role (id, code, name, flag, type) VALUES ('39f6c4e7ab2add31c7c027dbca9b918d', 'admin', '管理员1', 1, 1);
INSERT INTO test.role (id, code, name, flag, type) VALUES ('f2020a952fdb669ba9bb90b76f15507c', 'admin', '管理员2', 1, 2);
INSERT INTO test.role (id, code, name, flag, type) VALUES ('f363d48b9184c1d5ac3bad851af12c52', 'admin', '管理员3', 1, 3);
create table user
(
  id    bigint auto_increment comment '主键ID'
    primary key,
  name  varchar(30) null comment '姓名',
  age   int         null comment '年龄',
  email varchar(50) null comment '邮箱'
)
  comment '用户表';

INSERT INTO test.user (name, age, email) VALUES ('Jone', 18, 'test1@baomidou.com');
INSERT INTO test.user (name, age, email) VALUES ('Jack', 20, 'test2@baomidou.com');
INSERT INTO test.user (name, age, email) VALUES ('Tom', 28, 'test3@baomidou.com');
INSERT INTO test.user (name, age, email) VALUES ('Sandy', 21, 'test4@baomidou.com');
INSERT INTO test.user (name, age, email) VALUES ('Billie', 24, 'test5@baomidou.com');