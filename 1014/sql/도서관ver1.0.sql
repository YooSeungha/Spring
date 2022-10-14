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

-- ���� ������ ����
create sequence MEMBER_SEQ increment by 1 start with 1 nocache;

-- ���� ���̺� ����
create table MEMBER(
		   MEM_Num number not null constraint MEMBER_PK primary key,	-- ȸ��������
		   MEM_Email varchar2(50) not null constraint MEM_EMAIL_UQ UNIQUE ,	-- ȸ�� �̸���
		   MEM_Pass varchar2(50),	-- ȸ�� �н�����
		   MEM_Phone varchar2(20) not null constraint MEM_PHONE_UQ UNIQUE,	-- ȸ�� �ڵ���
		   MEM_Id varchar2(50) not null constraint MEM_ID_UQ UNIQUE,	--ȸ�� ���̵�
		   MEM_Name varchar2(50) not null,	--ȸ�� �̸�
		   Mem_Grade number not null,		--ȸ�� ���
		   MEM_SNS varchar2(20) not null, -- SNS �÷��� �з�(naver.kakao,google,normal)
		   MEM_RDATE date,	-- ������¥
		   MEM_UDATE date	-- ������¥
);

INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'admin@admin.com', 'admin', '010-1111-1111', 'admin', '������', 1,'normal', sysdate, sysdate);
INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'test@test.com', 'test', '010-2222-2222', 'TESTER', '�׽���', 1,'normal', sysdate, sysdate);
INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'normal@normal.com', 'normal123!', '010-3333-3333', 'normal', 'normal', 2,'normal', sysdate, sysdate);
INSERT INTO MEMBER values(MEMBER_SEQ.nextval, 'normal2@normal2.com', 'normal23!', '010-4444-4444', 'normal2', 'normal2', 2,'normal2', sysdate, sysdate);


-- FACILITY(�ü��ȳ�) ������ ����
create sequence FACILITY_SEQ increment by 1 start with 1 nocache;

-- FACILITY(�ü��ȳ�) ���̺� ����
create table FACILITY(
		   F_Num number not null constraint FACILITY_PK primary key,	
		   F_Name varchar2(50) not null,	
		   F_Floor number not null
);

INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '�κ�', 1);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '�ȳ�����ũ', 1);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '��̵�����', 1);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '�ڷ��A', 2);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '�ڷ��B', 2);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '������A', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '������B', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '������C', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '������D', 3);
INSERT INTO FACILITY values(FACILITY_SEQ.nextval, '��������', 4);

-- CLASSIFICATION(�����з�) ������ ����
create sequence CLASSIFICATION_SEQ increment by 1 start with 1 nocache;

-- CLASSIFICATION(�����з�) ���̺� ����
create table CLASSIFICATION(
		   CF_CODE number not null constraint CLASSIFICATION_PK primary key,	-- CLASSIFICATION(�����з�) ������
		   CF_NAME varchar2(50) not null	-- �ü��̸�   
);
INSERT INTO CLASSIFICATION values(1, '�Ҽ�(����)');
INSERT INTO CLASSIFICATION values(2, '������(����)');
INSERT INTO CLASSIFICATION values(3, '����(����)');
INSERT INTO CLASSIFICATION values(4, '�ι���(����)');
INSERT INTO CLASSIFICATION values(5, '����/���߹�ȭ(����)');
INSERT INTO CLASSIFICATION values(6, '�Ҽ�(�ܱ�)');
INSERT INTO CLASSIFICATION values(7, '���(�ܱ�)');
INSERT INTO CLASSIFICATION values(8, '�Ϻ�����(�ܱ�)');
INSERT INTO CLASSIFICATION values(9, '�߱�����(�ܱ�)');
INSERT INTO CLASSIFICATION values(10, '����/���߹�ȭ(�ܱ�)');


-- ���� ������ ����
create sequence BOOK_SEQ increment by 1 start with 1 nocache;

