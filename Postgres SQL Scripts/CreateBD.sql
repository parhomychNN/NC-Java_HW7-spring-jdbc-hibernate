drop table customer cascade;
drop table shop cascade;
drop table book cascade;
drop table purchase cascade;

CREATE TABLE customer
(
    customer_id SERIAL PRIMARY KEY,
    LastName CHARACTER VARYING(30),
    District CHARACTER VARYING(30),
    Discount INTEGER
);

CREATE TABLE shop
(
    shop_id SERIAL PRIMARY KEY,
    Name CHARACTER VARYING(30),
    District CHARACTER VARYING(30),
    Commission INTEGER
);

CREATE TABLE book
(
    book_id SERIAL PRIMARY KEY,
    Name CHARACTER VARYING(30),
	  Price NUMERIC (10,2),
    Stock CHARACTER VARYING(30),
    Quantity INTEGER
);

CREATE TABLE purchase
(
    purchase_Id SERIAL PRIMARY KEY,
	  Purchase_Date DATE,
    Seller INTEGER REFERENCES shop (shop_id) ,
	  Customer INTEGER REFERENCES customer (customer_id),
	  Book INTEGER REFERENCES book (book_id),
    Quantity INTEGER,
	  Purchase_Sum NUMERIC (10,2)
);

insert INTO book (name, price, stock, quantity) VALUES ('Три мушкетера', 453, 'Сормовский', 12);
insert INTO book (name, price, stock, quantity) VALUES ('Намедни', 340, 'Нижегородский', 15);
insert INTO book (name, price, stock, quantity) VALUES ('Алхимик', 230, 'Сормовский', 3);
insert INTO book (name, price, stock, quantity) VALUES ('Отцы и дети', 450, 'Советский', 4);
insert INTO book (name, price, stock, quantity) VALUES ('Эмануэль', 454, 'Нижегородский', 2);
insert INTO book (name, price, stock, quantity) VALUES ('Забота о детях', 567, 'Сормовский', 25);
insert INTO book (name, price, stock, quantity) VALUES ('Java in action', 434, 'Советский', 34);
insert INTO book (name, price, stock, quantity) VALUES ('Python', 583, 'Нижегородский', 3);
insert INTO book (name, price, stock, quantity) VALUES ('Архитектура', 389, 'Советский', 0);
insert INTO book (name, price, stock, quantity) VALUES ('Соль земли', 433, 'Сормовский', 12);
insert INTO book (name, price, stock, quantity) VALUES ('Лабуда', 765, 'Нижегородский', 5);
insert INTO book (name, price, stock, quantity) VALUES ('Танзания', 22000, 'Сормовский', 23);
insert INTO book (name, price, stock, quantity) VALUES ('Прогулки по Праге', 324, 'Советский', 4);
insert INTO book (name, price, stock, quantity) VALUES ('Фиолетовое солнце', 122, 'Нижегородский', 34);
insert INTO book (name, price, stock, quantity) VALUES ('Продажи', 25000, 'Сормовский', 25);
insert INTO book (name, price, stock, quantity) VALUES ('Том Сойер', 466, 'Нижегородский', 95);
insert INTO book (name, price, stock, quantity) VALUES ('Целина', 2354, 'Советский', 23);
insert INTO book (name, price, stock, quantity) VALUES ('Целина', 3344, 'Нижегородский', 6);
insert INTO book (name, price, stock, quantity) VALUES ('Целина', 2333, 'Советский', 33);
insert INTO book (name, price, stock, quantity) VALUES ('Windows для детей', 350, 'Советский', 25);

insert INTO customer (LastName, District, Discount) VALUES ('Иванов', 'Нижегородский', 2);
insert INTO customer (LastName, District, Discount) VALUES ('Петров', 'Сормовский', 5);
insert INTO customer (LastName, District, Discount) VALUES ('Сидоров', 'Советский', 11);
insert INTO customer (LastName, District, Discount) VALUES ('Пархоменко', 'Нижегородский', 13);
insert INTO customer (LastName, District, Discount) VALUES ('Волкова', 'Сормовский', 16);
insert INTO customer (LastName, District, Discount) VALUES ('Вострова', 'Советский', 10);
insert INTO customer (LastName, District, Discount) VALUES ('Жукова', 'Нижегородский', 25);
insert INTO customer (LastName, District, Discount) VALUES ('Морозова', 'Сормовский', 20);

insert INTO shop (Name, District, Commission) VALUES ('Магаз в Сормово', 'Сормовский', 20);
insert INTO shop (Name, District, Commission) VALUES ('Магаз в Центре', 'Нижегородский', 15);
insert INTO shop (Name, District, Commission) VALUES ('Магаз на Советской', 'Советский', 10);
insert INTO shop (Name, District, Commission) VALUES ('Магаз в Автозе', 'Автозаводский', 13);


insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-04-01', 1, 1, 20, 2, (select price FROM book where book_id = 20) * 2);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-04-02', 2, 2, 12, 3, (select price FROM book where book_id = 12) * 3);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-05-01', 3, 3, 5, 2, (select price FROM book where book_id = 5) * 2);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-06-02', 1, 4, 17, 1, (select price FROM book where book_id = 17) * 1);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-07-01', 2, 5, 4, 1, (select price FROM book where book_id = 4) * 1);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-08-01', 3, 6, 16, 3, (select price FROM book where book_id = 16) * 3);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-04-06', 3, 7, 19, 2, (select price FROM book where book_id = 19) * 2);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-04-02', 3, 8, 8, 2, (select price FROM book where book_id = 8) * 2);
insert into purchase (Purchase_Date, Seller, Customer, Book, Quantity, Purchase_Sum) VALUES ('2019-01-02', 4, 8, 8, 2, (select price FROM book where book_id = 8) * 2);

select * from book;
select * from customer;
select * from shop;
select * from purchase;

