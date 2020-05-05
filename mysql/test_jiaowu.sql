
use test;
drop table if exists student;
drop table if exists teacher;
drop table if exists course;
drop table if exists score;
create table student(
	student_id VARCHAR(20) primary key,
    student_name varchar(20) not null,
    student_gender varchar(10) not null,
    student_birth datetime,
    class varchar(20)
)DEFAULT CHARSET=utf8;

insert into student VALUES ("101","曾华","男","1997-01-09","9003");
insert into student VALUES ("102","贾玲","女","1977-11-19","9003");
insert into student VALUES ("103","花花","男","1997-01-21","9013");
insert into student VALUES ("104","小童","女","1987-01-09","9013");
insert into student VALUES ("105","沈腾","男","1987-03-11","9003");

 create table teacher(
	teacher_id varchar(20) primary key,
    teacher_name varchar(20) not null,
    teacher_gender varchar(10) not null,
    teacher_birth datetime,
    teacher_title varchar(20) not null,
    dept varchar(20) not null
 )CHARSET=utf8;
 
 insert into teacher VALUES ("901","老张","男","1957-01-09","教授","电信");
 insert into teacher VALUES ("902","老李","女","1947-11-29","教授","材料");
 insert into teacher VALUES ("903","老王","男","1977-01-24","副教授","通信");
 
 create table course(
	course_id varchar(20) primary key,
    course_name varchar(20) not null,
    teacher_id varchar(20) not null,
    FOREIGN KEY(teacher_id) REFERENCES teacher(teacher_id)
 )CHARSET=utf8;
  insert into course VALUES ("1001","控制理论","901");
  insert into course VALUES ("1002","微机原理","902");
  insert into course VALUES ("1003","控制理论","903");
  
 create table score(
	course_id varchar(20) not null,
	student_id varchar(20) not null,
    degree decimal(18,1),
    FOREIGN KEY(course_id) references course(course_id),
    FOREIGN KEY(student_id) references student(student_id),
    primary key(course_id,student_id)
 )CHARSET=utf8;
   insert into score VALUES ("1001","101",89.4);   
   insert into score VALUES ("1001","102",59.3);
   insert into score VALUES ("1001","103",49.5);  
   insert into score VALUES ("1001","104",39.4);
   insert into score VALUES ("1002","101",99.1);
   insert into score VALUES ("1002","102",29.4);
   insert into score VALUES ("1002","104",78.4);
   insert into score VALUES ("1003","101",69.9);
   insert into score VALUES ("1003","103",56.4);
   insert into score VALUES ("1003","104",98.2);
   insert into score VALUES ("1003","105",45.4);