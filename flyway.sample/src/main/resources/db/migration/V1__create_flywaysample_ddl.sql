-- Postgres  - SQL generated with Cayenne Modeller
-- SQL based migration of Flyway supports executing Dynamic SQL as well

CREATE TABLE public.project (id bigint NOT NULL, name varchar NOT NULL, PRIMARY KEY (id))
;

CREATE TABLE public.address (address varchar NOT NULL, country varchar NOT NULL, id bigint NOT NULL, postcode varchar NOT NULL, state varchar NOT NULL, PRIMARY KEY (id))
;

CREATE TABLE public.employee (address_id bigint NOT NULL, id bigint NOT NULL, name varchar NOT NULL, position varchar NOT NULL, project_id bigint NULL, PRIMARY KEY (id))
;

ALTER TABLE public.employee ADD UNIQUE (address_id)
;

ALTER TABLE public.employee ADD FOREIGN KEY (address_id) REFERENCES public.address (id)
;

ALTER TABLE public.employee ADD FOREIGN KEY (project_id) REFERENCES public.project (id)
;

CREATE SEQUENCE public.pk_address INCREMENT 20 START 200
;

CREATE SEQUENCE public.pk_employee INCREMENT 20 START 200
;

CREATE SEQUENCE public.pk_project INCREMENT 20 START 200
;

