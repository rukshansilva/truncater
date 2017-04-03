package com.truncater.service.impl;

import org.springframework.stereotype.Service;

import com.truncater.service.ServiceManager;

/**
 * The Logging Service which handles the logging functionalities
 * 
 * @author Rukshan Silva
 * @since 30th March 2017
 * @version 1.0
 */
@Service("loggingService")
public class LoggingServiceManager implements ServiceManager{

	/**
	 * Truncates the given log into the length given.
	 * The return log is always the same length as the provided
	 * @throws Exception 
	 */
	@Override
	public String truncate(String log, int length) throws Exception {
		
		int replaceStartIndex = 0, replaceEndIndex = 0;
		
		if (log == null || log.isEmpty() || length < 1) {
			
			throw new IllegalArgumentException(String.format("Invalid log - %s OR length - %s", log, length));
		}
			
		try {
			
			/*
			 * if the log is less than the truncate length OR the truncate length is less than
			 * 	the truncate log - return the original log
			 */
			if ((log.length() <= length) ||
					(length <= TRUNCATE_LOG.length())) {
				return log;
			}
			
			int charInReturn = length - TRUNCATE_LOG.length();
			
			StringBuffer returnLog = new StringBuffer(log);
			
			//we are returning only a single charactor in original log
			if (charInReturn < 2) {
				replaceStartIndex = 1;
				
			} else {
				replaceStartIndex = charInReturn/2;
			} 
			
			replaceEndIndex = log.length() - (charInReturn - replaceStartIndex);
			
			//replace the middle with truncate log
			returnLog.replace(replaceStartIndex, replaceEndIndex, TRUNCATE_LOG);
			
			return returnLog.toString();
			
		} catch (Exception e) {
			throw new Exception(String.format("Error occured while truncating the log - %s AND length - %s", log, length));
		}
	}
}
