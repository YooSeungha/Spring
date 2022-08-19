package soo.md.service;

import soo.md.domain.Board;
import soo.md.domain.BoardListResult;

public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	Board selectBySeqS(long seq);

	void insertS(Board board);
	void updateS(Board board);
	void deleteS(long seq);
}
