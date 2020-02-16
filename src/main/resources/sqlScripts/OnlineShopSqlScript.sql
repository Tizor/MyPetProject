-- create database OnlineShop;

create table customer (
                          Id uuid  NOT NULL DEFAULT uuid_generate_v4(),
                          FirstName text,
                          LastName text,
                          Age INTEGER,
                          Email text,
                          Address text
);
