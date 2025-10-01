select
    a.student_id,
    a.student_name,
    s.subject_name,
    count(e.student_id) AS attended_exams
from
    Students a
cross join
    Subjects s
left join
    Examinations e
    on a.student_id = e.student_id
    and e.subject_name = s.subject_name
group by
    a.student_id, a.student_name, s.subject_name
ORDER BY
    a.student_id, s.subject_name;