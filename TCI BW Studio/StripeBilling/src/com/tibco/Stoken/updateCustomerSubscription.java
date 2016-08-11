package com.tibco.Stoken;
import java.util.*;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import com.stripe.model.Token;
import com.google.gson.Gson;

public class updateCustomerSubscription {

	public static String modifyCustomerSubscription(String plan, String stripeCustomerID){
		Stripe.apiKey = "sk_test_R6YhheMbEXzja80Gk70GrSlr";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("plan", plan);
		params.put("customer", stripeCustomerID);
		
		try {
			Subscription subscription=Subscription.create(params);
			System.out.println("Execute success");
			
			return subscription.getStatus();

		}
		catch(Exception E){
			System.out.println(E);
			return("Not generated");
		}
		finally{
			
		}
		
		
	}
	
}
