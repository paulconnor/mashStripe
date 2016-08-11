package com.tibco.Stoken;
import java.util.*;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.ChargeCollection;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.google.gson.Gson;

public class getCharges {

	public static String listCharges(String chargeID){

		Stripe.apiKey = "sk_test_R6YhheMbEXzja80Gk70GrSlr";
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("limit", 3);
		
		try {
		
			ChargeCollection charge = Charge.list(chargeParams);
			
			System.out.println("Execute success");
			return charge.toString();
	
		}
		catch(Exception E){
			System.out.println(E);
			return("Not generated");
		}
		finally{
			
		}
	}

	public static String listCustCharges(String customer,String chargeID){

		Stripe.apiKey = "sk_test_R6YhheMbEXzja80Gk70GrSlr";
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		//chargeParams.put("limit", 3);
		chargeParams.put("customer", customer);
		
		try {
		
			ChargeCollection charge = Charge.list(chargeParams);
			
			System.out.println("Execute success");
			return charge.toString();
	
		}
		catch(Exception E){
			System.out.println(E);
			return("Not generated");
		}
		finally{
			
		}
	}
}
