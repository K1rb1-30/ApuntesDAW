### Subconsulta IN

``` MySQL
Manera sin el IN

SELECT DISTINCT c.first_name, c.last_name
FROM customers c
JOIN orders o ON c.id = o.customer_id
WHERE DATE(o.order_date) = '2006-03-24';

 Manera CON el IN 

SELECT c.first_name, c.last_name
FROM customers c
WHERE c.id IN (SELECT o.customer_id
FROM orders o WHERE o.order_date = '2006-03-24');
```


Subconsulta IN con LIMIT como arreglarlo.

```MYSQL
SELECT p.product_name
FROM products p
WHERE p.id IN ( SELECT * FROM (SELECT od.product_id FROM order_details od GROUP BY od.product_id ORDER BY COUNT(*) DESC LIMIT 2) AS temporal);
```


### Ejercicios de subconsultas

``` MYSQL
SELECT COUNT(*)
FROM Track t
WHERE t.UnitPrice = (SELECT t1.UnitPrice
FROM Track t1 GROUP BY t1.UnitPrice ORDER BY t1.UnitPrice DESC LIMIT 1);

SELECT t.Name
FROM Track t
WHERE t.UnitPrice = (SELECT t1.UnitPrice
FROM Track t1 GROUP BY t1.UnitPrice ORDER BY t1.UnitPrice DESC LIMIT 1)
ORDER BY t.Name DESC LIMIT 5;

SELECT t.Name, (t.Milliseconds / 1000) / 60 as Durada
FROM Track t
WHERE t.Milliseconds > 3*(SELECT AVG(t1.Milliseconds)
FROM Track t1)
ORDER BY t.Name, t.Milliseconds;

SELECT t.Name, SEC_TO_TIME(t.Milliseconds / 1000)
FROM Track t
WHERE t.Milliseconds > (SELECT t1.Milliseconds
FROM Track t1 WHERE t1.Name = 'Take the Celestra')
ORDER BY t.Name;

SELECT a.Name
FROM Artist a
WHERE a.ArtistId IN ( SELECT * FROM (SELECT a2.ArtistId
FROM Album a2 GROUP BY a2.ArtistId ORDER BY COUNT(*) DESC LIMIT 4) as tablita)
ORDER BY a.Name;

SELECT a.Title, COUNT(t.TrackId) AS quantitatCan
FROM Album a
JOIN Track t ON a.AlbumId = t.AlbumId
GROUP BY a.Title, a.AlbumId
HAVING COUNT(t.TrackId) = (SELECT COUNT(t2.TrackId) FROM Album a2 JOIN Track t2 ON a2.AlbumId = t2.AlbumId WHERE a2.Title = 'Live After Death')
ORDER BY a.Title;

SELECT
FROM Customer c
JOIN Invoice i ON c.CustomerId = i.CustomerId
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId

```