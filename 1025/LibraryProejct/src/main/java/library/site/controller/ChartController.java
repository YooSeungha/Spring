package library.site.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import library.site.domain.ChartDTO;
import library.site.service.AdminBookManageService;
import library.site.service.InfographyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class ChartController {
	@Autowired
	private InfographyService ifgService; 
	
	@RequestMapping("/chart")
	public String chart() {				
		return "chart";
	}
	
	private Random r = new Random(); 
	@ResponseBody 
	@PostMapping("/chartData")
	public List<ChartDTO> getChartData() {
		ifgService.getMonthCatgoRentalChart();
		List<ChartDTO> list = new ArrayList<ChartDTO>();
		String items[] = {"봄", "초여름", "여름", "가을", "늦가을", "겨울"};
		
		for(int i=0; i<items.length; i++){
			int number = r.nextInt(100);
			ChartDTO dto = new ChartDTO(items[i], number);
			list.add(dto);
		}
		
		return list;
	}

	@ResponseBody
	@PostMapping("/AreaChart")
	public List<ChartDTO> AreaChart() {
		List<ChartDTO> chart = ifgService.getWeekRentalChart();				
		return chart;
	}
	
	@ResponseBody
	@PostMapping("/pieChart")
	public List<ChartDTO> pieChart() {
		List<ChartDTO> chart = ifgService.getBookCatgoChart();			
		return chart;
	}
	@ResponseBody
	@PostMapping("/barChart")
	public List<ChartDTO> barChart() {
		List<ChartDTO> chart = ifgService.getMonthCatgoRentalChart();			
		return chart;
	}
	
	@ResponseBody
	@PostMapping("/verticalBarChart")
	public List<ChartDTO> verticalBarChart() {
		List<ChartDTO> chart = ifgService.getMonthPopRentalChart();		
		return chart;
	}
	
	@ResponseBody
	@PostMapping("/infoChart")
	public List<ChartDTO> infoChart(String isbn) {
		log.info("####isbn : " + isbn);
		List<ChartDTO> chart = ifgService.getBookWeekChart(isbn);		
		return chart;
	}
}
