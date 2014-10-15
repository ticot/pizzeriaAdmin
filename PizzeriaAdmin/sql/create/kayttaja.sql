CREATE TABLE Kayttaja
     (kayttaja_id INTEGER (10) NOT NULL AUTO_INCREMENT
,enimi VARCHAR (10) COLLATE utf8_swedish_ci NOT NULL
,snimi VARCHAR (20) COLLATE utf8_swedish_ci NOT NULL
,katuosoite VARCHAR (20) COLLATE utf8_swedish_ci  NOT NULL
,postinro VARCHAR (5) COLLATE utf8_swedish_ci NOT NULL
,postitmp VARCHAR (10) COLLATE utf8_swedish_ci NOT NULL
,email VARCHAR (20) COLLATE utf8_swedish_ci
,puhelinnro VARCHAR (10) COLLATE utf8_swedish_ci NOT NULL
,salasana VARCHAR (10) COLLATE utf8_swedish_ci NOT NULL
,repvm TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
,level INTEGER (1) NOT NULL
,PRIMARY KEY (kayttaja_id)
)ENGINE=InnoDB;