package soo.md.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;
import soo.md.domain.ChartDTO;

@Log4j
@Controller
@RequestMapping("/chart")
public class ChartController {

	@GetMapping("chart.do")
	public String showView() {
		
		return "chart/chart";
	}
	private Random r = new Random();
	@ResponseBody
	@PostMapping("chartData")
	public List<ChartDTO> getChartData() {
		List<ChartDTO> list = new ArrayList<ChartDTO>();
		String items[] = {"삼성전자","LG","테슬라","Google","Apple","KaKao","naver"};
		
		for(int i=0; i<items.length; i++) {
			int number = r.nextInt(101);
			ChartDTO dto = new ChartDTO(items[i], number);
			list.add(dto);
		}
		
		return list;
	}
}
