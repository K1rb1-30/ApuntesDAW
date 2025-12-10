
Para decir si existe algo

Los clientes que alguna vez han hecho un pedido para francia.

```MYSQL
SELECT c.CustomerId, c.FirstName, c.LastName 
FROM Customer c 
WHERE EXISTS (SELECT * FROM Invoice i WHERE i.CustomerId = c.CustomerId AND i.BillingCountry = 'France') 
ORDER BY c.CustomerId;
```

## NOT EXISTS

```MYSQL
SELECT c.CustomerId, c.FirstName, c.LastName 
FROM Customer c 
WHERE NOT EXISTS (SELECT 1 FROM Invoice i JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId JOIN Track t ON il.TrackId = t.TrackId WHERE i.CustomerId = c.CustomerId AND t.Composer = 'Johann Sebastian Bach') 
ORDER BY c.CustomerId;
```

