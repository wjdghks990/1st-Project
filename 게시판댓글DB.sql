/*
DROP TABLE cmt
drop SEQUENCE seq_cmt_idx; 


CREATE TABLE cmt(
    cmt_idx 	INT, 							-- 댓글 ID (기본 키)
    c_idx 		INT,          		 			-- 게시물 ID (외래 키)
    mem_idx 	INT,            				-- 회원 ID (외래 키)
  	mem_nickname VARCHAR2(100) NOT NULL,		-- 회원 닉네임
    cmt_content VARCHAR2(2000) NOT NULL,        -- 댓글 내용
    cmt_regdate DATE DEFAULT   SYSDATE          -- 등록 날짜
);

-- on delete cascade
-- 부모 삭제 시 자식도 삭제

	CREATE SEQUENCE seq_cmt_idx; 
	
	ALTER TABLE cmt
		ADD CONSTRAINT pk_cmt_idx PRIMARY KEY (cmt_idx);
		
	ALTER TABLE cmt
		ADD CONSTRAINT fk_cmt_c_idx FOREIGN KEY (c_idx)
									REFERENCES commu(c_idx)
									on delete cascade

	ALTER TABLE cmt
		ADD CONSTRAINT fk_cmt_mem_idx FOREIGN KEY (mem_idx)
									  REFERENCES member(mem_idx)
									  on delete cascade

select * from cmt WHERE c_idx=1;

SELECT 
	
FROM cmt c

SELECT c.cmt_idx, c.c_idx, c.mem_idx, c.cmt_content, c.cmt_regdate, m.mem_nickname 
                   FROM cmt c 
                   JOIN member m ON c.mem_idx = m.mem_idx 
                   WHERE c.c_idx = 1 ORDER BY c.cmt_regdate DESC

SELECT c.cmt_idx, c.c_idx, c.mem_idx, c.cmt_content, c.cmt_regdate, m.mem_nickname FROM cmt c JOIN member m ON c.mem_idx = m.mem_idx WHERE c.c_idx = ? ORDER BY c.cmt_regdate DESC

insert into cmt values(seq_cmt_idx.nextval,1,1,'닉네임','하나',sysdate);
insert into cmt values(seq_cmt_idx.nextval,1,1,'테스트','둘',sysdate);
*/