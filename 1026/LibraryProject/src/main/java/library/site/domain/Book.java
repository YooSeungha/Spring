package library.site.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	private String title;
	private String writer;
	private String publisher;
	private String description;
	private String isbn;
	private String catgo;
	private int catgoId;
	private String img;
	private int page;
	private int sizeWidth;
	private int sizeHeight;
	private int sizeDepth;
	private int weight;
	private String pubDate;
	private LibraryBook Lbook;
	
	
}
