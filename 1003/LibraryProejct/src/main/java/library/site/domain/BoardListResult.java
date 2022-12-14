package library.site.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BoardListResult {
	private List<Board> list;
	private int cp;
	private int ps;
	private long totalCount;
	private long totalPageCount;
	
	public BoardListResult(int cp, long totalCount, int ps, List<Board> list) {
		this.cp = cp;
		this.totalCount = totalCount;
		this.ps = ps;
		this.list = list;
		this.totalPageCount = calTotalPageCount();
	}
	private long calTotalPageCount() {
		long tpc = totalCount/ps;
		if(totalCount%ps != 0) tpc++;
		
		return tpc;
	}
}
