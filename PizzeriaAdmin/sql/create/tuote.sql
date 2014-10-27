CREATE TABLE Tuote
(tuote_id INTEGER (3) NOT NULL AUTO_INCREMENT
,nimi VARCHAR (10) COLLATE utf8_swedish_ci NOT NULL
,tilattavissa BOOLEAN DEFAULT 0
,hinta DECIMAL NOT NULL,
,PRIMARY KEY (tuote_id)
)ENGINE=InnoDB;

CREATE TABLE Sisalto
(sisalto_id INTEGER (3) NOT NULL AUTO_INCREMENT
,nimi varchar(20) COLLATE utf8_swedish_ci NOT NULL
,sisalto varchar (50) COLLATE utf8_swedish_ci NOT NULL
,PRIMARY KEY (sisalto_id)
)ENGINE=InnoDB;

CREATE TABLE Tuotteen_sisalto
(sisalto_id INTEGER (3) NOT NULL
,tuote_id INTEGER (3) NOT NULL
,PRIMARY KEY (sisalto_id, tuote_id)
,FOREIGN KEY (sisalto_id) REFERENCES Sisalto(sisalto_id)
,FOREIGN KEY (tuote_id) REFERENCES Tuote(tuote_id)
)ENGINE=InnoDB;