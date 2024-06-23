create table chinese_titles
(
    movieid integer not null,
    rn      bigint  not null,
    title   varchar(250),
    constraint chinese_titles_pk
        primary key (movieid, rn)
);

create table chinese_blocks
(
    movieid integer    not null,
    rn      integer    not null,
    block   varchar(3) not null,
    constraint chinese_blocks_pk
        primary key (block, movieid, rn),
    constraint chinese_blocks_fk
        foreign key (movieid, rn) references chinese_titles
            on delete cascade
);
