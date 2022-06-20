# Write your MySQL query statement below

select a.customer_id,a.customer_name
from Customers a , Orders b
where a.customer_id=b.customer_id 
group by a.customer_id
having (sum(b.product_name="A")>0 and sum(b.product_name="B")>0 and sum(b.product_name="C")<=0)
order by a.customer_id; 
