package library.site.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import library.site.domain.Board;
import library.site.domain.BoardListResult;

public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	BoardListResult getBoardListResult(int cp, int ps, String catgo, String keyword);
	Board getBoard(long seq);
	
	void write(Board board);
	void edit(Board board);
	void remove(long seq);
	void review(long seq);
}
