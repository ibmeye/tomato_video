//package com.duapp.ibmeye.domain;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.duapp.ibmeye.repository.ProvinceRespository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProvinceTests {
//	
//	@Autowired
//	ProvinceRespository repository;
//	
//	@Test
//	public void testProvince() {
//		Province province = new Province("山西","晋");
//		repository.save(province);
//		
//		System.out.println(province.getId());
//		Assert.assertEquals(true, repository.exists(province.getId()));
//		
//		Province province2 = repository.findOne( province.getId() );
//		Assert.assertEquals(province, province2);
//		
//		
//		Assert.assertEquals("山西", province2.getName());
//		Assert.assertEquals("晋", province2.getShort_name());
//	
//		repository.delete( province2 );
//		Assert.assertEquals( false , repository.exists(province.getId()));
//	}
//}
