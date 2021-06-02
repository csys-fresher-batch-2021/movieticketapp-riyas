create database movieticketapp_db;

create table users(
	id serial NOT NULL,
    name character varying(40) NOT NULL,
    email character varying(40) NOT NULL,
    mobile_number bigint NOT NULL,
    user_name character varying(15) NOT NULL,
    password character varying(15)  NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

create table movies(
	id  serial NOT NULL ,
	movie_name character varying(40) NOT NULL,
    actor_name character varying(40) NOT NULL,
    rating real NOT NULL,
    status character varying(40) NOT NULL,
    CONSTRAINT movies_pkey PRIMARY KEY (id)
    screen character varying(40)  NOT NULL,
    CONSTRAINT screen FOREIGN KEY (screen)
        REFERENCES screens (name) MATCH SIMPLE
    
);

create table seat_types(
	seat_type character varying(20) NOT NULL,
    price real NOT NULL
);

create table show_times(
	id serial NOT NULL,
    show_time time without time zone NOT NULL,
    CONSTRAINT show_times_pkey PRIMARY KEY (id),
    CONSTRAINT show_time UNIQUE (show_time)
);

create table booking_details(

 	id  serial NOT NULL  PRIMARY KEY,
    user_id integer NOT NULL,
    movie_id integer NOT NULL,
    showdate date NOT NULL,
    booking_date timestamp without time zone NOT NULL,
    total_price real NOT NULL,
    status character varying(100) DEFAULT 'BOOKED',
    seat_type character varying(50),
    tickets integer NOT NULL,
    screen character varying(40) NOT NULL
    show_time time without time zone NOT NULL,
    CONSTRAINT booking_deatails_movie_id_fkey FOREIGN KEY (movie_id)
        REFERENCES movies (id),
    CONSTRAINT booking_deatails_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES users (id),
    CONSTRAINT show_time FOREIGN KEY (show_time)
        REFERENCES show_times (show_time) 
);

create table admins(id serial primary key,
				   user_name varchar(15) not null,
				   password varchar(15) not null ,
				   CONSTRAINT user_name UNIQUE (user_name),
				   CONSTRAINT password UNIQUE(password));

insert into seat_types(seat_type , price)
values ('Silver' , 60),
('Gold' , 120),
('Platinum',180);

insert into show_times(show_time) 
values ('10:00'),
('14:00'),
('18:00'),
('22:00');

create table admins(id serial primary key,
				   user_name varchar(15) not null,
				   password varchar(15) not null ,
				   CONSTRAINT user_name UNIQUE (user_name),
				   CONSTRAINT password UNIQUE(password));
				   
insert into admins(user_name , password) 
values('admin','Admin@12'),
('admin1','Admin@1'),
('admin2','Admin@2');

create table screens(id serial primary key,
					  name varchar(40) not null,
					  status varchar(40) not null default 'INACTIVE',
					   unique(name));





