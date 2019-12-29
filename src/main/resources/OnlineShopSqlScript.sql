-- create database OnlineShop;

create table customer (
                          Id SERIAL PRIMARY KEY,
                          FirstName text,
                          LastName text,
                          Age INTEGER,
                          Email text,
                          Address text
);
