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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="REVIEW")
public class ReviewJPA {
	@Id @Column(name="NUM")
	private long num;
	@Column
	private long seq;
	@Column
	private String content;
	@Column
	private String writer;
	@Column
	private Date regdate;
	@Column
	private Date update_regdate;
	
}
