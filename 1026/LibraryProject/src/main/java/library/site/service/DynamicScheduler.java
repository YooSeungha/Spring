package library.site.service;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import library.site.domain.Seat;
import library.site.domain.SeatTime;

@Service
@Component
public class DynamicScheduler {
	@Autowired
	SeatService seatService;
	private ThreadPoolTaskScheduler scheduler1;
	private ThreadPoolTaskScheduler scheduler2;
	private String cron = "*/10 * * * * *";
	public void startScheduler(Seat seat,SeatTime seatTime,String cron2) {
		scheduler1 = new ThreadPoolTaskScheduler();
		scheduler1.setPoolSize(4);
		scheduler1.initialize();
		changeCronSet(cron2);
		scheduler1.schedule(getRunnable(seat,seatTime,cron),getTrigger());
	}
	
	public void startScheduler2(Seat seat,SeatTime seatTime) {
		scheduler2 = new ThreadPoolTaskScheduler();
		scheduler2.setPoolSize(4);
		scheduler2.initialize();
		scheduler2.schedule(getRunnable2(seat,seatTime),getTrigger());
	}
	public void changeCronSet(String cron) {
		this.cron = cron;
	}
	public void stopScheduler() {
		scheduler1.shutdown();
	}
	public void stopScheduler2() {
		scheduler2.shutdown();
	}

	public Runnable getRunnable(Seat seat,SeatTime seatTime,String cron2) {
		return () ->{
			System.out.println("#1: "+ seat);
			changeCronSet("*/30 * * * * *"); // 4시간 고정값
			seatService.updateSeat(seat);
			startScheduler2(seat,seatTime);
			stopScheduler();
		};
	}
	public Runnable getRunnable2(Seat seat,SeatTime seatTime) {
		return () ->{
			seat.setSeat_use("");
			seatService.updateSeat(seat);
			System.out.println("#2: "+ seat);
			stopScheduler2();
		};
	}
	public Trigger getTrigger() {
		return new CronTrigger(cron);
	}
//	@PostConstruct
//	public void init() {
//		startScheduler();
//	}
//	@PreDestroy
//	public void destroy() {
//		stopScheduler();
//	}
	
}
