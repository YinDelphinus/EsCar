
    create table Client (
       id bigint not null auto_increment,
        language integer not null,
        name varchar(150),
        phone_number integer not null,
        preferred_messenger integer not null,
        registered_messangers_mask integer not null,
        registration_date datetime not null,
        primary key (id)
    ) engine=InnoDB;

    create table Company (
       id bigint not null auto_increment,
        address varchar(150) not null,
        dgisURL varchar(255) not null,
        name varchar(150) not null,
        registration_date datetime not null,
        working_hours_from time not null,
        working_hours_to time not null,
        primary key (id)
    ) engine=InnoDB;

    create table Event (
       id bigint not null auto_increment,
        end_date_time datetime,
        price double precision not null,
        start_date_time datetime,
        client_id bigint,
        facility_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table event_services (
       event_id bigint not null,
        service_id bigint not null
    ) engine=InnoDB;

    create table Facility (
       id bigint not null auto_increment,
        company_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table facility_services (
       facility_id bigint not null,
        service_id bigint not null
    ) engine=InnoDB;

    create table Service (
       id bigint not null auto_increment,
        end_date_time datetime,
        price double precision not null,
        start_date_time datetime,
        company_id bigint not null,
        name varchar(200) not null,
        required_duration time,
        primary key (id)
    ) engine=InnoDB;

    create table services_price (
       facility_id bigint not null,
        service_id bigint not null
    ) engine=InnoDB;

    alter table Client 
       add constraint UK_23fc2dnissv310bwe1isl07f4 unique (phone_number);

    alter table Event 
       add constraint FK4s4yivsu8by5d5wmvprgpggol 
       foreign key (client_id) 
       references Client (id);

    alter table Event 
       add constraint FK9sqsafc09bcmkm72mnuxvnnp9 
       foreign key (facility_id) 
       references Facility (id);

    alter table event_services 
       add constraint FKpsn03g59bipfeokhikckk1yr6 
       foreign key (service_id) 
       references Service (id);

    alter table event_services 
       add constraint FKkcd25dmbvjtlt0120van14wtp 
       foreign key (event_id) 
       references Event (id);

    alter table facility_services 
       add constraint FKm3apufwngax4dwrnphwf1e8or 
       foreign key (service_id) 
       references Service (id);

    alter table facility_services 
       add constraint FKtgyq9ck5pnfsox2l3lie34oc5 
       foreign key (facility_id) 
       references Facility (id);

    alter table services_price 
       add constraint FK5amsf0y8qfrq4tbg51wn56mkd 
       foreign key (service_id) 
       references Service (id);

    alter table services_price 
       add constraint FKpmj47tll31y9xt6kf9imjdljl 
       foreign key (facility_id) 
       references Service (id);
