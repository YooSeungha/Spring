package library.site.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChartDTO {
	private String item;
	private long number;
	
	@Override
	public String toString() {
		return "#ChartDTO item: " + item + ", number: " + number;
	}
}
