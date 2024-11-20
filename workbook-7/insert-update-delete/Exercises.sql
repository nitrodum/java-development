--1
USE northwind;
INSERT INTO suppliers(SupplierID, CompanyName, ContactName,
 ContactTitle, Address, City, Region, PostalCode, Country,
 Phone, Fax, HomePage)
 VALUES (30, "Example CO", "John Doe", "Sales Manager", "123 Easy St",
 "Springfield", "TX", "12345", "USA", "123-456-7890", "123-456-7890", "Example.com");

--2
USE northwind;
INSERT INTO products(ProductID, ProductName, SupplierID, CategoryID,
QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel,
Discontinued)
VALUES(78, "Ex Pro", 30, 1, "5 boxes", 99.99, 5, 10, 10, 0);

--3
USE northwind;
SELECT products.*, suppliers.CompanyName AS Supplier
FROM products
INNER JOIN suppliers ON products.SupplierID = suppliers.SupplierID;

--4
USE northwind;
UPDATE products
SET UnitPrice = UnitPrice * 1.15
WHERE ProductID = 78;

--5
USE northwind;
SELECT * FROM products
WHERE SupplierID = 30;

--6
USE northwind;
DELETE FROM products
WHERE productID = 78;

--7
USE northwind;
DELETE FROM suppliers
WHERE SupplierID = 30;

--8
SELECT * FROM northwind.products;

--9
SELECT * FROM northwind.suppliers;