-- ���� ���̺� ����  # ����
create table BOOK(
		   BOOK_Num number not null constraint BOOK_PK primary key,	-- ���� ������
		   BOOK_Code number not null,	-- �з��ڵ�(�����з� ���̺�)
		   F_Num number not null,	-- �ü���ȣ ������
		   BOOK_TITLE varchar2(50) not null,	-- ����
		   BOOK_WRITER varchar2(30),	-- ������
		   BOOK_PUBLISHER varchar2(20),	-- ���ǻ�
		   BOOK_ISBN varchar2(17) not null,	-- ISBN
		   BOOK_RECOMEND varchar2(20),	-- ��õ���� (boolean)���� �Ǿ��ִµ� ���� 0����õ, 1��õ
		   BOOK_COUNT number,	-- ���
		   CONSTRAINT BOOK_CLASS_FK foreign key(BOOK_Code) references CLASSIFICATION (CF_CODE) on delete cascade,
		   CONSTRAINT BOOK_F_FK foreign key(F_Num) references FACILITY (F_Num) on delete cascade
);
insert into BOOK values(BOOK_SEQ.nextval, 1, 4, '�عٶ�Ⱑ ���� �ʴ� ����', '��ġ�� ������', '���', '9788975270062', '0', 2, 'http://image.yes24.com/goods/14610822/XL');

-- ���� �뿩 ������ ����
create sequence RENTAL_SEQ increment by 1 start with 1 nocache;

-- ���� �뿩 ���̺� ����
create table RENTAL(
		   REN_Num number not null constraint RENTAL_PK primary key,	-- �����뿩 ������
		   MEM_Num number not null,	-- ȸ����ȣ ������
		   BOOK_Num number not null,	-- ������ȣ ������		   
		   REN_BORROW date,	-- �뿩����
		   REN_RETURN date,	-- �ݳ�����
		   CONSTRAINT REN_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT REN_BOOK_FK foreign key(BOOK_Num) references BOOK (BOOK_Num) on delete cascade
);


-- ������û ������ ����
create sequence BOOK_REQUEST_SEQ increment by 1 start with 1 nocache;

-- ������û ���̺� ����
create table BOOK_REQUEST(
		   BR_Num number not null constraint BOOK_REQUEST_PK primary key,	-- ������û ������
		   MEM_Num number not null,	-- ȸ����ȣ(FK)
		   BR_TITLE varchar2(50) not null,	-- ����
		   BR_WRITER varchar2(30) not null,	-- ������
		   BR_ISBN varchar2(17) not null,	-- ISBN
		   CONSTRAINT BR_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade
);

-- �������ã�� ������ ����
create sequence BOOK_FAVORITE_SEQ increment by 1 start with 1 nocache;

-- �������ã�� ���̺� ����
create table BOOK_FAVORITE(
		   BF_Num number not null constraint BOOK_FAVORITE_PK primary key,	-- �������ã�� ������
		   BOOK_Num number not null,	-- book������(FK) book_NUM�� ����
		   MEM_Num number not null,	-- ȸ����ȣ(FK)
		   CONSTRAINT BF_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT BF_BOOK_FK foreign key(BOOK_Num) references BOOK (BOOK_Num) on delete cascade
);

-- DVD ������ ����
create sequence DVD_SEQ increment by 1 start with 1 nocache;

-- DVD ���̺� ����
create table DVD(
		   DVD_Num number not null constraint DVD_PK primary key,
		   F_Num number not null,-- DVD ������
		   DVD_TITLE varchar2(100) not null,	-- ����
		   DVD_CONTENT varchar2(300),	-- ����
		   DVD_DIRECTOR varchar2(50) not null,	-- ����
		   DVD_RDATE date,	-- ����⵵		   
		   CONSTRAINT DVD_F_FK foreign key(F_Num) references FACILITY (F_Num) on delete cascade
);

-- DVD�뿩 ������ ����
create sequence DVD_RENTAL_SEQ increment by 1 start with 1 nocache;

