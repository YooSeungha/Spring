package library.site.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
	private int cp = 1;
	private int ps = 5;
	
	public int getStartRow() {
		return (cp-1)*ps;
	}
	public int getEndRow() {
		return cp*ps;
		
	}
	public BoardVo(int cp, int ps) {
		this.cp = cp;
		this.ps = ps;
	}
	
	String catgo;
	String keyword;
	public String getCatgo(){
		return catgo;
	}
	public String getKeyword() {
		return keyword;
	}
}
