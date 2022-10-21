package library.site.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="BOOK_REQUEST")
public class BookRequestDAO {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGeneratorName")
	@SequenceGenerator(sequenceName = "BOOK_REQUEST_SEQ", name = "SequenceGeneratorName", allocationSize = 1)	
	@Id @Column(name="BR_NUM")
	private long br_num;
	private long mem_num;
	private String br_title;
	private String br_writer;
	private String br_isbn;
	private long br_stat;
}
