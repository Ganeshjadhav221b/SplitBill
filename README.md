# Split Bill

Visit the problem statement [here](https://git.hashedin.com/ganesh.jadhav/kotlin-assignment-2/-/blob/master/metadata/SplitBill%20Assignment%20-%20To%20Share.pdf)

## ER Diagram
![ER diagram for split bill](https://git.hashedin.com/ganesh.jadhav/kotlin-assignment-2/-/raw/master/metadata/SplitPerfect_ER_Diagram.png)

## NOTE
<b>Entity diagram </b>
Balance(in user entity) can be negative indicating the user has to pay money back(due). Positive balance for an user means he recieve the amount, yet.

<b>Soft delete</b>
Soft delete is done via deletion_date column which indicates date deleted if it's deleted, would be null otherwise. ([reference](https://stackoverflow.com/a/68338/7467083))

<b>Simplifying debt</b>
Debt is simplified using binary heap, which serves best at such cases.

<b>Database</b>
H2 In memory database is used.

<b>Conventions followed</b>
-FK_ForeignTableName_CurrentTableName, example -> FK_Student_Department(meaning, in department entity, we're putting primary key of student as foreign key)