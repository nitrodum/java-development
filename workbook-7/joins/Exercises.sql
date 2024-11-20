--1
SELECT ProductID, ProductName, UnitPrice, CategoryName
FROM products AS p
INNER JOIN categories AS c
ON p.CategoryID = c.CategoryID
ORDER BY CategoryName, ProductName;

--2
USE northwind;
SELECT ProductID, ProductName, UnitPrice, CompanyName AS SupplierName
FROM products AS p
INNER JOIN suppliers AS s
ON p.SupplierID = s.SupplierID
WHERE UnitPrice > 75
ORDER BY ProductName;

--3
USE northwind;
SELECT ProductID, ProductName, UnitPrice, CategoryName, CompanyName AS SupplierName
FROM products AS p
INNER JOIN suppliers AS s
ON p.SupplierID = s.SupplierID
INNER JOIN categories AS c
ON p.CategoryID = c.CategoryID
ORDER BY ProductName;

--4
USE northwind;
SELECT ProductName, CategoryName
FROM products AS p
INNER JOIN categories AS c
ON p.CategoryID = c.CategoryID
WHERE UnitPrice = (SELECT max(UnitPrice)
					FROM products)
ORDER BY ProductName;

--5
USE northwind;
SELECT OrderID, ShipName, ShipAddress, CompanyName AS ShippingCompanyName
FROM orders AS o
INNER JOIN shippers AS s
ON o.ShipVia = s.ShipperID
WHERE ShipCountry = "Germany";

--6
USE northwind;
SELECT OrderID, OrderDate, ShipName, ShipAddress
FROM orders AS o
INNER JOIN shippers AS s
ON o.ShipVia = s.ShipperID
INNER JOIN products AS p
WHERE ProductName = "Sasquatch Ale";