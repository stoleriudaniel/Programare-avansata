DROP TABLE userFriends;
DROP TABLE users;
CREATE TABLE users(
    name varchar(20) primary key not null,
    password varchar(25) not null
);

CREATE TABLE userFriends(
    user_name varchar(20) not null,
    friend_name varchar(20) not null,
    FOREIGN KEY(user_name) REFERENCES users(name),
    unique(user_name,friend_name)
);

