#create database workshops;
#use workshops;

create table RSVP(
	id int not null auto_increment,
	name char(64) not null,
    email char(64) not null,
    phone varchar(100),
    confirmation_date date,
    comments varchar(250),
    constraint pk_id primary key (id)
);

drop table RSVP;
insert into RSVP(name,email,phone,confirmation_date,comments) values('Fred','fred@gmail.com','9123 4566','2025-02-13','NA');
select * from RSVP;

select count(*) from RSVP where name = 'Bob';

delete from RSVP where id = 4;

alter table RSVP
auto_increment = 1;

select count(*) from RSVP;


    