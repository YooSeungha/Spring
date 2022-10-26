package library.site.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatTime {
	private long time_seq;
	private long seat_seq;
	private String seat_time;
	private String before_time;
	private String seat_time_use;
}
