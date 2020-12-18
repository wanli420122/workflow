1.安装yum-utils：

```
yum install -y yum-utils device-mapper-persistent-data lvm2
```

2.为yum源添加docker仓库位置：

```
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
```

3.安装docker：

```
yum install docker-ce
```

4.启动docker：

```
systemctl start docker
```

5.安装并启动mysql，挂载宿主目录到镜像

```
docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root  \
-d mysql:5.7
```

5.1将sql文件拷贝到mysql容器

```
docker cp /mydata/*.sql mysql:/
```

6.进入mysql容器

```
docker exec -it mysql /bin/bash
```

7.打开mysql客户端

```
mysql -uroot -proot --default-character-set=utf8;
```

8.修改root帐号的权限，使得任何ip都能访问

```
grant all privileges on *.* to 'root'@'%';
```

9.创建数据库

```
create database test character set utf8;
```

10.将sql文件导入到数据库

```
use test;
source /*.sql;
```

11.启动应用，mysql容器

```
docker run -p 8080:8080 --name mall-tiny-docker-file \
--link mysql:db \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-tiny-docker-file/logs:/var/logs \
-d mall-tiny/mall-tiny-docker-file:0.0.1-SNAPSHOT
```

12.编写Dockerfile

```
# 该镜像需要依赖的基础镜像
FROM java:8
# 指定维护者的名字
MAINTAINER wabli
# 将当前目录下的jar包复制到docker容器的/目录下
ADD workflow-admin-1.0-SNAPSHOT.jar /workflow-admin-1.0-SNAPSHOT.jar
# 运行过程中创建一个workflow-admin-1.0-SNAPSHOT.jar文件
RUN bash -c 'touch /workflow-admin-1.0-SNAPSHOT.jar'
# 对外暴露的端口
EXPOSE 8181
# 执行jar启动命令
ENTRYPOINT ["java","-jar","workflow-admin-1.0-SNAPSHOT.jar"]
```

13.执行Dockerfile生成镜像

```
docker build -t mall-tiny/mall-tiny-docker-file:0.0.1-SNAPSHOT .
```

14.启动镜像

```
docker run -p 8080:8080 --name mall-tiny-docker \
--link mysql:db \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/mall-tiny-docker/logs:/var/logs \
-d mall-tiny/mall-tiny-docker:0.0.1-SNAPSHOT
```

15.开启端口

```
firewall-cmd --zone=public --add-port=8080/tcp --permanent
firewall-cmd --reload
```

