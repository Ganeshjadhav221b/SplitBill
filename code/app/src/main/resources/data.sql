--create table temp(name varchar(100))
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses towards Kedarnath','Bangalore bulls',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses in Thailand','Travel buffs',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'For all expenses in San Fransisco','Travel buffs',CURRENT_TIMESTAMP())

--select * from groups

insert into user(id,name,balance,email,deletion_timestamp) values (USER_SEQUENCE.nextval,'ganesh',0,'ganesh@gmail.com',null)


insert into bill(id,creation_timestamp,deletion_timestamp,description,number,total_balance,total_expenditure,fk_group_bill) values (BILL_SEQUENCE.nextval,CURRENT_TIMESTAMP(),null,'desc',0,0,0,1)
