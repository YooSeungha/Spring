package library.site.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.LibraryBook;
@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {
	@Query(value = "SELECT * FROM book WHERE book_num = :book_num",
			nativeQuery = true)
	LibraryBook findByBook_num(@Param("book_num") long book_num);
}
