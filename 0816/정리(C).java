< ���� for ��ȣ >

1. JDK ����Ȯ�� 
	$> java -version 

2. STS���� 
	(1) spring-tool-suite-3.9.11.RELEASE-e4.14.0-win32-x86_64.zip �������� 
	(2) C:\SOO\Spring\sts-bundle �̵� 
	(3) STS.ini
		-vm
		C:\Program Files\Java\jdk1.8.0_221\bin\javaw.exe
	(4) STS.exe ����
	(5) C:\SOO\Spring\sts-bundle\workspace �߰� 

3. ������Ʈ ���� 
	(1) Spring Legacy Project -> Project name: Sp01 -> Spring MVC Project ���� 
	(2) ��Ű������: soo.ct.controller

4. STS���� JDK���� ���� 
	(1) Window -> Preferences -> Java -> Compiler -> JDK Compliance -> 1.8 
	(2) Properties for Sp01 ( Sp01 -> �����ʸ��콺 -> Properties )
		<1> Java Build Path -> Libraries -> JRE System Library -> 1.8 
		<2> Project Facets -> Java -> 1.8 

5. UTF-8 ���ڵ� ���� ( Window -> Preferences -> Web )
	(1) CSS
	(2) HTML 
	(3) JSP 

6. Maven Setting ( pom.xml )

   (1) ����
		<java-version>1.8</java-version>  
		<org.springframework-version>5.0.7.RELEASE</org.springframework-version>
		..
   (2) �߰� 
	   1) ����
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>
	   2) ���� 
		 <dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		 </dependency> 

	   3) ���� 
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-test</artifactId>
		    <version>${org.springframework-version}</version>
		    <!-- <scope>test</scope> --> 
		</dependency>
	   4) ���� 
		  <dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>
	   5) lombok �߰� ( lombok.jar -> ����: (java -jar lombok.jar -> STS.exe ����)  )
		<dependency>
		    <groupId>org.projectlombok</groupId>
		    <artifactId>lombok</artifactId>
		    <version>1.18.8</version>
		    <scope>provided</scope>
		</dependency>
		
7. ContextLoaderListener ���� �ذ� 
	(1) ���� �޼��� 
	     java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener

	(2) �ذ� ���
		Properties for Sp01 ( Sp01 -> �����ʸ��콺 -> Properties ) ���� 
		Deployment Assembly -> Add��ư -> java build path entries -> Next��ư -> Maven Dependencies �߰�

8. ���ϼ����� ���� 
	(1) Servers�� -> �����ʸ��콺 -> New -> Server -> tomcat9���� -> tomcat9��� ���� 
    (2) ������ tomcat9 ����Ŭ�� -> Modules�� -> edit��ư -> Path : /

9. Controller 
	(1) �ε��� ���� 
		- soo.ct.controller.IndexController ���� 
		- index.jsp 
	(2) ��Ʈ�ѷ� ���� 
		- TestController ���� 
		- index.jsp ��ũ + TestController �޼ҵ� �߰� ( 12�� ) 

		cf) log.info()�� �ν� ���� �� -> ����� 

10. Chrome Ȯ���
	'Talend API Tester'
