package library.site.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.Reservation;
import library.site.domain.Seat;
import library.site.domain.SeatTime;
import library.site.mapper.SeatMapper;
@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatMapper seatMapper;
	
	// Seat
	@Override
	public void insertSeat(Seat seat) {
		seatMapper.insertSeat(seat);
	}
	@Override
	public void deleteSeat(Seat seat) {
		seatMapper.deleteSeat(seat);
	}
	@Override
	public Seat selectTakenAll(long seq){
		return seatMapper.selectTakenAll(seq);
	}
	
	@Override
	public void updateSeat(Seat seat) {
		seatMapper.updateSeat(seat);
	}
	@Override
	public List<Seat> selectSeat(Seat seat) {
		return seatMapper.selectSeat(seat);
	}
	
	
	// SeatTime
	@Override
	public void insertTime(SeatTime seatTime) {
		seatMapper.insertTime(seatTime);
	}
	public void updateSeatTimeAll(SeatTime seatTime) {
		seatMapper.updateSeatTimeAll(seatTime);
	}
	@Override
	public List<SeatTime> selectSeatTime(Seat seat){
		return seatMapper.selectSeatTime(seat);
	}
	@Override
	public long selectSeatSeq(Seat seat) {
		return seatMapper.selectSeatSeq(seat);
	}
	@Override
	public void updateSeatTime(SeatTime seatTime) {
		seatMapper.updateSeatTime(seatTime);
	}
	@Override
	public String selectTimeBySeq() {
		return seatMapper.selectTimeBySeq();
	}
	//Reservation
	@Override
	public void insertRez(Reservation rez) {
		seatMapper.insertRez(rez);
	}
	@Override
	public long[] selectSeatRez(){
		return seatMapper.selectSeatRez();
	}
	@Override
	public List<Reservation> selectTime(HashMap<String, Object> map) {
		return seatMapper.selectTime(map);
	}
	@Override
	public List<String> selectTimeBetween(Reservation rez){
		return seatMapper.selectTimeBetween(rez);
	}
	@Override
	public Reservation selectTimeByMem(HashMap<String, Object> map) {
		return seatMapper.selectTimeByMem(map);
	}
	@Override
	public void updateTime(HashMap<String, Object> map) {
		seatMapper.updateTime(map);
	}
	@Override
	public void deleteRez(long res_num) {
		seatMapper.deleteRez(res_num);
	}
	
}
