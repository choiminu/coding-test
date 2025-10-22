select
    employee_id 
from
    Employees
where
    salary < 30000
    and manager_id NOT IN (SELECT employee_id FROM Employees)
order by
    1;
