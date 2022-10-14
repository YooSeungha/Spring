drop USER team4 cascade;
alter session set "_oracle_script"=true;
create user team4 identified by team4;
grant connect, resource, unlimited tablespace to team4; 
conn team4/team4;

drop table RESERVATION;
drop table SEAT;
drop table BOARD;
drop table BOARD_TYPE;
drop table DVD_FAVORITE;
drop table DVD_RENTAL;
drop table DVD;
drop table BOOK_FAVORITE;
drop table BOOK_REQUEST;
drop table RENTAL;
drop table BOOK;
drop table CLASSIFICATION;
drop table FACILITY;
drop table MEMBER;
drop sequence RESERVATION_SEQ;
drop sequence SEAT_SEQ;
drop sequence BOARD_SEQ;
drop sequence BOARD_TYPE_SEQ;
drop sequence DVD_FAVORITE_SEQ;
drop sequence DVD_RENTAL_SEQ;
drop sequence DVD_SEQ;
drop sequence BOOK_FAVORITE_SEQ;
drop sequence BOOK_REQUEST_SEQ;
drop sequence RENTAL_SEQ;
drop sequence BOOK_SEQ;
drop sequence CLASSIFICATION_SEQ;
drop sequence FACILITY_SEQ;
drop sequence MEMBER_SEQ;

-- 유저 시퀀스 생성
create sequence MEMBER_SEQ increment by 1 start with 1 nocache;

-- 유저 테이블 생성
create table MEMBER(
		   MEM_Num number not null constraint MEMBER_PK primary key,	-- 회원시퀀스
		   MEM_Email varchar2(50) not null constraint MEM_EMAIL_UQ UNIQUE ,	-- 회원 이메일
		   MEM_Pass varchar2(50),	-- 회원 패스워드
		   MEM_Phone varchar2(20) not null constraint MEM_PHONE_UQ UNIQUE,	-- 회원 핸드폰
		   MEM_Id varchar2(50) not null constraint MEM_ID_UQ UNIQUE,	--회원 아이디
		   MEM_Name varchar2(50) not null,	--회원 이름
		   Mem_Grade number not null,		--회원 등급
		   MEM_SNS varchar2(20) not null, -- SNS 플랫폼 분류(naver.kakao,google,normal)
		   MEM_RDATE date,	-- 생성날짜
		   MEM_UDATE date	-- 수정날짜
);

INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'admin@admin.com', 'admin', '010-1111-1111', 'admin', '관리자', 1,'normal', sysdate, sysdate);
INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'test@test.com', 'test', '010-2222-2222', 'TESTER', '테스터', 1,'normal', sysdate, sysdate);
INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'normal@normal.com', 'normal123!', '010-3333-3333', 'normal', 'normal', 2,'normal', sysdate, sysdate);
INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'normal2@normal2.com', 'normal23!', '010-4444-4444', 'normal2', 'normal2', 2,'normal2', sysdate, sysdate);


-- FACILITY(시설안내) 시퀀스 생성
create sequence FACILITY_SEQ increment by 1 start with 1 nocache;

-- FACILITY(시설안내) 테이블 생성
create table FACILITY(
		   F_Num number not null constraint FACILITY_PK primary key,	
		   F_Name varchar2(50) not null,	
		   F_Floor number not null
);

INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '로비', 1);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '안내데스크', 1);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '어린이도서관', 1);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '자료실A', 2);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '자료실B', 2);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '열람실A', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '열람실B', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '열람실C', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '열람실D', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '옥상정원', 4);

-- CLASSIFICATION(도서분류) 시퀀스 생성
create sequence CLASSIFICATION_SEQ increment by 1 start with 1 nocache;

-- CLASSIFICATION(도서분류) 테이블 생성
create table CLASSIFICATION(
		   CF_CODE number not null constraint CLASSIFICATION_PK primary key,	-- CLASSIFICATION(도서분류) 시퀀스
		   CF_NAME varchar2(50) not null	-- 시설이름   
);
INSERT INTO CLASSIFICATION values(1, '소설(국내)');
INSERT INTO CLASSIFICATION values(2, '에세이(국내)');
INSERT INTO CLASSIFICATION values(3, '과학(국내)');
INSERT INTO CLASSIFICATION values(4, '인문학(국내)');
INSERT INTO CLASSIFICATION values(5, '예술/대중문화(국내)');
INSERT INTO CLASSIFICATION values(6, '소설(외국)');
INSERT INTO CLASSIFICATION values(7, '어린이(외국)');
INSERT INTO CLASSIFICATION values(8, '일본도서(외국)');
INSERT INTO CLASSIFICATION values(9, '중국도서(외국)');
INSERT INTO CLASSIFICATION values(10, '예술/대중문화(외국)');


