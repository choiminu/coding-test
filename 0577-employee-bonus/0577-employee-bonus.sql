select
    name,
    bonus
from
    Employee E
left join
    Bonus B on E.empId = B.empId
where
    bonus is null || bonus < 1000