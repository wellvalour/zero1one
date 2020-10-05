CREATE TABLE `mitarbeiter` (
  `persnr` int(3),
  `nachname` char(30),
  `vorname` char(30),
  `wohnort` char(30),
  `beruf` char(30),
  `gehalt` decimal(7,2),
  `zulage` decimal(7,2),
  `stellenr` int(3),
  `gebdatum` date,
  `einstelldatum` date,
  PRIMARY KEY (`persnr`),
  UNIQUE KEY `mit_nr_2` (`persnr`),
  UNIQUE KEY `mit_nr_3` (`persnr`)
);