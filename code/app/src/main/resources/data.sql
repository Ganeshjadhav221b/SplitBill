insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'no description','Bangalore bulls',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'no description','Travel buffs',null)
insert into groups(id,description,name,deletion_timestamp) values (GROUP_SEQUENCE.nextval,'no description','Travel buffs',CURRENT_TIMESTAMP())

--select * from groups

insert into user(id,name,balance,email,deletion_timestamp) values (USER_SEQUENCE.nextval,'ganesh',0,'ganesh@gmail.com',null)
insert into user(id,name,balance,email,deletion_timestamp) values (USER_SEQUENCE.nextval,'omkar',0,'omkar@gmail.com',null)
insert into user(id,name,balance,email,deletion_timestamp) values (USER_SEQUENCE.nextval,'shridhar',0,'shridhar@gmail.com',null)
insert into user(id,name,balance,email,deletion_timestamp) values (USER_SEQUENCE.nextval,'vinayak',0,'vinayak@gmail.com',null)


insert into bill(id,creation_timestamp,deletion_timestamp,description,number,total_balance,total_expenditure,fk_group_bill) values (BILL_SEQUENCE.nextval,CURRENT_TIMESTAMP(),null,'For all expenses in Kedarnath',0,0,0,1)


--adding user 1 to group1
insert into user_group(id,groups,joined_timestamp,fk_user_usergroup) values (USER_GROUP_SEQUENCE.nextval,1,CURRENT_TIMESTAMP(),1)
--adding user 2 to group1
insert into user_group(id,groups,joined_timestamp,fk_user_usergroup) values (USER_GROUP_SEQUENCE.nextval,1,CURRENT_TIMESTAMP(),2)
--adding user 3 to group1
insert into user_group(id,groups,joined_timestamp,fk_user_usergroup) values (USER_GROUP_SEQUENCE.nextval,1,CURRENT_TIMESTAMP(),3)
--adding user 4 to group1
insert into user_group(id,groups,joined_timestamp,fk_user_usergroup) values (USER_GROUP_SEQUENCE.nextval,1,CURRENT_TIMESTAMP(),4)


--insert into expense values (EXPENSE_SEQUENCE.nextval,'n1',CURRENT_TIMESTAMP(),1,1)

--insert into transaction(id,description,transaction_timestamp,fk_bill_transaction,fk_user1_transaction,fk_user2_transaction) values (TRASNSACTION_SEQUENCE.nextval,'desc1',CURRENT_TIMESTAMP(),1,1,2)
