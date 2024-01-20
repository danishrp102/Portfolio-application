create table traded_stock if not exists (dummy_id integer not null auto_increment, quantity bigint, stock_id varchar(255), total_buy_price float(53), user_id integer, primary key (dummy_id));

create table stock if not exists(id varchar(255) primary key, name varchar(255), open_price double, high_price double, low_price double, close_price double, settlement_price double);

insert into stock(id, name, open_price, high_price, low_price, close_price, settlement_price)
values('101', 'Groww', 1200, 1400, 900, 1150, 950);

insert into stock(id, name, open_price, high_price, low_price, close_price, settlement_price)
values('102', 'Adobe', 250, 400, 250, 300, 350);

insert into stock(id, name, open_price, high_price, low_price, close_price, settlement_price)
values('103', 'IBM', 1600, 1900, 1500, 1550, 1650);

--create table traded_stock(dummy_id int primary key, quantity bigint, stock_id varchar(255), total_buy_price double, user_id int references );

create table users if not exists (id integer not null, primary key (id));

--insert into users(id)
--values(1);
--
--insert into users(id)
--values(2);
--
--insert into users(id)
--values(3);

--insert into traded_stock(stock_id, total_buy_price, user_id)
--values()
--
--insert into user_details(id, birth_date, name)
--values(10003, current_date, 'Ethan');
--
--insert into post(id, user_id, description)
--values(20001, 10001, 'I want to learn Spring Boot');
--
--insert into post(id, user_id, description)
--values(20002, 10002, 'I want to learn ELK Stack');
--
--insert into post(id, user_id, description)
--values(20003, 10001, 'I want to learn Rabbit MQ');
--
--insert into post(id, user_id, description)
--values(20004, 10002, 'I want to learn Kafka');
