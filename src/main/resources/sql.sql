CREATE TABLE `post`
(
  id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  description  VARCHAR(250),
  image        VARCHAR(250)    NOT NULL,
  created_date DATETIME        NOT NULL,
  user_id      INT             NOT NULL
);

CREATE TABLE `like`
(
  id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  created_date DATETIME        NOT NULL,
  post_id      INT             NOT NULL,
  user_id      INT             NOT NULL
);

CREATE TABLE `comment`
(
  id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  text         TEXT            NOT NULL,
  created_date DATETIME        NOT NULL,
  post_id      INT             NOT NULL,
  user_id      INT             NOT NULL
);

CREATE TABLE `user`
(
  id       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(250)    NOT NULL,
  password VARCHAR(250)    NOT NULL,
  name     VARCHAR(250),
  bio      TEXT,
  email    VARCHAR(250)    NOT NULL,
  phone    VARCHAR(250),
  gender   INT(1),
  website  VARCHAR(250)
);

CREATE TABLE `follower`
(
  follower_id INT NOT NULL,
  followee_id INT NOT NULL
);

ALTER TABLE `follower` ADD PRIMARY KEY (follower_id, followee_id);

ALTER TABLE follower ADD FOREIGN KEY (follower_id) REFERENCES user (id);
ALTER TABLE follower ADD FOREIGN KEY (followee_id) REFERENCES user (id);

ALTER TABLE post ADD FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE comment ADD FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE comment ADD FOREIGN KEY (post_id) REFERENCES post (id);

ALTER TABLE `like` ADD FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE `like` ADD FOREIGN KEY (post_id) REFERENCES post (id);