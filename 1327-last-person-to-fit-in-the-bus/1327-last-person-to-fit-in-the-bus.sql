with t as (
select
    *, sum(weight) over(order by turn) as 'total'
from
    Queue
)

select
    person_name
from
    t
where
    total <= 1000
order by
    total desc
limit 1