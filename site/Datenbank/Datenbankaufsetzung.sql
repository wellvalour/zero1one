create database zero1one if not  exist;

create table Berechtigung(
ID int(5),
Bezeichnung char(30));

create table User(
ID int(5),
Name char(30),
Passwort char(30),
BerechtigungsID int(5));

create table ConfigItemTyp(
ID int(5),
Name char(30));

create table Instanz(
ID int(5),
ConfigItemTypID int (5),
Name char(30));

create table Attributtyp(
ID int(5),
Name char(30),
ConfigItemTypID int (5));

create table Attribut(
ID int(5),
Wert char(15),
InstanzID int (5),
AttributtypID int (5));