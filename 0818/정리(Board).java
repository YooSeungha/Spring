< Spring Board >

1. Model 
   (1) board.sql 실행 
   (2) mybatis-config.xml
        <typeAlias alias="Board" type="soo.md.domain.Board"/>
		<typeAlias alias="BoardVo" type="soo.md.domain.BoardVo"/> 
   (3) BoardMapper.xml 틀 생성 
   (4) soo.md.domain 하위에 생성 
        - Board.java 
		- BoardVo.java 
   (5) BoardMapper.xml 구현 
       참고) mybatis xml의 SQL에 '<>','&','||'등의 특수문자가 있으면.. CDATE섹션 안에 기술해줘야 함 
   (6) soo.md.mapper.BoardMapper.java 

   (7) Service구현 
        - soo.md.service.BoardService.java
        - soo.md.service.BoardServiceImpl.java
		- soo.md.domain.BoardListResult.java 

2. Controller 
   - BoardController.java 

3. View 