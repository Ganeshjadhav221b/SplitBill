--create table temp(name varchar(100))
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses towards Kedarnath','Bangalore bulls',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses in Thailand','Travel buffs',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses in San Fransisco','Travel buffs',null)

select * from groups
