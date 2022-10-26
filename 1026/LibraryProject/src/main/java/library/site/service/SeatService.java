package library.site.service;

import java.util.HashMap;
import java.util.List;

import library.site.domain.Reservation;
import library.site.domain.Seat;
import library.site.domain.SeatTime;


public interface SeatService {
	// Seat
	void insertSeat(Seat seat);
	List<Seat> selectSeat(Seat seat);
	Seat selectTakenAll(long seq);
	void updateSeat(Seat seat);
	void deleteSeat(Seat seat);
	
	//SeatTime
	void insertTime(SeatTime seatTime);
	void updateSeatTimeAll(SeatTime seatTime);
	List<SeatTime> selectSeatTime(Seat seat);
	long selectSeatSeq(Seat seat);
	void updateSeatTime(SeatTime seatTime);
	String selectTimeBySeq();
	
	//Reservation
	void insertRez(Reservation rez);
	long[] selectSeatRez();
	List<Reservation> selectTime(HashMap<String, Object> map);
	List<String> selectTimeBetween(Reservation rez);
	Reservation selectTimeByMem(HashMap<String, Object> map);
	void updateTime(HashMap<String, Object> map);
	void deleteRez(long res_num);
}
