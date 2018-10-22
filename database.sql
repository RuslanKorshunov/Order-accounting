CREATE DATABASE PBZ2;
USE PBZ2;
CREATE TABLE workers(FIO VARCHAR(30) NOT NULL,
					 DIVISION_NAME VARCHAR(30) NOT NULL,
					 POSITION VARCHAR(20) NOT NULL);
INSERT INTO workers VALUES
	('Иванов Иван Иванович', 'Подразделение 1', 'Должность 1'),
	('Андреев Андрей Андреевич', 'Подразделение 1', 'Должность 1'),
	('Бутька Дмитрий Дмитриевич', 'Подразделение 1', 'Должность 1'),
	('Голубева Евгения Евгеньевна', 'Подразделение 1', 'Должность 2'),
	('Коршунов Руслан Андреевич', 'Подразделение 1', 'Царь и бог'),
	('Гончарушкин Даниил Аркадьевич', 'Подразделение 2', 'Должность 1'),
	('Труха Ульян Аристархович', 'Подразделение 2', 'Должность 2'),
	('Волях Изольда Дмитриевна', 'Подразделение 2', 'Должность 2'),
	('Шу Юань', 'Подразделение 1', 'Руководитель');
SELECT * 
	FROM workers;
CREATE TABLE orders(ID SMALLINT NOT NULL,
					DATE_OF_ADOPTION DATE,
                    CONTENT VARCHAR(100),
                    FIO VARCHAR(30) NOT NULL);
INSERT INTO orders VALUES
	(1, '2018-09-21', 'Планы по захвату мира', 'Коршунов Руслан Андреевич'),
    (2, '2018-10-19', 'Свод мероприятий по организации ДР Коршунова Руслана', 'Шу Юань');
SELECT *
	FROM orders;
CREATE TABLE orderevents(ORDEREVENT VARCHAR(100) NOT NULL,
						ID_OF_ORDER SMALLINT NOT NULL,
						DATE_OF_ADOPTION DATE,
						MARK ENUM('Y', 'N') NOT NULL,
						FIO VARCHAR(30) NOT NULL); 
INSERT INTO orderevents VALUES
	('Покупка сахарной ваты', 1, '2018-12-01', 'N', 'Иванов Иван Иванович');
SELECT *
	FROM orderevents;