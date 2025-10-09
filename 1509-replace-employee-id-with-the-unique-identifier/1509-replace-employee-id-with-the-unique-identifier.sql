select
    unique_id,
    name
from
    Employees E
left join
    EmployeeUNI U on E.id = U.id