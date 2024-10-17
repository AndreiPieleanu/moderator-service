CREATE TABLE kwex_posts
(
    id        int         NOT NULL AUTO_INCREMENT,
    text varchar(500) NOT NULL,
    isOffensive bool not null,
    createdAt DATE NOT NULL,
    userId int,
    PRIMARY KEY (id)
);
create table kwex_users
(
  id int not null auto_increment,
  email varchar(100) NOT NULL,
  primary key (id)
);
