create table client (
                        id integer not null auto_increment,
                        age integer not null,
                        first_name varchar(45) not null,
                        last_name varchar(45) not null,
                        phone_number varchar(9) not null,
                        sex varchar(5) not null,
                        trainer_id integer,
                        primary key (id)) engine=InnoDB;

create table exercise (
                          id integer not null auto_increment,
                          title varchar(255) not null,
                          workout_id integer,
                          primary key (id)) engine=InnoDB;

create table result_workouts (
                                 id integer not null auto_increment,
                                 results varchar(1000) not null,
                                 weight_clients integer not null,
                                 primary key (id)) engine=InnoDB;

create table trainer (
                         id integer not null auto_increment,
                         age integer not null,
                         first_name varchar(45) not null,
                         last_name varchar(45) not null,
                         phone_number varchar(9) not null,
                         sex varchar(5) not null,
                         primary key (id)) engine=InnoDB;

create table users (
                       id bigint not null auto_increment,
                       email varchar(45) not null,
                       password varchar(64) not null,
                       first_name varchar(45) not null ,
                       last_name varchar(45) not null ,
                       role varchar(10) not null,
                       primary key (id)) engine=InnoDB;

create table workout (
                         id integer not null auto_increment,
                         date datetime(6) not null,
                         explanations varchar(1000) not null,
                         client_id integer,
                         resultworkouts_id integer,
                         primary key (id)) engine=InnoDB;

alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);
alter table client add constraint FK3ca1sss0o77xcww04t3vlw4kk foreign key (trainer_id) references trainer (id);
alter table exercise add constraint FKim5ih59gfsc718iyew89ki5xu foreign key (workout_id) references workout (id);
alter table workout add constraint FKryn7txqh4vbrygadt6mxft6wq foreign key (client_id) references client (id);
alter table workout add constraint FKsl9fikk3vlqcjpxm4vx5ig9g8 foreign key (resultworkouts_id) references result_workouts (id);