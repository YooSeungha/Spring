package library.site.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import library.site.domain.PBoard;
import library.site.domain.PBoardListResult;
import library.site.domain.PagingVO;

public interface PBoardService {
	PBoardListResult getPBoardListResult(int cp, int ps);
	PBoardListResult getPBoardListResult(int cp, int ps, String catgo, String keyword);
	PBoard getPBoard(long pb_num);
	
	void write(PBoard pboard);
	void edit(PBoard pboard);
	void remove(long pb_num);
	void review(long pb_num);
	
	//게시물 총 갯수
	public int countBoard();
	
	//페이징 처리 게시글 조회
	public List<PBoard> selectBoard(PagingVO vo);
}
