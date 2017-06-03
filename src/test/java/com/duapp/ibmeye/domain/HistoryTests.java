//package com.duapp.ibmeye.domain;
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.duapp.ibmeye.repository.HistoryRespository;
//import com.duapp.ibmeye.repository.ProvinceRespository;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class HistoryTests {
//	@Autowired
//	//HistoryRespository repository;
//	
//	@Autowired
//	ProvinceRespository provinceRespository;
//	
//	
//	
//	@Test
//	public void testSaveHistoryAndProvinceWithCascade() {
////		Province province = new Province("四川","川");
////		provinceRespository.save(province);
////		History history1 = new History("2015","文",399.282,"西安交通大学","计算机",188,province);
////		History history2 = new History("2016","文",312.282,"西安交通大学","计算机",128,province);
////		repository.save(history1);
////		province.setName("陕西");
////		repository.save(history2);
////		
////		Assert.assertNotNull(history1.getId());
////		Assert.assertNotNull(history2.getId());
////		
////		// 系统会在最后时刻，将内存中维护的对象的关系更新到数据库，所以，要小心，针对数据库的操作，我们要以用copy，而不应该是对象。
////		
////		Assert.assertEquals("陕西", history1.getProvince().getName());
//		
//	}
//	
//	@Test
//	public void testSaveHistoryAndProvince() {
////		Province province = new Province("四川","川");
////		// if there is not the follow instruction, some error will occured!
////		provinceRespository.save(province);
////		Assert.assertNotNull(province.getId());
////		Assert.assertEquals(province.getName(), "四川");
////		Assert.assertEquals(province.getShort_name(), "川");
//		
////		History history1 = new History("2015","文",399.282,"西安交通大学","计算机",188,province);
////		History history2 = new History("2016","文",312.282,"西安交通大学","计算机",128,province);
////		repository.save(history1);
//		
////		repository.save(history2);
////		
////		Assert.assertNotNull(history1.getId());
////		Assert.assertNotNull(history2.getId());
////		
////		Assert.assertEquals(true, history1.getProvince().getId().equals(province.getId()));
////		Assert.assertEquals(true, history1.getProvince().getName().equals(province.getName()));
////		Assert.assertEquals(true, history1.getProvince().getShort_name().equals(province.getShort_name()));
////
////		Assert.assertEquals(true, history2.getProvince().getId().equals(province.getId()));
////		Assert.assertEquals(true, history2.getProvince().getName().equals(province.getName()));
////		Assert.assertEquals(true, history2.getProvince().getShort_name().equals(province.getShort_name()));
//		
//	}
//	
//	@Test
//	public void testFindHistoryByProvince() {
////		Province province = new Province("四川","川");
////		// if there is not the follow instruction, some error will occured!
////		provinceRespository.save(province);
////		History history1 = new History("2015","文",399.282,"西安交通大学","计算机",188,province);
////		History history2 = new History("2016","文",312.282,"西安交通大学","计算机",128,province);
////		repository.save(history1);
////		repository.save(history2);
//		
////		List<History> historys = repository.findByProvince( province );
////		Assert.assertEquals(2, historys.size());
////		Assert.assertEquals(historys.get(0),history1);
////		Assert.assertEquals(historys.get(1),history2);
//		
//		//Province province = provinceRespository.findByName("山东省");
//		//Assert.assertNotNull(province);
//	}
//	
//	@Test
//	public void testProvince() {
////		Province province = new Province("山西","晋");
////		provinceRespository.save(province);
////		
////		History history = new History("2015","文",399.282,"西安交通大学","计算机",188,province);
////		repository.save(history);
////		Assert.assertEquals(true, repository.exists(history.getId()));
////		
////		History history2 = repository.findOne( history.getId() );
////		Assert.assertEquals( history , history2 );
////		
////		
////		Assert.assertEquals("2015", history2.getYear());
////		Assert.assertEquals(new Double(399.282), history2.getScore());
////		Assert.assertEquals("西安交通大学", history2.getCollege());
////		Assert.assertEquals("文", history2.getWenli());
////		Assert.assertEquals("计算机", history2.getMajor());
////		Assert.assertEquals(new Integer(188), history2.getAccepted());
////
////		Assert.assertNotNull(province.getId());
////		
////		repository.delete( history );
////		Assert.assertEquals( false , repository.exists(history.getId()));
////		
////		Assert.assertNotNull(province.getId());
////		Assert.assertEquals( true , repository.exists(province.getId()));
//	}
//}
