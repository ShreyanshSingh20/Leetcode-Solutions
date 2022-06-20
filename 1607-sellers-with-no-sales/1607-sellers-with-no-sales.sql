# Write your MySQL query statement below

select a.seller_name
from Seller a left join Orders b
on a.seller_id=b.seller_id and left(b.sale_date,4)='2020'
where b.seller_id is null
order by a.seller_name asc;