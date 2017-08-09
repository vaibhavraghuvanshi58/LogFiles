/*
 ****************************************************************************
 *
 * Copyright (c)2014 The Vanguard Group of Investment Companies (VGI)
 * All rights reserved.
 *
 * This source code is CONFIDENTIAL and PROPRIETARY to VGI. Unauthorized
 * distribution, adaptation, or use may be subject to civil and criminal
 * penalties.
 *
 ****************************************************************************
 Module Description:

 $HeadURL: http://prdsvnrepo:8080/svn/shared/projects/selenium-test-data-framework/trunk/src/main/java/com/vanguard/selenium/inner/base/ElementNotFoundException.java $
 $LastChangedRevision: 5267 $
 $Author: uz0s $
 $LastChangedDate: 2017-02-15 14:50:29 -0500 (Wed, 15 Feb 2017) $
*/
package com.vanguard.selenium.inner.base;

import org.openqa.selenium.WebDriver;

import com.vanguard.selenium.inner.core.utils.ScreenshotUtils;

/**
 * @author uz0s
 *
 */
public class ElementNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	//Parameterless Constructor
    public ElementNotFoundException() {}

    //Constructor that accepts a message
    public ElementNotFoundException(String message)
    {
       super(message);
    }

    /**Constructor that takes a screenshot of the current WebDriver. 
     * The screenshot will take the name specified and put in the path specified.
     * */
    public ElementNotFoundException(String message, WebDriver driver, String screenShotFilePath, String screenShotFileName)
    {
    	super(message);
   		ScreenshotUtils.takeScreenShot(screenShotFileName, driver, screenShotFilePath);
    }

    /**Constructor that takes a screenshot of the current WebDriver. 
     * The screenshot will take the same name as the error message and put the file in the location of the 
     * "screenShotDirectory" property or the root folder if no such property exists.
     * */
    public ElementNotFoundException(String message, WebDriver driver)
    {
    	super(message);
    	String screenShotFilePath = PropertiesManager.getProperty(PropertiesManager.SCREENSHOT_DIRECOTRY_KEY);
    	if(screenShotFilePath == null){
    		screenShotFilePath = "";
    	}
   		ScreenshotUtils.takeScreenShot(message, driver, screenShotFilePath);
    }
}
