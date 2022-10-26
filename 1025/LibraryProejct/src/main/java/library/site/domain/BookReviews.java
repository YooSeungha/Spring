package library.site.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "book_reviews")
public class BookReviews {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long brs_num;
	@Column
	private String brs_content;

	@Column
	private int brs_rating;
	@Column
	private int brs_like;
	@Column
	private int brs_hate;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss", timezone="Asia/Seoul")
	private Date brs_cdate;
	@Column
	private Date brs_update;
	
	@ManyToOne
	@JoinColumn(name = "book_num")
	private LibraryBook book;
	
	@ManyToOne
	@JoinColumn(name = "mem_num")
	private Member member;
	
}
