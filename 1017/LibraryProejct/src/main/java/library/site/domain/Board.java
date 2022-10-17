package library.site.domain;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="BOARD")
public class Board{	
	@Id
	private long b_num;
	@Column
	private long mem_num;
	@Column
	private String b_title;
	@Column
	private String b_content;
	@Column
	private Date b_rdate;
	@Column
	private long b_view;
}	

