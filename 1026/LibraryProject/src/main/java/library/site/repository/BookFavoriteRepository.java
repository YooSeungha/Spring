package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import library.site.domain.BookFavorite;

public interface BookFavoriteRepository extends JpaRepository<BookFavorite, Long> {
	@Query(value = "select * from BOOK_FAVORITE where MEM_NUM=:memnum",
			nativeQuery = true)	
	List<BookFavorite> findByMem_num(@Param("memnum") long memnum);	
	
	@Query(value = "select * from BOOK_FAVORITE where MEM_NUM=:memnum and BOOK_NUM=:booknum",
			nativeQuery = true)
	BookFavorite findByFav(@Param("memnum") long memnum, @Param("booknum") long booknum);
}
