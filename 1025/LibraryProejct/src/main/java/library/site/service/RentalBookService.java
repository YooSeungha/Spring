package library.site.service;

import java.util.Map;

import library.site.domain.RentalBookDAO;

public interface RentalBookService {
	int insertrentalBook(RentalBookDAO rb); //���⿹��
	RentalBookDAO rentalBook(long book_num);
	long rentalBookCount(long book_num); //������ å ����
	RentalBookDAO rentalBookInfo(Map<String, Object> map); //ȸ���� ������ ���� ����
	long mem_rentalCount(long mem_num); // ȸ���� ������ ���� ����
}
