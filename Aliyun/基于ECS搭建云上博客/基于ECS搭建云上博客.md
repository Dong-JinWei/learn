# 基于ECS搭建云上博客

## 1、创建资源

购买服务器

## 2、连接ECS服务器

使用系统自带终端连接

1. 输入`ssh -V`检测是否安装`ssh`
2. 输入`ssh root@123.123.123.123`连接

## 3、安装 Apache HTTP 服务

Apache是世界使用排名第一的Web服务器软件。它可以运行在几乎所有广泛使用的计算机平台上，由于其跨平台和安全性被广泛使用，是最流行的Web服务器端软件之一。

1. 执行如下命令，安装Apache服务及其扩展包。

```
yum -y install httpd httpd-manual mod_ssl mod_perl mod_auth_mysql
```

2. 执行如下命令，启动Apache服务。

```
systemctl start httpd.service
```

3. 测试Apache服务是否安装并启动成功。

Apache默认监听80端口，所以只需在浏览器访问ECS分配的IP地址http://<ECS公网地址>

## 4、安装 MySQL 数据库

由于使用wordpress搭建云上博客，需要使用MySQL数据库存储数据，所以这一步我们安装一下MySQL。

1. 执行如下命令，下载并安装MySQL官方的`Yum Repository`。

```
wget http://dev.mysql.com/get/mysql57-community-release-el7-10.noarch.rpm
yum -y install mysql57-community-release-el7-10.noarch.rpm
yum -y install mysql-community-server
```

![img](https://img.alicdn.com/tfs/TB1BRnVHxz1gK0jSZSgXXavwpXa-958-431.png)

2. 执行如下命令，启动 MySQL 数据库。

```
systemctl start mysqld.service
```

3. 执行如下命令，查看MySQL运行状态。

```
systemctl status mysqld.service
```

![img](https://img.alicdn.com/tfs/TB1gszWHuT2gK0jSZFvXXXnFXXa-945-229.png)

4. 执行如下命令，查看MySQL初始密码。

```
grep "password" /var/log/mysqld.log
```

![img](https://img.alicdn.com/tfs/TB16.uB0FY7gK0jSZKzXXaikpXa-948-62.png)

5. 执行如下命令，登录数据库。

```
mysql -uroot -p
```

![img](https://img.alicdn.com/tfs/TB1Wz6UHvb2gK0jSZK9XXaEgFXa-675-226.png)

6. 执行如下命令，修改MySQL默认密码。

> **说明** 
>
> 
>
> - 您需要将下面命令中的NewPassWord1.修改为您要设置的数据库密码。
> - 新密码设置的时候如果设置的过于简单会报错，必须同时包含大小写英文字母、数字和特殊符号中的三类字符。
> - 注意每条完整的SQL命令结尾都有一个半角分号（;），如果多行命令中间没有分号分隔，这些命令将不会执行，直至遇到一个分号。

```
ALTER USER 'root'@'localhost' IDENTIFIED BY 'NewPassWord1.';
```

7. 执行如下命令，创建wordpress库。

```
create database wordpress; 
```

8. 执行如下命令，创建wordpress库。 执行如下命令，查看是否创建成功。

```
show databases;
```

9. 输入`exit`退出数据库。

![img](https://img.alicdn.com/tfs/TB14Bj0HxD1gK0jSZFKXXcJrVXa-836-664.png)

## 5、安装 PHP 语言环境

WordPress是使用PHP语言开发的博客平台，用户可以在支持PHP和MySQL数据库的服务器上架设属于自己的网站。也可以把WordPress当作一个内容管理系统（CMS）来使用。

1. 执行如下命令，安装PHP环境。

```
yum -y install php php-mysql gd php-gd gd-devel php-xml php-common php-mbstring php-ldap php-pear php-xmlrpc php-imap
```

2. 执行如下命令创建PHP测试页面。

```
echo "<?php phpinfo(); ?>" > /var/www/html/phpinfo.php
```

3. 执行如下命令，重启Apache服务。

```
systemctl restart httpd
```

\4.  打开浏览器，访问`http://<ECS公网地址>/phpinfo.php`，显示如下页面表示PHP语言环境安装成功。

![img](https://img.alicdn.com/tfs/TB1oCVpaepyVu4jSZFhXXbBpVXa-601-840.png)

## 6、Wordpress安装和配置

本小节将在已搭建好的LAMP 环境中，安装部署 WordPress

1. 执行如下命令，安装wordpress。

```
yum -y install wordpress
```

显示如下信息表示安装成功。

![img](https://img.alicdn.com/tfs/TB1b02VHEz1gK0jSZLeXXb9kVXa-1042-156.png)

2. 修改WordPress配置文件。

1）执行如下命令，修改wp-config.php指向路径为绝对路径。

```
# 进入/usr/share/wordpress目录。
cd /usr/share/wordpress
# 修改路径。
ln -snf /etc/wordpress/wp-config.php wp-config.php
# 查看修改后的目录结构。
ll
```

2）执行如下命令，移动wordpress到Apache根目录。

```
# 在Apache的根目录/var/www/html下，创建一个wp-blog文件夹。
mkdir /var/www/html/wp-blog
mv * /var/www/html/wp-blog/
```

3）执行以下命令修改wp-config.php配置文件。

在执行命令前，请先替换以下三个参数值。

- database_name_here为之前步骤中创建的数据库名称，本示例为wordpress。
- username_here为数据库的用户名，本示例为root。
- password_here为数据库的登录密码，本示例为NewPassWord1.。

```
sed -i 's/database_name_here/wordpress/' /var/www/html/wp-blog/wp-config.php
sed -i 's/username_here/root/' /var/www/html/wp-blog/wp-config.php
sed -i 's/password_here/NewPassWord1./' /var/www/html/wp-blog/wp-config.php
```

4）执行以下命令，查看配置文件信息是否修改成功。

```
cat -n /var/www/html/wp-blog/wp-config.php
```



![img](https://img.alicdn.com/tfs/TB1j02VHEz1gK0jSZLeXXb9kVXa-913-631.png)

3. 执行如下命令，重启Apache服务。

```
systemctl restart httpd
```

## 7、测试Wordpress

完成以上所有步骤后，就可以测试我们基于ECS所搭建的云上博客了。

1. 打开浏览器并访问http://<ECS公网IP>/wp-blog/wp-admin/install.php。

2.  根据以下信息完成wordpress初始化配置。

- Site Title：站点名称，例如：Hello ADC。
- Username：管理员用户名，例如：admin。
- Password：访问密码，例如：cIxWg9t@a8MJBAnf%j。
- Your Email：email地址，建议为真实有效的地址。若没有，可以填写虚拟email地址，但将无法接收信息，例如：admin@admin.com。