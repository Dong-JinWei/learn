# 学习内容

MyBatis

spring

SpringMvc

SSM整合

# Maven

Maven 翻译为"专家"、"内行"，是 Apache 下的一个纯 Java 开发的开源项目。基于项目对象模型（缩写：POM）概念，Maven利用一个中央信息片断能管理一个项目的构建、报告和文档等步骤。

Maven 是一个项目管理工具，可以对 Java 项目进行构建、依赖管理。

# 一、概念，好处

## 1、概念

- maven是服务于java平台的自动化**构建**工具
- 构建：将java程序、配置文件、JPS文件、HTML文件等生产出一个可以运行项目的过程

## 2、好处

存在问题：一个项目一个工程；下载jar包，添加jar包；一个jar包依赖的其他jar包也需要手动下载和添加；

- 项目设置遵循统一的规则。
- 任意工程中共享。
- 依赖管理包括自动更新。
- 一个庞大且不断增长的库。
- 可扩展，能够轻松编写 Java 或脚本语言的插件。
- 只需很少或不需要额外配置即可即时访问新功能。
- **基于模型的构建** − Maven能够将任意数量的项目构建到预定义的输出类型中，如 JAR，WAR 或基于项目元数据的分发，而不需要在大多数情况下执行任何脚本。
- **项目信息的一致性站点** − 使用与构建过程相同的元数据，Maven 能够生成一个网站或PDF，包括您要添加的任何文档，并添加到关于项目开发状态的标准报告中。
- **发布管理和发布单独的输出** − Maven 将不需要额外的配置，就可以与源代码管理系统（如 Subversion 或 Git）集成，并可以基于某个标签管理项目的发布。它也可以将其发布到分发位置供其他项目使用。Maven 能够发布单独的输出，如 JAR，包含其他依赖和文档的归档，或者作为源代码发布。
- **向后兼容性** − 您可以很轻松的从旧版本 Maven 的多个模块移植到 Maven 3 中。
- 子项目使用父项目依赖时，正常情况子项目应该继承父项目依赖，无需使用版本号，
- **并行构建** − 编译的速度能普遍提高20 - 50 %。
- **更好的错误报告** − Maven 改进了错误报告，它为您提供了 Maven wiki 页面的链接，您可以点击链接查看错误的完整描述。

## 3、Maven 功能

Maven 能够帮助开发者完成以下工作：

- 构建
- 文档生成
- 报告
- 依赖
- SCMs
- 发布
- 分发
- 邮件列表

# 二、安装

下载解压：

```shell
$ curl -O http://mirrors.hust.edu.cn/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
$ tar -xvf  apache-maven-3.3.9-bin.tar.gz
$ sudo mv -f apache-maven-3.3.9 /usr/local/
```

编辑 **/etc/profile** 文件 **sudo vim /etc/profile**，在文件末尾添加如下代码：

```shell
export MAVEN_HOME=/usr/local/apache-maven-3.3.9
export PATH=${PATH}:${MAVEN_HOME}/bin
```

保存文件，并运行如下命令使环境变量生效：

```shell
$ source /etc/profile
```

在控制台输入如下命令，如果能看到 Maven 相关版本信息，则说明 Maven 已经安装成功：

```shell
$ mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T00:41:47+08:00)
Maven home: /usr/local/apache-maven-3.3.9
Java version: 1.8.0_31, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_31.jdk/Contents/Home/jre
Default locale: zh_CN, platform encoding: ISO8859-1
OS name: "mac os x", version: "10.13.4", arch: "x86_64", family: "mac"

```

配置阿里云镜像

```xml
<localRepository>D:/work/repository</localRepository>

<mirrors>
     <mirror>
		   <id>nexus-aliyun</id>
		   <mirrorOf>central</mirrorOf>
		   <name>Nexus aliyun</name>
		   <url>http://maven.aliyun.com/nexus/content/groups/public</url>
	 </mirror>
</mirrors>
```

# 三、开发hello world

```shell
1. 创建的工程

项目名
		src
				main
						java
						resources
				test
						java
						resources
			pom.xml
				
2. 编写pom.xml文件
3. 编写源文件
4. 编写测试文件
5. 执行mvn命令编译、测试、打包、部署（在pom.xml所在目录下执行以下命令）
	5.1 清理：mvn clean
	5.2 编译主程序：mvn compile
	5.3 编译测试程序：mvn test-compile
	5.4 执行测试程序：mvn test
	5.5 打包：mvn package
	5.6 添加到仓库：mvn install
```

# 四、POM

POM( Project Object Model，项目对象模型 ) 是 Maven 工程的基本工作单元，是一个XML文件，包含了项目的基本信息，用于描述项目如何构建，声明项目依赖，等等。

执行任务或目标时，Maven 会在当前目录中查找 POM。它读取 POM，获取所需的配置信息，然后执行目标。

POM 中可以指定以下配置：

- 项目依赖
- 插件
- 执行目标
- 项目构建 profile
- 项目版本
- 项目开发者列表
- 相关邮件列表信息

pom.xml文件：

- 是maven工程的核心配置文件，与构建过程相关的设置都在该文件配置

- ```xml
    <groupId>org.example</groupId>
    <artifactId>idea</artifactId>
    <version>1.0-SNAPSHOT</version>
    
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
    </dependency>
  ```

  

# 五、坐标

使用以下三个向量在仓库中唯一定位一个maven工程：

```xml
  <!-- 公司或者组织的唯一标志，并且配置时生成的路径也是由此生成， 如com.companyname.project-group，maven会将该项目打成的jar包放本地路径：/com/companyname/project-group -->
	<!-- 公司或组织名字+项目名-->
  <groupId>com.companyname.project-group</groupId>

  <!-- 项目的唯一ID，一个groupId下面可能多个项目，就是靠artifactId来区分的 -->
	<!-- 模块名-->
  <artifactId>project</artifactId>

  <!-- 版本号 -->
  <version>1.0</version>
```



# 六、仓库

## 1、仓库分类

### 1.1 本地仓库

当前电脑上部署的仓库目录，为当前单呢上所有的maven工程服务

## 1.2 远程仓库

### 1.2.1 私服

搭建在局域网环境中，为局域网范围内的所有maven工程服务

### 1.2.2 中央仓库

架设到internet上，为全世界所有的maven工程服务

### 1.2.3 中央仓库镜像

为了分担中央仓库的流量，提升用户的访问速度

## 2、仓库保存的内容

maven自身所需要的插件

第三方框架工具的jar包

自己开发的maven工程

# 七、依赖

依赖有 **compile、test、provided**、runtime、system、import 6种

|                    | compile | test  |  provided   |
| :----------------: | :-----: | :---: | :---------: |
|  对主程序是否有效  |   是    |  无   |     是      |
| 对测试程序是否有效 |   是    |  是   |     是      |
|    是否参与打包    |   是    |  无   |     无      |
|    是否参与部署    |   是    |  无   |     无      |
|     典型jar包      |  log4j  | junit | servlet-api |

# 八、通过idea创建maven工