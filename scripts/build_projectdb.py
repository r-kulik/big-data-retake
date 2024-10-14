"""
This python code makes a database for the project
"""

from pprint import pprint
import os
from io import open

import psycopg2 as psql


# Read password from secrets file
file = os.path.join("secrets", ".psql.pass")
with open(file, "r", encoding='utf-8') as file:
    password = file.read().rstrip()


# Build connection string
CONN_STRING = "host=hadoop-04.uni.innopolis.ru port=5432" +\
    "user=team38 dbname=team38_projectdb password=" + password



# Connect to the remote DBMS
with psql.connect(CONN_STRING) as conn:
    cur = conn.cursor()
    # Create a cursor for executing psql commands
    # Read the commands from the file and execute them.
    with open(os.path.join("sql", "create_tables.sql"), encoding='utf-8') as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    # Import data from dataGeo.csv

    # Read the commands from the file and execute them.
    with open(os.path.join("sql", "import_data.sql"), 'r', encoding='utf-8') as file:
        commands = list(filter(bool, [
            command.strip() for command in file.read().split(';')
        ]))  # Filter out empty lines
        # print('\n-----------------------------\n'.join(commands))
        with open(os.path.join("data", "dataGeo.csv"), "r", encoding='utf-8') as data_geo_file:
            cur.copy_expert(commands[0], data_geo_file)
            cur.copy_expert(commands[1], data_geo_file)

        with open(os.path.join("data", "data.csv"), "r", encoding='utf-8') as data_file:
            for command in commands[2:]:
                cur.copy_expert(command, data_file)
    # If the SQL statements are CRUD then you need to commit the change
    conn.commit()

    # pprint(conn)
    cur = conn.cursor()
    # Read the SQL commands from the file
    with open(os.path.join("sql", "test_database.sql"), 'r', encoding='utf-8') as file:
        commands = [
            command.strip() for command in file.read().split(';')
        ]  # Filter out empty lines
        for command in commands:
            if command:
                cur.execute(command)
            else:
                continue
            # Check if the query returns results before calling fetchall()
            if cur.description:
                result = cur.fetchall()
                if len(result) > 2:
                    print("ERROR WHILE PERFORMING TESTS")
                    pprint(result)
                    raise ValueError

    # Close the cursor
    cur.close()
    print('Database was loaded successfully')
