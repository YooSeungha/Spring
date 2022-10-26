package library.site.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class uploadFile {
	private long f_num;
	private String f_rname;
	private String f_fname;
	private long pb_num;
}
