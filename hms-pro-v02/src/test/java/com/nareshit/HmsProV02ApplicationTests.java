package com.nareshit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nareshit.dao.AdminDao;
import com.nareshit.dao.DoctorDao;
import com.nareshit.domain.Admin;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HmsProV02ApplicationTests {

	@Autowired
	private AdminDao adminDao;

	
	@Test
	public void contextLoads() {
	}

	@Test

	public void testAdminCreation() {
	
	//User user =  new User();
		
		Admin admin = new Admin();
		admin.setFname("sachin123");
		admin.setLname("tendulaka123");
		admin.setEmail("sachin123@email.com");
		admin.setPassword("testUser");
		admin.setStatus(true);
		admin.setConpassword("testUser");
		
		admin = adminDao.addAdmin(admin);
		System.out.println("&&&&&&&&:\t"+admin.getId());
		
	}
	
	/*@Test
	public void testDoctorCreation() {
	
		User user =  new User();
		
		user.setFname("ram123");
		user.setLname("john");
		
		Session ses = sf.openSession();
		ses.save(user);
		ses.beginTransaction().commit();
		
		Doctor admin = new Doctor();
		admin.setFname("Ram1234");
		admin.setLname("simple123");
		admin.setEmail("ram123@email.com");
		admin.setPassword("testUser");
		admin.setStatus(true);
		admin.setConpassword("testUser");
		
		admin = docDao.addDoctor(admin);
		System.out.println("&&&&&&&&:\t"+admin.getId());
		
	}*/
}
