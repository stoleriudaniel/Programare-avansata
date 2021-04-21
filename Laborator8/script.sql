DROP TABLE movieDirectors;
DROP TABLE movieActors;
DROP TABLE movieGenres;
DROP TABLE movies;
DROP TABLE genres;
DROP TABLE directors;
DROP TABLE actors;

CREATE TABLE movies(
    id int primary key not null auto_increment,
    title varchar(80),
    release_date date,
    duration int,
    score int
);

CREATE TABLE genres(
    id int primary key not null auto_increment,
    name varchar(10)
);

CREATE TABLE actors(
    id int primary key not null auto_increment,
    name char(50)
);

CREATE TABLE directors(
    id int primary key auto_increment,
    name char(50)
);

CREATE TABLE movieGenres(
    id_movie int not null,
    id_genre int not null,
    FOREIGN KEY (id_movie) REFERENCES movies(id),
    FOREIGN KEY (id_genre) REFERENCES genres(id),
    unique(id_movie, id_genre)
);

CREATE TABLE movieActors(
    actor_id int not null,
    movie_id int not null,
    FOREIGN KEY (actor_id) REFERENCES actors(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    unique(actor_id,movie_id)
);

CREATE TABLE movieDirectors(
    director_id int not null,
    movie_id int not null,
    FOREIGN KEY (director_id) REFERENCES directors(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    unique(director_id,movie_id)
);

INSERT INTO movies(title,release_date,duration,score) VALUES('Titanic',STR_TO_DATE('1997-11-18','%Y-%m-%d'),90,5);
INSERT INTO movies(title,release_date,duration,score) VALUES('Norbit', STR_TO_DATE('2007-02-09','%Y-%m-%d'),60,3);

INSERT INTO genres(name) VALUES('Drama');
INSERT INTO genres(name) VALUES('Romance');
INSERT INTO genres(name) VALUES('Comedy');
INSERT INTO genres(name) VALUES('Historical');
INSERT INTO genres(name) VALUES('Epic');

