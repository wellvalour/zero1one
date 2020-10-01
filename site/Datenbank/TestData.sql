
INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (1, 'Admin');

INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (2, 'Mitarbeiter');

INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (3, 'Azubi');

INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (4, 'Teamleiter');


INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('Peter', 'peter1234', 4);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('Max', 'max1234', 2);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('Daniel', 'daniel1234', 1);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('Dimitri', 'dimitri1234', 3);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('Johanna', 'johanna1234', 2);


INSERT INTO ConfigItemTyp (Name)
VALUES ('Computer');

INSERT INTO ConfigItemTyp (Name)
VALUES ('Drucker');

INSERT INTO ConfigItemTyp (Name)
VALUES ('Router');

INSERT INTO ConfigItemTyp (Name)
VALUES ('Bildschirm');

INSERT INTO ConfigItemTyp (Name)
VALUES ('Tastatur');

INSERT INTO ConfigItemTyp (Name)
VALUES ('Maus');


INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (1, 'Maus', 'Logitech Maus');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (2, 'Maus', 'Logitech Maus');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (3, 'Maus', 'LogLink Maus');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (4, 'Maus', 'LogLink Maus');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (5, 'Tastatur', 'Logitech Tastatur');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (6, 'Tastatur', 'Logitech Tastatur');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (7, 'Tastatur', 'Logitech Tastatur');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (8, 'Tastatur', 'LogiLink Tastatur');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (9, 'Tastatur', 'LogiLink Tastatur');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (10, 'Router', 'FritzBox 7590');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (11, 'Computer', 'IMac Pro');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (12, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (13, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (14, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (15, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (16, 'Bildschirm', 'Lenovo L24-10');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (17, 'Bildschirm', 'Lenovo L24-10');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (18, 'Bildschirm', 'Samsung C24F396FH');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (19, 'Bildschirm', 'Samsung C24F396FH');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (20, 'Drucker', 'Samsung MultiXpress C9251NA CLX-9251');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (21, 'Drucker', 'Samsung MultiXpress C9251NA CLX-9251');



INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Farbe', 'Drucker');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Blattdruckanzahl/m', 'Drucker');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Speicher', 'Computer');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Arbeitsspeicher', 'Computer');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Prozessor', 'Computer');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Groeße', 'Bildschirm');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Auflösung', 'Bildschirm');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Reaktionszeit', 'Bildschirm');




INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (20, 'Farbe', 'weiß');

INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (20, 'Blattdruckanzahl/m', '25');

INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (20, 'Speicher', '64MB');



INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (21, 'Farbe', 'schwarz');

INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (21, 'Blattdruckanzahl/m', '25');

INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (21, 'Speicher', '64MB');



INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (11, 'Speicher', '1000GB');

INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (11, 'Arbeitsspeicher', '8GB');

INSERT INTO Attribut (InstanzID, AttributtypID, Wert)
VALUES (11, 'Prozessor', '3,2GHz 8Core');