package library.site.service;

import library.site.domain.BookRequestDAO;

public interface BookRequestService {
	int insertBookRequest(BookRequestDAO brDAO);
	
	void requestUpdate(String isbn);
	void requestDelete(String isbn);
	void getBookInfo(String isbn);
}
