/*
CREATE SEQUENCE seq_commu_idx
DROP TABLE commu
DROP SEQUENCE seq_commu_idx

CREATE TABLE commu
(
	c_idx 			INT,		 			  -- 일련번호
	c_title   		VARCHAR2(200)  NOT NULL,  -- 제목
	c_content 		VARCHAR2(2000) NOT NULL,  -- 내용
	c_regdate		DATE DEFAULT   SYSDATE,	  -- 등록날짜
	c_category		VARCHAR2(200)  NOT NULL,  -- 카테고리
	c_inCount		INT DEFAULT    0,		  -- 조회수
	c_reply			VARCHAR2(2000) DEFAULT ' ',-- 댓글
	mem_idx			INT,					  -- 회원번호 (FK)
	mem_nickname  	VARCHAR2(100)  NOT NULL   -- 회원닉네임
)

-- PK설정
 ALTER TABLE commu
	ADD CONSTRAINT pk_commu_idx PRIMARY KEY(c_idx);
	
-- FK설정
 ALTER TABLE commu
 	ADD CONSTRAINT fk_commu_mem_idx FOREIGN KEY (mem_idx)
 									REFERENCES member(mem_idx) 
 									
 									
-- Number View 생성
 CREATE OR REPLACE VIEW commu_view
 AS
 	SELECT
 		rownum AS c_no, a.*
 	FROM (SELECT * FROM commu ORDER BY c_idx DESC) a
 									
 UPDATE commu SET c_title='수정', c_content='수정' WHERE c_idx=1	
 									
-- TEST Data 생성
 INSERT INTO commu VALUES(seq_commu_idx.nextVal,'Test-Title1','Test-Content1',SYSDATE,'전략게임',DEFAULT,DEFAULT,1,'Test1');
 INSERT INTO commu VALUES(seq_commu_idx.nextVal,'Test-Title2','Test-Content2',SYSDATE,'파티게임',DEFAULT,DEFAULT,2,'Test2');
 INSERT INTO commu VALUES(seq_commu_idx.nextVal,'Test-Title3','Test-Content3',SYSDATE,'테마게임',DEFAULT,DEFAULT,3,'Test3');
 INSERT INTO commu VALUES(seq_commu_idx.nextVal,'Test-Title4','Test-Content4',SYSDATE,'추상게임',DEFAULT,DEFAULT,3,'Test4');
 INSERT INTO commu VALUES(seq_commu_idx.nextVal,'Test-Title5','Test-Content5',SYSDATE,'가족게임',DEFAULT,DEFAULT,3,'Test5');
 				
 DELETE commu WHERE c_idx=1
 UPDATE commu SET c_inCount = c_inCount + 1 WHERE c_idx=1
 SELECT * FROM commu_view  WHERE c_no = 1
 */