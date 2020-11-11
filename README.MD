# Sharding JDBC Demo

基于 sharding-jdbc 4.x 演练，持续更新。

## 目录模块说明

database    数据库相关配置及建表语句

sharding-jdbc-algorithm     提取公共的分片算法

sharding-jdbc-simple        纯java代码配置示例，不包含其他功能集成

spring-sharding-jdbc        使用springboot集成的完整示例

## 环境搭建

#### 安装数据库

**Docker方式**

```
docker run --name master1 -p 3307:3306 -e MYSQL_ROOT_PASSWORD=engrz2021 -d mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --server-id=100
docker run --name slave1 -p 3308:3306 -e MYSQL_ROOT_PASSWORD=engrz2021 -d mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --server-id=200
docker run --name slave2 -p 3309:3306 -e MYSQL_ROOT_PASSWORD=engrz2021 -d mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --server-id=201
```

**MySQL多实例运行**

初始化数据库

```
mysqld --initialize-insecure --datadir=/home/mysql/master1 user=mysql
mysqld --initialize-insecure --datadir=/home/mysql/slave1 user=mysql
mysqld --initialize-insecure --datadir=/home/mysql/slave2 user=mysql
```

启动多实例

```
mysqld_multi --defaults-file=/home/mysql/my_multi.cnf --user=mysql start
```

## 配置主从复制

MySQL主从复制需要保证：

- 开启binlog日志
- 每台mysql服务器server id唯一

开启日志和设置id需修改my.cnf配置文件。Docker方式运行只需在命令后指定参数。

```
server-id=
```

查看server id

```
show variables like '%server_id%';
```

**创建主从复制账户并授权**

查看主库信息，执行

```
show master status;
```

记下上面主库的File和Position，在从库执行：

```
change master to master_host='主库IP地址',master_port=3307,master_user='root',master_password='engrz2021',master_log_file='主库的binlog文件名',master_log_pos=主库的Position;

start slave;
```

查看从库状态：

```
show slave status;
```

Slave_IO_Running: Yes    //此状态必须YES

Slave_SQL_Running: Yes     //此状态必须YES

以上两个字段为YES时说明主从环境OK。

因为用的root账户，拥有最大权限。所以不新建专用的账户用来做主从复制了。关于主从相关的配置这里不详述。

找到demo.sql，在主库中执行建库建表操作。主从环境运行正常的话可以看到从库也有了相应的数据库数据表。