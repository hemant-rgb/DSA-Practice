# Write your MySQL query statement below
Select p.project_id , Round(AVG(e.experience_years),2) as average_years
From Project p
Inner Join Employee e
on p.employee_id = e.employee_id
Group By p.project_id;
