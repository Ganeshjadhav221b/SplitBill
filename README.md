Visit the problem statement <a href="#">here</>

<b>Entity diagram </b>
Red eclipse are not part of the actual entity but their DTOs(which is extension of entity), and due can be negative indicating the user has to get money back. Positive due for an user means he has to pay it, yet.

<b>Soft delete</b>
Soft delete is done via deletion_date column which indicates date deleted if it's deleted, would be null otherwise.  
(Reference-https://stackoverflow.com/a/68338/7467083)

<b>Simplifying debt</b>
Debt is simplified using binary heap, which serves best at this cases.

