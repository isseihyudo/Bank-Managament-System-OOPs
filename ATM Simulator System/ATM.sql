create database atmsimulatorsystem;
show databases;
use atmsimulatorsystem;
show tables; 
select * from signup3;

create table signup2(formNo varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(10), aadhar varchar(12), senior varchar(20), existingAccount varchar(20));
drop table atm;
select * from login;
select * from atm;
create  table  signup (formNo varchar(20),name varchar(20),fname varchar(20),dob varchar(20),gender varchar(20),email  varchar(20),marital varchar(20),address varchar(50),city varchar(20),state varchar(20),pincode varchar(20));

select * from signup3;
DESC signup;
create table signup3(formNo varchar (10), accountType1 varchar(50), cardNo1 varchar(20), pinNo1 varchar(10), facility varchar(255));
SET SQL_SAFE_UPDATES = 0;
create table login(formNo varchar(10), cardNo1 varchar(15), pinNo1 varchar(5));
create table atm(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));

select * from login; 
select * from signup;
select * from signup2;
select * from signup3;
select * from atm;