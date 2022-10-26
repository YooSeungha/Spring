package library.site.service;

import java.util.List;

import library.site.domain.ChartDTO;

public interface InfographyService {
	List<ChartDTO> getWeekRentalChart();
	List<ChartDTO> getMonthCatgoRentalChart();
	List<ChartDTO> getMonthPopRentalChart();
	List<ChartDTO> getBookCatgoChart();
	List<ChartDTO> getBookWeekChart(String isbn);
}
