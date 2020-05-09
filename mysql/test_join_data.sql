use test_join;

create table person(
	id int,
    name varchar(20),
    cardId int
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table card(
	id INT,
    name varchar(20)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into card  values (1,"工行卡");
insert into card  values (2,"农行卡");
insert into card  values (3,"建设行卡");
insert into card  values (4,"中国行卡");
insert into card  values (5,"浦发行卡");
insert into person  values (1,"张三",1);
insert into person  values (2,"李四",3);
insert into person  values (3,"王五",6);


