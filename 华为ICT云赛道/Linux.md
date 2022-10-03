# Linux--操作系统

## Shell Linux操作系统交互窗口

桌面右键打开终端，终端是Shell的一个窗口

## 命令

Linux使用命令来操作。

命令 \[选项] \[参数]

\- 短格式

\-- 长格式

### 帮助命令

`命令 --help`	帮助命令，可以显示命令的选项和参数以及使用方法

`man 命令`	命令手册

### ip地址查看

`ifconfig`

`ip a`

### 基础的系统命令

`shutdown -h 0`	关机

`shutdown -r 0`	重启

`reboot`	重启



`systemctl start 服务名`	启动服务

`systemctl stop 服务名`	停止

`systemctl restart 服务名`	重启

`systemctl status 服务名` 	查看状态



`service 服务名 stop`	旧版系统使用这个



`/etc/init.d/firewalld stop`	操作文件



`nmtui`	配置网络

```bash
#编辑文件配置网络
vim /etc/sysconfig/network-scripts/ifcfg-ens33

dhcp改为static
IPADDR=192.168.1.1
NETMASK=255.255.255.0
GATEWAY=192.168.1.1
DHS=114.114.114.114

systemctl restart network
```

`ps -aux`	查看系统状态

`top`	Linux系统所的任务管理器

### 文件和目录

cd 目录切换
|路径|功能|
|-----|-----|
|`/etc`	|放配置文件|
|`/`	|根目录|
|`home`	|用户文件|
|`/dev`	|设备文件目录|
|`/var`	|动态文件|
|`/tmp`	|回收站|
|`/opt`	|存放大文件|
|`/mnt`	|挂载点|

ls	查看当前目录下的内容

- -a 查看所有文件, 包括隐藏文件
- -l 查看文件的详细信息
- -d 查看指定目录信息

区分文件和目录

​	`-`开头的是文件

​	`d`开头的是目录

查看文件

- `cat 文件名`	查看文件内容
- `tail 文件名`	显示尾部十行
  - `tail -n 3 文件名`	查看后3行
- `head 文件名`	显示头部十行
  - `head -n 3 文件名`	查看前3行
- `more 文件名`	可以用空格键向下翻页(无法向上)
- `less 文件名`	翻页查看
  - `grep [要查看的字符\] 文件名`	查看文件见中是否包含括号中的字符

- mv 移动文件

- cp 复制文件
- pwd 查看当前所在目录
- rm 删除文件
  - -r 删除目录
  - -f 不需要确定删除
- touch 创建一个文件
- mkdir 创建一个目录

vim 三种模式

- 编辑模式
  - 从命令模式切换到编辑模式
    - a 在字符后插入
    - i 在当前位置插入
    - o 在行末插入
- 末行模式
  - :q 不报存退出
  - :wq 保存退出
  - :q! 强制退出
- 命令模式
  - dd 删除一行
  - x 删除一个字符
  - u 撤销
  - p 粘贴
  - y 复制
  - ESC 从末行模式/命令模式切换到编辑模式

### 权限管理

`-rw-r--r--` 

分别表示文件所有者, 所属组, 其他用户的权限

r: 读 = 4

w: 写 = 2

x: 执行 = 1

chmod 文件权限更改

`chmod u+x 文件名` 给所有者执行权限

`chmod 777 文件名` 说有人都是rwx

u: 所有者, g: 组, o: 其他人

### 打包压缩/搜索

`tar -cf 打包后的文件名 打包的文件`

- -c 打包
- -f 指定文件名
- -t 查看
- -x 解包

`tar -cf a.tar passwd`

`find 所搜的位置 -name 文件名`

- -name 搜索文件
- -user 搜索属于某个用户的文件

`find / -name a.tar` 在根目录下搜索a.tar
