import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    salaries = employee['salary'].sort_values(ascending=False).drop_duplicates()
    
    if len(salaries)<2:
        return pd.DataFrame({
            'SecondHighestSalary':[None]
        })
    s_highest_salary = salaries.iloc[1]
    return pd.DataFrame({
        'SecondHighestSalary' : [s_highest_salary]
    })


    