import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:

    employee = employee.merge(department , left_on = 'departmentId' , right_on ='id')
    max_salaries = employee.groupby('departmentId')['salary'].transform("max")


    return employee[employee['salary']==max_salaries][['name_x','salary','name_y']].rename(columns = {'name_x': 'Employee', 'name_y':'Department','salary':'Salary'})
    