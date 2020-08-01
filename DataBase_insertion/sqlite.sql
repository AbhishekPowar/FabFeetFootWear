
create table owner (
	ownerId INTEGER PRIMARY key AUTOINCREMENT,
    ownerName varchar(30),
	password VARCHAR(50)
);
insert into owner (ownerName,password) values ('Admin1','admin');
insert into owner (ownerName,password) values ('Admin2','admin2');




create table branches (
	branchID INTEGER PRIMARY key AUTOINCREMENT,
	branchName VARCHAR(50),
	managerID number,
	managerPassword VARCHAR(50)
);
insert into branches (branchName, managerID, managerPassword) values ('Delhi', 1, 'alpha');
insert into branches (branchName, managerID, managerPassword) values ('Mumbai', 2, 'bravo');
insert into branches (branchName, managerID, managerPassword) values ('Kolkata', 3, 'charlie');
insert into branches (branchName, managerID, managerPassword) values ('Banglore', 4, 'delta');
insert into branches (branchName, managerID, managerPassword) values ('Chennai', 5, 'echo');
insert into branches (branchName, managerID, managerPassword) values ('Pune', 6, 'foxtrot');


create table customers (
	CustomerID INTEGER PRIMARY key AUTOINCREMENT,
	CustomerName VARCHAR(50),
	phone varchar(10),
	address VARCHAR(50)
);

insert into customers (CustomerName, phone, address) values ('Darshan', '9333389353', '66051 Northfield Circle');
insert into customers (CustomerName, phone, address) values ('Karthik', '9222828234', '7 Boyd Trail');
insert into customers (CustomerName, phone, address) values ('Bhavana', '8876230761', '41970 Moose Plaza');
insert into customers (CustomerName, phone, address) values ('Vinod', '8905025817', '980 Gateway Place');
insert into customers (CustomerName, phone, address) values ('Anandi', '8492376713', '265 Tennessee Street');
insert into customers (CustomerName, phone, address) values ('Sagari', '8789132267', '6667 Marcy Junction');
insert into customers (CustomerName, phone, address) values ('Akshay', '9250926819', '891 Springs Way');
insert into customers (CustomerName, phone, address) values ('Saukhya', '9542324456', '73418 Carpenter Road');
insert into customers (CustomerName, phone, address) values ('Prathibha', '8657317200', '46 Grover Parkway');
insert into customers (CustomerName, phone, address) values ('Sudha', '8892142539', '96972 Arkansas Avenue');







create table products (
	productId INTEGER PRIMARY key AUTOINCREMENT,
	productName VARCHAR(50)
);

insert into products (productName) values ('Red Shoe');
insert into products (productName) values ('Black Shoe');
insert into products (productName) values ('White Shoe');

insert into products (productName) values ('Red Bag');
insert into products (productName) values ('Black Bag');
insert into products (productName) values ('White Bag');

insert into products (productName) values ('Red Hand Bag');
insert into products (productName) values ('Black Hand Bag');
insert into products (productName) values ('White Hand Bag');

insert into products (productName) values ('Red Jacket');
insert into products (productName) values ('Black Jacket');
insert into products (productName) values ('White Jacket');


insert into products (productName) values ('Red Travel Bag');
insert into products (productName) values ('Black Travel Bag');
insert into products (productName) values ('White Travel Bag');




create table requests (
	requestId INTEGER PRIMARY key AUTOINCREMENT,
	branchId number,
	requestMsg VARCHAR(50),
	FOREIGN KEY(branchId) REFERENCES branches(branchID) 
);

insert into requests (branchId, requestMsg) values (3, 'Send Shoes');
insert into requests (branchId, requestMsg) values (1, 'Send Hand bags');
insert into requests (branchId, requestMsg) values (3, 'Shoes ID 3 are faulty');
insert into requests (branchId, requestMsg) values (1, 'Handbags have been recieved');
insert into requests (branchId, requestMsg) values (6, 'Customer has a new design');
insert into requests (branchId, requestMsg) values (5, 'Shipment as due tommarow');
insert into requests (branchId, requestMsg) values (5, 'I have recived shipment');
insert into requests (branchId, requestMsg) values (3, 'Cancel Jacket order ID 3');
insert into requests (branchId, requestMsg) values (4, 'Travel bags red color required');
insert into requests (branchId, requestMsg) values (2, 'Payemnt delayed');


