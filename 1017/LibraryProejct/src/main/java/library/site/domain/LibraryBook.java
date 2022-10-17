package library.site.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "BOOK")
public class LibraryBook {
	@Id	@Column(name="BOOK_NUM")
	private long book_num;
	@Column
	private long book_code; //장르번호
	@Column
	private long f_num; //위치번호
	@Column
	private String book_title;
	@Column
	private String book_writer;
	@Column
	private String book_publisher;
	@Column
	private String book_isbn;
	@Column
	private String book_recomend;
	@Column
	private int book_count;
	@Column
	private String book_img;

	
	public void update(String book_title, String book_writer, String book_publisher,
			String book_isbn, String book_recomend, String book_img, long book_code,
			long f_num, int book_count) {
        this.book_title = book_title;
        this.book_writer = book_writer;
        this.book_publisher = book_publisher;
        this.book_isbn = book_isbn;
        this.book_recomend = book_recomend;
        this.book_img = book_img;
        this.book_code = book_code;
        this.f_num = f_num;
        this.book_count = book_count;
    }
}
