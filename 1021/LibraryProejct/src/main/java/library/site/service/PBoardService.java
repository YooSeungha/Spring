package library.site.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import library.site.domain.PBoard;
import library.site.domain.PBoardListResult;
import library.site.domain.uploadFile;

public interface PBoardService {
	PBoardListResult getPBoardListResult(int cp, int ps);
	PBoardListResult getPBoardListResult(int cp, int ps, String catgo, String keyword);
	PBoard getPBoard(long pb_num);
	
	void write(PBoard pboard);
	void edit(PBoard pboard);
	void remove(long pb_num);
	void review(long pb_num);
	
	public PBoard movePage(long pb_num);
	void fileUpload(String f_rname, String f_fname);
	List<uploadFile> getfileList(long pb_num);
	
	void deleteFile(long pb_num);
	void delFile(long f_num);
	void fileUpdate(String f_rname, String f_fname, long pb_num);
	List<PBoard> notice();
}	
