select
    a.machine_id,
    round(sum(b.timestamp - a.timestamp) / count(a.machine_id),3) as processing_time 
from (
        select
            machine_id,
            process_id,
            timestamp
        from
            Activity
        where 
            activity_type ='start' 
    ) as a
join
    (
        select
            machine_id,
            process_id,
            timestamp
        from
            Activity
        where 
            activity_type ='end' 
    ) as b on a.machine_id = b.machine_id and a.process_id = b.process_id
group by
    a.machine_id 