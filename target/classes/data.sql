insert into Course(id, name) values(10001, 'AWS');
insert into Course(id, name) values(10002, 'Azure');
insert into Course(id, name) values(10003, 'Google');

insert into Passport(id, number) values(30001, 'E20001');
insert into Passport(id, number) values(30002, 'D20002');
insert into Passport(id, number) values(30003, 'C20003');
insert into Passport(id, number) values(30004, 'A20001');
insert into Passport(id, number) values(30005, 'D22002');
insert into Passport(id, number) values(30006, 'C20403');


insert into Student(id, name, passport_id) values(20001, 'yash', 30001);
insert into Student(id, name, passport_id) values(20002, 'Anu', 30002);
insert into Student(id, name, passport_id) values(20003, 'sonali', 30003);
insert into Student(id, name, passport_id) values(20004, 'aaa', 30004);
insert into Student(id, name, passport_id) values(20005, 'sss', 30005);
insert into Student(id, name, passport_id) values(20006, 'xxx', 30006);

insert into review(id, rating, description, course_id) values(40001, '3star', 'Good', 10001);
insert into review(id, rating, description, course_id) values(40002, '4star', 'better', 10001);
insert into review(id, rating, description, course_id) values(40003, '5star', 'best', 10003);

insert into student_course(course_id, student_id) values(10002, 20001);
insert into student_course(course_id, student_id) values(10001, 20001);
insert into student_course(course_id, student_id) values(10002, 20003);
insert into student_course(course_id, student_id) values(10003, 20001);