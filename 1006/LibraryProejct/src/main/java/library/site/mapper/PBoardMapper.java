package library.site.mapper;

import java.util.List;
import library.site.domain.Board;
import library.site.domain.BoardVo;
import library.site.domain.PBoard;
import library.site.domain.PBoardVo;

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
}
