package soo.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChartDTO {
	private String item;
	private int number;
	
	@Override
	public String toString() {
		return "#ChartDTO itme: "+ item +", number"+ number;
		
	}
}
