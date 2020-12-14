# Split Bill

Visit the problem statement [here](https://git.hashedin.com/ganesh.jadhav/kotlin-assignment-2/-/blob/master/metadata/SplitBill%20Assignment%20-%20To%20Share.pdf)

## ER Diagram
![ER diagram for split bill](https://git.hashedin.com/ganesh.jadhav/kotlin-assignment-2/-/raw/master/metadata/SplitPerfect_ER_Diagram.png)

## NOTE
<b>Entity diagram </b>
Balance(in user entity) can be negative indicating the user has to pay money back(due). Positive balance for an user means he recieve the amount, yet.

<b>Soft delete</b>
Soft delete is done via deletion_date column which indicates date deleted if it's deleted, would be null otherwise. ([reference](https://stackoverflow.com/a/68338/7467083))

<b>Database</b>
H2 In memory database is used.


<b>Tables</b>
A user has to first create account(stored in user table).
when user pays against a bill(stored in bill table), it's an expense(stored in expense table).(bill table also keeps track of total expenditure and due/balance yet not settled).
When user returns money that he owed, it's a transaction(stored in transaction table).
In both above cases, balancesheet is maintained among 2 users(in balancesheet table). 

<b>Order of creation</b>
1. users
2. groups
2.1 user_groups
3. bills
4. expense
5. transaction
6. balance_sheet

<b>Conventions followed</b>
-FK_ForeignTableName_CurrentTableName, example -> FK_Student_Department(meaning, in department entity, we're putting primary key of student as foreign key)


<b>Simplifying debt</b>
Debt is simplified using binary heap, which serves best at such cases.

