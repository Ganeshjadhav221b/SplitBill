# Split Bill
Visit the problem statement [here](https://git.hashedin.com/ganesh.jadhav/kotlin-assignment-2/-/blob/master/metadata/SplitBill%20Assignment%20-%20To%20Share.pdf)

## ER Diagram
![ER diagram for split bill](https://git.hashedin.com/ganesh.jadhav/kotlin-assignment-2/-/raw/master/metadata/SplitPerfect_ER_Diagram.png)

## NOTE
<b>Entity diagram </b>
Balance(in user entity) can be negative indicating the user has to pay money back(due). Positive balance for an user means he recieve the amount, yet.


<b>Milestones</b>
Milestone 1 -> added in code/domain<br>
Milestone 2 & 5.1 -> http://localhost:8080/api/v1/user/{operation}, where operation = [`create`,`update`,`delete`,`read`]<br>
Milestone 3,5.2,6.1,8.3-> http://localhost:8080/api/v1/bill/{operation}, where operation = [`create`,`read`,`update`]<br>
Milestone 4 & 5.3 -> to get net user balance ->http://localhost:8080/api/v1/user/userbalance/{id}, where id is userid<br>
Milestone 5.4 to get individual balance ->http://localhost:8080/api/v1/user/userbalancesheet/{id}, where id is usedid<br>
Milestone 9.1 -> http://localhost:8080/api/v1/group/{operation}, where operation = [`create`,`update`,`delete`,`read`]<br>
Milestone 9.2 -> http://localhost:8080/api/v1/usergroup<br>

<b>Soft delete</b>
Soft delete is done via deletion_date column which indicates date deleted if it's deleted, would be null otherwise. ([reference](https://stackoverflow.com/a/68338/7467083))

<b>Database</b>
H2 In memory database is used.

Find table strucuture with json examples [here](https://git.hashedin.com/ganesh.jadhav/kotlin-assignment-2/-/blob/master/metadata/table_strucuture_with_examples.txt)

<b>Tables</b>
1. A user has to first create account(stored in user table).
2. When user pays against a bill(stored in bill table), it's an expense(stored in expense table).(bill table also keeps track of total expenditure and due/balance yet not settled).
3. Step 2 is also saved in transaction table
4. When user returns money that he owed, it's a transaction(stored in transaction table).
5. For step 2 and 4, balancesheet is updated among 2 users(in balancesheet table) 

<b>Order of creation</b>
1. users
2. groups<br>
2.1 user_groups
3. bills
4. expense
5. transaction
6. balance_sheet

<b>Conventions followed</b>
1. Foreign key-FK_ForeignTableName_CurrentTableName, example -> FK_Student_Department(meaning, in department entity, we're putting primary key of student as foreign key)


<b>Simplifying debt</b>
Debt is simplified using binary heap, which serves best at such cases.(yet to be done)

