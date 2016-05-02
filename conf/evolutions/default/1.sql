create database films_storage;
use films_storage;

create table flist (
  id                        bigint not null AUTO_INCREMENT,
  name                      varchar(255),
  constraint pk_flist primary key (id));

create table film (
  id                        bigint not null AUTO_INCREMENT,
  name                      varchar(255),
  external_id				        bigint,
  flist_id                	bigint,
  constraint pk_film primary key (id));

create table ulink (
  id                        bigint not null AUTO_INCREMENT,
  ulink						          varchar(255) not null,
  flist_id                	bigint,
  film_id                	  bigint,
  external_id               bigint not null,
  constraint pk_ulink primary key (id))
;

alter table film add constraint fk_film_flist_1 foreign key (flist_id) references flist(id) on delete restrict on update restrict;

create sequence flist_seq start with 1000;

create sequence film_seq start with 1000;


SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists flist;

drop table if exists film;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists flist_seq;

drop sequence if exists film_seq;