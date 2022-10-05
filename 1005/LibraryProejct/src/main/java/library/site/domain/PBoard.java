package library.site.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PBoard {
	private long pb_num;
	private long mem_num;
	private String pb_title;
	private String pb_content;
	private long pb_view;
	private long pb_top;
	
	private String pb_fname;
	private String pb_rname;
	private MultipartFile uploadFile; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date Pb_rdate;
	
}
