package library.site.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="RENTAL")
public class RentalBook {
	@Id
	private long ren_num;	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date ren_borrow;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date ren_return;
	@Column
	private long ren_stat;
	@ManyToOne
	@JoinColumn(name = "MEM_NUM")
	private Member member;
	@ManyToOne
	@JoinColumn(name = "BOOK_NUM")
	private LibraryBook book;
}
