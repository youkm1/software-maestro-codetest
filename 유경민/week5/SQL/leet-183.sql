SELECT c.Name AS Customers
FROM Customers c
LEFT JOIN Orders o ON c.id = o.CustomerId  #null을 나타내야하므로 NOT IN (X) INNER JOIN(X)은 매칭되는 rows만 나옴 
WHERE o.CustomerId IS NULL;