create table inventory (
	productId number,
	branchId number,
	sizes number,
	quantity number,
	price number,
	FOREIGN KEY(branchId) REFERENCES branches(branchID) ,
	FOREIGN KEY(productId) REFERENCES products(productId) 
);

insert into inventory (productId, branchId, sizes, quantity, price) values (1, 1, 24, 60, 500);
insert into inventory (productId, branchId, sizes, quantity, price) values (2, 2, 30, 50, 900);
insert into inventory (productId, branchId, sizes, quantity, price) values (3, 3, 20, 30, 800);
insert into inventory (productId, branchId, sizes, quantity, price) values (4, 4, 20, 60, 500);
insert into inventory (productId, branchId, sizes, quantity, price) values (5, 5, 10, 40, 1900);
insert into inventory (productId, branchId, sizes, quantity, price) values (6, 6, 20, 30, 700);
insert into inventory (productId, branchId, sizes, quantity, price) values (7, 1, 20, 40, 1400);
insert into inventory (productId, branchId, sizes, quantity, price) values (8, 2, 20, 30, 1400);
insert into inventory (productId, branchId, sizes, quantity, price) values (9, 3, 10, 40, 1900);
insert into inventory (productId, branchId, sizes, quantity, price) values (10, 4, 30, 30, 500);
insert into inventory (productId, branchId, sizes, quantity, price) values (11, 5, 24, 60, 800);
insert into inventory (productId, branchId, sizes, quantity, price) values (12, 6, 14, 60, 1600);
insert into inventory (productId, branchId, sizes, quantity, price) values (13, 1, 24, 50, 1100);
insert into inventory (productId, branchId, sizes, quantity, price) values (14, 2, 30, 30, 400);
insert into inventory (productId, branchId, sizes, quantity, price) values (15, 3, 30, 60, 700);
insert into inventory (productId, branchId, sizes, quantity, price) values (1, 4, 20, 50, 1300);
insert into inventory (productId, branchId, sizes, quantity, price) values (2, 5, 30, 30, 1300);
insert into inventory (productId, branchId, sizes, quantity, price) values (3, 6, 30, 40, 1000);
insert into inventory (productId, branchId, sizes, quantity, price) values (4, 1, 30, 30, 1400);
insert into inventory (productId, branchId, sizes, quantity, price) values (5, 2, 20, 40, 1700);
insert into inventory (productId, branchId, sizes, quantity, price) values (6, 3, 10, 70, 500);
insert into inventory (productId, branchId, sizes, quantity, price) values (7, 4, 20, 50, 1000);
insert into inventory (productId, branchId, sizes, quantity, price) values (8, 5, 10, 50, 1400);
insert into inventory (productId, branchId, sizes, quantity, price) values (9, 6, 20, 80, 2000);
insert into inventory (productId, branchId, sizes, quantity, price) values (10, 1, 20, 70, 1800);
insert into inventory (productId, branchId, sizes, quantity, price) values (11, 2, 20, 60, 2000);
insert into inventory (productId, branchId, sizes, quantity, price) values (12, 3, 10, 70, 1400);
insert into inventory (productId, branchId, sizes, quantity, price) values (13, 4, 20, 40, 1200);
insert into inventory (productId, branchId, sizes, quantity, price) values (14, 5, 10, 50, 1600);
insert into inventory (productId, branchId, sizes, quantity, price) values (15, 6, 20, 30, 700);
insert into inventory (productId, branchId, sizes, quantity, price) values (1, 1, 20, 70, 1600);
insert into inventory (productId, branchId, sizes, quantity, price) values (2, 2, 20, 70, 1700);
insert into inventory (productId, branchId, sizes, quantity, price) values (3, 3, 10, 70, 1700);
insert into inventory (productId, branchId, sizes, quantity, price) values (4, 4, 30, 50, 500);
insert into inventory (productId, branchId, sizes, quantity, price) values (5, 5, 30, 50, 2000);
insert into inventory (productId, branchId, sizes, quantity, price) values (6, 6, 10, 70, 1700);
insert into inventory (productId, branchId, sizes, quantity, price) values (7, 1, 10, 70, 1700);
insert into inventory (productId, branchId, sizes, quantity, price) values (8, 2, 10, 60, 2000);
insert into inventory (productId, branchId, sizes, quantity, price) values (9, 3, 30, 60, 1400);
insert into inventory (productId, branchId, sizes, quantity, price) values (10, 4, 20, 70, 300);
insert into inventory (productId, branchId, sizes, quantity, price) values (11, 5, 20, 60, 500);
insert into inventory (productId, branchId, sizes, quantity, price) values (12, 6, 10, 50, 1000);
insert into inventory (productId, branchId, sizes, quantity, price) values (13, 1, 20, 50, 1900);
insert into inventory (productId, branchId, sizes, quantity, price) values (14, 2, 20, 40, 1000);
insert into inventory (productId, branchId, sizes, quantity, price) values (15, 3, 10, 40, 500);
insert into inventory (productId, branchId, sizes, quantity, price) values (1, 4, 30, 50, 300);
insert into inventory (productId, branchId, sizes, quantity, price) values (2, 5, 20, 70, 400);
insert into inventory (productId, branchId, sizes, quantity, price) values (3, 6, 20, 60, 900);
insert into inventory (productId, branchId, sizes, quantity, price) values (4, 1, 10, 40, 1900);
insert into inventory (productId, branchId, sizes, quantity, price) values (5, 2, 30, 50, 1300);



