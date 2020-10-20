INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (1, 'ADMIN');

INSERT INTO berechtigung (ID, Bezeichnung)
VALUES (0, 'USER');


INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('pascal', '-995396628', 1);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('max', '107876', 1);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('daniel', '-1339089505', 1);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('dimitri', '1666022698', 0);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('johanna', '-1431976733', 1);

INSERT INTO User (Name, Passwort, BerechtigungsID)
VALUES ('til', '114839', 1);


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


INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (1, 'Maus', 'Logitech Maus');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (2, 'Maus', 'Logitech Maus');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (3, 'Maus', 'LogLink Maus');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (4, 'Maus', 'LogLink Maus');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (5, 'Tastatur', 'Logitech Tastatur');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (6, 'Tastatur', 'Logitech Tastatur');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (7, 'Tastatur', 'Logitech Tastatur');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (8, 'Tastatur', 'LogiLink Tastatur');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (9, 'Tastatur', 'LogiLink Tastatur');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (10, 'Router', 'FritzBox 7590');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (11, 'Computer', 'IMac Pro');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (12, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (13, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (14, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (15, 'Computer', 'ACER Predator Orion 9000');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (16, 'Bildschirm', 'Lenovo L24-10');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (17, 'Bildschirm', 'Lenovo L24-10');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (18, 'Bildschirm', 'Samsung C24F396FH');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (19, 'Bildschirm', 'Samsung C24F396FH');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
VALUES (20, 'Drucker', 'Samsung MultiXpress C9251NA CLX-9251');

INSERT INTO ConfigItem (ID, ConfigItemTypname, Name)
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
VALUES ('Groe�e', 'Bildschirm');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Aufl�sung', 'Bildschirm');

INSERT INTO AttributTyp (Name, ConfigItemTypname)
VALUES ('Reaktionszeit', 'Bildschirm');




INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (1, 20, 'Farbe', 'wei�');

INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (2, 20, 'Blattdruckanzahl/m', '25');

INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (3, 20, 'Speicher', '64MB');



INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (4, 21, 'Farbe', 'schwarz');

INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (5, 21, 'Blattdruckanzahl/m', '25');

INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (6, 21, 'Speicher', '64MB');



INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (7, 11, 'Speicher', '1000GB');

INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (8, 11, 'Arbeitsspeicher', '8GB');

INSERT INTO Attribut (ID, ConfigItemID, AttributtypID, Wert)
VALUES (9, 11, 'Prozessor', '3,2GHz 8Core');



INSERT INTO Instanz (ID, InstanzTypname, Name)
VALUES (16, 'Bildschirm', 'Lenovo L24-10');

INSERT INTO Instanz (ID, InstanzTypname, Name)
VALUES (17, 'Bildschirm', 'Lenovo L24-10');

INSERT INTO instanz (ID, InstanzTypname, Name)
VALUES (18, 'Bildschirm', 'Samsung C24F396FH');