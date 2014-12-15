INSERT INTO Tilaus(kayttaja_id, tuote_id, maksutapa, toimitustapa, katuosoite, postinumero, postitoimipaikka, puhelinnumero, status, yhteensa)
VALUES (1, 12.245);

INSERT INTO Tilauksen_tuote (tilaus_id, tuote_id, gluteeniton, laktoositon)
VALUES (

);




SELECT p.name, p.price, p.is_shown, GROUP_CONCAT(DISTINCT c.content ORDER BY c.content SEPARATOR ', ') AS contents
FROM Products p
INNER JOIN ProductContentRows r ON p.product_id = r.product_id
INNER JOIN Contents c ON r.content_id = c.content_id
WHERE p.product_id = r.product_id
AND r.content_id = c.content_id
GROUP BY p.product_id
ORDER BY p.name;

SELECT varaus.varausID, tilaisuus.tilaisuusNimi, tilaisuusEsittaja.artistiNimi
FROM varaus, tilaisuus, tilaisuusEsittaja 
WHERE tilaisuus.tilaisuusID=varaus.tilaisuusID AND varaus.lunastettu=1
GROUP BY varaus.varausID
ORDER BY tilaisuus.tilaisuusNimi ASC

// THIS IS IT
SELECT Tilaus.tilaus_id, Tilaus.kayttaja_id, Tilaus.maksutapa, Tilaus.toimitustapa ,		Tilaus.katuosoite, Tilaus.postinumero, Tilaus.postitoimipaikka, Tilaus.puhelinnumero, Tilaus.yhteensa, Tilaus.tilaus_pvm, Tilaus.status,GROUP_CONCAT(DISTINCT Tuote.nimi ORDER BY
Tuote.nimi SEPARATOR ', ') AS Tuotteet
FROM Tilaus
INNER JOIN Tilauksen_tuote
ON Tilaus.tilaus_id = Tilauksen_tuote.tilaus_id
INNER JOIN Tuote
ON Tilauksen_tuote.tuote_id = Tuote.tuote_id
GROUP BY tilaus_id
ORDER BY Tilauksen_tuote.tuote_id ASC;

SELECT Tilaus.tilaus_id, Tilaus.maksutapa, Tuote.nimi,  GROUP_CONCAT(DISTINCT Tilauksen_tuote.tuote_id ORDER BY
Tilauksen_tuote.tuote_id) AS Tuotteet
FROM Tilaus
INNER JOIN Tilauksen_tuote
ON Tilaus.tilaus_id = Tilauksen_tuote.tilaus_id
INNER JOIN Tuote
ON Tilauksen_tuote.tuote_id = Tuote.tuote_id
GROUP BY tilaus_id
ORDER BY Tilauksen_tuote.tuote_id ASC;

