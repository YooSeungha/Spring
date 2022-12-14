< Spring Address >

1. Sp02 생성 ( Sp01 복사해서 )
   (1) 패기지 생성( soo.md.controller ) 후 등록 
       servlet-context.xml의 <context:component-scan base-package="soo.md.controller" />

   (2) soo.md.controller 수정 
       pom.xml, log4j.xml

2. views하위 틀생성 
   (1) index.jsp 
   (2) address 폴더생성
   
3. Model 
   (1) DB테이블 생성 
       - 관리자계정에서 address.sql 실행 

   (2) DAO(AddressMapper) 생성
       1) DS 설정 
	      <1> web.xml 
		     <listener>
			    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		     </listener>
			    위 기존코드의 아래에.. 
	
	
		     <filter>
				 <filter-name>encoding</filter-name>
				 <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
				 <init-param>
					  <param-name>encoding</param-name>
					  <param-value>UTF-8</param-value>
				 </init-param>
			  </filter>
			
			  <filter-mapping>
				  <filter-name>encoding</filter-name>
				  <servlet-name>appServlet</servlet-name>
			  </filter-mapping>

	      <2> pom.xml 
            <dependency>
				<groupId>com.oracle.ojdbc</groupId>
				<artifactId>ojdbc8</artifactId>
				<version>19.3.0.0</version>
			</dependency>
			<dependency>
				<groupId>com.oracle.ojdbc</groupId>
				<artifactId>orai18n</artifactId>
				<version>19.3.0.0</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-jdbc</artifactId>
				<version>${org.springframework-version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-tx</artifactId>
				<version>${org.springframework-version}</version>
			</dependency>
			<dependency>
				<groupId>com.zaxxer</groupId>
				<artifactId>HikariCP</artifactId>
				<version>2.7.8</version>
			</dependency>		     

	      <3> root-context.xml
		    <bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
				<property name="driverClassName"
					value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
				<property name="jdbcUrl"
					value="jdbc:log4jdbc:oracle:thin:@localhost:1521:JAVA"></property>
				<property name="username" value="spring"></property>
				<property name="password" value="java"></property>
			</bean>
			<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource"
				destroy-method="close">
				<constructor-arg ref="hikariConfig" />
			</bean>	

       2) JDBC 로그 설정
	      <1> pom.xml 
		    <dependency>
				<groupId>org.bgee.log4jdbc-log4j2</groupId>
				<artifactId>log4jdbc-log4j2-jdbc4</artifactId>
				<version>1.16</version>
			</dependency> 
			
	      <2> src/main/resources/log4jdbc.log4j2.properties
		     log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator

	   3) myBatis 설정 
	      <1> pom.xml
		    <dependency>
				<groupId>org.mybatis</groupId>
				<artifactId>mybatis</artifactId>
				<version>3.4.6</version>
			</dependency>
			<dependency>
				<groupId>org.mybatis</groupId>
				<artifactId>mybatis-spring</artifactId>
				<version>1.3.2</version>
			</dependency>

	      <2> root-context.xml
		    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				<property name="dataSource" ref="dataSource"></property>
				<property name="configLocation"
					 value="classpath:/mybatis-config.xml"/>
			</bean>

		  <3> src/main/resources/mybatis-config.xml
		    <?xml version="1.0" encoding="UTF-8"?>
			<!DOCTYPE configuration
			  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
			  "http://mybatis.org/dtd/mybatis-3-config.dtd">
			<configuration>
				<typeAliases>
					<typeAlias alias="Address" type="soo.md.domain.Address"/>
				</typeAliases>
				<mappers>
					 <mapper resource="soo/md/mapper/AddressMapper.xml"/>
				</mappers>
			</configuration>

          <4> soo.md.domain.Address.java 
		    @Data
			@NoArgsConstructor
			@AllArgsConstructor
			public class Address {
				private long seq;
				private String name;
				private String addr;
				private Date rdate;
			}

		  <5> soo/md/mapper/AddressMapper.xml
		    <?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE mapper
			  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
			  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
			<mapper namespace="soo.md.mapper.AddressMapper">
				<select id="list" resultType="Address">
					select * from ADDRESS order by SEQ desc
				</select>
				<insert id="insert" parameterType="Address">
					 insert into ADDRESS values(ADDRESS_SEQ.nextval, #{name}, #{addr}, SYSDATE)
				</insert>
				<delete id="delete" parameterType="long">
					 delete from ADDRESS where SEQ=#{seq}
				</delete>
			</mapper>

		  <6> soo.md.mapper.AddressMapper.java 
		     public interface AddressMapper {
				List<Address> list();
				void insert(Address address);
				void delete(long seq);
			 }

		  <7> root-context.xml
		     <mybatis-spring:scan base-package="soo.md.mapper"/>
			 <context:component-scan base-package="soo.md.mapper"/>
		     
		   
		    Tip1) DAO의 클래스위에 @Repository 해줘야 Spring객체로 등록 
            Tip2) JUnit(단위) 테스트 
			   1> pom.xml에서 다음을 확인!
				   <dependency>
						<groupId>junit</groupId>
						<artifactId>junit</artifactId>
						<version>4.12</version>
				  </dependency>
			   2> src/test/java/soo.md.persistence.DataSourceTests.java 
			   3> src/test/java/soo.md.mapper.AddressMapperTests.java


