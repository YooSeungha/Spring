package soo.md.mapper;

import java.util.List;

import soo.md.domain.Board;

public interface BoardMapper {
	List<Board> list();
	void insert(Board board);
	void delete(long seq);
	void update(Board board);
}
