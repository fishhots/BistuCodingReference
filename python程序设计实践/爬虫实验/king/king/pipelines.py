# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import pymysql
from scrapy.exceptions import DropItem

class KingPipeline:
    def process_item(self, item, spider):
        return item
class MySQLPipeline:
    def __init__(self):
        self.connection = pymysql.connect(host='localhost', user='root', password='qrewsdfa', database='spider_emperor',
                                       charset='utf8', use_unicode=True)  # 连接数据库
        self.cursor = self.connection.cursor()  # 创建游标
        print('连接成功！')
    def process_item(self,item,spider):
        # 确保Item中的字段不为空
        if not all(item[field] for field in item.fields):
            raise DropItem("Item is missing required fields.")

        # 动态选择表名
        table_name = f"{item['host']+'_'+item['relations']}"

        # 创建表（如果不存在）
        self.create_table_if_not_exists(table_name,f"{item['host']+'_'+item['relations']}")

        # 执行插入操作
        sql = f"INSERT INTO {table_name} ( name, relations,url) VALUES (%s, %s, %s)"
        values = ( item["name"], item["relations"],item["url"])

        try:
            self.cursor.execute(sql, values)
            self.connection.commit()
        except Exception as e:
            self.connection.rollback()
            raise DropItem(f"Failed to insert item into MySQL: {e}")

        return item

    def is_group_exists(self, group_name):
        # 执行 SHOW TABLES 查询
        show_tables_sql = f"SHOW TABLES LIKE '{group_name}%'"
        self.cursor.execute(show_tables_sql)
        result = self.cursor.fetchone()

        # 如果查询结果不为空，说明组存在
        return result is not None

    def create_table_if_not_exists(self, table_name, default_group="朱元璋"):
        # 检查表名是否已经包含了默认组名前缀
        if not table_name.startswith(default_group):
            table_name = f"{default_group}_{table_name}"

        # 创建表的SQL语句，你需要根据你的需求修改字段类型和约束
        create_table_sql = f"""
            CREATE TABLE IF NOT EXISTS {table_name} (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255),
                relations VARCHAR(255),
                url VARCHAR(255)
            )
        """

        # 执行创建表的SQL语句
        self.cursor.execute(create_table_sql)
        self.connection.commit()

    def open_spider(self, spider):
        self.connection = pymysql.connect(host='localhost', user='root', password='qrewsdfa', database='spider_emperor',
                                       charset='utf8', use_unicode=True)  # 连接数据库
        self.cursor = self.connection.cursor()

    def close_spider(self,spider):
        self.cursor.close()     #关闭游标
        self.connection.close()    #关闭数据库