-- 도서 시퀀스 생성
create sequence BOOK_SEQ increment by 1 start with 1 nocache;

-- 도서 테이블 생성  # 보류
create table BOOK(
		   BOOK_Num number not null constraint BOOK_PK primary key,	-- 도서 시퀀스
		   BOOK_Code number not null,	-- 분류코드(도서분류 테이블)
		   F_Num number not null,	-- 시설번호 시퀀스
		   BOOK_TITLE varchar2(50) not null,	-- 제목
		   BOOK_WRITER varchar2(30),	-- 지은이
		   BOOK_PUBLISHER varchar2(20),	-- 출판사
		   BOOK_ISBN varchar2(17) not null,	-- ISBN
		   BOOK_RECOMEND varchar2(20),	-- 추천도서 (boolean)으로 되어있는데 없음 0비추천, 1추천
		   BOOK_COUNT number,	-- 재고량
		   CONSTRAINT BOOK_CLASS_FK foreign key(BOOK_Code) references CLASSIFICATION (CF_CODE) on delete cascade,
		   CONSTRAINT BOOK_F_FK foreign key(F_Num) references FACILITY (F_Num) on delete cascade
);
insert into BOOK values(BOOK_SEQ.nextval, 1, 4, '해바라기가 피지 않는 여름', '미치오 슈스케', '들녘', '9788975270062', '0', 2, 'http://image.yes24.com/goods/14610822/XL');

-- 도서 대여 시퀀스 생성
create sequence RENTAL_SEQ increment by 1 start with 1 nocache;

-- 도서 대여 테이블 생성
create table RENTAL(
		   REN_Num number not null constraint RENTAL_PK primary key,	-- 도서대여 시퀀스
		   MEM_Num number not null,	-- 회원번호 시퀀스
		   BOOK_Num number not null,	-- 도서번호 시퀀스		   
		   REN_BORROW date,	-- 대여일자
		   REN_RETURN date,	-- 반납일자
		   CONSTRAINT REN_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT REN_BOOK_FK foreign key(BOOK_Num) references BOOK (BOOK_Num) on delete cascade
);


-- 도서신청 시퀀스 생성
create sequence BOOK_REQUEST_SEQ increment by 1 start with 1 nocache;

-- 도서신청 테이블 생성
create table BOOK_REQUEST(
		   BR_Num number not null constraint BOOK_REQUEST_PK primary key,	-- 도서신청 시퀀스
		   MEM_Num number not null,	-- 회원번호(FK)
		   BR_TITLE varchar2(50) not null,	-- 제목
		   BR_WRITER varchar2(30) not null,	-- 지은이
		   BR_ISBN varchar2(17) not null,	-- ISBN
		   CONSTRAINT BR_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade
);

-- 도서즐겨찾기 시퀀스 생성
create sequence BOOK_FAVORITE_SEQ increment by 1 start with 1 nocache;

-- 도서즐겨찾기 테이블 생성
create table BOOK_FAVORITE(
		   BF_Num number not null constraint BOOK_FAVORITE_PK primary key,	-- 도서즐겨찾기 시퀀스
		   BOOK_Num number not null,	-- book시퀀스(FK) book_NUM로 수정
		   MEM_Num number not null,	-- 회원번호(FK)
		   CONSTRAINT BF_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT BF_BOOK_FK foreign key(BOOK_Num) references BOOK (BOOK_Num) on delete cascade
);

-- DVD 시퀀스 생성
create sequence DVD_SEQ increment by 1 start with 1 nocache;

-- DVD 테이블 생성
create table DVD(
		   DVD_Num number not null constraint DVD_PK primary key,
		   F_Num number not null,-- DVD 시퀀스
		   DVD_TITLE varchar2(100) not null,	-- 제목
		   DVD_CONTENT varchar2(300),	-- 내용
		   DVD_DIRECTOR varchar2(50) not null,	-- 저자
		   DVD_RDATE date,	-- 발행년도		   
		   CONSTRAINT DVD_F_FK foreign key(F_Num) references FACILITY (F_Num) on delete cascade
);

