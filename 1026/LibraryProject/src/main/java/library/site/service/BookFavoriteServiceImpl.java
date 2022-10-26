package library.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.site.domain.BookFavorite;
import library.site.domain.LibraryBook;
import library.site.domain.Member;
import library.site.repository.BookFavoriteRepository;
import library.site.repository.LibraryBookRepository;
import library.site.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
@Transactional
public class BookFavoriteServiceImpl implements BookFavoriteService {

	private final BookFavoriteRepository bfRepository;
	private final LibraryBookRepository lbRepository;
	private final MemberRepository memRepository;
	
	@Override
	@Transactional
	public Member insertFav(String isbn, String memnum) {
		BookFavorite bf = new BookFavorite();
		LibraryBook lb = lbRepository.findByBook_isbn(isbn);
		log.info("##############lb: " + lb);
		if(lb == null) { //db에 있는 도서가 아닐때			
			return null;
		}
		log.info("#######memnum : " + memnum);
		long mem_num = Long.parseLong(memnum);
		bf.setMem_num(mem_num);		
		bf.setLibraryBook(lb);
		log.info("####bf : " + bf);
		bfRepository.save(bf);
		Member mem = memRepository.findByMem_num(mem_num);
		return mem;
	}

	@Override
	@Transactional
	public Member deleteFav(String isbn, String memnum) {
		BookFavorite bf = new BookFavorite();
		LibraryBook lb = lbRepository.findByBook_isbn(isbn);
		long book_num = lb.getBook_num();
		long mem_num = Long.parseLong(memnum);
		bf = bfRepository.findByFav(mem_num, book_num);
		bfRepository.delete(bf);
		
		Member mem = memRepository.findByMem_num(mem_num);
		return mem;
	}

}
