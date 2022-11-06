create table "joojoo_user"
(
    user_id       uuid                                not null
        constraint user_pk
            primary key,
    username      varchar(45)                         not null,
    password      text,
    registered_at timestamp default CURRENT_TIMESTAMP not null
);

alter table "joojoo_user"
    owner to jeongyong;

create index joojoo_user__idx01
    on "joojoo_user" (registered_at);
create index joojoo_user__idx02 on "joojoo_user" (username);

create table otp
(
    otp_id     uuid        not null
        constraint otp_pk
            primary key,
    username   varchar(45) not null,
    code       varchar(45),
    created_at timestamp default CURRENT_TIMESTAMP
);

alter table otp
    owner to jeongyong;

create index otp__idx01
    on otp (created_at);

create index otp__idx02 on "otp" (username);