-- DVD�뿩 ���̺� ����
create table DVD_RENTAL(
		   DR_Num number not null constraint DVD_RENTAL_PK primary key,	-- DVD�뿩 ������
		   MEM_Num number not null,	-- ȸ����ȣ
		   DVD_Num number not null,	-- DVD��ȣ
		   DR_BORROW date,	-- �뿩����
		   DR_RETURN date,	-- �ݳ�����
		   CONSTRAINT DR_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT DR_DVD_FK foreign key(DVD_Num) references DVD (DVD_Num) on delete cascade
);

-- DVD���ã�� ������ ����
create sequence DVD_FAVORITE_SEQ increment by 1 start with 1 nocache;

-- DVD���ã�� ���̺� ����
create table DVD_FAVORITE(
		   DF_Num number not null constraint DVD_FAVORITE_PK primary key,	-- DVD���ã�� ������
		   DVD_Num number not null,	-- DVD������(FK) DVD_NUM�� ����
		   MEM_Num number not null,	-- ȸ����ȣ(FK)
		   CONSTRAINT DF_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT DF_DVD_FK foreign key(DVD_Num) references DVD (DVD_Num) on delete cascade
);

-- �Խ��� ���� ���̺� ����
create table BOARD_TYPE(
			BT_Num number not null constraint BT_PK primary key,
			BT_Name varchar2(50) not null
);

INSERT INTO BOARD_TYPE values(1, '��������');
INSERT INTO BOARD_TYPE values(2, 'QNA');
INSERT INTO BOARD_TYPE values(3, 'FAQ');


-- BOARD ������ ����
create sequence BOARD_SEQ increment by 1 start with 1 nocache;

-- BOARD ���̺� ����
create table BOARD(
		   B_Num number not null constraint NOTICE_PK primary key,	-- NOTICE ������
		   MEM_Num number not null,	-- �ۼ���
		   BT_Num number not null,	-- �� ����
		   B_TITLE varchar2(100) not null,	-- ����
		   B_CONTENT varchar2(3000) not null,	-- ����
		   B_RDATE date not null,	-- �ۼ���
		   B_VIEW number,	-- ��ȸ��
		   B_TOP number not null,	-- ��ܰ�������
		   CONSTRAINT B_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
		   CONSTRAINT B_BT_FK foreign key(BT_Num) references BOARD_TYPE (BT_Num) on delete cascade
);

-- SEAT(������ �ڸ�) ������ ����
create sequence SEAT_SEQ increment by 1 start with 1 nocache;

-- SEAT(������ �ڸ�) ���̺� ����
create table SEAT(
         SEAT_Seq number not null constraint ROOM_PK primary key,   -- ROOM(������) ������
         F_Num number not null,   -- �ü���ȣ(FK)    
         Seat_Use varchar2(50),
         Seat_Num varchar2(50),
         CONSTRAINT SEAT_F_FK foreign key(F_Num) references FACILITY (F_Num) on delete cascade
);
INSERT INTO seat values(seat_seq.nextval, 6,'taken', 'A1');
-- RESERVATION(�����ǿ���) ������ ����
create sequence RESERVATION_SEQ increment by 1 start with 1 nocache;

-- RESERVATION(�����ǿ���) ���̺� ����
create table RESERVATION(
         RES_Num number not null constraint RESERVATION_PK primary key,   -- RESERVATION(�����ǿ���) ������
         MEM_Num number not null,   -- ȸ����ȣ(FK) 
         SEAT_Seq number not null,   -- �ڸ�������ȣ(FK)      
         RES_START date not null,   -- ������۽ð�
         RES_END date not null,   -- ��������ð�
         CONSTRAINT RESERVATION_MEM_FK foreign key(MEM_Num) references MEMBER (MEM_Num) on delete cascade,
         CONSTRAINT RESERVATION_SEAT_FK foreign key(SEAT_Seq) references SEAT (SEAT_Seq) on delete cascade
);
INSERT INTO reservation values(reservation_seq.nextval, 2,1, to_date('03/05/2000 12:10:17','MM-DD-YYYY HH24:MI:SS'),to_date('03/05/2000 16:10:17','MM-DD-YYYY HH24:MI:SS') );