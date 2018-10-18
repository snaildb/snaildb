create table snail_superfamily (
	superfamily_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL
);

create table snail_family (
	family_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	superfamily_id int NOT NULL,
	name varchar(255) NOT NULL,
	FOREIGN KEY(superfamily_id) REFERENCES snail_superfamily(superfamily_id) ON DELETE CASCADE
);

create table snail_genus (
	genus_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	family_id int NOT NULL,
	name varchar(255) NOT NULL,
	FOREIGN KEY(family_id) REFERENCES snail_family(family_id) ON DELETE CASCADE
);

create table snail_species (
	species_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	genus_id int NOT NULL,
	name varchar(255) NOT NULL,
	FOREIGN KEY(genus_id) REFERENCES snail_genus(genus_id) ON DELETE CASCADE
);

create table snail_subspecies (
	subspecies_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	species_id int NOT NULL,
	name varchar(255) NOT NULL,
	FOREIGN KEY(species_id) REFERENCES snail_species(species_id) ON DELETE CASCADE
);
