package library.site.service;

import library.site.domain.Member;

public interface BookFavoriteService {
	Member insertFav(String isbn, String memnum);
	Member deleteFav(String isbn, String memnum);
}
