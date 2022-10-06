package library.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import library.site.domain.Book;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		log.info("#11111");
		return "index";
	}
	@RequestMapping("/write.do")
	public String write() {
		
		return "others/board/write";
	}
	@RequestMapping(value = "/popup", method = RequestMethod.GET)
	public String popup() {
		log.info("#11111");
		return "popup";
	}
	@RequestMapping(value = "/modal", method = RequestMethod.GET)
	public String modal() {
		log.info("#11111");
		return "modal";
	}
}
