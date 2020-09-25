-- Berechtigungen erstellen
INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (1, 'Admin');

INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (2, 'Mitarbeiter');

INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (3, 'Azubi');

INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (4, 'Teamleiter');

-- User erstellen
INSERT INTO User (ID, Name, Passwort, BerechtigungsID)
VALUES (1, 'Peter', 'peter1234', 4);

INSERT INTO User (ID, Name, Passwort, BerechtigungsID)
VALUES (2, 'Max', 'max1234', 2);

INSERT INTO User (ID, Name, Passwort, BerechtigungsID)
VALUES (3, 'Daniel', 'daniel1234', 1);

INSERT INTO User (ID, Name, Passwort, BerechtigungsID)
VALUES (4, 'Dimitri', 'dimitri1234', 3);

INSERT INTO User (ID, Name, Passwort, BerechtigungsID)
VALUES (5, 'Johanna', 'johanna1234', 2);

-- ConfigItemtyp erstellen
INSERT INTO ConfigItemTyp (ID, Name)
VALUES (1, 'Computer');

INSERT INTO ConfigItemTyp (ID, Name)
VALUES (2, 'Drucker');

INSERT INTO ConfigItemTyp (ID, Name)
VALUES (3, 'Router');

INSERT INTO ConfigItemTyp (ID, Name)
VALUES (4, 'Bildschirm');

INSERT INTO ConfigItemTyp (ID, Name)
VALUES (5, 'Tastatur');

INSERT INTO ConfigItemTyp (ID, Name)
VALUES (6, 'Maus');

--Instanzen erstellen
INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (1, 'Maus', 'Logitech Maus');

INSERT INTO Instanz (ID, ConfigItemTypname, Name)
VALUES (2, 'Maus', 'Logitech Maus');

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


--Attributtypen erstellen
INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (1, 'Farbe', 'Drucker');

INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (2, 'Blattdruckanzahl/m', 'Drucker');

INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (3, 'Speicher', 'Computer');

INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (4, 'Arbeitsspeicher', 'Computer');

INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (4, 'Prozessor', 'Computer');

INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (5, 'Groeße', 'Bildschirm');

INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (6, 'Auflösung', 'Bildschirm');

INSERT INTO AttributTyp (ID, Name, ConfigItemTypname)
VALUES (7, 'Reaktionszeit', 'Bildschirm');


--Attribute erstellen
INSERT INTO Attribut (ID, Wert, InstanzID, AttributtypID)
VALUES (1, 'weiß', 20, 1);

INSERT INTO Attribut (ID, Wert, InstanzID, AttributtypID)
VALUES (2, '25', 20, 2);

INSERT INTO Attribut (ID, Wert, InstanzID, AttributtypID)
VALUES (3, '64MB', 20, 3);



INSERT INTO Attribut (ID, Wert, InstanzID, AttributtypID)
VALUES (4, 'schwarz', 21, 1);

INSERT INTO Attribut (ID, Wert, InstanzID, AttributtypID)
VALUES (5, '25', 21, 2);

INSERT INTO Attribut (ID, Wert, InstanzID, AttributtypID)
VALUES (6, '64MB', 21, 3);