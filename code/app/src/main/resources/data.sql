--create table temp(name varchar(100))
insert into groups(id,description,name) values (GROUP_SEQUENCE.nextval,'For all expenses towards Kedarnath','Bangalore bulls')
insert into groups(id,description,name) values (GROUP_SEQUENCE.nextval,'For all expenses in Thailand','Travel buffs')
insert into groups(id,description,name) values (GROUP_SEQUENCE.nextval,'For all expenses in San Fransisco','Travel buffs')

select * from groups
