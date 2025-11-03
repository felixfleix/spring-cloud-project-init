create table if not exists user_info (
id bigint not null primary key auto_increment,
gmt_create datetime not null,
gmt_modified datetime not null,
name varchar(256) not null,
age int not null,
deleted tinyint not null default 0,
lock_version bigint not null default 0
);
