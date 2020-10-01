create database if not exists zero1one;

create table if not exists Berechtigung(
ID int(5),
Bezeichnung char(30));

create table if not exists User(
Name char(30),
Passwort char(30),
BerechtigungsID int(5),
PRIMARY KEY(Name));

create table if not exists ConfigItemTyp(
Name char(30),
PRIMARY KEY(Name));

create table if not exists Instanz(
ID int(5),
ConfigItemTypname char (30),
Name char(30),
PRIMARY KEY(ID));

create table if not exists Attributtyp(
Name char(30),
ConfigItemTypname char (30),
PRIMARY KEY(Name));

create table if not exists Attribut(
InstanzID int (5),
AttributtypID char(30),
Wert char(15),
PRIMARY KEY(InstanzID, AttributtypID));