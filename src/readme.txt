1.在ubuntu server 12.04安装mysql
  sudo apt-get install mysql-server
  sudo apt-get install mysql-client
2.修改mysql的配置，支持远程连接
$ sudo vim /etc/mysql/my.cnf
然后注释掉如下行：
#bind-address = 127.0.0.1
重启mysql
$ sudo /etc/init.d/mysql restart 
3.在ubuntu终端登录mysql
$ sudo mysql -u root -p
 输入密码
mysql> grant all privileges on *.* to 'root'@'%' identified by 'password';
mysql> flush privileges;
说明：
第一行命令解释如下，*.*：第一个*代表数据库名；第二个*代表表名。这里的意思是所有数据库里的所有表都授权给用户。root：授予root账号。“%”：表示授权的用户IP可以指定，这里代表任意的IP地址都能访问MySQL数据库。“password”：分配账号对应的密码，这里密码自己替换成你的mysql root帐号密码。
第二行命令是刷新权限信息，也即是让我们所作的设置马上生效。
4.创建数据库表： MySQL数据库
create database sshmysql;
use sshmysql;
CREATE TABLE `student` (
  `id` varchar(36) NOT NULL,
  `name` varchar(32) NOT NULL,
  `course` varchar(64) NOT NULL,
  `score` int(11) NOT NULL,
  `remarks` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
5.修改MySQL的字符编码方式，设置成UTF8，这样就可以支持中文了。
$ sudo vim /etc/mysql/my.cnf
[client]
default-character-set=utf8

[mysql]
default-character-set=utf8


[mysqld]
collation-server = utf8_unicode_ci
init-connect='SET NAMES utf8'
character-set-server = utf8
修改之后重启：
$ sudo service mysql restart

