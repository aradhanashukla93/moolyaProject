package com.mooyla.utilities;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ServiceUtils {
	
	/**
	 * Enum to set HttpMethod type
	 */
	public enum HttpMethod{
		
		GET("get"),POST("post"),PUT("put"), DELETE("delete");
		private String method;
		
		private HttpMethod(String method) {
			this.method=method;
		}
		public String getMethod() {
			return method;
		}
	}
	
	/**
	 * Method to execute given type request with given request-specification , url.
	 * @param request
	 * @param endpoint
	 * @param method
	 * @return response of the requests
	 */
	public static Response execute(RequestSpecification request, String endpoint, HttpMethod method) {
		Response response =null;
		
		switch(method) {
		case GET:
			response =request.get(endpoint);
			break;
		case POST:
			response =request.post(endpoint);
			break;
		case PUT:
			response =request.put(endpoint);
			break;
		case DELETE:
			response =request.delete(endpoint);
			break;	
		default:
			break;	
		
		}
		return response;
		
	}

}
