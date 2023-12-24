# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class KingItem(scrapy.Item):
    # define the fields for your item here like:
    # 定义关系人
    host = scrapy.Field()
    # 定义关系
    relations = scrapy.Field()
    # 定义名字
    name = scrapy.Field()
    # 定义目标网址
    url = scrapy.Field()
