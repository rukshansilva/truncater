package com.truncater.service;

/**
 * The Generic Service interface which handle different functionalities
 * 
 * @author Rukshan Silva
 * @since 30th March 2017
 * @version 1.0
 */
public interface ServiceManager {

	// Implicitly public static final 
	String TRUNCATE_LOG = " ... (truncated) ... ";
			
	String truncate(String log, int length) throws Exception;
}
