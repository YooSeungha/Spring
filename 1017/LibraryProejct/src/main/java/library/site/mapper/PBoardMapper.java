package library.site.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import library.site.domain.Board;
import library.site.domain.BoardVo;
import library.site.domain.PBoard;
import library.site.domain.PBoardVo;
import library.site.domain.uploadFile;

public interface PBoardMapper {
	List<PBoard> selectPerPage(PBoardVo pboardVo);
	PBoard selectBySeq(long pb_num);
	long selectCount();
	
	void insert(PBoard pboard);
	void update(PBoard pboard);
	void delete(long pb_num);
	void review(long pb_num);
	
	List<PBoard> selectPerPageByCatgo(PBoardVo pboardvo);
	long selectCountByCatgo(PBoardVo pboardvo);
	
	long descView();
	long descDate();
	
	public PBoard movePage(long pb_num);
	void uploadFile(HashMap<String, Object> hm);
	List<uploadFile> fileList(long pb_num);
	
	void deleteFile(long pb_num);
	void delFile(long f_num);
	void updateFile(HashMap<String, Object> hm);
	List<PBoard> notice();
}
