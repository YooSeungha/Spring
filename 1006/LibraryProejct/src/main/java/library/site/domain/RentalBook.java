package library.site.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalBook {
	private long ren_num;
	private long mem_num;
	private long book_num;
	private Date ren_borrow;
	private Date ren_return;
}
