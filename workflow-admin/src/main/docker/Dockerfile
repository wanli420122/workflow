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