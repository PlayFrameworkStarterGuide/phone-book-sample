# --- !Ups

create table entry (
  id                  bigint auto_increment primary key,
  name                varchar(255) not null,
  phone               varchar(255) not null)
;

# --- !Downs

drop table if exists entry;
