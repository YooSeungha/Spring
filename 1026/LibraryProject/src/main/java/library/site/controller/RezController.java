package library.site.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import library.site.domain.Member;
import library.site.domain.Reservation;
import library.site.domain.Seat;
import library.site.domain.SeatTime;
import library.site.service.DynamicScheduler;
import library.site.service.SeatService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class RezController {
	SeatService seatService;
	DynamicScheduler scheduler;
	
	@GetMapping("rez")
	public String Show() {
		return "rez2";
	}
	@RequestMapping("rezUpdate")
	public String rezUpdate() {
		return "rezUpdate";
	}
	
	//이건 직접 페이지 들어가서 데이터 받아와야함
	@RequestMapping("insertSeat")
	@ResponseBody
	public void insertSeat(@RequestBody String Data, Seat seat) {
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(Data);
		JsonArray array = element.getAsJsonArray();
		String seatNum = "";
		for(int i=0; i<array.size();i++) {
			seatNum = array.get(i).getAsJsonObject().get("seat").getAsString();
			seat.setSeat_num(seatNum);
			seatService.insertSeat(seat);
		}
	}
	
	// 예약 하기
	@RequestMapping("updateSeat")
	@ResponseBody
	public String updateSeat(@RequestBody String Data,Seat seat,SeatTime seatTime,HttpSession session)throws JsonProcessingException {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(Data);
		JsonObject jsonObject = element.getAsJsonObject();
		String seatnum = jsonObject.get("seatnum").getAsString();
		int seattime4 = 0 ;
		if(jsonObject.get("seattime").getAsString().length() == 6) seattime4 = Integer.parseInt(jsonObject.get("seattime").getAsString().substring(1, 3));
		else seattime4 = Integer.parseInt(jsonObject.get("seattime").getAsString().substring(1, 2));
		long roomnum = Long.parseLong(jsonObject.get("roomid").getAsString())+5;
		seat.setF_num(roomnum);
		seat.setSeat_num(seatnum);

		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");         
		String formatedNow = now.format(formatter);         
		Reservation rez = new Reservation();
		rez.setRes_start(formatedNow+" "+seattime4+":00:00");
		rez.setRes_end(formatedNow+" "+(seattime4+2)+":00:00");
		rez.setSeat_seq(seatService.selectSeatSeq(seat));
		
		log.info(rez);
		Member member = (Member)session.getAttribute("member");

		try {
			rez.setMem_num(member.getMem_num());
		}catch(NullPointerException ne) {
			log.info("#memberNull");
		}

		log.info("#seat_size"+seatService.selectTimeBetween(rez).size());
		JSONObject response = new JSONObject();
		response.put("size", seatService.selectTimeBetween(rez).size());
		response.put("rez", session.getAttribute("rez"));
		// selectTimeBetween은 뒤에 예약시간 있을 시 예약 못하게 하는 method
		if(seatService.selectTimeBetween(rez).size()==0 && session.getAttribute("rez")==null) seatService.insertRez(rez);
		
//      마이페이지 예약시간 
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("mem_num", member.getMem_num());
			map.put("today", df.format(cal.getTime())+" "+"00:00:00");
			session.setAttribute("rez",seatService.selectTimeByMem(map));
			Seat seat1 = seatService.selectTakenAll(seatService.selectTimeByMem(map).getSeat_seq());
			session.setAttribute("seatNum", seat1.getSeat_num());
			int a1 = 0;
			if (seat1.getF_num() == 6) a1 = 1;else if(seat1.getF_num() == 7) a1=2;
			else if(seat1.getF_num() == 8) a1=3;else if(seat1.getF_num() == 9) a1=4;
			session.setAttribute("fNum", a1);
		}catch(NullPointerException ne) {
			session.setAttribute("rez",null);
			session.setAttribute("seatNum", null);
			session.setAttribute("fNum", null);
		}
//		---

		return response.toString();
	}
	
	// 예약 수정 하기
	@RequestMapping("updateRez.do")
	@ResponseBody
	public String updateRezDo(@RequestBody String Data,Seat seat,SeatTime seatTime,HttpSession session)throws JsonProcessingException {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(Data);
		JsonObject jsonObject = element.getAsJsonObject();
		String seatnum = jsonObject.get("seatnum").getAsString();
		// 9시 와 13시는 자릿수가 다르므로 그거 구분
		int seattime4 = 0 ;
		if(jsonObject.get("seattime").getAsString().length() == 6) seattime4 = Integer.parseInt(jsonObject.get("seattime").getAsString().substring(1, 3));
		else seattime4 = Integer.parseInt(jsonObject.get("seattime").getAsString().substring(1, 2));
		//---
		long roomnum = Long.parseLong(jsonObject.get("roomid").getAsString())+5;
		seat.setF_num(roomnum);
		seat.setSeat_num(seatnum);
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");         
		String formatedNow = now.format(formatter); 
		Member member = (Member)session.getAttribute("member");
		Reservation re = (Reservation)session.getAttribute("rez");
		Reservation rez = new Reservation();
		rez.setRes_start(formatedNow+" "+seattime4+":00:00");
		rez.setRes_end(formatedNow+" "+(seattime4+2)+":00:00");
		rez.setSeat_seq(seatService.selectSeatSeq(seat));
		

//		fetch 데이터 넘기기
		JSONObject response = new JSONObject();
		response.put("size", seatService.selectTimeBetween(rez).size());
		response.put("rez", session.getAttribute("rez"));
		if(seatService.selectTimeBetween(rez).size()>0) {
			response.put("update", 1);
		}else if(session.getAttribute("rez")==null) {
			response.put("update", 2);
			return response.toString();
		}else response.put("update", 0);
		
//		업데이트문
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("update_start", formatedNow+" "+seattime4+":00:00");map.put("update_end", formatedNow+" "+(seattime4+2)+":00:00");
		map.put("rez_now", re.getRes_start());map.put("mem_num", member.getMem_num());map.put("seat_seq", seatService.selectSeatSeq(seat));
		if(seatService.selectTimeBetween(rez).size()==0 && session.getAttribute("rez")!=null) seatService.updateTime(map);
//      마이페이지 예약시간 
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		try {
			map2.put("mem_num", member.getMem_num());
			map2.put("today", df.format(cal.getTime())+" "+"00:00:00");
			session.setAttribute("rez",seatService.selectTimeByMem(map2));
			Seat seat1 = seatService.selectTakenAll(seatService.selectTimeByMem(map2).getSeat_seq());
			session.setAttribute("seatNum", seat1.getSeat_num());
			int a1 = 0;
			if (seat1.getF_num() == 6) a1 = 1;else if(seat1.getF_num() == 7) a1=2;
			else if(seat1.getF_num() == 8) a1=3;else if(seat1.getF_num() == 9) a1=4;
			session.setAttribute("fNum", a1);
		}catch(NullPointerException ne) {
			session.setAttribute("rez",null);
			session.setAttribute("seatNum", null);
			session.setAttribute("fNum", null);
		}
//		---

		return response.toString();
	}
	
	// 예약 삭제 하기
	@RequestMapping("rezDelete")
	public String delete(HttpSession session) {
		
		Reservation rez = (Reservation)session.getAttribute("rez");
		seatService.deleteRez(rez.getRes_num());
		session.setAttribute("rez",null);
		session.setAttribute("seatNum", null);
		session.setAttribute("fNum", null);
		return "redirect:/";//redirect:/
	}
	// 열람실 자리 데이터 넣기
	@RequestMapping("initSeat")
	@ResponseBody
	public String initSeat(Seat seat) throws JsonProcessingException{
		List<Seat> list = new ArrayList<Seat>();
		Seat seatTaken = new Seat();
		long[] a = seatService.selectSeatRez();
		for(int i=0; i<= a.length-1;i++) {
			seatTaken = seatService.selectTakenAll(a[i]);
			list.add(seatTaken);
		}
		log.info("#list: "+list);
		ObjectMapper om = new ObjectMapper();
		String seatJson = om.writeValueAsString(list);
		return seatJson;
	}
	
	// 열람실 자리 데이터 삭제
	@RequestMapping("deleteSeat")
	public void deleteSeat(Seat seat) {
		seatService.deleteSeat(seat);
	}
	//http://127.0.0.1:8080/deleteSeat
	
}
