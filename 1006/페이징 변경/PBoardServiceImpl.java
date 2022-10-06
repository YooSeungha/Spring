package library.site.service;

import java.io.*;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import library.site.domain.PBoard;
import library.site.domain.PBoardListResult;
import library.site.domain.PBoardVo;
import library.site.domain.PagingVO;
import library.site.mapper.PBoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Service
public class PBoardServiceImpl implements PBoardService {

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
	public int countBoard() {
		return pboardMapper.countBoard();
	}
	@Override
	public List<PBoard> selectBoard(PagingVO vo){
		return pboardMapper.selectBoard(vo);
	}
	
}
