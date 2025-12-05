create TABLE member(
    id_member int not null AUTO_INCREMENT,
    name varchar(255) not null,
    email varchar(255) not null,
    phone_number varchar(50) not null,
    dt_join varchar(50),
    CONSTRAINT member_pk PRIMARY KEY(id_member)
);
