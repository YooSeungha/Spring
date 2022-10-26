package library.site.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
	private long num;
	private long seq;
	private String content;
	private String writer;
	private Date regdate;
	private Date update_regdate;
	
	private long startRow =0;
	private long endRow=5;
}	

