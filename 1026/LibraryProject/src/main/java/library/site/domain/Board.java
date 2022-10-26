package library.site.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BOARD")
public class Board {
	@Id
	@Column(name = "B_NUM")
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

	@ManyToOne
	@JoinColumn(name = "MEM_NUM")
	private Member member;
}
