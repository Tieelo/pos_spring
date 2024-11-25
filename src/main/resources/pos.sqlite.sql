BEGIN TRANSACTION;
DROP TABLE IF EXISTS "groups";
CREATE TABLE "groups" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL UNIQUE,
	"salevolume"	REAL NOT NULL,
	"measurement"	TEXT NOT NULL,
	"tax"	REAL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "invoice";
CREATE TABLE "invoice" (
	"id"	INTEGER,
	"item_name"	TEXT,
	"amount"	REAL,
	"total_price"	REAL,
	"bill_cost"	REAL,
	"bill_number"	TEXT,
	"date"	TEXT,
	"storno"	INTEGER,
	PRIMARY KEY("id" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "items";
CREATE TABLE "items" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL,
	"price"	REAL NOT NULL,
	"amount"	REAL NOT NULL,
	"groups_id"	INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "groups" VALUES (1,'Alkoholfrei',0.3,'Liter',0.19);
INSERT INTO "groups" VALUES (2,'Cocktails',0.2,'Liter',0.19);
INSERT INTO "groups" VALUES (3,'Mocktails',0.2,'Liter',0.19);
INSERT INTO "groups" VALUES (4,'Heissgetraenke',1.0,'Portion',0.19);
INSERT INTO "groups" VALUES (5,'Wein',0.2,'Liter',0.19);
INSERT INTO "groups" VALUES (6,'Speisen',1.0,'Portion',0.07);
INSERT INTO "groups" VALUES (7,'Saft',0.2,'Liter',0.07);
INSERT INTO "groups" VALUES (8,'Groß',0.5,'Liter',0.19);
INSERT INTO "items" VALUES (1,'Cafe.Creme',2.7,30.0,4);
INSERT INTO "items" VALUES (2,'Cafe.Hag',2.7,30.0,4);
INSERT INTO "items" VALUES (3,'Milchkaffee',2.9,30.0,4);
INSERT INTO "items" VALUES (4,'Latte.Macchiato',2.9,30.0,4);
INSERT INTO "items" VALUES (5,'Cappuccino',2.9,30.0,4);
INSERT INTO "items" VALUES (6,'Espresso',2.5,30.0,4);
INSERT INTO "items" VALUES (7,'Esspresso.M',2.5,30.0,4);
INSERT INTO "items" VALUES (8,'Espresso.Dopio',2.5,30.0,4);
INSERT INTO "items" VALUES (9,'Milch.Honig',3.0,30.0,4);
INSERT INTO "items" VALUES (10,'Kakao',3.5,29.0,4);
INSERT INTO "items" VALUES (11,'Kakao.M',3.9,30.0,4);
INSERT INTO "items" VALUES (12,'Schwarzer.Tee',2.7,30.0,4);
INSERT INTO "items" VALUES (13,'Grüner.Tee',2.7,30.0,4);
INSERT INTO "items" VALUES (14,'Kräutertee',2.7,30.0,4);
INSERT INTO "items" VALUES (15,'Früchtetee',2.7,30.0,4);
INSERT INTO "items" VALUES (16,'Wasser',2.7,195.0,1);
INSERT INTO "items" VALUES (17,'Apfelschorle',3.2,119.0,1);
INSERT INTO "items" VALUES (18,'Cola',3.2,120.0,1);
INSERT INTO "items" VALUES (19,'Fanta',3.2,80.0,1);
INSERT INTO "items" VALUES (20,'Schweppes',3.1,120.0,1);
INSERT INTO "items" VALUES (21,'Eistee',3.2,118.0,1);
INSERT INTO "items" VALUES (22,'Fassbrause',3.2,120.0,1);
INSERT INTO "items" VALUES (23,'Koelsches.Wasser',3.2,120.0,1);
INSERT INTO "items" VALUES (24,'Grauburgunder',5.5,10.0,5);
INSERT INTO "items" VALUES (25,'Chardonnay',5.9,5.0,5);
INSERT INTO "items" VALUES (26,'Muskateller',6.2,10.0,5);
INSERT INTO "items" VALUES (27,'Riesling',6.5,10.0,5);
INSERT INTO "items" VALUES (28,'Spaetburgunder',7.5,10.0,5);
INSERT INTO "items" VALUES (29,'Primitivo',6.5,10.0,5);
INSERT INTO "items" VALUES (30,'Tempranillo',7.9,10.0,5);
INSERT INTO "items" VALUES (31,'Sekt',5.5,10.0,5);
INSERT INTO "items" VALUES (32,'Lugana',6.9,10.0,5);
INSERT INTO "items" VALUES (33,'Sauvignon Blanc',6.9,10.0,5);
INSERT INTO "items" VALUES (34,'Rose',5.9,7.0,5);
INSERT INTO "items" VALUES (35,'Koelsch',2.7,90.0,8);
INSERT INTO "items" VALUES (36,'Pils',3.0,20.0,8);
INSERT INTO "items" VALUES (37,'Weizen',4.5,30.0,8);
INSERT INTO "items" VALUES (38,'Desperados',4.5,10.0,8);
INSERT INTO "items" VALUES (39,'Malzbier',3.2,15.0,8);
INSERT INTO "items" VALUES (40,'WhiskyCola',6.0,15.0,8);
INSERT INTO "items" VALUES (41,'RumCola',5.8,15.0,8);
INSERT INTO "items" VALUES (42,'WodkaLemon',5.8,15.0,8);
INSERT INTO "items" VALUES (43,'CampariOrange',5.8,15.0,8);
INSERT INTO "items" VALUES (44,'Caipirinha',6.7,10.0,2);
INSERT INTO "items" VALUES (45,'Mojito',7.2,10.0,2);
INSERT INTO "items" VALUES (46,'Cubano',7.9,10.0,2);
INSERT INTO "items" VALUES (47,'Pina.Colada',7.2,10.0,2);
INSERT INTO "items" VALUES (48,'Sex.ontheBeach',7.2,10.0,2);
INSERT INTO "items" VALUES (49,'Tequila.Sunrise',6.7,10.0,2);
INSERT INTO "items" VALUES (50,'Vanity',7.9,10.0,2);
INSERT INTO "items" VALUES (51,'Big.Ben',7.2,9.0,2);
INSERT INTO "items" VALUES (52,'Espresso.Martini',7.5,10.0,2);
INSERT INTO "items" VALUES (53,'Americano',6.2,10.0,2);
INSERT INTO "items" VALUES (54,'Negroni',6.2,10.0,2);
INSERT INTO "items" VALUES (55,'Martini.Dry',6.2,10.0,2);
INSERT INTO "items" VALUES (56,'Margarita',6.2,10.0,2);
INSERT INTO "items" VALUES (57,'Aperol.Spritz',5.9,10.0,2);
INSERT INTO "items" VALUES (58,'Hugo',5.9,3.0,2);
INSERT INTO "items" VALUES (59,'Ipanema',5.9,7.0,3);
INSERT INTO "items" VALUES (60,'Virgin.Colada',5.9,10.0,3);
INSERT INTO "items" VALUES (61,'YFB',5.2,7.0,3);
INSERT INTO "items" VALUES (62,'Carribean',6.2,10.0,3);
INSERT INTO "items" VALUES (63,'Currywurst',4.9,20.0,6);
INSERT INTO "items" VALUES (64,'Flamm.Els',7.5,20.0,6);
INSERT INTO "items" VALUES (65,'Flamm.Gr',7.5,20.0,6);
INSERT INTO "items" VALUES (66,'Flamm.Ve',7.9,20.0,6);
INSERT INTO "items" VALUES (67,'Laugenbrezel',2.5,20.0,6);
INSERT INTO "items" VALUES (68,'Nachos',4.9,20.0,6);
COMMIT;