-- DVD대여 시퀀스 생성
create sequence DVD_RENTAL_SEQ increment by 1 start with 1 nocache;

-- DVD대여 테이블 생성
create table DVD_RENTAL(
		   DR_Num number not null constraint DVD_RENTAL_PK primary key,	-- DVD대여 시퀀스
		   MEM_Num number not null,	-- 회원번호
		   DVD_Num number not null,	-- DVD번호
		   DR_BORROW date,	-- 대여일자
		   DR_RETURN date,	-- 반납일자
		   CONSTRAINT DR_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT DR_DVD_FK foreign key(DVD_Num) references DVD (DVD_Num) on delete cascade
);

-- DVD즐겨찾기 시퀀스 생성
create sequence DVD_FAVORITE_SEQ increment by 1 start with 1 nocache;

-- DVD즐겨찾기 테이블 생성
create table DVD_FAVORITE(
		   DF_Num number not null constraint DVD_FAVORITE_PK primary key,	-- DVD즐겨찾기 시퀀스
		   DVD_Num number not null,	-- DVD시퀀스(FK) DVD_NUM로 수정
		   MEM_Num number not null,	-- 회원번호(FK)
		   CONSTRAINT DF_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT DF_DVD_FK foreign key(DVD_Num) references DVD (DVD_Num) on delete cascade
);

-- 게시판 종류 테이블 생성
create table BOARD_TYPE(
			BT_Num number not null constraint BT_PK primary key,
			BT_Name varchar2(50) not null
);

INSERT INTO BOARD_TYPE values(1, '공지사항');
INSERT INTO BOARD_TYPE values(2, 'QNA');
INSERT INTO BOARD_TYPE values(3, 'FAQ');


-- BOARD 시퀀스 생성
create sequence BOARD_SEQ increment by 1 start with 1 nocache;

-- BOARD 테이블 생성
create table BOARD(
		   B_Num number not null constraint NOTICE_PK primary key,	-- NOTICE 시퀀스
		   MEM_Num number not null,	-- 작성자
		   BT_Num number not null,	-- 글 종류
		   B_TITLE varchar2(100) not null,	-- 제목
		   B_CONTENT varchar2(3000) not null,	-- 내용
		   B_RDATE date not null,	-- 작성일
		   B_VIEW number,	-- 조회수
		   B_TOP number not null,	-- 상단고정여부
		   CONSTRAINT B_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT B_BT_FK foreign key(BT_Num) references BOARD_TYPE (BT_Num) on delete cascade
);

-- SEAT(열람실 자리) 시퀀스 생성
create sequence SEAT_SEQ increment by 1 start with 1 nocache;

-- SEAT(열람실 자리) 테이블 생성
create table SEAT(
         SEAT_Seq number not null constraint ROOM_PK primary key,   -- ROOM(열람실) 시퀀스
         F_Num number not null,   -- 시설번호(FK)    
         Seat_Use varchar2(50),
         Seat_Num varchar2(50),
         CONSTRAINT SEAT_F_FK foreign key(F_Num) references FACILITY (F_Num) on delete cascade
);
INSERT INTO seat values(seat_seq.nextval, 6,'taken', 'A1');
-- RESERVATION(열람실예약) 시퀀스 생성
create sequence RESERVATION_SEQ increment by 1 start with 1 nocache;

-- RESERVATION(열람실예약) 테이블 생성
create table RESERVATION(
         RES_Num number not null constraint RESERVATION_PK primary key,   -- RESERVATION(열람실예약) 시퀀스
         MEM_Num number not null,   -- 회원번호(FK) 
         SEAT_Seq number not null,   -- 자리고유번호(FK)      
         RES_START date not null,   -- 예약시작시간
         RES_END date not null,   -- 예약종료시간
         CONSTRAINT RESERVATION_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
         CONSTRAINT RESERVATION_SEAT_FK foreign key(SEAT_Seq) references SEAT (SEAT_Seq) on delete cascade
);
INSERT INTO reservation values(reservation_seq.nextval, 2,1, to_date('03/05/2000 12:10:17','MM-DD-YYYY HH24:MI:SS'),to_date('03/05/2000 16:10:17','MM-DD-YYYY HH24:MI:SS') );