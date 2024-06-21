
    create table tbfeedback (
        id integer not null auto_increment,
        date_time datetime(6),
        apprentice_id integer,
        instrutor_id integer,
        primary key (id)
    ) engine=InnoDB;


    alter table tbfeedback
       add constraint FKcj6unx9oc23n60p6hgjm4pg87
       foreign key (apprentice_id)
       references tbapprentices (id);

    alter table tbfeedback
       add constraint FK4o4e8svcwleld8vecoygo7x74
       foreign key (instrutor_id)
       references tbinstrutores (id);
