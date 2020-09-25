create database if not exists zero1one;

create table Berechtigung(
ID int(5),
Bezeichnung char(30));

create table User(
-- ID int(5),
Name char(30),
Passwort char(30),
BerechtigungsID int(5),
PRIMARY KEY());

create table ConfigItemTyp(
-- ID int (5),
Name char(30),
PRIMARY KEY(Name);

create table Instanz(
ID int(5),
ConfigItemTypname char (30),
Name char(30),
PRIMARY KEY(ID));

create table Attributtyp(
-- ID int(5),
Name char(30),
ConfigItemTypname char (30),
PRIMARY KEY(Name));

create table Attribut(
-- ID int(5),
Wert char(15),
InstanzID int (5),
AttributtypID char(30),
PRIMARY KEY(InstanzID, AttributtypID));