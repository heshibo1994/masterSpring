use `test`;
-- -- drop table if exists `user` ;
-- -- create table user (
-- -- name VARCHAR(20),
-- -- age VARCHAR(20),
-- -- species VARCHAR(20),
-- -- sex char(1),
-- -- birth DATE
-- -- );
-- -- -- DESCRIBE user;

-- -- insert into user 
-- -- values
-- -- ("keran","21","human",'1',"1994-04-04"),
-- -- ("apple","13","friut",'1',"2994-04-04"),
-- -- ("red","25","color",'0',"1994-06-04"),
-- -- ("yello","34","color",'1',"1994-08-04"),
-- ("green","24","color",'0',"1994-04-09")
--  ;
-- SET SQL_SAFE_UPDATES = 0;
-- update user set age="29" where name="keran";
-- use test;
-- create table user1(
-- 	id int,
--     name varchar(20),
--     PRIMARY key(id,name)
-- );
-- insert into user1 values(1,"zhangsan");
-- insert into user1 values(2,"lisi");
-- DESCRIBE user1;


-- -- create table user2(
-- -- 	id int PRIMARY key AUTO_INCREMENT,
-- --     name varchar(20)
-- -- );
-- -- insert into user2(name) values("zhangsan");
-- -- insert into user2(name) values("lisi");
-- -- insert into user2(name) values("lisi");
-- -- SELECT * from user2;

-- create table user3(
-- 	id int,
--     name varchar(20),
--     UNIQUE(name)
-- );
-- insert into user3 values(1,"zhangsan");
-- insert into user3 values(2,"");
-- select * from  user3;

-- create table class(
-- 	id int PRIMARY key,
--     name varchar(20)
-- );

-- create table student(
-- 	id int primary key,
--     name varchar(20),
--     class_id int,
--     foreign key(class_id) references class(id)
-- );

-- insert into  class values(1,"class_1");
-- insert into  class values(2,"class_2");
-- insert into  class values(3,"class_3");
-- insert into  class values(4,"class_4");

-- insert into  student values(1001,"zhangsan",1);
-- insert into  student values(1002,"lisi",1);
-- insert into  student values(1003,"wangwu",4);

-- create table morder(
-- 	order_id int primary key,
--     product_id int,
--     customer_id int
-- );
-- create table product(
-- 	id int primary key,
--     name varchar(20)
-- );
-- create table customer(
-- 	id int primary key,
--     name varchar(20)
-- );

-- create table student(
-- 	student_id VARCHAR(20) primary key,
--     student_name varchar(20) not null,
--     student_gender varchar(10) not null,
--     student_birth datetime,
--     class varchar(20)
-- )DEFAULT CHARSET=utf8;

-- insert into student VALUES ("101","曾华","男","1997-01-09","9003");
-- insert into student VALUES ("102","贾玲","女","1977-11-19","9003");
-- insert into student VALUES ("103","花花","男","1997-01-21","9013");
-- insert into student VALUES ("104","小童","女","1987-01-09","9013");
-- insert into student VALUES ("105","沈腾","男","1987-03-11","9003");

--  create table teacher(
-- 	teacher_id varchar(20) primary key,
--     teacher_name varchar(20) not null,
--     teacher_gender varchar(10) not null,
--     teacher_birth datetime,
--     teacher_title varchar(20) not null,
--     dept varchar(20) not null
--  )CHARSET=utf8;
--  
--  insert into teacher VALUES ("901","老张","男","1957-01-09","教授","电信");
--  insert into teacher VALUES ("902","老李","女","1947-11-29","教授","材料");
--  insert into teacher VALUES ("903","老王","男","1977-01-24","副教授","通信");
--  
--  create table course(
-- 	course_id varchar(20) primary key,
--     course_name varchar(20) not null,
--     teacher_id varchar(20) not null
--  --    FOREIGN KEY(teacher_id) REFERENCES teacher(teacher_id)
--  )CHARSET=utf8;
--   insert into course VALUES ("1001","控制理论","901");
--   insert into course VALUES ("1002","微机原理","902");
--   insert into course VALUES ("1003","控制理论","903");
--   
--  create table score(
-- 	course_id varchar(20) primary key,
-- 	student_id varchar(20) not null,
--     degree decimal,
--     FOREIGN KEY(course_id) references course(course_id),
--     FOREIGN KEY(student_id) references student(student_id)
--  )CHARSET=utf8;
--    insert into score VALUES ("1001","101",89.4);   
--    insert into score VALUES ("1001","102",59.3);
--    insert into score VALUES ("1001","103",49.5);  
--    insert into score VALUES ("1001","104",39.4);
--    insert into score VALUES ("1002","101",99.1);
--    insert into score VALUES ("1002","102",29.4);
--    insert into score VALUES ("1002","104",78.4);
--    insert into score VALUES ("1003","101",69.9);
--    insert into score VALUES ("1003","103",56.4);
--    insert into score VALUES ("1003","104",98.2);
--    insert into score VALUES ("1003","105",45.4);
 

 

