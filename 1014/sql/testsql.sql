< 게시판 테이블>
drop table PBOARD;
drop sequence PBOARD_SEQ;
purge recyclebin;

create table PBOARD(
   PB_NUM number constraint PBOARD_PK primary key, 
   MEM_NUM number, 
   PB_TITLE varchar2(100), 
   PB_CONTENT varchar2(1000), 
   PB_VIEW number,
   PB_TOP number,
   PB_RDATE date
); 
create sequence PBOARD_SEQ increment by 1 start with 1 nocache;
CONSTRAINT PB_MEM_FK FOREIGN KEY(MEM_NUM) REFERENCES MEMBER(MEM_NUM);

insert into PBOARD values(PBOARD_SEQ.nextval, '1', '제목1', '내용1', null,null, SYSDATE);


insert into pboard(seq, writer, subject, content, review, rdate)
select pboard_seq.nextval, writer, subject, content,  review, rdate from pboard;



<property name="jdbcUrl"
value="jdbc:log4jdbc:oracle:thin:@192.168.0.125:1521:JAVA"></property>
<property name="username" value="team4"></property>
<property name="password" value="team4"></property>
