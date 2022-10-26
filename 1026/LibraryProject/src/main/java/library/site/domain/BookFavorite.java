package library.site.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "BOOK_FAVORITE")
public class BookFavorite {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BF_SequenceGenerator")
	@SequenceGenerator(sequenceName = "BOOK_FAVORITE_SEQ", name = "BF_SequenceGenerator", allocationSize = 1)
	@Id	@Column(name="BF_NUM")
	private long bf_num;		
	@Column
	private long mem_num; //회원번호	
		
	@ManyToOne
	@JoinColumn(name="BOOK_NUM")
	private LibraryBook libraryBook;

}