4. Service ( AddressSerivce ) 생성 
   (1) 인터페이스( soo.md.service.AddressSerivce.java ) 생성  
       public interface AddressSerivce {
			List<Address> listS();
			void insertS(Address address);
			void deleteS(long seq);
	   }

   (2) 구현클래스( soo.md.service.AddressSerivceImpl.java ) 생성  
       @Service
       public class AddressSerivceImpl implements AddressSerivce {
       }

   (3) root-context.xml
       <context:component-scan base-package="soo.md.service"/>

   (4) JUnit 테스트 
       soo.md.service.AddressSerivceTests.java 

5. Controller ( AddressController ) 생성
   (1) soo.md.controller.AddressController.java 
		@Controller
		@RequestMapping("/address")
		public class AddressController {
			@Autowired
			private AddressSerivce addressService;
        } 

		또는

		@AllArgsConstructor 
		@Controller
		@RequestMapping("/address")
		public class AddressController {
			private AddressSerivce addressService; //Spring 4.3~: AutoInjection ( with @AllArgsConstructor )
        } 

    (2) servlet-context.xml 추가 
	    <context:component-scan base-package="soo.md.controller" />

6. View ( *.jsp ) 
    1) list.jsp 
	2) write.jsp 
     
	  cf) servlet-context.xml 추가 
	    <resources mapping="/js/**" location="/resources/js/" />



cf) 오라클의 드라이버(ojdbc.jar)에서 지원하지않는 문자셋을 지원하게 하는 방법
	(1) 에러 메세지 
		Request processing failed; 
		nested exception is org.springframework.jdbc.UncategorizedSQLException: 
		Error attempting to get column 'SEQ' from result set. Cause: java.sql.SQLException: 
		지원되지 않는 문자 집합(클래스 경로에 orai18n.jar 추가): KO16MSWIN949

	(2) 해결 방법 
		1) pom..xml 에 다음을 추가
			<!-- https://mvnrepository.com/artifact/com.oracle.database.nls/orai18n -->
			<dependency>
				<groupId>com.oracle.database.nls</groupId>
				<artifactId>orai18n</artifactId>
				<version>11.2.0.4</version>
			</dependency>
	  
		 2) Tomcat9/context.xml 에 다음을 추가 ( tomcat실행시 warning 메세지 줄이는 효과 )
			<WatchedResource>WEB-INF/web.xml</WatchedResource>
			..
			<JarScanner scanManifest="false"/>

		 3) Tomcat restart!
