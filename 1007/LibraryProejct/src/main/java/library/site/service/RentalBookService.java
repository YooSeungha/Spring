package library.site.service;

import java.util.Map;

import library.site.domain.RentalBook;

public interface RentalBookService {
	boolean insertrentalBook(RentalBook rb); //���⿹��
	RentalBook rentalBook(long book_num);
	long rentalBookCount(long book_num); //������ å ����
	RentalBook rentalBookInfo(Map<String, Object> map); //ȸ���� ������ ���� ����
}
