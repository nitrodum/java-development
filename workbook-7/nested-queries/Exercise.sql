--1
SELECT ProductName FROM northwind.products
WHERE UnitPrice in (SELECT max(UnitPrice)
					FROM northwind.products);

--2
SELECT OrderID, ShipName, ShipAddress FROM northwind.orders
WHERE ShipVia IN (SELECT ShipperID
					FROM northwind.shippers
                    where CompanyName = "Federal Shipping");

--3
SELECT OrderID FROM northwind.`order details`
WHERE ProductID IN (SELECT ProductID
					FROM northwind.products
                    WHERE ProductName = "Sasquatch Ale");

--4
SELECT FirstName, LastName FROM northwind.employees
WHERE EmployeeID in (SELECT EmployeeID
					FROM northwind.orders
                    WHERE OrderID = 10266);

--5
SELECT ContactName FROM northwind.customers
WHERE CustomerID in (SELECT CustomerID
					FROM northwind.orders
                    WHERE OrderID = 10266);