# Write your MySQL query statement below
Select e1.name
From Employee e1
Inner Join Employee e2
on e1.id = e2.managerId
Group By e2.managerId
Having Count(e2.managerId)>=5;