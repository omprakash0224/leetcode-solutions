# Write your MySQL query statement below
SELECT d.name Department, e.name Employee, salary
FROM Employee e JOIN Department d ON departmentId = d.id
WHERE (departmentId, salary) IN (
    SELECT departmentId, MAX(salary) FROM Employee GROUP BY 1
);