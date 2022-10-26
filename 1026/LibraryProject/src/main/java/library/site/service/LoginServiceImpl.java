package library.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.site.domain.BookFavorite;
import library.site.domain.BookRequestDAO;
import library.site.domain.Member;
import library.site.domain.RentalBook;
import library.site.mapper.LoginMapper;
import library.site.repository.BookFavoriteRepository;
import library.site.repository.BookRequestRepository;
import library.site.repository.RentalBookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	private final RentalBookRepository rbrepository;
	private final BookFavoriteRepository bfRepository;
	private final BookRequestRepository brequestRepository;
	
	@Override
	public int signUp(Member member) {
		return loginMapper.signUp(member);
	}

	@Transactional(readOnly = true)
	@Override	
	public Member login(Member member) {
		Member loginMember = loginMapper.login(member);
		long memnum = member.getMem_num();
		//즐겨찾기 추가
		List<BookFavorite> bf = new ArrayList<BookFavorite>();
		bf = bfRepository.findByMem_num(memnum);
		try {
			loginMember.setBookFavorite(bf);
		}
		catch(NullPointerException npe) {
			
		}		
		return loginMember;
	}

	@Override
	public Member mypage(long mem_num) {
		return loginMapper.mypage(mem_num);
	}

	@Override
	public int emailCheck(String mem_email) {
		return loginMapper.emailCheck(mem_email);
	}

	@Override
	public int phoneCheck(String mem_phone) {
		return loginMapper.phoneCheck(mem_phone);
	}

	@Override
	public int idCheck(String mem_id) {
		return loginMapper.idCheck(mem_id);
	}

	@Override
	public String phoneAccount(String mem_phone) {
		return loginMapper.phoneAccount(mem_phone);
	}

	@Override
	public String findPass(String mem_email) {
		return loginMapper.findPass(mem_email);
	}

	@Override
	public int NaverSignUp(Member member) {
		return loginMapper.NaverSignUp(member);
	}

	@Override
	public int deleteMember(Member member) {
		return loginMapper.deleteMember(member);
	}

	@Override
	public int passCheck(Member member) {
		return loginMapper.passCheck(member);
	}

	@Override
	public Member naverLogin(String mem_email) {
		return loginMapper.naverLogin(mem_email);
	}

	@Override
	public int passUpdate(Member member) {
		return loginMapper.passUpdate(member);
	}
	
	
	@Override
	public List<RentalBook> getMem_rental(long mem_num){
		List<RentalBook> mem_rentalBook = rbrepository.getMem_rentalBook(mem_num);
		return mem_rentalBook;
	}

	@Override
	public int deleteNaverMember(String mem_email) {
		loginMapper.deleteNaverMember(mem_email);
		return 0;
	}
	@Override
	public List<BookRequestDAO> getMem_request(long mem_num) {
		List<BookRequestDAO> mem_requestBook = brequestRepository.getMem_requestBook(mem_num);
		return mem_requestBook;
	}

}
