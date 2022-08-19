package soo.md.service;

import java.util.List;
import soo.md.domain.Board;

public interface BoardService {
	List<Board> listS();
	void insertS(Board board);
	void deleteS(long seq);
	void updateS(Board board);
}