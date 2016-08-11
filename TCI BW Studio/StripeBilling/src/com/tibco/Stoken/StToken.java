package com.tibco.Stoken;

import java.util.HashMap;

import java.util.Map;


import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Token;
import com.google.gson.Gson;


public class StToken  {

	
	
	public static String createToken(String number,String exp_month,String exp_year,String cvc){
		
		
		Stripe.apiKey = "sk_test_R6YhheMbEXzja80Gk70GrSlr";

		Map<String, Object> tokenParams = new HashMap<String, Object>();
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.put("number", number);
		cardParams.put("exp_month", exp_month);
		cardParams.put("exp_year", exp_year);
		cardParams.put("cvc", cvc);
		tokenParams.put("card", cardParams);

		try
		{
		Token token = Token.create(tokenParams);
		
		
		//Token token = null;
		//token = Token.create(tokenParams);
		//token = com.stripe.model.Token.create(tokenParams);
		System.out.println("Execute success");
		return token.getId(); 
		
		}
		catch(Exception E){
			System.out.println(E);
			return("Not generated");
		}
		finally{
			
		}
	}
}