
    create table tbapprentices (
        active bit not null,
        id integer not null auto_increment,
        vacation bit not null,
        classroom varchar(255),
        edv varchar(255),
        email varchar(255),
        nome varchar(255),
        shift varchar(255),
        curso enum ('DS','MECATRONICA','MANUFATURA','ADM'),
        primary key (id)
    ) engine=InnoDB;

    create table tbinstrutores (
        ativo bit not null,
        ferias bit not null,
        id integer not null auto_increment,
        disciplina varchar(255),
        edv varchar(255),
        email varchar(255),
        faculdade varchar(255),
        nome varchar(255),
        trilha varchar(255),
        turma varchar(255),
        curso enum ('DS','MECATRONICA','MANUFATURA','ADM'),
        primary key (id)
    ) engine=InnoDB;