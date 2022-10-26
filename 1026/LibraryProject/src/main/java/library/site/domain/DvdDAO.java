package library.site.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="DVD")
public class DvdDAO {
	@Id @Column(name="DVD_NUM")
	private int dvd_num;
	@Column
	private int f_num;
	@Column
	private String dvd_title;
	@Column
	private String dvd_content;
	@Column
	private String dvd_director;
	@Column
	private String dvd_img;
	@Column
	private Date dvd_rdate;
}
