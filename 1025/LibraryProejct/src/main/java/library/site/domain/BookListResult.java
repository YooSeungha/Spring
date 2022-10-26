package library.site.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookListResult {
	private List<Book> items;
	private List<Book> popBook; //인기도서
	private List<Book> dvd; //dvd
	private List<Book> writerBook; //작가의 다른 작품
	private List<Book> catgoBook; //카테고리별 다른 작품
	private List<LibraryBook> bookList;//db에 있는 도서	
	private List<Facility> bookLoc; //db에있는 도서 위치
	private String keyword;
	private int cp;
	private int ps;
	private long totalCount;
	private long totalPageCount;
	private int startpaging;
	private int endpaging;
	private int sorted;
	private int qtype;
	
	public BookListResult(int cp, long totalCount, int ps, int sorted, List<Book> list) {
		this.cp = cp;
		this.totalCount = totalCount;
		this.ps = ps;
		this.items = list;
		this.totalPageCount = calTotalPageCount();
		this.sorted = sorted;
	}
	
	public BookListResult(int cp, long totalCount, int ps, List<LibraryBook>list) {
		this.cp = cp;
		this.totalCount = totalCount;
		this.ps = ps;
		this.totalPageCount = calTotalPageCount();
		this.bookList = list;
	}
	private long calTotalPageCount() {
		long tpc = totalCount/ps;
		if(totalCount%ps != 0) tpc++;
		return tpc;
	}
}
