import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    sorted_salaries = employee['salary'].sort_values(ascending=False).drop_duplicates()

    if N <= 0 or N > len(sorted_salaries):
        
        return pd.DataFrame({f'getNthHighestSalary({N})': [None]})

    
    nthHighest = sorted_salaries.iloc[N-1]

    return pd.DataFrame({f'getNthHighestSalary({N})' : [nthHighest]})