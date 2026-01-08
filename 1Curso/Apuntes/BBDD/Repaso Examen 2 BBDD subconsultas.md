```MySQL
SELECT t.Id, t.Nickname, t.Firstname, t.Lastname
FROM Traders t
JOIN Stays s ON t.Id = s.TraderId
GROUP BY t.Id, t.Nickname, t.Firstname, t.Lastname
HAVING SUM(TIMEDIFF(s.EndDate, s.StartDate ) + 1) = (
SELECT MAX(total_dies)
FROM(
SELECT SUM(TIMEDIFF(s2.EndDate, s2.StartDate) + 1) AS total_dies
FROM Stays s2
GROUP BY s2.TraderId
) AS temp)


SELECT CONCAT('De ', s1.Name, ' a ', s2.Name,' hi ha ', FORMAT(d.Distance, 2),' anys llum') AS frase
FROM SolarSystemsDistances d
JOIN SolarSystems s1 ON d.SystemId1 = s1.Id
JOIN SolarSystems s2 ON d.SystemId2 = s2.Id
WHERE d.Distance <= (
SELECT MAX(Distance)
FROM (
SELECT Distance
FROM SolarSystemsDistances
ORDER BY Distance
LIMIT 11
) x)
ORDER BY d.Distance, s1.Name;


SELECT p.Name, COUNT(*) as visites
FROM Traders t
JOIN Stays s ON s.TraderId = t.Id
JOIN Planets p ON p.Id = s.PlanetId
WHERE t.Firstname = 'Roys' AND t.Lastname = 'Vedstra'
GROUP BY p.Id, p.name
HAVING visites = (
SELECT MAX(total_visites)
FROM(
SELECT COUNT(*) AS total_visites
FROM Traders t2
JOIN Stays s2 ON s2.TraderId = t2.Id
WHERE t2.Firstname = 'Roys' AND t2.Lastname = 'Vedstra'
GROUP BY s2.PlanetId
)x )


SELECT t.Nickname, ROUND(COALESCE(SUM(so.AcquisitionPrice), 0)) AS TotalGastat
FROM Traders t
LEFT JOIN ShipOwners so ON so.TraderId = t.Id
AND YEAR(so.AcquisitionDate) BETWEEN 2260 AND 2275
GROUP BY t.Id, t.Nickname
ORDER BY t.Nickname;

SELECT s.Id, s.Name, ROUND(so.AcquisitionPrice, 2) as preu
FROM Ships s
JOIN ShipOwners so ON s.Id = so.ShipId
JOIN Traders t ON so.TraderId = t.Id
WHERE t.Firstname = 'Eriska' AND t.Lastname = 'Hordell'
GROUP BY s.Id, s.Name, so.AcquisitionPrice
ORDER BY preu DESC, s.Id

```