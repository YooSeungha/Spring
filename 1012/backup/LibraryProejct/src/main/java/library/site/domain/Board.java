package library.site.domain;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
	private long b_num;
	private long mem_num;
	private String b_title;
	private String b_content;
	private Date b_rdate;
	private long b_view;
}	

