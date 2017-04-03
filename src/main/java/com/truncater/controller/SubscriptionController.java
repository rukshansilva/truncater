package com.truncater.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.truncater.service.ServiceManager;

@RestController
public class SubscriptionController {

	private static final Logger LOG = LoggerFactory.getLogger(SubscriptionController.class);

	/*
	 *  Assumeed there will be many more Services in the future
	 *  	eg : DatabaseServiceManager/ fileServiceManager
	 */
	@Autowired
	@Qualifier("loggingService")
	private ServiceManager serviceManger;
	
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscribe(HttpServletRequest request) {

		String orderDetails = getOrderDetails(request);
		
		String truncatedOrderDetails = "";
		try {
			truncatedOrderDetails = serviceManger.truncate(orderDetails, 250);
		} catch (Exception e) {

			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		
		LOG.info(truncatedOrderDetails);
		
		return truncatedOrderDetails;
	}
}
