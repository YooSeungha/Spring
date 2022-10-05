package library.site.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import library.site.domain.PBoard;
import library.site.domain.PBoardListResult;

public interface PBoardService {
	PBoardListResult getPBoardListResult(int cp, int ps);
	PBoardListResult getPBoardListResult(int cp, int ps, String catgo, String keyword);
	PBoard getPBoard(long pb_num);
	
	void write(PBoard pboard);
	void edit(PBoard pboard);
	void remove(long pb_num);
	void review(long pb_num);
}
