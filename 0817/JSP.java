< JSP & EL & Session >

1. JSP 
	(1) �������	
		1) JSP elements 
			<1> ���þ� 
				<%@ %>

			<2> ��ũ���� �������� 
				<%%>
				<%=%>
				<%!%>

			<3> JSP �׼�(ǥ���±�)
				<jsp:XXX />

		2) Fixed Template Data ( HTML )

	(2) ����Ʈ ��ü(9����)
		1) ���� 
			JSP�������� ��ü�� ���������ʰ� <%%> or <%=%> ���� ����� �� �ִ� ��ü

		2) ���� 
			<1> out ( JspWriter )

			<2> response ( HttpServletResponse )

			<3> request ( HttpServletRequest )

			<4> session ( HttpSession )

			<5> application ( ServletContext )

			<6> page ( Object )

			<7> pageContext ( PageContext )

			<8> config ( ServletConfig )

				����) web.xml 
				<servlet>
				  <servlet-name>servletEx</servlet-name>
				  <jsp-file>/jspEx.jsp</jsp-file>
				  <init-param>
					  <param-name>adminId</param-name>
					  <param-value>admin</param-value>
				  </init-param>
				</servlet>

				���) jspEx.jsp
				<%
					String adminId = config.getInitParameter("adminId");
				%>

			<9> exception  ( Throwable ) 


2. EL ( Expression Language )
	(1) ��� ${}  
	(2) ���
		1) ��ü�� �Ӽ���
		2) �迭�� �� 
		3) List �� 
		4) Map �� 

	(3) EL�� ����Ʈ ��ü�� (11��)
		1) param 
		   paramValues

		2) header
		   headerValues 

		3) pageContext : 'EL���� JSP�� ����Ʈ��ü ���ٽ� ���'

		4) pageScope
		   requestScope 
		   sessionScope
		   applicationScope 

		5) cookie 

		6) initParam : 'ServletContext�� ���� initParam ����'
		  
		   
		  ����) web.xml 
		  <context-param>
			 <param-name>siteName</param-name>
			 <param-value>Soo Site</param-value>
		  </context-param>

		  ���) jsp 
		  ${initParam.siteName}

	(4) EL������ 
		 1) ��� 
			ex) +, -, *, / �� div, %�� mod

			cf1) /�� div ���� 0���� ���� �� ���� ( Infinity ) 
			cf2) %�� mod ���� 0���� ���� �� ���� ( ���� ) 

		 2) �� 
			ex) &&�� and , ||�� or, !�� not 

		 3) ���� 
			ex) ==�� eq, !=�� ne, <�� lt, >�� gt, <=�� le, >=�� ge 

		 4) empty : ����ְų� null �� ��� true ���� 

			cf1) jsp�� ����(���/����)�� EL���� �ν����� ���� 
			cf2) ���� ���� ���� ����/��(null)�� ��� ǥ��ó�� 
				- case1) ����ó�� (ex: ${str} )
				- case2) 0���� ó�� (ex: ${str+10} )
				- case3) false ó�� (ex: ${true and str} )
			
	(5) EL Function 


3. Session �� Cookie 
	(1) ����
	   1) ���� : HTTP ���������� ������(stateless)��������
			   �̱⶧���� ���¸� ������ �� ����.
			   '����'�̶�� ����� �� ���� ������ ������ �� �ֵ��� 
			   ������� "���"�̴�.

			   ex) ���θ��� ��ٱ���, �α���, ...
				 
	   2) ���� : Ŭ���̾�Ʈ�� 'ù��° ��û'�� ���ؼ� ������ 
			   �޸𸮿��� JSessionId��� ID�� �ش� Ŭ���̾�Ʈ�� 
			   ���� ��(����)�� ���������, ù��° �亯���� �� 
			   JSessionId�� '��Ű' ���·� Ŭ���̾�Ʈ���� �����Ѵ�.

			   ���� ��û���ʹ� Ŭ���̾�Ʈ�� JSessionId�� ������ 
			   �������� ��û�����ν� ������ �� Ŭ���̾�Ʈ�� �ĺ� 
			   �� �� �ְ�, �� Ŭ���̾�Ʈ�� ���� ������ �� �ְ� �Ѵ�.
			   ����, �� �濡 �ִ� ��ü(���Ǻ�����==���ǼӼ���)���
			   ���������� ���� �� �� �ִ� ���̴�.

		3) ����
			 ���� ���������� �ϳ��� Ŭ���̾�Ʈ�� �������� ���ؼ�
			 WebApplication(Context)���� JSessionId�� ���� �����ȴ�.
			 ex) Tomcat ���� 

	(2) ��Ű
		1) ��    �� : Ŭ���̾�Ʈ���� ����Ǵ� ������ ����(�ν�����)
		2) ���� ũ�� : 4KB ���� ����/�� 
		3) ���� ���� : 300 ��
		4) �ִ�� ���� ������ ��Ű�� �뷮 : 1.2 MB
		5) ��    �� 
		   <1> Ŭ���̾�Ʈ�� �ϵ� ��ũ�� ����Ǵ� ��Ű(����)
		   <2> Ŭ���̾�Ʈ�� �޸𸮿� �����ϴ� ��Ű 
			  ( �������� ������ ���� �������� ���� )
			  1> JSessionID
			  2> setMaxAge(0 || ����) -> (MaxAge �⺻�� -1)
	   6) ��   �� 
		   <1> �ѱ��� ���� �ȵȴ�.
		   <2> MaxAge �� ������ ��, �ϵ��� ���Ͽ��� �������� ������
			   MaxAge�� ���� Cookie�� ������� �ʴ´�.