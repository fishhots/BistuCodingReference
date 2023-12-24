import requests
from bs4 import BeautifulSoup
headers = {
    'Accept-Language': 'zh-CN',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36'
}
#页面信息请求函数
def request_url(url):
    req_url = requests.get(url=url, headers=headers)
    if req_url.status_code == requests.codes.ok:
        # 用reqs_content接取返回的页面信息
        print('ok')
        reqs_content = req_url.content.decode('utf-8')
        return reqs_content
        pass
    else:

        return None
        pass

    pass


def get_content(page_data):
    page_soup = BeautifulSoup(page_data, 'html.parser')
    m_title=page_soup.select('h1[id="firstHeading"]')
    king=''
    for it in m_title:
        king=it.text
    tables = page_soup.select('table[class="infobox vcard"] tr')
    children = []
    queen = []
    fei = []
    huangguifei = []
    guifei = []
    father=''
    mother=''
    next_king=''
    url = 'https://zh.wikipedia.org/'
    for item in tables:
        item_th = item.select('th')
        item_td = item.select('td')
        for j in item_td:
            if j.previous == '继任':
                q_url=j.select('a')
                for q in q_url:
                     next_king=q.text
                     url += q.get('href')
                     break
                pass
            if j.previous == '王后':
                for i in j:
                    name = i.text
                    queen.append(name)
                    pass
                #print(queen)
                pass
            if j.previous == '子嗣':
                string = j.text
                name = ''
                count = 0
                while True:
                    if count == len(string)-1:
                        break
                        pass
                    elif string[count] == '：' or string[count] == '）':
                        name = ''
                        count += 1
                        while string[count] != '）':
                            if string[count] == '：':
                                name = ''
                                break
                                pass
                            name += string[count]
                            count += 1
                            pass
                        if len(name) > 0:
                            name += '）'
                            children.append(name)
                            pass
                    else:
                        count += 1
                        pass
                    pass
                #print(children)
                pass
            if j.previous == '皇贵妃':
                for i in j:
                    name = i.text
                    huangguifei.append(name)
                    pass
                #print(huangguifei)
                pass
            if j.previous == '父亲':
                father=j.text
            if j.previous == '母亲':
                mother=j.text
            if j.previous == '妃':
                for i in j:
                    name = i.text
                    fei.append(name)
                    pass
            if j.previous == '贵妃':
                for i in j:
                    name = i.text
                    guifei.append(name)
                    pass
                #print(guifei)
                pass
            pass
        pass
    if king=='溥仪':
        url='https://zh.wikipedia.org/'
        next_king='无'
    result_dic={"king_name":king,"next_king":next_king,"url":url,"father":father,"mother":mother,"queen":queen,"fei":fei,"huangguifei":huangguifei,"guifei":guifei,"children":children}
    return result_dic
    pass
    