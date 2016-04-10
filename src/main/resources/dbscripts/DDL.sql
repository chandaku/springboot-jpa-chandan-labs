

CREATE SCHEMA user_survey;

DROP TABLE IF EXISTS SURVEY_ANSWERS;
DROP TABLE IF EXISTS SURVEY_QUESTIONS;
DROP TABLE IF EXISTS USER_SURVEY_RESPONSE;
DROP TABLE IF EXISTS USER_SURVEY_REWARD;
DROP TABLE IF EXISTS REVINFO;


CREATE TABLE SURVEY_QUESTIONS (
  id int(11) NOT NULL AUTO_INCREMENT,
  question varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE SURVEY_ANSWERS (
  id int(11) NOT NULL AUTO_INCREMENT,
  answer varchar(255) NOT NULL,
  question_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (question_id) REFERENCES SURVEY_QUESTIONS (id)
);

CREATE TABLE USER_SURVEY_RESPONSE (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(255) NOT NULL,
  question_id int(11) DEFAULT NULL,
  answer_id int(11) DEFAULT NULL,
  survey_date DATE,
  flight_no varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE USER_SURVEY_REWARD (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(255) NOT NULL,
  rewards int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE REVINFO (
  id int(11) NOT NULL AUTO_INCREMENT,
  revtstmp bigint(20) NOT NULL,
  userinfo varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);


insert into SURVEY_QUESTIONS (id,question)values(1,'How much have your skills improved because of the training at the event?');
insert into SURVEY_QUESTIONS (id,question)values(2,'If you were particularly dissatisfied with any of (Airline) procedures at the airport you just departed, please indicate which area(s).');
insert into SURVEY_QUESTIONS (id,question)values(3,'For Aircraft boarding, please indicate how long you waited in line, and whether that wait was acceptable or not.');
insert into SURVEY_QUESTIONS (id,question)values(4,'For Boarding gate counter, please indicate how long you waited in line, and whether that wait was acceptable or not.');
insert into SURVEY_QUESTIONS (id,question)values(5,'For Express baggage/seat check-in counter, please indicate how long you waited in line, and whether that wait was acceptable or not.');
insert into SURVEY_QUESTIONS (id,question)values(6,'For Curbside baggage check, please indicate how long you waited in line, and whether that wait was acceptable or not.');
insert into SURVEY_QUESTIONS (id,question)values(7,'Overall, how courteous and helpful were (Airlines) personnel at the airport you just departed?');

insert into SURVEY_ANSWERS (answer,question_id) values('A great deal ',1);
insert into SURVEY_ANSWERS (answer,question_id) values('A lot',1);
insert into SURVEY_ANSWERS (answer,question_id) values('A moderate amount',1);
insert into SURVEY_ANSWERS (answer,question_id) values('A little',1);
insert into SURVEY_ANSWERS (answer,question_id) values('None at all',1);


insert into SURVEY_ANSWERS (answer,question_id) values('Curbside baggage check-in',2);
insert into SURVEY_ANSWERS (answer,question_id) values('(Airline) ticket counter ',2);
insert into SURVEY_ANSWERS (answer,question_id) values('
Express baggage/Seat check-in counter
',2);
insert into SURVEY_ANSWERS (answer,question_id) values('Security checkpoint',2);
insert into SURVEY_ANSWERS (answer,question_id) values('Red Carpet Room',2);
insert into SURVEY_ANSWERS (answer,question_id) values('Boarding gate check-in counter',2);
insert into SURVEY_ANSWERS (answer,question_id) values('Aircraft boarding ',2);
insert into SURVEY_ANSWERS (answer,question_id) values('Other',2);


insert into SURVEY_ANSWERS (answer,question_id) values('Didnt Use',3);
insert into SURVEY_ANSWERS (answer,question_id) values('No Wait',3);
insert into SURVEY_ANSWERS (answer,question_id) values('0-5 min',3);
insert into SURVEY_ANSWERS (answer,question_id) values('6-10 min.',3);
insert into SURVEY_ANSWERS (answer,question_id) values('11-20 min.',3);
insert into SURVEY_ANSWERS (answer,question_id) values('20+ min',3);


insert into SURVEY_ANSWERS (answer,question_id) values('Didnt Use',4);
insert into SURVEY_ANSWERS (answer,question_id) values('No Wait',4);
insert into SURVEY_ANSWERS (answer,question_id) values('0-5 min',4);
insert into SURVEY_ANSWERS (answer,question_id) values('6-10 min.',4);
insert into SURVEY_ANSWERS (answer,question_id) values('11-20 min.',4);
insert into SURVEY_ANSWERS (answer,question_id) values('20+ min',4);

insert into SURVEY_ANSWERS (answer,question_id) values('Didnt Use',5);
insert into SURVEY_ANSWERS (answer,question_id) values('No Wait',5);
insert into SURVEY_ANSWERS (answer,question_id) values('0-5 min',5);
insert into SURVEY_ANSWERS (answer,question_id) values('6-10 min.',5);
insert into SURVEY_ANSWERS (answer,question_id) values('11-20 min.',5);
insert into SURVEY_ANSWERS (answer,question_id) values('20+ min',5);

insert into SURVEY_ANSWERS (answer,question_id) values('Didnt Use',6);
insert into SURVEY_ANSWERS (answer,question_id) values('No Wait',6);
insert into SURVEY_ANSWERS (answer,question_id) values('0-5 min',6);
insert into SURVEY_ANSWERS (answer,question_id) values('6-10 min.',6);
insert into SURVEY_ANSWERS (answer,question_id) values('11-20 min.',6);
insert into SURVEY_ANSWERS (answer,question_id) values('20+ min',6);

insert into SURVEY_ANSWERS (answer,question_id) values('Among the Best',7);
insert into SURVEY_ANSWERS (answer,question_id) values('Better than Most',7);
insert into SURVEY_ANSWERS (answer,question_id) values('About the same as Most',7);
insert into SURVEY_ANSWERS (answer,question_id) values('Not as good as Most',7);
insert into SURVEY_ANSWERS (answer,question_id) values('Among the Worst',7);
