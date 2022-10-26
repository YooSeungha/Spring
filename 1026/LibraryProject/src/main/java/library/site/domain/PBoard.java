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
	private String sort;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date pb_rdate;

	
	private long next;
	private long last;
	private String nexttitle;
	private String lasttitle;
	private List<PBoard> notice;
	private List<PBoard> newlist;
}
