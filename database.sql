create table public.instrutor
(
    id_instrutor serial not null,
    rg           int4,
    nome         varchar(45),
    nascimento   timestamp,
    titulacao    int4,
    primary key (id_instrutor)
);

create table public.atividade
(
    id_atividade serial not null,
    nome         varchar(45),
    primary key (id_atividade)
);

create table public.turma
(
    id_turma     serial not null,
    horario      timestamp,
    duracao      int4,
    data_inicio  timestamp,
    data_fim     timestamp,
    id_instrutor int4,
    id_atividade int4,
    primary key (id_turma),
    foreign key (id_instrutor) references instrutor (id_instrutor),
    foreign key (id_atividade) references atividade (id_atividade)
);