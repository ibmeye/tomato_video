//package com.duapp.ibmeye.domain;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.duapp.ibmeye.repository.UserRespository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserTests {
//	
//	@Autowired
//	UserRespository repository;
//	
//	@Test
//	public void testUser() {
//		User user = new User("ibmeye","123456");
//		repository.save(user);
//	
//		Assert.assertEquals(true, repository.exists(user.getId()));
//		
//		User user2 = repository.findOne( user.getId() );
//		Assert.assertEquals(user, user2);
//		
//		
//		Assert.assertEquals("ibmeye", user.getUsername());
//		Assert.assertEquals("123456", user.getPassword());
//		
//		repository.delete( user );
//		Assert.assertNotNull( user );
//		Assert.assertNotNull( user.getId() );
//		Assert.assertEquals( false , repository.exists(user.getId()));
//	}
//}
