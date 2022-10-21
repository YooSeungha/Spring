package library.site.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "book_reviews_log")
public class BookReviewsLog {
	@Id
	private long brl_num;
	@Column
	private int brl_likecheck;
	@Column
	private int brl_hatecheck;
	@Column
	private Date brl_cdate;
	@Column
	private Date brl_udate;
	
	@ManyToOne
	@JoinColumn(name = "brs_num")
	private BookReviews bookReviews;
	
	@ManyToOne
	@JoinColumn(name = "mem_num")
	private Member member;
}
