package com.mooyla.testCases;
import com.mooyla.utilities.GenericUtils;
import com.mooyla.utilities.ReadPropertiesFileTest;
import com.mooyla.utilities.ServiceUtils;
import com.mooyla.utilities.ServiceUtils.HttpMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.mooyla.testCases.ListenerTest.class)	

public class MoolyaAPITestCases {
	private static final String HTTP = "http:";
	private static final String PROPERTY_FILE_PATH= System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\api.properties";
	private static final int OK_REQUEST_200=200;
	private static final int OK_REQUEST_204=204;
	private static final String JSON=".json";
	static ExtentTest test;
	static ExtentReports report;
	static Properties prop;
	
	@BeforeClass
	public static void startTest() throws IOException {
		prop = ReadPropertiesFileTest.readPropertiesFile(PROPERTY_FILE_PATH);
		System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\ReportGeneration\\ExtentReportResults.html");
		report = new ExtentReports(System.getProperty("user.dir") + "\\src\\test\\resources\\ReportGeneration\\ExtentReportResults.html", true);
	}
	
	@BeforeMethod
	public void startUpTest(Method method) {
		test = report.startTest(method.getName());
	}
	
	@Test(priority = 0)
	public void verifyGetListUserAPI() throws IOException {
		RequestSpecification requestspecification = given()
		        .contentType(prop.getProperty("Content-Type")).queryParam("page", 2);
		Response response= ServiceUtils.execute(requestspecification,HTTP+prop.getProperty("getListUserServiceURL"), HttpMethod.GET);
		int statusCode =response.getStatusCode();
		test.log(LogStatus.INFO, "Response we got:"+response.asString());
		test.log(LogStatus.INFO, "Response status code is:"+response.getStatusCode());
		System.out.println("Response we got:"+response.asString()+" with status code:"+response.getStatusCode());
		if(OK_REQUEST_200==statusCode) {
			test.log(LogStatus.PASS, "200 ok status code ");
		}
		else {
			test.log(LogStatus.FAIL, "200 NOT ok status code");
		}
	}
	@Test(priority = 1)
	public void verifyGetSingleUserAPI() throws IOException {
		RequestSpecification requestspecification = given()
		        .contentType(prop.getProperty("Content-Type"));
		Response response= ServiceUtils.execute(requestspecification,HTTP+prop.getProperty("getSingleUSerserviceURL"), HttpMethod.GET);
		int statusCode =response.getStatusCode();
		test.log(LogStatus.INFO, "Response we got:"+response.asString());
		test.log(LogStatus.INFO, "Response status code is:"+response.getStatusCode());
		System.out.println("Response we got:"+response.asString()+" with status code:"+response.getStatusCode());
		if(OK_REQUEST_200==statusCode) {
			test.log(LogStatus.PASS, "200 ok status code ");
		}
		else {
			System.out.println("Inside fail");
			test.log(LogStatus.FAIL, "200 NOT ok status code");
		}
	}
	
	@Test(priority = 2)
	public void verifyPostRegisterSuccessfulAPI() throws IOException {
		JSONObject jsonbody=null;
		jsonbody=GenericUtils.readJSONFile(prop.getProperty("postRegisterBody")+JSON); 
	    RequestSpecification requestspecification = given()
		        .contentType(prop.getProperty("Content-Type")).body(jsonbody.toJSONString());
		Response response= ServiceUtils.execute(requestspecification,HTTP+prop.getProperty("postRegisterSuccessfulserviceURL"), HttpMethod.POST);
		int statusCode =response.getStatusCode();
		test.log(LogStatus.INFO, "Response we got:"+response.asString());
		test.log(LogStatus.INFO, "Response status code is:"+response.getStatusCode());
		System.out.println("Response we got:"+response.asString()+" with status code:"+response.getStatusCode());
		
		if(OK_REQUEST_200==statusCode) {
			test.log(LogStatus.PASS, "200 ok status code ");
		}
		else {
			test.log(LogStatus.FAIL, "200 NOT ok status code");
		}
	}
	@Test(priority = 3)
	public void verifyUpdateUserAPI() throws IOException {
		JSONObject jsonbody=null;
		jsonbody=GenericUtils.readJSONFile(prop.getProperty("updateUserBody")+JSON); 
	    RequestSpecification requestspecification = given()
		        .contentType(prop.getProperty("Content-Type")).body(jsonbody.toJSONString());
		Response response= ServiceUtils.execute(requestspecification,HTTP+prop.getProperty("updateUserserviceURL"), HttpMethod.PUT);
		int statusCode =response.getStatusCode();
		test.log(LogStatus.INFO, "Response we got:"+response.asString());
		test.log(LogStatus.INFO, "Response status code is:"+response.getStatusCode());
		System.out.println("Response we got:"+response.asString()+" with status code:"+response.getStatusCode());
		if(OK_REQUEST_200==statusCode) {
			test.log(LogStatus.PASS, "200 ok status code ");
		}
		else {
			test.log(LogStatus.FAIL, "200 NOT ok status code");
		}
	}
	
	@Test(priority = 4)
	public void verifyDeleteUserAPI() throws IOException {
		RequestSpecification requestspecification = given()
		        .contentType(prop.getProperty("Content-Type"));
		Response response= ServiceUtils.execute(requestspecification,HTTP+prop.getProperty("deleteUserserviceURL"), HttpMethod.DELETE);
		int statusCode =response.getStatusCode();
		test.log(LogStatus.INFO, "Response we got:"+response.asString());
		test.log(LogStatus.INFO, "Response status code is:"+response.getStatusCode());
		System.out.println("Response we got:"+response.asString()+" with status code:"+response.getStatusCode());
		if(OK_REQUEST_204==statusCode) {
			test.log(LogStatus.PASS, "204 ok status code ");
		}
		else {
			test.log(LogStatus.FAIL, "204 NOT ok status code");
		}
	}
	
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}
	
	
	

}
