create database if not exists java_gobang;

use java_gobang;
drop table if exists user;
create table user (
    userId int primary key auto_increment,
    username varchar(50) unique,
    password varchar(50),
    score int, -- 天梯积分
    totalCount int, -- 比赛总场数
    winCount int -- 获胜场数
);

insert into user values (null, '张雨潇', '123', 1000, 0, 0);
insert into user values (null, '李明', 'password1', 1200, 10, 6);
insert into user values (null, '王芳', 'password2', 1100, 8, 4);
insert into user values (null, '刘强', 'password3', 950, 12, 5);
insert into user values (null, '赵静', 'password4', 980, 7, 3);
insert into user values (null, '孙鹏', 'password5', 1050, 11, 7);
insert into user values (null, '周丽', 'password6', 1020, 9, 4);
insert into user values (null, '郑凯', 'password7', 1150, 15, 8);
insert into user values (null, '何敏', 'password8', 990, 10, 5);
insert into user values (null, '吴昊', 'password9', 1080, 13, 6);
insert into user values (null, '陈晓', 'password10', 930, 8, 3);
insert into user values (null, '杨洋', 'password11', 1120, 14, 9);
insert into user values (null, '林静', 'password12', 1040, 11, 6);
insert into user values (null, '张伟', 'password13', 950, 7, 2);
insert into user values (null, '刘畅', 'password14', 1070, 12, 7);
insert into user values (null, '宋雨', 'password15', 990, 9, 4);
insert into user values (null, '唐鹏', 'password16', 1010, 10, 5);
insert into user values (null, '许娟', 'password17', 920, 6, 2);
insert into user values (null, '高飞', 'password18', 960, 8, 3);
insert into user values (null, '钟丽', 'password19', 980, 7, 3);
insert into user values (null, '魏强', 'password20', 1100, 10, 5);
