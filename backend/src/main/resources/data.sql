-- Create Default User
INSERT IGNORE INTO users (id, username) VALUES (1, 'TestUser');

-- INSERT Categories
INSERT IGNORE INTO categorys (id, name) VALUES (1, 'Allgemein');
INSERT IGNORE INTO categorys (id, name) VALUES (2, 'Wetterkunde');
INSERT IGNORE INTO categorys (id, name) VALUES (3, 'Seemannschaft');

-- INSERT Questions

-- Allgemein
INSERT IGNORE INTO questions (id, text, correct_option_id, category_id) VALUES (1, 'Welche Farbe hat das Backbord-Positionslicht bei einem Motorboot?', 2, 1);
INSERT IGNORE INTO questions (id, text, correct_option_id, category_id) VALUES (2, 'Wo befindet sich Steuerbord auf einem Schiff?', 7, 1);

-- Wetterkunde
INSERT IGNORE INTO questions (id, text, correct_option_id, category_id) VALUES (3, 'Was zeigt ein Barometer an?', 12, 2);
INSERT IGNORE INTO questions (id, text, correct_option_id, category_id) VALUES (4, 'Aus welcher Richtung weht ein Ostwind?', 14, 2);

-- Seemannschaft
INSERT IGNORE INTO questions (id, text, correct_option_id, category_id) VALUES (5, 'Wozu dient ein Fender?', 19, 3);
INSERT IGNORE INTO questions (id, text, correct_option_id, category_id) VALUES (6, 'Was ist die Lee-Seite?', 21, 3);


-- INSERT Options

-- Q1, C Allgemein
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (1, 1, 'Grün');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (2, 1, 'Rot');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (3, 1, 'Weiß');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (4, 1, 'Gelb');

-- Q2, C Allgemein
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (5, 2, 'Hinten');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (6, 2, 'Links');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (7, 2, 'Rechts');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (8, 2, 'Vorne');

-- Q1, C Wetterkunde
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (9, 3, 'Windgeschwindigkeit');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (10, 3, 'Luftfeuchtigkeit');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (11, 3, 'Wassertemperatur');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (12, 3, 'Luftdruck');

-- Q2, C Wetterkunde
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (13, 4, 'Von Westen nach Osten');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (14, 4, 'Von Osten nach Westen');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (15, 4, 'Von Norden nach Osten');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (16, 4, 'Von Süden nach Osten');

-- Q1, C Seemannschaft
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (17, 5, 'Zum Steuern des Bootes');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (18, 5, 'Als Rettungsmittel');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (19, 5, 'Als Stoßdämpfer an der Bordwand');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (20, 5, 'Zum Festmachen an der Boje');

-- Q2, C Seemannschaft
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (21, 6, 'Die dem Wind abgewandte Seite');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (22, 6, 'Die dem Wind zugewandte Seite');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (23, 6, 'Die zum Ankerplatz zugewandte Seite');
INSERT IGNORE INTO question_options (id, question_id, option_text) VALUES (24, 6, 'Die zum Ankerplatz abgewandte Seite');