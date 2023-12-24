import requests
from bs4 import BeautifulSoup

nonvisited=[]#未访问的URL列表
visited=[]#已经访问过的URL列表
datas=[]#价值数据

#获取url网页内容，注意这里有小缺陷，只能下载以http://为开头的网页内容
def getHtmlContent(url):    
    print('正在访问'+url)
    if len(url) <7:return ''
    if url[:7]=='http://':
        r=requests.get(url)
        if r.status_code==200:
            r.encoding = 'utf-8'
            html=r.text
            return html
    return ''

#解析网页中的超链接
def parseURLs(html):
    global nonvisited
    global visited
    
    soup = BeautifulSoup(html,"html.parser")

    #从文档中找到所有<a>标签的链接:
    for link in soup.find_all('a'):
        print(link.get('href'))#print(link['href'])#节点属性
        print(link.name)#节点名字
        print(link.get_text())#节点文字
        if link not in visited:
              nonvisited.append(link.get('href'))

#解析网页中的数据，这里没有实现
def parseData(html):
    soup = BeautifulSoup(html,"html.parser")

    
#初始化              
def init(root):
    global nonvisited
    global visited
    global datas
    nonvisited=[]
    visited=[]
    datas=[]
    
    nonvisited.append(root)
                   


init('http://www.bistu.edu.cn')

while len(nonvisited)>0:
    url=nonvisited.pop(0)
    visited.append(url)
    html=getHtmlContent(url)
    parseURLs(html)
    parseData(html)
