package library.site.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
	private long res_num;
	private long mem_num;
	private long seat_seq;
	private String res_start;
	private String res_end;
}