create table orders (
	orderId INTEGER PRIMARY key AUTOINCREMENT,
	customerId number,
	productId number,
	branchId number,
	sizes number,
	quantity number,
	amount number,
	orderDate varchar(50),
	FOREIGN KEY(branchId) REFERENCES branches(branchID) ,
	FOREIGN KEY(productId) REFERENCES products(productId) ,
	FOREIGN KEY(customerId) REFERENCES customers(CustomerID) 

);

insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (9, 14, 5, 28, 80, 400, '2020-07-29 20:22:40');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (5, 5, 5, 28, 90, 1900, '2019-08-10 11:31:09');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (10, 1, 4, 30, 50, 800, '2020-03-21 04:05:07');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (4, 12, 6, 30, 50, 1500, '2020-04-05 11:16:03');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (4, 3, 4, 30, 70, 700, '2020-03-10 06:51:54');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (9, 7, 1, 32, 80, 1400, '2020-02-25 16:36:40');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (1, 12, 6, 28, 90, 1700, '2020-07-29 17:49:26');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (10, 1, 2, 32, 80, 1000, '2020-07-18 19:28:33');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (10, 3, 1, 28, 40, 500, '2019-08-20 12:32:46');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (1, 13, 3, 30, 60, 1900, '2019-10-07 13:29:04');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (3, 2, 6, 32, 70, 1400, '2019-08-06 04:24:05');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (10, 8, 4, 30, 100, 1000, '2020-05-31 06:51:07');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (3, 14, 1, 32, 60, 1700, '2020-05-17 01:44:18');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (2, 13, 2, 32, 60, 1200, '2019-09-25 03:15:30');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (5, 6, 6, 28, 50, 1400, '2019-11-05 04:20:31');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (8, 13, 5, 28, 40, 300, '2019-12-15 18:08:31');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (9, 11, 4, 32, 50, 1800, '2019-11-17 13:21:10');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (5, 4, 5, 30, 90, 600, '2019-11-11 05:37:30');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (7, 10, 6, 30, 90, 1700, '2020-04-10 04:10:08');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (10, 3, 5, 32, 50, 1600, '2019-12-18 04:47:25');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (5, 1, 3, 32, 40, 2000, '2020-03-02 19:14:12');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (3, 8, 1, 28, 30, 400, '2020-01-10 01:20:20');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (6, 15, 2, 30, 70, 500, '2020-04-28 01:30:26');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (2, 7, 5, 32, 60, 1500, '2020-03-24 07:27:33');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (10, 11, 6, 30, 50, 400, '2020-06-26 05:06:16');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (9, 4, 6, 30, 70, 1500, '2019-11-16 02:57:22');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (1, 10, 6, 32, 80, 1000, '2020-04-01 13:55:02');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (9, 8, 6, 28, 80, 1800, '2019-08-14 03:39:33');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (9, 9, 1, 32, 60, 300, '2020-01-26 17:48:29');
insert into orders (customerId, productId, branchId, sizes, quantity, amount, orderDate) values (7, 1, 6, 30, 70, 400, '2019-09-27 07:32:14');


