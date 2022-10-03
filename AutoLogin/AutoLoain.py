import requests

url = 'http://10.1.4.131/'  # 这行是你需要根据自己的情况修改的地方
data = {
        "callback": "dr1004",
        "DDDDD": "000551",
        "upass": "181510",
        "0MKKey": "123456",
        "R1": "0",
        "R3": "0",
        "R6": "0",
        "para": "00",
        "v": "7783",
}
# 这整个header都是需要根据网页中的请求头来做修改
# 下面这个header是我的,你需要按照你自己浏览器中出现的Response Headers(请求标头)来修改。
header = {
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Accept-Encoding": "gzip, deflate",
    "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6",
    "Cache-Control": "max-age=0",
    "Connection": "keep-alive",
    "Cookie": "PHPSESSID=e2ap3nsulkam55aafan4bhvd21",
    "Host": "10.1.4.131",
    "Referer": "http://10.1.4.131/",
    "Upgrade-Insecure-Requests": "1",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36 Edg/94.0.992.31",
}
response = requests.post(url, data, headers=header).status_code  # 获取状态码

print("回应代码{}".format(response))  # 打印状态码