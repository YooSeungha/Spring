package library.site.service;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import library.site.domain.PBoard;
import library.site.domain.PBoardListResult;
import library.site.domain.PBoardVo;
import library.site.domain.uploadFile;
import library.site.mapper.PBoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@AllArgsConstructor
@Service
public class PBoardServiceImpl implements PBoardService {
	
	@Autowired
	private PBoardMapper pboardMapper;
	
	
	@Override
	public PBoardListResult getPBoardListResult(int cp, int ps) {
		PBoardVo pboardVO = new PBoardVo(cp, ps);
		long totalCount = pboardMapper.selectCount();
		List<PBoard> list = pboardMapper.selectPerPage(pboardVO);
		
		return new PBoardListResult(cp, totalCount, ps, list);
	}

	@Override
	public PBoardListResult getPBoardListResult(int cp, int ps, String catgo, String keyword) {
		PBoardVo pboardVo = new PBoardVo(cp,ps,catgo,keyword);
		long totalCount = pboardMapper.selectCountByCatgo(pboardVo);
		List<PBoard> list = pboardMapper.selectPerPageByCatgo(pboardVo);
		
		return new PBoardListResult(cp, totalCount, ps, list);
	}

	@Override
	public PBoard getPBoard(long pb_num) {
		PBoard pboard = pboardMapper.selectBySeq(pb_num);
		return pboard;
	}

	@Override
	public void write(PBoard pboard) {
		pboardMapper.insert(pboard);

	}

	@Override
	public void edit(PBoard pboard) {
		pboardMapper.update(pboard);
		

	}

	@Override
	public void remove(long pb_num) {
		pboardMapper.delete(pb_num);

	}
	@Override
	public void review(long pb_num) {
		pboardMapper.review(pb_num);
	}
	@Override
	public PBoard movePage(long pb_num) {
		PBoard pboard = pboardMapper.movePage(pb_num);
		return pboard;
	}
	@Override
	public void fileUpload(String f_rname, String f_fname) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("f_fname", f_fname);
		hm.put("f_rname", f_rname);
		
		pboardMapper.uploadFile(hm);
	}
	@Override
	public List<uploadFile> getfileList(long pb_num){
		List<uploadFile> list = pboardMapper.fileList(pb_num);
		return list;
	}

	@Override
	public void deleteFile(long pb_num){
		pboardMapper.deleteFile(pb_num);
	}
	@Override
	public void delFile(long f_num) {
		pboardMapper.delFile(f_num);
	}
	@Override
	public void fileUpdate(String f_rname, String f_fname, long pb_num) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("f_fname", f_fname);
		hm.put("f_rname", f_rname);
		hm.put("pb_num", pb_num);
		pboardMapper.updateFile(hm);
	}
	}
