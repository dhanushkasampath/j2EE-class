create table reg_users(
reg_id int(4) PRIMARY KEY not null auto_increment,
user_name varchar(20),
password varchar(20),
fullname varchar(100),
city varchar(50),
sex varchar(10),
tele varchar(20),
email varchar(100)
);