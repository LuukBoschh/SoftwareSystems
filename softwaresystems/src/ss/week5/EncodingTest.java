package ss.week5;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;



/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException, UnsupportedEncodingException {
        String input = "Hello World";
        
        System.out.println(input);
        System.out.println(input.getBytes());
       

        String output = Hex.encodeHexString(input.getBytes());
        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        byte[] back = Hex.decodeHex(output);
        System.out.println(back);
        
        String str = new String(back, "UTF-8");
        System.out.println(str);
        
       //------------------------------------------------------------
        
       System.out.println(Base64.encodeBase64String(input.getBytes()));
       String output2 = Base64.encodeBase64String(input.getBytes());
       byte[] back2 = Base64.decodeBase64(output2);
       String str2 = new String(back2, "UTF-8");
       System.out.println(str2);
       
       //----------------------------------------------------------
       
       String input5 = "4d6f64756c652032";
       byte[] back5 = Hex.decodeHex(input5);
       String str5 = new String(back5, "UTF-8");
       System.out.println(str5);
       
       //--------------------------------------------------------------------
        
       byte[] back3 = Base64.decodeBase64("U29mdHdhcmUgU3lzdGVtcw==");
       String str3 = new String(back3, "UTF-8");
       System.out.println(str3);
       String stra = "";
       for(int i = 0; i<20 ;i ++) {
    	   stra += "a";
    	   System.out.println(stra);
    	   System.out.println(Base64.encodeBase64String(stra.getBytes()));
       }
        
        
    }
}
