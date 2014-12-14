CREATE TABLE Tilaus
(tilaus_id INTEGER (10) NOT NULL AUTO_INCREMENT
,kayttaja_id INTEGER (10) NOT NULL
,maksutapa VARCHAR (100) NOT NULL
,toimitustapa VARCHAR (100) NOT NULL
,tilaus_pvm TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
,toimitus_paivamaara DATE NOT NULL 
,katuosoite VARCHAR (100) NOT NULL
,postinumero VARCHAR (100) NOT NULL
,postitoimipaikka VARCHAR (100) NOT NULL
,puhelinnumero VARCHAR (100) NOT NULL
,status INTEGER (10) NOT NULL
,yhteensa DECIMAL(5,2) NOT NULL
,PRIMARY KEY (tilaus_id)
,FOREIGN KEY (kayttaja_id) REFERENCES Kayttaja (kayttaja_id)
)ENGINE=InnoDB;

CREATE TABLE Tilauksen_tuote
(tilaus_id INTEGER (10)NOT NULL
,tuote_id INTEGER (10) NOT NULL
,gluteeniton BOOLEAN NOT NULL
,laktoositon BOOLEAN NOT NULL
,PRIMARY KEY (tilaus_id,tuote_id)
,FOREIGN KEY (tilaus_id) REFERENCES Tilaus (tilaus_id)
,FOREIGN KEY (tuote_id) REFERENCES Tuote (tuote_id)
)ENGINE=InnoDB;	