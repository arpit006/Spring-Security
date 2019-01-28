create table customer_entity(
  uuid CHARACTER VARYING (60) PRIMARY KEY,
  user_name CHARACTER VARYING(20) UNIQUE,
  first_name CHARACTER VARYING(20),
  last_name CHARACTER Varying (30),
  email CHARACTER VARYING(70),
  active INTEGER,
  password CHARACTER VARYING(70),
  authority jsonb
);

create table authority(
  uuid CHARACTER VARYING(60) PRIMARY KEY,
  authority CHARACTER VARYING
);

create table user_role(
  uuid CHARACTER VARYING(60) PRIMARY KEY default uuid_generate_v4(),
  customer_id CHARACTER VARYING(60) references customer_entity(uuid),
  role_id CHARACTER VARYING(60) references authority(uuid)
);