create table reviews (
	reviewId INTEGER PRIMARY key AUTOINCREMENT,
	customerName VARCHAR(50),
	productName VARCHAR(50),
	review VARCHAR(50)
);



insert into reviews (customerName, productName, review) values ('Karthik', 'Black Shoe', 'GOOD');
insert into reviews (customerName, productName, review) values ('Karthik', 'Red Jacket', 'BEST');
insert into reviews (customerName, productName, review) values ('Bhavana', 'Black Shoe', 'NICE');
insert into reviews (customerName, productName, review) values ('Karthik', 'Black Jacket', '');
insert into reviews (customerName, productName, review) values ('Vinod', 'Black Shoe', '');
insert into reviews (customerName, productName, review) values ('Karthik', 'Red Jacket', 'VERY POOR');
insert into reviews (customerName, productName, review) values ('Darshan', 'Travel Bag', 'BAD');
insert into reviews (customerName, productName, review) values ('Karthik', 'Red Bag', 'NICE');
insert into reviews (customerName, productName, review) values ('Karthik', 'White Shoe', '');
insert into reviews (customerName, productName, review) values ('Vinod', 'Red Shoe', 'NICE');







create table employees (
	employeeId INTEGER PRIMARY key AUTOINCREMENT,
	employeeName VARCHAR(50),
	designation VARCHAR(50),
	branchId number,
	FOREIGN KEY(branchId) REFERENCES branches(branchID) 

);

insert into employees (employeeName, designation, branchId) values ('Pranay', 'Sales Women', 4);
insert into employees (employeeName, designation, branchId) values ('Naitee', 'Sales Man', 6);
insert into employees (employeeName, designation, branchId) values ('Adah', 'Sales Women', 6);
insert into employees (employeeName, designation, branchId) values ('Pranay', 'Sales Women', 5);
insert into employees (employeeName, designation, branchId) values ('Dasya', 'Sales Man', 5);
insert into employees (employeeName, designation, branchId) values ('Adah', 'Sales Women', 4);
insert into employees (employeeName, designation, branchId) values ('Taksh', 'Sales Man', 3);
insert into employees (employeeName, designation, branchId) values ('Avni', 'Sales Man', 3);
insert into employees (employeeName, designation, branchId) values ('Joseph', 'Cashier', 2);
insert into employees (employeeName, designation, branchId) values ('Taksh', 'Sales Man', 4);
insert into employees (employeeName, designation, branchId) values ('Aadiv', 'Helper', 4);
insert into employees (employeeName, designation, branchId) values ('Zuber', 'Sales Women', 2);
insert into employees (employeeName, designation, branchId) values ('Hiya', 'Cleaner', 6);
insert into employees (employeeName, designation, branchId) values ('Mahika', 'Sales Man', 1);
insert into employees (employeeName, designation, branchId) values ('Saisha', 'Sales Women', 6);
insert into employees (employeeName, designation, branchId) values ('Kabir', 'Cashier', 1);
insert into employees (employeeName, designation, branchId) values ('Gian', 'Sales Man', 6);
insert into employees (employeeName, designation, branchId) values ('Yash', 'Helper', 6);
insert into employees (employeeName, designation, branchId) values ('Luv', 'Sales Women', 2);
insert into employees (employeeName, designation, branchId) values ('Pavati', 'Sales Man', 6);
insert into employees (employeeName, designation, branchId) values ('Vivaan', 'Sales Man', 1);
insert into employees (employeeName, designation, branchId) values ('Pranay', 'Sales Women', 6);
insert into employees (employeeName, designation, branchId) values ('Amoli', 'Sales Women', 1);
insert into employees (employeeName, designation, branchId) values ('Kaia', 'Sales Man', 4);
insert into employees (employeeName, designation, branchId) values ('Sarthak', 'Helper', 2);
insert into employees (employeeName, designation, branchId) values ('Pranay', 'Sales Man', 3);
insert into employees (employeeName, designation, branchId) values ('Yug', 'Cashier', 4);
insert into employees (employeeName, designation, branchId) values ('Mahika', 'Cashier', 3);
insert into employees (employeeName, designation, branchId) values ('Prisha', 'Sales Women', 1);
insert into employees (employeeName, designation, branchId) values ('Adah', 'Sales Women', 2);
