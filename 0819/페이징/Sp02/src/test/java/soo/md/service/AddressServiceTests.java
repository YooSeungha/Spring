package soo.md.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")



public class AddressServiceTests {
	@Autowired
	private AddressService addressService;
	
	@Test
	public void testListS() {
		log.info("#addressService: " + addressService);
		List<Address> list = addressService.listS();
		log.info("#addressMapper list: " + list);
	}
	
	@Test
	public void testInsertS() {
		Address address = new Address(-1L, "testN", "testA", null);
		addressService.insertS(address);
		log.info("#addressMapper testInsert() 성공");
	}
	
	@Test
	public void testDeleteS() {
		long seq = 6;
		addressService.deleteS(seq);
		log.info("#addressMapper testDelete() 성공");
	}
	
}