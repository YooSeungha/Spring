package library.site.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import library.site.domain.Board;
import library.site.domain.BoardListResult;

public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	BoardListResult getBoardListResult(int cp, int ps, String catgo, String keyword);
	Board getBoard(long pb_num);
	
	void write(Board board);
	void edit(Board board);
	void remove(long pb_num);
	void review(long pb_num);
}
