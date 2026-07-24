INSERT INTO author(name, firstname) VALUES ('Homere', '');
INSERT INTO category(name) VALUES ('Science-fiction');
INSERT INTO book(availability, isbn, cover, title, description, id_author, id_category) VALUES (3, '333-3333333', 'none', N'''L''Odyssée', 'C''est l''histoire de Ulysse', 1, 1 );
INSERT INTO member(email, password, name, firstname, phone, role) VALUES ( 'member1@bookhub.test', '{bcrypt}$2a$10$H4DbMlDEXwJho0aSm/0Oz.eVgNk5OgkAF5c3qvcap6Hs2D9luzWZq', 'GAGNANT', 'Michel', '0011223344', 'USER');
