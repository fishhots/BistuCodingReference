import Pages_mangers
import  SQL
import getking
if __name__ == '__main__':
    url_start='https://zh.wikipedia.org/wiki/%E9%A1%BA%E6%B2%BB%E5%B8%9D'
    #爬取页面起点地址
    nonvisit=[]
    #未访问的网址列表
    visit=[]
    #已访问的网站列表
    data=[]
    #用于保存价值数据
    nonvisit.append(url_start)
    #将初始地址添加到未访问列表中
    while len(nonvisit)!=0:
        url=nonvisit.pop()
        #当前访问的url
        result_data=Pages_mangers.request_url(url=url)
        #调用页面管理器的request_url函数对目标网站进行访问，并通过result_data接受页面返回信息
        print(result_data)
        result_dic=Pages_mangers.get_content(result_data)
        #调用页面管理器的get_content函数接收爬取的信息
        visit.append(url)
        #将网址添加到已访问列表
        url=result_dic.get('url')
        #判断爬取的下一个网站信息是否合法
        if url!='https://zh.wikipedia.org/':
            nonvisit.append(result_dic.get('url'))
            #如果合法则添加到未访问列表中
        SQL.insert_table(result_dic,result_dic.get('king_name'))
        data.append(result_dic)
        #对价值数据进行保存
        pass
    while(True):
        print('请输入要查询的皇帝编号：\n1.顺治帝\n2.康熙帝\n3.雍正帝\n4.乾隆帝\n5.嘉庆帝\n6.道光帝\n7.咸丰帝\n8.同治帝\n9.光绪帝\n10.溥仪\n11.退出')
        i=int(input())
        if i==1:
            getking.print_detail('顺治帝')
            continue
        if i==2:
            getking.print_detail('康熙帝')
            continue
        if i==3:
            getking.print_detail('雍正帝')
            continue
        if i==4:
            getking.print_detail('乾隆帝')
            continue
        if i==5:
            getking.print_detail('嘉庆帝')
            continue
        if i==6:
            getking.print_detail('道光帝')
            continue
        if i==7:
            getking.print_detail('咸丰帝')
            continue
        if i==8:
            getking.print_detail('同治帝')
            continue
        if i==9:
            getking.print_detail('光绪帝')
            continue
        if i==10:
            getking.print_detail('溥仪')
            continue
        if i==11:
            break

    pass