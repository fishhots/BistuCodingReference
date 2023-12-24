import SQL
def print_detail(name):
    cnxn=SQL.get_access()
    cursor=cnxn.cursor()
    cursor.execute("SELECT 父亲 FROM %s"%name)
    rows=cursor.fetchall()
    print('父亲：')
    for row in rows:
        for i in row:
            if i is not None:
                print(i)
    cursor.execute("SELECT 母亲 FROM %s"%name)
    rows=cursor.fetchall()
    print('母亲：')
    for row in rows:
        for i in row:
            if i is not None:
                print(i)
    cursor.execute("SELECT 皇后 FROM %s"%name)
    rows=cursor.fetchall()
    print('皇后：')
    for row in rows:
        for i in row:
            if i is not None:
                print(i)
    cursor.execute("SELECT 妃 FROM %s"%name)
    rows=cursor.fetchall()
    print('妃：')
    for row in rows:
        for i in row:
            if i is not None:
                print(i)
    cursor.execute("SELECT 贵妃 FROM %s"%name)
    rows=cursor.fetchall()
    print('贵妃：')
    for row in rows:
        for i in row:
            if i is not None:
                print(i)
    cursor.execute("SELECT 皇贵妃 FROM %s"%name)
    rows=cursor.fetchall()
    print('皇贵妃：')
    for row in rows:
        for i in row:
            if i is not None:
                print(i)
    cursor.execute("SELECT 子女 FROM %s"%name)
    rows=cursor.fetchall()
    print('子女：')
    for row in rows:
        for i in row:
            if i is not None:
                print(i)
