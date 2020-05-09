-- 查询所有学生记录
-- select * from student;
-- 查询学生表中的部分字段
-- select student_id, student_name from student;
-- 查询教师表中所有部分的不重复序列-- 
-- select DISTINCT dept from teacher;
-- 查询成绩中介于60到80的
-- select * from score where degree between 60.0 and 80.0;
-- 查询score=29.4或者78.4的数据
-- select * from score where degree in (29.4,78.4,49.8);
-- 查询学生表中9003的男同学
-- select * from student where class="9003" and student_gender="男"
-- 成绩升序或者降序，默认升序asc，降序desc
-- select * from score order by degree;
-- 成绩升序，学号降序，默认升序asc，降序desc
-- select * from score order by degree asc,student_id desc;
-- 查询选择1001课程的人数
-- select count(*) from score where course_id = "1001";
-- -- 查找score最高分的学生学号和课程号
-- select student_id,course_id from score where degree=(select max(degree) from score );
-- 查询选择1001的课的学生平均成绩
-- select avg(degree) from score where course_id="1001";
-- 查询每一门课的学生平均成绩
-- select course_id, avg(degree) from score group by course_id;
-- 查询score表中以3结尾,且至少有两个学生选择的课程的平均成绩,以have带条件，% 模糊查询
-- select course_id  from score group by course_id
-- having count(course_id)>2 and course_id like "%3";

use test;
-- 多表查询

-- 查询所有学生的姓名，课程号和成绩
-- 共同字段包含学生的学号

-- select student_name,course_id,degree from student,score
-- where student.student_id = score.student_id;

-- 查询所有学生的学号，课程名和成绩
-- 共同字段包含课程号
-- select student_id,course_name,degree from course,score
-- where course.course_id = score.course_id;

-- 查询所有学生的姓名，课程名和成绩
-- 共同字段包含学生的学号和课程号
-- select student_name,course_name,degree from student,course,score
-- where student.student_id=score.student_id and course.course_id = score.course_id;

-- 查询9003班的学生每一门课的平均分
-- select student_id from student where class="9003";
-- select course_id,avg(degree) from score 
-- where student_id in (select student_id from student where class="9003")
-- group by course_id;

-- 查询选择课“1001”并且成绩高于"102"号同学的所有同学的成绩
-- select degree from score where course_id="1001" and student_id="102";
-- select * from score where degree>(select degree from score where course_id="1001" and student_id="102") and course_id="1001";


-- 查询和学号为“104”同学同年出生的所有学生的学号，姓名和生日
-- select year(student_birth) from student where student_id="104";
-- select student_id,student_name,student_birth from student WHERE  year(student_birth)=(select year(student_birth) from student where student_id="104");

-- 查询老王带的课的学生成绩
-- select teacher_id from teacher where teacher_name="老王";
-- select course_id from course where teacher_id=(select teacher_id from teacher where teacher_name="老王");
-- select  * from score where course_id = (select course_id from course where teacher_id=(select teacher_id from teacher where teacher_name="老王"));

-- 查询9003和9013班的学生  in 
-- select * from student where class in ("9003","9013");

-- 查询材料和电信专业不同职称教师的姓名和职称  union 取并集
-- select * from teacher where dept="材料" and teacher_title not in (select teacher_title from teacher where teacher_title="电信")
-- union
-- select * from teacher where dept="电信" and teacher_title not in (select teacher_title from teacher where teacher_title="材料"); 

-- 查询选择1001课程，且成绩至少高于选择1002的成绩的同学  any
-- select * from score where course_id="1001" and degree> any(select degree from score where  course_id="1002");

-- -- 查询选择1002课程，且成绩高于所有选择1003的成绩的同学  all
-- select * from score where course_id="1002" and degree> all(select degree from score where  course_id="1003");

-- -- 别名as
-- select student_name as name,student_gender as gender,student_birth as bitth from student;

-- 筛选出成绩低于平均值的同学的成绩表
-- select course_id ,avg(degree) from score group by course_id;
-- select * from score a where degree<(select avg(degree) from score b where a.course_id=b.course_id);

-- 查询至少有两个男生的班级
-- select class from student where student_gender="男" group by class having count(*)>1;

-- -- 查询不姓花的同学
-- select * from student where student_name not like "花%";

-- 以班级和年龄从大到小对student进行排序-- 
select * from student order by class desc,student_birth;