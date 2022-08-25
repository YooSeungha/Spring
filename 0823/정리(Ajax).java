< Spring Ajax >


(1) soo.md.controller.AjaxIndexController.java 틀 생성 
    @GetMapping("test01.do")
	public String t01() {
		return "ajax/test01";
	}

(2) Mapper와 Service 갱신 
    1) soo.md.mapper.AddressAjaxMapper.xml
	2) soo.md.mapper.AddressAjaxMapper.java
	3) soo.md.service.AddressAjaxService.java
	4) soo.md.service.AddressAjaxServiceImpl.java

(3) Address @JsonFormat 
    public class Address {
		...
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
		private Date rdate;
	}

(4) Controller + View 
    1) soo.md.controller.AjaxT01Controller.java 
	   ajax/test01.jsp 

    
	2) soo.md.controller.AjaxT02Controller.java  
	   ajax/test02.jsp
	    
	   <!-- pom.xml for ajax -->
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-databind</artifactId>
		    <version>2.9.4</version>
		</dependency>
		<dependency>
		    <groupId>com.fasterxml.jackson.dataformat</groupId>
		    <artifactId>jackson-dataformat-xml</artifactId>
		    <version>2.9.6</version>
		</dependency>
		<dependency>
		    <groupId>com.google.code.gson</groupId>
		    <artifactId>gson</artifactId>
		    <version>2.8.2</version>
		</dependency>
		<!-- Append for ObjectMapper -->
		<dependency> 
			<groupId>org.codehaus.jackson</groupId> 
			<artifactId>jackson-core-lgpl</artifactId> 
			<version>1.9.11</version> 
		</dependency>	
		<dependency> 
			<groupId>org.codehaus.jackson</groupId> 
			<artifactId>jackson-mapper-asl</artifactId> 
			<version>1.9.11</version> 
		</dependency> 
	   

    3) soo.md.controller.AjaxT03Controller.java  
	   ajax/test03.jsp

	   cf)  호출시 .json 또는 .xml 

	4) soo.md.controller.AjaxT04Controller.java  
	   ajax/test04.jsp

	   cf)  호출시 .json 또는 .xml 
     


