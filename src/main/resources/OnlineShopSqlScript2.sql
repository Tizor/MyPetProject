create schema if not exists hello;
create table hello.customer (
                          Id uuid,
                          FirstName text,
                          LastName text,
                          Age INTEGER,
                          Email text,
                          Address text
);
