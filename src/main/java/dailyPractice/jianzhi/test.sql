select t1.EmpName, t2.EmpName as ManagerName
From emp t1
LEFT JOIN emp t2
ON t1.ManageId = t2.EmpId

EmpName ManagerName
A, D
B, A
C, null
D, C

We need minor
select * from EMB where sr_no in (select Sr_no
                         from EMB
                         group by Sr_no
                         having count(*) > 1)

Row Sr_no Name
1 10    A
2 10    B
1 20    C
1 30    D
2 30    E
1 40    F
