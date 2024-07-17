/*	보드게임 DB

drop table games1;
drop sequence seq_games1_game_idx;

CREATE TABLE games1(
	game_idx   		int,
	name	   		VARCHAR2(200),
	category   		VARCHAR2(100)	  NOT NULL,
	min_player 		int				  DEFAULT 2,
	max_player 		int				  DEFAULT 2,
	playtime   		int		 		  NOT NULL,
	age		   		int 			  NOT NULL,
	year	   		int 			  NOT NULL,
	publisher    	VARCHAR2(200) 	  NOT NULL,
	img_filename	varchar2(200),
	detail_loc		varchar2(200)
)

	ALTER TABLE games1
		ADD CONSTRAINT pk_games1_game_idx PRIMARY KEY (game_idx)
	
	ALTER TABLE games1
		ADD CONSTRAINT unique_games1_name UNIQUE (name)	
	
	CREATE SEQUENCE seq_games1_game_idx
		
	SELECT * FROM games1
	
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'아컴 호러 : 카드게임','컬렉터블 게임',1,2,60,14,2016,'Asterion Press','c-game1.png','de-c-1.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'7 원더스 대결',  '전략게임',2,2,30,10,2015,'ADC Blackfire Entertainment','s-game8.png', 'de-s-8.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'우봉고 3D 프로','추상게임',2,4,30,10,2009,'Albi','a-game7.png','de-a-7.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'반지 전쟁(2판)',    '워게임',2,4,150,13,2011,'Ares Games','w-game2.png','de-w-2.jsp');

	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'패스 오브 글로리','워게임',2,2,480,14,1999,'GMT Games','w-game5.png','de-w-5.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'사그라다','추상게임',	1,4,30,14,2017,'Matagot','a-game9.png','de-a-9.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'워해머 언더월드 : 나이트 볼트','워게임',2,2,30,12,2018,'Gmaes Workshop Ltd','w-game8.png','de-w-8.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'코드네임','파티게임',		2,8,15,14,2015,'Brain Games','p-game4.png','de-p-4.jsp');
		
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'텔레스트레이션','파티게임',	4,8,30,12,2009,'Broadway Toys LTD','p-game3.png','de-p-3.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'생쥐 만세!','어린이게임',	2,4,20,4,2002,'Matagot','k-game6.png','de-k-6.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'윙스팬','가족게임',		1,5,40,10,2019,'999 Games','f-game3.png','de-f-3.jsp');
	INSERT INTO games1 VALUES(seq_games1_game_idx.nextVal,'핑고 핑고','어린이게임',		2,5,15,6,2015,'Asterion Press','k-game5.png','de-k-5.jsp');
	
	
	
	select * from games1
	
	select * from games1 where game_idx=1
	
	
*/