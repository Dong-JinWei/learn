import re

pattern = r'[a-zA-Z]\w{3,5}[^_]$'  
#设置的长度为3-5，但是，实际 测试中，长度为5-7。比设定的长度多了两位。

print("提示：用户名必须以字母开头，5-7位，字母数字下划线，不能以下划线结尾")

while (True):
	string = input("请输入你的用户名:")
	
	if string == '':
		break
	try:
		result = re.match(pattern, string)
		print(result.group(0), '\n')
	except:
		print("用户名无效！")
