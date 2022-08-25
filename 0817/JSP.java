< JSP & EL & Session >

1. JSP 
	(1) 구성요소	
		1) JSP elements 
			<1> 지시어 
				<%@ %>

			<2> 스크립팅 엘리먼츠 
				<%%>
				<%=%>
				<%!%>

			<3> JSP 액션(표준태그)
				<jsp:XXX />

		2) Fixed Template Data ( HTML )

	(2) 디폴트 객체(9가지)
		1) 설명 
			JSP문서에서 객체를 생성하지않고도 <%%> or <%=%> 에서 사용할 수 있는 객체

		2) 종류 
			<1> out ( JspWriter )

			<2> response ( HttpServletResponse )

			<3> request ( HttpServletRequest )

			<4> session ( HttpSession )

			<5> application ( ServletContext )

			<6> page ( Object )

			<7> pageContext ( PageContext )

			<8> config ( ServletConfig )

				정의) web.xml 
				<servlet>
				  <servlet-name>servletEx</servlet-name>
				  <jsp-file>/jspEx.jsp</jsp-file>
				  <init-param>
					  <param-name>adminId</param-name>
					  <param-value>admin</param-value>
				  </init-param>
				</servlet>

				사용) jspEx.jsp
				<%
					String adminId = config.getInitParameter("adminId");
				%>

			<9> exception  ( Throwable ) 


2. EL ( Expression Language )
	(1) 모양 ${}  
	(2) 기능
		1) 객체의 속성값
		2) 배열의 값 
		3) List 값 
		4) Map 값 

	(3) EL의 디폴트 객체들 (11개)
		1) param 
		   paramValues

		2) header
		   headerValues 

		3) pageContext : 'EL에서 JSP의 디폴트객체 접근시 사용'

		4) pageScope
		   requestScope 
		   sessionScope
		   applicationScope 

		5) cookie 

		6) initParam : 'ServletContext에 대한 initParam 참조'
		  
		   
		  정의) web.xml 
		  <context-param>
			 <param-name>siteName</param-name>
			 <param-value>Soo Site</param-value>
		  </context-param>

		  사용) jsp 
		  ${initParam.siteName}

	(4) EL연산자 
		 1) 산술 
			ex) +, -, *, / 와 div, %와 mod

			cf1) /와 div 사용시 0으로 나눌 수 있음 ( Infinity ) 
			cf2) %와 mod 사용시 0으로 나눌 수 있음 ( 오류 ) 

		 2) 논리 
			ex) &&와 and , ||와 or, !와 not 

		 3) 관계 
			ex) ==와 eq, !=와 ne, <와 lt, >와 gt, <=와 le, >=와 ge 

		 4) empty : 비어있거나 null 일 경우 true 리턴 

			cf1) jsp의 변수(멤버/지역)는 EL에서 인식하지 못함 
			cf2) 정의 되지 않은 변수/값(null)일 경우 표현처리 
				- case1) 공백처리 (ex: ${str} )
				- case2) 0으로 처리 (ex: ${str+10} )
				- case3) false 처리 (ex: ${true and str} )
			
	(5) EL Function 


3. Session 과 Cookie 
	(1) 세션
	   1) 설명 : HTTP 프로토콜은 무상태(stateless)프로토콜
			   이기때문에 상태를 유지할 수 없다.
			   '세션'이라는 기술은 그 상태 정보를 유지할 수 있도록 
			   만들어진 "기술"이다.

			   ex) 쇼핑몰의 장바구니, 로그인, ...
				 
	   2) 원리 : 클라이언트의 '첫번째 요청'에 의해서 서버측 
			   메모리에는 JSessionId라는 ID로 해당 클라이언트를 
			   위한 방(공간)이 만들어지고, 첫번째 답변으로 그 
			   JSessionId를 '쿠키' 형태로 클라이언트에게 전달한다.

			   다음 요청부터는 클라이언트가 JSessionId을 가지고 
			   서버에게 요청함으로써 서버는 그 클라이언트를 식별 
			   할 수 있고, 그 클라이언트의 방을 공유할 수 있게 한다.
			   따라서, 그 방에 있는 객체(세션변수값==세션속성값)들로
			   상태정보를 유지 할 수 있는 것이다.

		3) 주의
			 같은 서버에서는 하나의 클라이언트의 브라우져에 대해서
			 WebApplication(Context)마다 JSessionId가 따로 생성된다.
			 ex) Tomcat 서버 

	(2) 쿠키
		1) 설    명 : 클라이언트측에 저장되는 서버측 정보(부스러기)
		2) 제한 크기 : 4KB 이하 제한/개 
		3) 제한 갯수 : 300 개
		4) 최대로 저장 가능한 쿠키의 용량 : 1.2 MB
		5) 종    류 
		   <1> 클라이언트의 하드 디스크에 저장되는 쿠키(파일)
		   <2> 클라이언트의 메모리에 존재하는 쿠키 
			  ( 브라우져가 열려져 있을 때까지만 존재 )
			  1> JSessionID
			  2> setMaxAge(0 || 음수) -> (MaxAge 기본값 -1)
	   6) 주   의 
		   <1> 한글이 지원 안된다.
		   <2> MaxAge 가 지났을 때, 하드의 파일에는 지워지지 않지만
			   MaxAge가 지난 Cookie는 검출되지 않는다.