DROP TABLE IF EXISTS organization CASCADE;
CREATE TABLE organization
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255),
    url  VARCHAR(255)
);

DROP TABLE IF EXISTS researcher CASCADE;
CREATE TABLE researcher
(
    id              SERIAL PRIMARY KEY,
    orcid           VARCHAR(255),
    organization_id INTEGER REFERENCES organization (id)
);

