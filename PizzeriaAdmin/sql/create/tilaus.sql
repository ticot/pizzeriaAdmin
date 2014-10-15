CREATE TABLE Tilaus
(tilaus_id INTEGER (10)NOT NULL AUTO_INCREMENT
,kayttaja_id INTEGER (10) NOT NULL
,maksutapa VARCHAR (100) NOT NULL
,hakutapa VARCHAR (100) NOT NULL
,tilauspvm TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
,toimituspvm DATE
,status VARCHAR (50) NOT NULL
,PRIMARY KEY (tilaus_id)
,FOREIGN KEY (kayttaja_id) REFERENCES Kayttaja (kayttaja_id)
)ENGINE=InnoDB;

CREATE TABLE Tilauksen_tuote
(tilaus_id INTEGER (10)NOT NULL
,tuote_id INTEGER (3) NOT NULL
,gluteeniton BOOLEAN NOT NULL
,laktoositon BOOLEAN NOT NULL
,fantasia VARCHAR (100) NOT NULL
,extra VARCHAR (100)
,PRIMARY KEY (tilaus_id,tuote_id)
,FOREIGN KEY (tilaus_id) REFERENCES Tilaus (tilaus_id)
,FOREIGN KEY (tuote_id) REFERENCES Tuote (tuote_id)
)ENGINE=InnoDB;