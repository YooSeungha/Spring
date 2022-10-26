package library.site.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.LibraryBook;
import library.site.domain.RentalBookDAO;
import library.site.mapper.BookSearchMapper;
import library.site.mapper.RentalBookMapper;
import library.site.repository.RentalBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class RentalBookServiceImpl implements RentalBookService {

	@Autowired
	RentalBookMapper rbmapper;
	
	@Autowired
	private BookSearchMapper bookmapper;
	
	private final RentalBookRepository rbrepository;
	
	@Override
	public int insertrentalBook(RentalBookDAO rb) {	
		long book_num = rb.getBook_num();
		long mem_num = rb.getMem_num();
		LibraryBook book = bookmapper.select_num(book_num);
		log.info("book : " + book);
		RentalBookDAO rbook = rbmapper.select(book_num);
		long rbook_mem_num = 0;
		if(rbook != null) {
			rbook_mem_num = rbook.getMem_num(); //������ ȸ����ȣ
		}
		log.info("rbook : " + rbook);
		long book_count = book.getBook_count();
		log.info("book_count : " + book_count);
		long rental_count = rbmapper.selectCount(book_num);
		log.info("rental_count : " + rental_count);
		if(rental_count<book_count) { //db���� ������ ���� ���� ���� �Ǻ�
			log.info("mem_num : " + mem_num);
			log.info("rbook_mem_num : " + rbook_mem_num);
			if(mem_num!=rbook_mem_num) { //������ ȸ���� db�� ����� ȸ�� ��ȸ �� ���� ����
				rbmapper.insert(rb);
				return 0; //insert����
			}else{ 
				return 1; //�ߺ� ����
			}			
		}
		return 2; //���������� ���ⰹ������ �ʰ�
	}
	
	@Override
	public RentalBookDAO rentalBook(long book_num) {
		RentalBookDAO rb = rbmapper.select(book_num);
		return rb;
	}
	
	@Override
	public long rentalBookCount(long book_num) {
		long rb = rbmapper.selectCount(book_num);
		return rb;
	}
	
	@Override
	public RentalBookDAO rentalBookInfo(Map<String, Object> map) {
		RentalBookDAO RentalInfo = rbmapper.selectRental(map);
		return RentalInfo;
	}
	
	@Override
	public long mem_rentalCount(long mem_num) {
		long num = rbrepository.mem_rentalCount(mem_num);
		return num;
	}
}
