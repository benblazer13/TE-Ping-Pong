drop table if exists players;

CREATE Table players (
	id SERIAL PRIMARY KEY,
	first_name varchar(100) not null,
	last_name varchar (100) not null, 
	nickname varchar (50),
	description varchar (500),
	player_wins int, 
	player_losses int, 
	games_played int
);