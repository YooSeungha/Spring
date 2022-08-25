< Spring FileUpload >

(1) index.jsp 링크 
    <a href="file/form.do">파일폼</a><br/>

(2) soo.md.controller.FileController.java 
    @GetMapping("form.do")
	public String formFu() {
		return "file/form";
	}
	@PostMapping("upload.do")
	public String upload(@RequestParam String name, @RequestParam MultipartFile file) {
		//log.info("#file: " + file); //출력실패( pom.xml 셋팅이 안되었으므로 )
		return "";
	}

(3) file/form.jsp 
    
(4) xml 설정 
    1) pom.xml 
        <!-- commons-fileupload -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.2.1</version> 
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.5</version>
		</dependency>

    2) servlet-context.xml
	    <!-- 파일 업로드용 resolver -->
		<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
			<beans:property name="defaultEncoding" value="UTF-8" />
			<beans:property name="maxUploadSize" value="10485760" />
			<beans:property name="maxUploadSizePerFile" value="2097152"/>
			<beans:property name="maxInMemorySize" value="10485756"/>
		</beans:bean>
	    
(5) 서비스 
    - soo.md.service.FileUploadService.java
    - soo.md.service.FileUploadServiceImpl.java
	- soo.md.fileset.Path.java

(6) file/list.jsp 
    - FileController 계속 업데이트 

(7) 다운로드 
    1) soo.md.fileset.FileDownloadView.java 생성 
	2) FileController.java 연결 
	   return new ModelAndView("FileDownloadView객체", "downloadFile", file);
	3) servlet-context.xml
	   <!-- 파일 다운로드 -->
		<beans:bean id="fileDownloadView" class="soo.md.fileset.FileDownloadView" />
		<beans:bean id="fileViewResolver" class="org.springframework.web.servlet.view.BeanNameViewResolver">
			<beans:property name="order" value="0" />
		</beans:bean>
    
(8) file/form_mt.jsp
    - FileController 업데이트
    