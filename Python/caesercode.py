"""
导入string模块
初始演示字符串
"""
import string
demo_string = "Light of my life, fire of my loins. My sins, my soul."

"""凯撒密码：加密
"""
def caesar_lock(MyString):
    """制作加密表，并对MyString字符串进行加密
    使用maketrans、translate方法实现加密
    返回值：加密后的字符串
    """
    before = string.ascii_letters  #加密前的26个字母，a-z, A-Z
    ChangeLower = "C@#$%^&*()_+-=[H]{};<>RJ/|"  #小写字母加密表
    ChangeUpper = "1029384756qwerasdfzxcvhjkl"  #大写字母加密表
    add = ChangeLower + ChangeUpper  #拼接加密后的字母
    after = "".maketrans(before, add)  #开始加密
    return MyString.translate(after)  #返回加密后的字符串

demo_lock = caesar_lock(demo_string)

"""凯撒密码：解密
"""
def caesar_unlock(MyString):
    """使用加密表，对MyString进行解密
    使用maketrans、translate方法实现解密
    返回值：解密后的字符串
    """
    before = string.ascii_letters  #加密前的26个字母，a-z, A-Z
    ChangeLower = "C@#$%^&*()_+-=[H]{};<>RJ/|"  #小写字母加密表
    ChangeUpper = "1029384756qwerasdfzxcvhjkl"  #大写字母加密表
    add = ChangeLower + ChangeUpper  #拼接加密后的字母
    after = "".maketrans(add, before)  #开始解密
    return MyString.translate(after)  #返回解密后的字符串

demo_unlock = caesar_unlock(demo_lock)

print("加密前的内容：",demo_string)
print()
print("加密后的内容：", demo_lock)
print()
print("解密后的内容：", demo_unlock)