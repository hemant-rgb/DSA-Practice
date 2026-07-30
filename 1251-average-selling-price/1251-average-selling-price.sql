# Write your MySQL query statement below
Select p.product_id , Round(IFNULL(SUM(p.price * us.units)/SUM(us.units),0),2) as average_price
From Prices p 
Left Join UnitsSold us
on p.product_id = us.product_id
And us.purchase_date Between p.start_date And p.end_date
Group By p.product_id;