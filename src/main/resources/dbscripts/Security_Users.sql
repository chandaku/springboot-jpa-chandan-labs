DROP TABLE ROLES;
CREATE TABLE ROLES
     (
ID int(20),
ROLE_ID int,
ROLE_NAME varchar(30),
USER_ID int(30),
FOREIGN KEY ( USER_ID ) REFERENCES USERS ( ID ),
PRIMARY KEY (id)
)
;

DROP TABLE user_survey.USERS;
CREATE TABLE USERS 
  (
ID int(30),
DOB DATE,
EMAIL varchar(255),
NAME varchar(255),
PASSWD varchar(255),
PRIMARY KEY (id)
);

INSERT INTO users (ID,DOB,EMAIL,NAME,PASSWD) VALUES (1,NULL,'admin@gmail.com','Administrator','admin');
INSERT INTO users (ID,DOB,EMAIL,NAME,PASSWD) VALUES (2,NULL,'chandan@gmail.com','Chandan','chandan');

INSERT INTO ROLES (id,role_id,role_name,user_id) VALUES  (1,1,'ROLE_ADMIN',1);
INSERT INTO ROLES (id,role_id,role_name,user_id) VALUES (2,2,'ROLE_USER',1);
INSERT INTO ROLES (id,role_id,role_name,user_id) VALUES (3,3,'ROLE_USER',2);
