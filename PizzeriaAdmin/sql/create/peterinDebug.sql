SELECT p.tuote_id, p.nimi, p.hinta, p.tilattavissa, GROUP_CONCAT(DISTINCT c.sisalto ORDER BY c.sisalto SEPARATOR ', ') AS Sisalto
FROM Tuote p
INNER JOIN Tuotteen_sisalto r ON p.tuote_id = r.tuote_id
INNER JOIN Sisalto c ON r.sisalto_id = c.sisalto_id
WHERE p.tuote_id = r.tuote_id
AND r.sisalto_id = c.sisalto_id
GROUP BY p.tuote_id
ORDER BY p.nimi;



INSERT INTO Sisalto (nimi, sisalto)
VALUES ('Aurajuusto','Valio');

INSERT INTO Sisalto (nimi, sisalto)
VALUES ('Pepperoni','Liha');

INSERT INTO Sisalto (nimi, sisalto)
VALUES ('Ananas','Mehico');

INSERT INTO Sisalto (nimi, sisalto)
VALUES ('Pillumehu','Vosu');

INSERT INTO Sisalto (nimi, sisalto)
VALUES ('Ei aineosia','Ei aineosia');


INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id)
VALUES (4,8);

INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id)
VALUES (4,6);

INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id)
VALUES (4,6);

INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id)
VALUES (4,6);

SELECT tuote_id FROM Tuote
ORDER BY tuote_id DESC
LIMIT 1;