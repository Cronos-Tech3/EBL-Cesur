-- 2.	Muestre todos los datos de la tabla DEPARTMENTS. 
SELECT *
FROM departments;

-- 3.	Cree una consulta para mostrar para cada empleado y en este orden: el número de empleado (employee_id), el apellido (last_name), el código de cargo (job_id) y la fecha de contratación
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, hire_Date
FROM employees;

-- 4.	Realice una consulta donde se muestre por este orden: 
-- Nombre (first_name), el salario (salary), un aumento del salario de 234,56, 
-- el salario anual (multiplicado por 12), el salario diario (dividido por 30), una reducción del salario del 2,78 %.  
select first_name, salary, salary+234.56, salary *12, salary /30, salary - (salary * 0.0278), salary * (1-2.78/100)
from employees;

-- 5.	Modifique la consulte 2 y la 3 para proporcionar un alias para cada columna. 
SELECT EMPLOYEE_ID AS "Codigo Empleado", LAST_NAME as "Apellido", JOB_ID "categoria", hire_date "fecha contratación"
FROM employees;

select first_name nombre, salary salario , salary+234.56 aumento, salary *12 "salario anual", salary /30 "salario diario", salary - (salary * 0.0278) "reducción"
from employees;

-- 6.	Cree una consulta para mostrar códigos de cargo únicos (job_id) de la tabla EMPLOYEES.
SELECT distinct job_id
FROM employees;

/* 7.	De la tabla EMPLOYEES, muestre el apellido (last_name) concatenado con el identificador de cargo, separados por una coma y un espacio. (Ej: King, AD_PRES)
Llame a la columna “trabajo y cargo”.
*/

SELECT concat (last_name , 'y tiene el cargo ' , job_id)
FROM employees; 

SELECT concat_ws (",", last_name , 'y tiene el cargo ' , job_id, commission_pct)
FROM employees; 

-- 8.	Cree una consulta para mostrar todos los datos de la tabla EMPLOYEES. Separe cada columna  con una coma. Llame a la columna “Datos de los empleados”.

SELECT  concat_ws (', ',employee_id ,
        first_name,
        last_name ,
        email , 
        phone_number ,
        hire_date, 
        job_id ,
        salary, 
        commission_pct ,
        manager_id , 
        department_id) "Datos trabajadores"
FROM employees;


