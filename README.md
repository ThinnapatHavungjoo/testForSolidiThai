# testForSolidiThai

This test I dicided to design and implement Back end service using Java Spring boot becuase I'm not good at C#.Net

I simulated RESTful APIs about subscript member for users.

Setup Development Environment.
	Language : JDK(java 20)
	Framwork : Springboot (Lastest Version)
	Project : Maven Project
	IDE : netbean18
	Database : MySQL server
	OS : Window


First I have done to create My Project Test and Database to connected them.

I created My Project Test with Command Line. It for Custom libery.

mkdir testForSolidiThai
cd testForSolidiThai
echo "" > pom.xml    
mkdir code
mkdir code/service
mkdir test
mkdir test/service
echo "" > code/service/Start.java
echo "" > code/service/MemberController.java
echo "" > code/service/MemberRepository.java
echo "" > test/service/Test.java
mkdir web
echo " " > application.properties


Created Database using MySQL server.

I used Mysql server with command line:
mysql -u root -p

Design Database:
If you want to run this code you can follow in 3. or you can change some code in Start.java and add Entity class for creat database.


1. User data 
	1.1 ID
	1.2 First name
	1.3 Last name 
	1.4 E-mail
2. Set data importance
	2.1 ID run auto.
	2.2 First name and Last name is an importance.
	2.3 data 1.4 don't repact
3. Create database:
create database memberdb;
use memberdb;
create table memberInfo(
	id integer unique not null auto_increment,
	first_name varchar(80) not null unique,
	last_name varchar(80) not null unique,
	email varchar(200) not null unique
);

Test to insert data to memberInfo.

insert into memberInfo(first_name, last_name, gender, email) values('firstname', 'lastname', 'demomail@hotmail.com');

create user adminmember identified with mysql_native_password by 'admin123';
//If you have user admin you can skip and grant your user for it.

grant all on memberdb.* to adminmember;

File: code/service/Start.java 
I have done to connected project and database with connection string and ceate class for table member_info from memberdb.


File: code/service/Repository.java

I ceated Repository Interface class


File: code/service/Controller.java
I created RestController for Request API mapping all of CRUD.

I test api with postman.
