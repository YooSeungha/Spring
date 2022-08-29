AOP(Aspect Oriented Programming 관점지향프로그래밍)
- 종적관심( Core concern )
- 횡적관심( Cross-cutting concern : 공통관심사항 ) 

(1) Logging with Advice

  1) pom.xml
    <dependency>
		<groupId>org.aspectj</groupId>
		<artifactId>aspectjrt</artifactId>
		<version>${org.aspectj-version}</version>
    </dependency>
    <dependency>
		<groupId>org.aspectj</groupId>
		<artifactId>aspectjweaver</artifactId>
		<version>${org.aspectj-version}</version>
    </dependency> 

   2) Java 
     soo.md.service.SampleLogService.java
     soo.md.service.SampleLogServiceImpl.java
     soo.md.aop.SampleLogAdvice.java

   3) root-context.xml
     <context:annotation-config></context:annotation-config>
	 <context:component-scan base-package="soo.md.aop"/>
	 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>

   4) jUnit 
     soo.md.service.SampleLogServiceTests.java 


(2) Transaction ( @Transactional )
   1) pom.xml 확인 
      <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>${org.springframework-version}</version>
	  </dependency>

   2) DB Table 생성 
      create table tbl_sample1(col1 varchar2(500));
      create table tbl_sample2(col2 varchar2(20));

   3) Java
      soo.md.mapper.TxSample1Mapper.java
	  soo.md.mapper.TxSample2Mapper.java
	  soo.md.service.TxSampleService.java
	  soo.md.service.TxSampleServiceImpl.java

   4) root-context.xml
      <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"/>
	  </bean>
	  <tx:annotation-driven/>

   5) jUnit
      soo.md.service.TxSampleServiceTests.java 



