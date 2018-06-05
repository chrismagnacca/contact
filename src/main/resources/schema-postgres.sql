-- extensions
CREATE EXTENSION IF NOT EXISTS "postgis"
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- neighborhoods
drop table if exists neighborhoods;
create table neighborhoods (uuid uuid not null, geom geometry(MultiPolygon, 4326), properties jsonb, primary key (uuid))