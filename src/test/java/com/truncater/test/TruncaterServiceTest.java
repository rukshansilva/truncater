package com.truncater.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truncater.service.ServiceManager;

import junit.framework.Assert;

/**
 * Unit test class which tests each functionality
 * 
 * @author Rukshan Silva
 * @since 30th March 2017
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TruncaterServiceTest {

	@Autowired
	private ServiceManager serviceManger;
    
    @Test
    public void testTruncater1() {
    	
    	try {
			Assert.assertEquals("12 ... (truncated) ... 90", serviceManger.truncate("123456789012345678901234567890", 25));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    public void testTruncater2() {
    	
    	try {
			Assert.assertEquals("1234567890", serviceManger.truncate("1234567890", 5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    public void testTruncater3() {
    	
    	try {
			Assert.assertEquals("123456789012345678901234567890", serviceManger.truncate("123456789012345678901234567890", 31));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
