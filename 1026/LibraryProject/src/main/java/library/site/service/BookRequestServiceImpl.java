package library.site.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.Book;
import library.site.domain.BookRequestDAO;
import library.site.repository.BookRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class BookRequestServiceImpl implements BookRequestService {
	
	@Autowired
	private BookSearch bookSearch;

	private final BookRequestRepository brRepository;
	
	String key = "ttbqkrwlstjrzoq2232001";
	
	@Transactional
	@Override
	public int insertBookRequest(BookRequestDAO brDAO) {
		long mem_num = brDAO.getMem_num();
		String isbn = brDAO.getBr_isbn();
		long result = brRepository.findRequestInfo(mem_num, isbn);
		if(result>0) {
			log.info("####false");
			return 1;
		}else {
			log.info("####true");
			long distinct = brRepository.findRequestBook(isbn);
			if(distinct>0) {
				log.info("##distinct");
				return 2;
			}else {
				log.info("##save");
				brRepository.save(brDAO);
				return 0;
			}			
		}		
	}

	@Override
	public void requestUpdate(String isbn) {
		BookRequestDAO brDAO = brRepository.findByIsbn(isbn);
		brDAO.setBr_stat(1);
		brRepository.save(brDAO);
	}

	@Override
	public void requestDelete(String isbn) {
		BookRequestDAO brDAO = brRepository.findByIsbn(isbn);
		brRepository.delete(brDAO);
	}

	@Override
	public void getBookInfo(String isbn) {
		Book book = bookSearch.getBook(isbn);
		String title = book.getTitle();
		log.info("##title : " + title);
	}
}
