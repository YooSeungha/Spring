package library.site.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seat {
	private long seat_seq;
	private long f_num = 9;
	private String seat_use = "taken";
	private String seat_num;
}
