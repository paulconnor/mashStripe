import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


public class getTimeStamp {

	/**
	 * @param args
	 */
	
	@SuppressWarnings("null")
	
	public static String getSign() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		/*Date d= new Date();
		String key="tpuddfcs5wmc982bturg68ax";
		//key=key.concat("tpuddfcs5wmc982bturg68ax");
		key=key.concat("j853eTUQyA");
		key=key.concat(Long.toString(d.getTime()));
		  MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
	       System.out.println("key.getBytes()");
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	        	
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	         //String test=Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1);
	         //System.out.println(test);
	         //System.out.println("Digest(in hex format):: " + sb.toString());
	         
	        }
	        System.out.println("Digest(in hex format):: " + sb.toString());
	     
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		long epoch = System.currentTimeMillis()/1000;
		String apikey="tpuddfcs5wmc982bturg68ax";
		String secret="j853eTUQyA";
		String timestamp = Long.toString(epoch);
		String sig = MD5(apikey + secret + timestamp); 
		System.out.println(sig);
		return(sig);
		
		
	      
	}
	private static String MD5(String text)
		    throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		        MessageDigest md;
		        md = MessageDigest.getInstance("MD5");
		        byte[] md5hash = new byte[32];
		        md.update(text.getBytes("iso-8859-1"), 0, text.length());
		        md5hash = md.digest();
		        return convertToHex(md5hash);
		    }
	private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
           } while(two_halfs++ < 1);
        }
        return buf.toString();
    }

}
