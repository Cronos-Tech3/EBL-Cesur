-- 1.	Crea una consulta para mostrar el apellido y el salario de los empleados que ganan más de $12.000. 
SELECT LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > 12000;

-- 2.	Crea una consulta para mostrar el apellido del empleado y el número de departamento para el número de empleado 176.
SELECT LAST_NAME, DEPARTMENT_ID
FROM employees
WHERE employee_id=176;

-- 3.	Realiza una consulta que muestre los empleados que trabajan en el departamento 80 y su jefe sea el que tiene el identificador 100

select * 
from employees
where department_id=80 and manager_id = 100;
-- 4.	Muestra los datos de los empleados que tienen un salario mayor de 15000 o una comisión mayor de 0.30
select *
from employees 
where salary >15000 or commission_pct > 0.30;
-- 5.	Se quiere dar una gratificación a los empleados que ganan menos de 8.000; pero solo a los que trabajan en el departamento 80 o que su jefe tiene un identificar 101. Realiza una consulta que muestre los datos de estos trabajadores.
select *
from employees
where (department_id = 80 or manager_id=101) and salary < 8000;

