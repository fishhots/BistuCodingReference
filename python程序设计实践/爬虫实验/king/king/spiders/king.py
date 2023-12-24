import scrapy
import bs4
import re
from ..items import KingItem

class EmperorSpider(scrapy.Spider):
    # 定义一个爬虫类EmperorSpider
    name = 'Emperor_Spider'
    # name是定义爬虫的名字，这个名字是爬虫的唯一标识。

    allowed_domains = ['zh.wikipedia.org']
    # allowed_domains是定义允许爬虫爬取的网址域名（不需要加https://）。
    # 如果网址的域名不在这个列表里，就会被过滤掉。

    start_urls = ['https://zh.wikipedia.org/wiki/%E7%9A%87%E5%A4%AA%E6%A5%B5']
    # start_urls是定义起始网址，就是爬虫从哪个网址开始抓取。
    # 其中的乱码为16进制的朱元璋
    # 并且allowed_domains的设定对start_urls里的网址不会有影响。
    '''
    def parse(self, response):
        # 使用BeautifulSoup解析HTML响应
        bs = bs4.BeautifulSoup(response.text, 'html.parser')

        # 定义皇帝字典{名字，网址}
        emperor_list = {}
        emperor_name = ''

        # 使用正则表达式匹配妃后和公主的模式
        pattern = re.compile('.*(妃|后)$')
        pattern1 = re.compile('.*公主$')

        # 爬取历任皇帝
        emperor_next = bs.find('table', {'class': ['infobox', 'vcard']}).find('tbody').findAll('tr')
        for tr in emperor_next:
            # 查找继任的<th>元素
            emp = tr.find('th', {'scope': 'row', 'style': 'text-align:left;white-space:nowrap;;'}, text='繼任')
            if emp:
                # 获取皇帝的名字和网址
                emp_name = tr.find('td').text.strip()
                emp_url = 'https://zh.wikipedia.org' + tr.find('td').find('a')['href']

                # 更新皇帝字典
                emperor_list.update({emp_name: emp_url})
                emperor_name = next(iter(emperor_list.keys()))
                break

        # 打印皇帝字典
        print(emperor_list)

        # 发送请求，继续爬取继任皇帝的详细信息
        yield scrapy.Request(url=emp_url, callback=self.parse)

        # 定义关系列表
        relations = ['父親', '母親', '王后', '子嗣']

        # 遍历关系列表
        for relation in relations:
            # 遍历历任皇帝的<tr>元素
            for tr in emperor_next:
                # 查找关系对应的<th>元素
                table = tr.find('th', {'scope': 'row', 'style': 'text-align:left;white-space:nowrap;;'}, text=relation)

                if table:
                    # 获取<td>元素，包含关系对应的人物信息
                    td_element = tr.findNext('td')
                    # 获取<a>元素列表
                    a_element = td_element.findAll('a')

                    # 处理不同关系的情况
                    if relation == '子嗣':
                        # 处理子嗣关系，过滤掉不符合条件的人物
                        for i, a in enumerate(a_element):
                            emp_name = a.getText()
                            if not pattern1.match(emp_name):
                                if i % 2 != 0 or pattern.match(emp_name):
                                    continue
                            emp_name = a.getText()
                            emp_url = a['href']

                            # 创建KingItem对象，表示人物信息
                            people = KingItem(host=emperor_name, url='https://zh.wikipedia.org' + emp_url,
                                              name=emp_name,
                                              relations=relation)
                            # 返回人物信息
                            yield people
                    else:
                        # 处理其他关系，遍历<a>元素列表
                        for i, a in enumerate(a_element):
                            # 过滤掉不符合条件的人物
                            if i % 2 != 0:
                                continue
                            emp_name = a.getText()
                            emp_url = a['href']

                            # 创建KingItem对象，表示人物信息
                            people = KingItem(host=emperor_name, url='https://zh.wikipedia.org' + emp_url,
                                              name=emp_name,
                                              relations=relation)
                            # 返回人物信息
                            yield people
    '''
    def parse(self, response):
        # parse是Scrapy里默认处理response的一个方法。
        bs = bs4.BeautifulSoup(response.text, 'html.parser')
        # 定义皇帝字典{名字，网址}
        emperor_list = {}
        emperor_name=''
        pattern = re.compile('.*(妃|后)$')
        pattern1=re.compile('.*公主$')
        # 爬取历任皇帝
        emperor_next = bs.find('table', {'class': ['infobox', 'vcard']}).find('tbody').findAll('tr')
        for tr in emperor_next:
            emp = tr.find('th', {'scope': 'row', 'style': 'text-align:left;white-space:nowrap;;'}, text='繼任')
            if emp:
                emp_name = tr.find('td').text.strip()
                emp_url = 'https://zh.wikipedia.org'+tr.find('td').find('a')['href']

                emperor_list.update({emp_name: emp_url})
                emperor_name = next(iter(emperor_list.keys()))
                break
        print(emperor_list)
        yield scrapy.Request(url=emp_url, callback=self.parse)

        relations=['父親','母親','王后','子嗣']

        for relation in relations:

            for tr in emperor_next:
                table=tr.find('th', {'scope': 'row', 'style': 'text-align:left;white-space:nowrap;;'}, text=relation)

                if table:
                    td_element = tr.findNext('td')
                    a_element=td_element.findAll('a')
                    if relation=='子嗣':
                        for i,a in enumerate(a_element):
                            emp_name = a.getText()
                            if not pattern1.match(emp_name):
                                if i % 2 != 0 or pattern.match(emp_name):
                                    continue
                            emp_name=a.getText()
                            emp_url=a['href']

                            people=KingItem(host=emperor_name,url='https://zh.wikipedia.org'+emp_url,name=emp_name,relations=relation)
                            yield  people
                    else:
                        for i,a in enumerate(a_element):
                            if i % 2 != 0:
                                continue
                            emp_name=a.getText()
                            emp_url=a['href']

                            people=KingItem(host=emperor_name,url='https://zh.wikipedia.org'+emp_url,name=emp_name,relations=relation)
                            yield  people



