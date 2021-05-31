

--OBRAZOVANJE

INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Osnovno obrazovanje', '1.', 
			'Osnovno obrazovanje i vaspitanje, Osnovno obrazovanje odraslih, Osnovno muzičko/baletsko obrazovanje');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Stručno osposobljavanje', '2.', 
			'Stručno osposobljavanje (1 godina), Obrazovanje za rad (2 godine), Obučavanje (120–360 sati obuke)');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Srednje stručno obrazovanje', '3.', 
			'Srednje stručno obrazovanje u trajanju od tri godine, Neformalno obrazovanje odraslih (min 960 sati obuke)');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Srednje obrazovanje', '4.', 
			'Srednje obrazovanje u trajanju od četiri godine (stručno, umetničko, gimnazijsko)');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Majstorsko i specijalističko obrazovanje', '5.', 
			'Majstorsko i specijalističko obrazovanje');			
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Osnovne akademske studije', '6.', 
			'Osnovne akademske studije(OAS, 180 ESPB), Osnovne strukovne studije (OSS, 180 ESPB),
			Osnovne akademske studije(OAS, 240),
			Specijalističke strukovne studije I stepena');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Master akademske studije', '7.', 
			'Integrisane akademske studije (IAS, maks. 360 ESPB), 
			Master akademske studije (MAS,180+120 ili 240+60 ESPB),
			Master strukovne studije (MSS, 120 ESPB),
			Specijalističke akademske studije (SAS, 60 ESPB)');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (nextval('obrazovanje_seq'), 'Doktorske studije', '8.', 
			'Doktorske studije (DS, 180 ESPB)');

--PREDUZECE
INSERT INTO "preduzece"("id", "naziv", "pib", "sediste", "opis")
	VALUES (nextval('preduzece_seq'), 'Crystal Pigeon', 103923476, 'Novi Sad', 'Preduzece za razvoj mobilnih aplikacija');
INSERT INTO "preduzece"("id", "naziv", "pib", "sediste", "opis")
	VALUES (nextval('preduzece_seq'), 'Hemofarm', 102037788, 'Vrsac',
		   'Primarnu delatnost kompanije čini proizvodnja kvalitetnih, efikasnih, bezbednih i dostupnih 
			farmaceutskih proizvoda.');
INSERT INTO "preduzece"("id", "naziv", "pib", "sediste", "opis")
	VALUES (nextval('preduzece_seq'), 'Plamen', 102001789, 'Indjija',
		   'Preduzeće PLAMEN je proizvođač elektro energetske opreme i pribora za niski i srednji napon.');
INSERT INTO "preduzece"("id", "naziv", "pib", "sediste", "opis")
	VALUES (nextval('preduzece_seq'), 'GAT', 102251754, 'Novi Sad', 
			'Osnovna delatnost GAT-a je trgovina na veliko elektroopremom i elektromaterijalom (unutrašnja i spoljna),
			izvođenje građevinskih i elektro-instalacionih radova.');
INSERT INTO "preduzece"("id", "naziv", "pib", "sediste", "opis")
	VALUES (nextval('preduzece_seq'), 'Energotehna', 105161799, 'Novi Sad',
			'Osnovna delatnost preduzeća “Energotehna” d.o.o. Novi Sad, su radovi iz oblasti izgradnje 
			energetskih objekata.');
			
--SEKTOR
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Razvoj iOS aplikacija', 'iOS', 1);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Razvoj Andorid aplikacija', 'Android', 1);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Proizvodnja', 'P', 3);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Prodaja', 'PR', 2);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Proizvodnja', 'P', 2);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Marketing', 'M', 5);			
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Nabavka', 'N', 2);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Nabavka', 'N', 4);	
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (nextval('sektor_seq'), 'Racunovodstvo', 'R', 5);	

--RADNIK
INSERT INTO "radnik"("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
	VALUES (nextval('radnik_seq'), 'Nikolina', 'Kotur', 011548753, 4, 9);	
INSERT INTO "radnik"("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
	VALUES (nextval('radnik_seq'), 'Jovan', 'Petrovic', 085696010, 7, 2);	
INSERT INTO "radnik"("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
	VALUES (nextval('radnik_seq'), 'Igor', 'Radivojevic', 011240056, 7, 6);	
INSERT INTO "radnik"("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
	VALUES (nextval('radnik_seq'), 'Milena', 'Vasiljevic', 056480011, 3, 5);	
INSERT INTO "radnik"("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
	VALUES (nextval('radnik_seq'), 'Anita', 'Kostic', 014785030, 6, 7);		
	
--TEST PODACI
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
	VALUES (-100, 'Test obrazovanje', '4.', 'Test opis');
INSERT INTO "preduzece"("id", "naziv", "pib", "sediste", "opis")
	VALUES (-100, 'Test preduzece', 10000000, 'Test grad', 'Test opis');
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
	VALUES (-100, 'Test sektor', 'T', 3);
INSERT INTO "radnik"("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
	VALUES (-100, 'Testime', 'Testprezime', 11000000, 4, -100);