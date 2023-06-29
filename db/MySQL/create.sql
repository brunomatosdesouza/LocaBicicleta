drop database if exists LocaBicicleta;

create database LocaBicicleta;

use LocaBicicleta

create table Cliente(id bigint not null auto_increment, email varchar(100) not null unique, senha varchar(64) not null, nome varchar(256) not null, papel varchar(10), cpf varchar(12) not null, telefone varchar(16), sexo varchar, dataNascimento varchar(10), primary key (id));

create table Locadora(id bigint not null auto_increment, email varchar(100) not null unique, senha varchar(64) not null, nome varchar(256) not null, papel varchar(10), cnpj varchar(24) not null, cidade varchar(64), primary key (id));

create table Locacao(id bigint not null auto_increment, foreign key (cpf), foreign key(cnpj), varchar data(10), primary key(id));

insert into Cliente