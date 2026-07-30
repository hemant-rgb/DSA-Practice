# Write your MySQL query statement below
Select s.student_id , s.student_name , sub.subject_name, Count(e.subject_name) as attended_exams
From Students s
Cross Join Subjects sub
Left Join Examinations e
on s.student_id = e.student_id and sub.subject_name = e.subject_name
Group By s.student_id , s.student_name , sub.subject_name
Order By s.student_id ,sub.subject_name;