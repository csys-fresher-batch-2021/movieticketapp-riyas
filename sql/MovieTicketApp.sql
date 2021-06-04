create database movieticketapp_db;

create table users(
	id serial NOT NULL,
    name varchar(40) NOT NULL,
    email varchar(40) NOT NULL,
    mobile_number bigint NOT NULL,
    user_name varchar(15) NOT NULL,
    password varchar(15)  NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    unique(email),
    unique(user_name),
    unique(mobile_number)
);

create table screens(id serial primary key,
					  name varchar(40) not null,
					  status varchar(40) not null default 'INACTIVE',
					  CHECK ( status in ('ACTIVE','INACTIVE')),
					   unique(name));
					  
insert into screens (name) 
values('Screen 1'),
('Screen 2'),
('Screen 3'),
('Screen 4');

create table seat_types(
	seat_type varchar(20) NOT NULL,
    price real NOT NULL,
    unique(seat_type)
);

insert into seat_types(seat_type , price)
values ('Silver' , 60),
('Gold' , 120),
('Platinum',180);

create table show_times(
	id serial NOT NULL,
    show_time time without time zone NOT NULL,
    CONSTRAINT show_times_pkey PRIMARY KEY (id),
    CONSTRAINT show_time UNIQUE (show_time)
);


insert into show_times(show_time) 
values ('10:00'),
('14:00'),
('18:00'),
('22:00');

create table movies(
	id  serial NOT NULL ,
	movie_name varchar(40) NOT NULL,
    actor_name varchar(40) NOT NULL,
    rating real NOT NULL,
    status varchar(40) NOT NULL default 'ACTIVE',
    CONSTRAINT movies_pkey PRIMARY KEY (id),
    screen varchar(40)  NOT NULL,
    CONSTRAINT screen FOREIGN KEY (screen)
        REFERENCES screens (name) MATCH SIMPLE,
        unique ( movie_name, actor_name),
        CHECK ( rating >0 AND rating <=10 ),
        CHECK ( status in ('ACTIVE','INACTIVE'))
    
);

create table booking_details(

 	id  serial NOT NULL  PRIMARY KEY,
    user_id integer NOT NULL,
    movie_id integer NOT NULL,
    showdate date NOT NULL,
    booking_date timestamp without time zone NOT NULL,
    total_price real NOT NULL,
    status varchar(100) DEFAULT 'BOOKED',
    seat_type varchar(50),
    tickets integer NOT NULL,
    screen varchar(40) NOT NULL,
    show_time time without time zone NOT NULL,
    CONSTRAINT booking_deatails_movie_id_fkey FOREIGN KEY (movie_id)
        REFERENCES movies (id),
    CONSTRAINT booking_deatails_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES users (id),
    CONSTRAINT show_time FOREIGN KEY (show_time)
        REFERENCES show_times (show_time) ,
    CHECK ( status in ('BOOKED','CANCELLED','FINISHED'))
        
);


create table admins(id serial primary key,
				   user_name varchar(15) not null,
				   password varchar(15) not null ,
				   CONSTRAINT user_name UNIQUE (user_name)
				 	);
				   
insert into admins(user_name , password) 
values('admin','Admin@12'),
('admin1','Admin@1'),
('admin2','Admin@2');






