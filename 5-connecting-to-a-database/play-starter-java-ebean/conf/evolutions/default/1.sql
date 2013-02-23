# --- !Ups

create table entry (
  id                  bigint not null,
  name                varchar(255) not null,
  phone               varchar(255) not null,
  constraint pk_entry primary key (id))
;

create sequence entry_seq start with 1;

# --- !Downs

drop table if exists entry;

drop sequence if exists seq_entry;
