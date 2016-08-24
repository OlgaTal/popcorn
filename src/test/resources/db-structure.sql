CREATE SCHEMA `Popcorn` DEFAULT CHARACTER SET utf8 ;
-- ++++++++++++++++++++++

USE Popcorn;

-- ++++++++++++++++++++++++

CREATE TABLE `studios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `est` DATE NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

  insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-03-11', 'MGM', '2016-08-22', 0);
  insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-04-12', 'Fox', '2016-08-22', 0);
  insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-05-13', 'Universal', '2016-08-22', 0);
  insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-06-14', 'WB', '2016-08-22', 0);
  insert into studios (created_at, est, name, updated_at, version) values ('2016-08-22', '1901-07-15', 'Paramount', '2016-08-22', 0);

-- ++++++++++++++++++++++++++++++++++
CREATE TABLE `movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `released` DATE NULL,
  `genre` ENUM('ACTION', 'SCIFI', 'HORROR') NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `rating` ENUM('G', 'PG', 'R') NULL,
  `studio_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_studios_idx` (`studio_id` ASC),
  CONSTRAINT `fk_studios`
    FOREIGN KEY (`studio_id`)
    REFERENCES `Popcorn`.`studios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    INSERT INTO `Popcorn`.`movies` (`version`, `name`, `released`, `created_at`, `updated_at`, `genre`, `rating`, `studio_id`)
    VALUES
      ('0', 'The Matrix', '1999-03-15', '2001-01-11', '2001-01-11', 'scifi', 'r', '1'),
      ('0', 'Avatar', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
      ('0', 'Star Wars I', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
      ('0', 'Harry Potter', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
      ('0', 'Lord of the Rings', '1998-03-15', '2001-01-11', '2001-01-11', 'scifi', 'pg', '2'),
      ('0', 'Titantic', '1997-03-15', '2001-01-11', '2001-01-11', 'action', 'pg', '2');

-- ++++++++++++++++++++++++++++++++++

CREATE TABLE `actors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `gender` ENUM('M', 'F') NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

  ALTER TABLE `actors`
  CHANGE COLUMN `name` `name` VARCHAR(45) NOT NULL ;



  INSERT INTO `actors` (`version`, `name`, `birthday`, `created_at`, `updated_at`, `gender`)
  VALUES
    ('0', 'Keanu Reeves', '1952-03-15', '2001-01-11', '2001-01-11', 'm'),
    ('0', 'Tom Cruise', '1953-03-15', '2001-01-11', '2001-01-11', 'm'),
    ('0', 'Jessica Chastain', '1954-03-15', '2001-01-11', '2001-01-11', 'f'),
    ('0', 'Halley Berry', '1955-03-15', '2001-01-11', '2001-01-11', 'f'),
    ('0', 'Jake Gyllenhaal', '1956-03-15', '2001-01-11', '2001-01-11', 'm'),
    ('0', 'Maggie Gyllenhall', '1957-03-15', '2001-01-11', '2001-01-11', 'f'),
    ('0', 'Liam Nieson', '1958-03-15', '2001-01-11', '2001-01-11', 'm'),
    ('0', 'Matt Damon', '1959-03-15', '2001-01-11', '2001-01-11', 'm'),
    ('0', 'Leo DiCaprio', '1960-03-15', '2001-01-11', '2001-01-11', 'm'),
    ('0', 'Abby Winters', '1961-03-15', '2001-01-11', '2001-01-11', 'f'),
    ('0', 'Jennifer Harris', '1962-03-15', '2001-01-11', '2001-01-11', 'f'),
    ('0', 'Margret Robb', '1963-03-15', '2001-01-11', '2001-01-11', 'f'),
    ('0', 'Ben Travis', '1964-03-15', '2001-01-11', '2001-01-11', 'm'),
    ('0', 'Patrick Stewart', '1965-03-15', '2001-01-11', '2001-01-11', 'm');

  -- ++++++++++++++++++++++++++++++++++++++++++++++++

  CREATE TABLE `Popcorn`.`actors_movies` (
    `actor_id` INT NOT NULL,
    `movie_id` INT NOT NULL,
    PRIMARY KEY (`actor_id`, `movie_id`),
    INDEX `fk_movie_idx` (`movie_id` ASC),
    CONSTRAINT `fk_actor`
      FOREIGN KEY (`actor_id`)
      REFERENCES `Popcorn`.`actors` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT `fk_movie`
      FOREIGN KEY (`movie_id`)
      REFERENCES `Popcorn`.`movies` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

      ALTER TABLE `Popcorn`.`actors_movies`
      ADD COLUMN `pay` INT NULL AFTER `movie_id`;

      INSERT INTO `actors_movies` (`actor_id`, `movie_id`, `pay`)
      VALUES
        (1, 1, 1200000),
        (2, 1, 2200000),
        (3, 1, 3200000),
        (4, 1, 4200000),
        (5, 2, 1500000),
        (6, 2, 3200000),
        (7, 2, 2200000),
        (8, 3, 6200000),
        (9, 4, 8200000),
        (10, 4, 2200000),
        (11, 4, 4200000),
        (12, 4, 7200000),
        (13, 4, 3200000),
        (14, 4, 200000),
        (1, 4, 12000),
        (2, 4, 24000),
        (3, 4, 320000),
        (4, 4, 4200000),
        (5, 4, 52000),
        (6, 5, 6200000),
        (7, 5, 7200000),
        (8, 5, 820000),
        (9, 5, 12000),
        (10, 5, 12000),
        (11, 5, 22000),
        (12, 5, 3200000),
        (13, 5, 4200000),
        (14, 5, 1000),
        (1, 5, 5200000),
        (2, 6, 62000000),
        (3, 6, 720000),
        (4, 6, 8200000),
        (5, 6, 200000),
        (6, 6, 4200000),
        (7, 6, 8200000),
        (8, 6, 1200000),
        (9, 6, 2200000),
        (10, 6, 32000),
        (11, 6, 4200000),
        (12, 6, 920000);
