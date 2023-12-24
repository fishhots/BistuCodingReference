import main
import pyodbc
def get_access():
    conn_str = (
        r'DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};'
        r'DBQ=C:\Users\61903\Desktop\Python e\code\Database1.accdb;'
    )
    cnxn = pyodbc.connect(conn_str)
    return cnxn

def insert_table(dic, table_name):
    cnxn = get_access()
    cursor = cnxn.cursor()
    print(dic)
    # 创建表的 SQL 语句
    create_table_sql = f"""
        CREATE TABLE [{table_name}] (
            名称 VARCHAR(255),
            父亲 VARCHAR(255),
            母亲 VARCHAR(255),
            皇后 VARCHAR(255),
            妃 VARCHAR(255),
            贵妃 VARCHAR(255),
            皇贵妃 VARCHAR(255),
            子女 VARCHAR(255)
        )
    """
    # 执行创建表的 SQL 语句
    cursor.execute(create_table_sql)
    # 插入数据的 SQL 语句
    insert_sql = f"""
        INSERT INTO [{table_name}] (名称, 父亲, 母亲)
        VALUES (?, ?, ?)
    """
    # 执行插入数据的 SQL 语句
    cursor.execute(insert_sql, dic['king_name'], dic['father'], dic['mother'])
    list_queen = dic['queen']
    list_fei = dic['fei']
    list_guifei = dic['guifei']
    list_child = dic['children']
    list_huangguifei=dic['huangguifei']
    list_nqueen = []
    count = 0
    if dic['king_name']=='康熙帝':
       del list_fei[6]
    if dic['king_name']=='道光帝':
       del list_guifei[5]
    if dic['king_name']=='乾隆帝':
       del list_guifei[2]
    while (True):
        if count == len(list_queen) or count > len(list_queen):
            break
        name = list_queen[count] + '·' + list_queen[count + 1]
        count += 3
        list_nqueen.append(name)
    for item in list_nqueen:
        insert_sql = f"""
             INSERT INTO {table_name} (皇后)
             VALUES (?)
        """
        cursor.execute(insert_sql, item)
    count=0
    list_nfei=[]
    while (True):
        if count == len(list_fei) or count > len(list_fei):
            break
        name = list_fei[count] + '·' + list_fei[count + 1]
        count += 3
        list_nfei.append(name)
    if len(list_nfei) > 0:
        for item in list_nfei:
            insert_sql = f"""
                INSERT INTO {table_name} (妃)
                VALUES (?)
            """
            cursor.execute(insert_sql, item)
    count=0
    list_nhgfei=[]
    while (True):
        if count == len(list_huangguifei) or count > len(list_huangguifei):
            break
        name = list_huangguifei[count] + '·' + list_huangguifei[count + 1]
        count += 3
        list_nhgfei.append(name)
    if len(list_nhgfei) > 0:
        for item in list_nhgfei:
            insert_sql = f"""
                 INSERT INTO {table_name} (皇贵妃)
                 VALUES (?)
            """
            cursor.execute(insert_sql, item)
    count=0
    list_ngfei=[]
    while (True):
        if count == len(list_guifei) or count > len(list_guifei):
            break
        name = list_guifei[count] + '·' + list_guifei[count + 1]
        count += 3
        list_ngfei.append(name)
    if len(list_ngfei) > 0:
        for item in list_ngfei:
            insert_sql = f"""
                INSERT INTO {table_name} (贵妃)
                VALUES (?)
            """
            cursor.execute(insert_sql, item)
    if len(list_child) > 0:
        for item in list_child:
            insert_sql = f"""
                INSERT INTO {table_name} (子女)
                VALUES (?)
            """
            cursor.execute(insert_sql, item)

        # 提交更改
    # 提交更改
    cnxn.commit()

    # 关闭连接
    cnxn.close()
