--create table temp(name varchar(100))
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses towards Kedarnath','Bangalore bulls',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses in Thailand','Travel buffs',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses in San Fransisco','Travel buffs',CURRENT_TIMESTAMP())

--select * from groups

insert into user(id,name,balance,email,deletion_timestamp) values (USER_SEQUENCE.nextval,'ganesh',0,'ganesh@gmail.com',null)
