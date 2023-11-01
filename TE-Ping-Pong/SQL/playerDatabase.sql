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

CREATE Table games (
    game_id SERIAL PRIMARY KEY,
    player1_id int not null,
    player2_id int not null,
    game_type varchar(15),
    who_won_id int,

    CONSTRAINT fk_player1_id FOREIGN KEY (player1_id) references players (id),
    CONSTRAINT fk_player2_id FOREIGN KEY (player2_id) references players (id),
    CONSTRAINT fk_winner_id FOREIGN KEY (who_won_id) references players (id),
    CONSTRAINT chk_valid_winner CHECK (who_won_id = player1_id or who_won_id = player2_id or who_won_id is null)

);