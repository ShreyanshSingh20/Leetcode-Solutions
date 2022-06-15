# Write your MySQL query statement below
#person 1  person 2  callcount  duration_total

select least(from_id,to_id) as person1,
greatest(from_id,to_id) as person2,
count(*) as call_count,
sum(duration) as total_duration
from Calls
group by person1,person2;
