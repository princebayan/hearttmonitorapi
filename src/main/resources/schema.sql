BEGIN;

-- Create the file_status Table --
CREATE TABLE IF NOT EXISTS device
(
    id     serial PRIMARY KEY,
    serial VARCHAR(100) UNIQUE NOT NULL
);

-- Create the file_extension table --
CREATE TABLE IF NOT EXISTS patient
(
    id   serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Create the action table --
CREATE TABLE IF NOT EXISTS study
(
    id              serial PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    start_time      TIMESTAMP WITHOUT TIME ZONE,
    end_time        TIMESTAMP WITHOUT TIME ZONE,
    low_heart_rate  integer default 50,
    high_heart_rate integer default 100,
    device_id       integer references device (id),
    patient_id      integer references patient (id)
);

CREATE TABLE IF NOT EXISTS heart_rate_record
(
    id          serial PRIMARY KEY,
    rate        integer NOT NULL,
    record_date TIMESTAMP WITHOUT TIME ZONE,
    study_id    integer references device (id)
);

insert into device ( serial )
values ('123456789');

insert into patient ( name )
values ('Amir Bayan');



Commit;