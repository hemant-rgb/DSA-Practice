import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    find_customers_df = customers[~customers['id'].isin(orders['customerId'])]
    return find_customers_df[['name']].rename(columns= {'name': "Customers"})