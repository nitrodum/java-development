-- 1.
SELECT DISTINCT count(*) FROM northwind.suppliers;

--2
SELECT sum(Salary) FROM northwind.employees;

--3
SELECT min(UnitPrice) FROM northwind.products;

--4
SELECT avg(UnitPrice) FROM northwind.products;

--5
SELECT max(UnitPrice) FROM northwind.products;

--6
SELECT SupplierID, count(*) FROM northwind.products GROUP BY SupplierID;

--7
SELECT CategoryID, avg(UnitPrice) FROM northwind.products GROUP BY CategoryID;

--8
SELECT SupplierID, count(*) AS items FROM northwind.products GROUP BY SupplierID HAVING items > 4;

--9
SELECT ProductID, ProductName, UnitPrice*UnitsInStock AS InventoryValue
FROM northwind.products ORDER BY InventoryValue DESC, ProductName;