CREATE TABLE MEMBER (
    mem_no NUMBER PRIMARY KEY, -- 회원번호 (PK)
    mem_id VARCHAR2(30) NOT NULL, -- 아이디
    mem_pass VARCHAR2(100) NOT NULL, -- 비밀번호
    mem_name VARCHAR2(50) NOT NULL,  -- 이름
    mem_age NUMBER NOT NULL,         -- 나이
    mem_ph VARCHAR2(15),          -- 전화번호
    mem_addr VARCHAR2(255),       -- 주소
    mem_job VARCHAR2(50),            -- 직업
    mem_date DATE DEFAULT SYSDATE -- 생성일
);

commit;

CREATE SEQUENCE mem_no_seq
START WITH 1         -- 시작 값
INCREMENT BY 1       -- 증가 값
NOCACHE;             -- 캐싱 없이 즉시 생성

commit;


ALTER TABLE MEMBER 
ADD mem_rank NUMBER DEFAULT 1;

ALTER TABLE MEMBER 
MODIFY mem_rank NOT NULL;
commit;

ALTER TABLE MEMBER 
MODIFY mem_date DATE DEFAULT SYSDATE NOT NULL;


create table BOARD(
    boa_no number PRIMARY KEY,
    boa_name varchar2(500) not null,
    boa_write varchar2(3000) not null,
    boa_like number default 0,
    boa_date date default sysdate not null,
    mem_no NUMBER,                            -- 회원 번호 (FK)
    CONSTRAINT fk_mem_no FOREIGN KEY (mem_no) REFERENCES MEMBER(mem_no) -- 외래 키 제약
);



CREATE TABLE BOARD_LIKES (
    like_id NUMBER PRIMARY KEY,          -- 좋아요 고유 ID (PK)
    boa_no NUMBER NOT NULL,               -- 게시글 번호 (FK)
    mem_no NUMBER NOT NULL,              -- 회원 번호 (FK)
    like_date DATE DEFAULT SYSDATE,      -- 좋아요 누른 날짜
    CONSTRAINT fk_boa_no FOREIGN KEY (boa_no) REFERENCES BOARD(boa_no),  -- 게시글 참조
    CONSTRAINT fk_mem_no_board_likes FOREIGN KEY (mem_no) REFERENCES MEMBER(mem_no),  -- 회원 참조 (이름 변경)
    CONSTRAINT unique_like_board_mem UNIQUE (boa_no, mem_no);  -- 게시글과 회원의 중복 좋아요 방지


create table WORKOUT (
    ex_no number primary key,
    ex_name varchar2(300) not null,
    ex_txt varchar2(2000) not null,
    ex_category varchar2(50) not null);
    
create table FOOD(
    food_no number primary key,
    food_name varchar2(1000) not null,
    food_kal varchar2(500) not null);
    
create table ADMIN(
    ad_no number primary key,
    ad_id varchar2(50) not null,
    ad_pass varchar2(50) not null);
    
        
create sequence mem_no_seq
    start with 1
    increment by 1
    nocache;
    
SELECT sequence_name
FROM user_sequences
WHERE sequence_name = 'MEM_NO_SEQ';
SELECT mem_no_seq.NEXTVAL FROM dual;

