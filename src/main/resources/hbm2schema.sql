
    create table Client (
       phone_number integer not null,
        language integer not null,
        name varchar(150),
        preferred_messenger integer not null,
        registered_messangers_mask integer not null,
        registration_date datetime not null,
        primary key (phone_number)
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
        client_phone_number integer,
        facility_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Events2Services (
       event_id bigint not null,
        service_id bigint not null,
        primary key (event_id, service_id)
    ) engine=InnoDB;

    create table Facilities2Services (
       facility_id bigint not null,
        service_id bigint not null,
        primary key (facility_id, service_id)
    ) engine=InnoDB;

    create table Facility (
       id bigint not null auto_increment,
        company_id bigint not null,
        primary key (id)
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

    create table Services2Prices (
       facility_id bigint not null,
        service_id bigint not null,
        primary key (facility_id, service_id)
    ) engine=InnoDB;

    alter table Event 
       add constraint FK_Client_Events 
       foreign key (client_phone_number) 
       references Client (phone_number);

    alter table Event 
       add constraint FK_Facility_Events 
       foreign key (facility_id) 
       references Facility (id);

    alter table Events2Services 
       add constraint FKmpdvpoj35iv9ug63l13674dku 
       foreign key (service_id) 
       references Service (id);

    alter table Events2Services 
       add constraint FKljyp40uvync2w843rlglcrlkn 
       foreign key (event_id) 
       references Event (id);

    alter table Facilities2Services 
       add constraint FKpun9j7e1yl1s215tepow1llpm 
       foreign key (service_id) 
       references Service (id);

    alter table Facilities2Services 
       add constraint FKgjwjkeaxemmd4alcqk9608vx8 
       foreign key (facility_id) 
       references Facility (id);

    alter table Facility 
       add constraint FK_Company_Facilities 
       foreign key (company_id) 
       references Company (id);

    alter table Service 
       add constraint FK_Company_Services 
       foreign key (company_id) 
       references Company (id);

    alter table Services2Prices 
       add constraint FKqdac6w29stykegsu5ioqtr17l 
       foreign key (service_id) 
       references Service (id);

    alter table Services2Prices 
       add constraint FK709rxc88xqjwx9d78bo3ys9k 
       foreign key (facility_id) 
       references Service (id);
