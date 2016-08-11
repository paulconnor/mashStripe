package com.tibco.Stoken;
import java.util.*;


import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.google.gson.Gson;


public class getCustomer  {

	
	
	public static String createCustomer(String desc,String source,String email){
		
		
		Stripe.apiKey = "sk_test_R6YhheMbEXzja80Gk70GrSlr";

		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("description", "Customer for test@example.com");
		customerParams.put("source", source);// obtained with Stripe.js
		customerParams.put("email", email);

		

		try
		{
			Customer customer=Customer.create(customerParams);
		
		
		//Token token = null;
		//token = Token.create(tokenParams);
		//token = com.stripe.model.Token.create(tokenParams);
		System.out.println("Execute success");
		return customer.getId(); 
		
		}
		catch(Exception E){
			System.out.println(E);
			return("Not generated");
		}
		finally{
			
		}
	}
	
}
