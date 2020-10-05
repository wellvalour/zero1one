CREATE TABLE if not exists Berechtigung(
ID int(5),
Bezeichnung char(30),
PRIMARY KEY(ID));

CREATE TABLE if not exists User(
Name char(50),
Passwort char(30),
BerechtigungsID int(5),
PRIMARY KEY(Name));

CREATE TABLE if not exists ConfigItemTyp(
Name char(50),
PRIMARY KEY(Name));

CREATE TABLE if not exists Instanz(
ID int(5),
ConfigItemTypname char (30),
Name char(50),
PRIMARY KEY(ID));

CREATE TABLE if not exists Attributtyp(
Name char(50),
ConfigItemTypname char (30),
PRIMARY KEY(Name));

CREATE TABLE if not exists Attribut(
InstanzID int (5),
AttributtypID char(30),
Wert char(15),
PRIMARY KEY(InstanzID, AttributtypID));