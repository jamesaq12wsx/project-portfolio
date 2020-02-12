create IF NOT EXISTS table account (
    id UUID NOT NULL PRIMARY KEY,
    username varchar(100) not null,
    password varchar(100) not null,
    email varchar(100) not null,
    default_resume UUID,
    constraints unique_username Unique (username)
);