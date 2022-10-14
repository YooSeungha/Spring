drop table MP_FILE;
drop sequence MP_FILE_SEQ;
purge recyclebin;


create sequence F_NUM_SEQ increment by 1 start with 1 nocache;

create table MP_FILE(
  F_NUM number NOT NULL constraint F_NUM_PK primary key,
  F_RNAME varchar2(300) NOT NULL,
  F_FNAME varchar2(300) NOT NULL,
  F_RDATE date,
  PB_NUM number,
  constraint PB_NUM_FK foreign key(PB_NUM) references PBOARD(PB_NUM)
);
