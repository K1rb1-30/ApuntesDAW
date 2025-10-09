Examen de prueba para practicar los enunciados estan en el drive.

```SQL
SELECT film_id, title, description, `length`

FROM film

WHERE description LIKE '%dentist%'

AND description LIKE '%drama%'

ORDER BY `length` DESC LIMIT 4;

  

SELECT payment_id, customer_id, amount, staff_id

FROM payment

WHERE staff_id = 1 AND (amount < 2 OR amount > 10)

ORDER BY customer_id, amount;

  

  

SELECT first_name, last_name

FROM customer

WHERE first_name LIKE '%a%a%a' AND last_name NOT LIKE '%a%';

  

SELECT film_id, title, rental_rate, special_features, rating, replacement_cost

FROM film

WHERE rating = 'PG-13' AND replacement_cost > 10

OR rating != 'PG-13'AND special_features LIKE '%Deleted Scenes%'

ORDER BY title;

  

SELECT DISTINCT c.city

FROM city c

JOIN address a ON c.city_id = a.city_id

JOIN store s ON a.address_id = s.address_id

JOIN inventory i ON s.store_id = i.store_id

JOIN film f ON i.film_id = f.film_id

JOIN film_actor fa ON f.film_id = fa.film_id

JOIN actor ac ON fa.actor_id = ac.actor_id

WHERE ac.first_name = 'Elvis'

AND ac.last_name = 'Marx';

  

  

  

SELECT cus.first_name, cus.last_name

FROM customer cus

JOIN country c

WHERE cus.first_name = c.country;

  

SELECT f.title, c.name

FROM film f

JOIN film_category fc ON f.film_id = fc.film_id

JOIN category c ON fc.category_id = c.category_id

WHERE f.rating = 'PG'

ORDER BY c.name, f.title;

  

SELECT p.payment_id, p.amount, c.first_name, c.last_name

FROM payment p

JOIN customer c ON p.customer_id = c.customer_id

LEFT JOIN rental r ON p.rental_id = r.rental_id

WHERE r.rental_id IS NULL;

  

SELECT DISTINCT c.city

FROM city c

JOIN address a ON c.city_id = a.city_id

JOIN customer cus ON a.address_id = cus.address_id;

  

SELECT f.title

FROM film f

LEFT JOIN inventory i ON f.film_id = i.film_id

WHERE i.film_id IS NULL;
```

