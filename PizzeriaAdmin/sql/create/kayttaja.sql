CREATE TABLE Kayttaja
     (kayttaja_id INTEGER (10) NOT NULL AUTO_INCREMENT
,etunimi VARCHAR (10) COLLATE utf8_swedish_ci NOT NULL
,sukunimi VARCHAR (20) COLLATE utf8_swedish_ci NOT NULL
,katuosoite VARCHAR (20) COLLATE utf8_swedish_ci  NOT NULL
,postinumero VARCHAR (5) COLLATE utf8_swedish_ci NOT NULL
,postitoimipaikka VARCHAR (100) COLLATE utf8_swedish_ci NOT NULL
,email VARCHAR (100) COLLATE utf8_swedish_ci
,puhelinnro VARCHAR (10) COLLATE utf8_swedish_ci NOT NULL
,salasana VARCHAR (100) COLLATE utf8_swedish_ci NOT NULL
,rekist_paivamaara TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
,level INTEGER (1) NOT NULL
,PRIMARY KEY (kayttaja_id)
)ENGINE=InnoDB;