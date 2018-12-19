package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.security.*;
import org.apache.commons.codec.binary.Hex;

public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws FileNotFoundException 
	 */
	public void readPasswords(String filename) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(filename)); 
		String line;
		try {
			passwordMap = new HashMap<String, String>();
		while((line = reader.readLine()) != null) {
			String[] arr = line.split(" ");
			String x = arr[0];
			String y = arr[1];
			passwordMap.put(x.replaceAll(":", ""), y);
		}
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) throws NoSuchAlgorithmException {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(password.getBytes());
		 byte[] digest = md.digest();
		 return Hex.encodeHexString(digest);
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 * @throws NoSuchAlgorithmException 
	 */
	public boolean checkPassword(String user, String password) throws NoSuchAlgorithmException {
        String hashedpass = getPasswordHash(password);
        if(passwordMap.get(user) == null) {
        	return false;
        } else {
        	return passwordMap.get(user).equals(hashedpass);
        }
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 * @throws FileNotFoundException 
	 * @throws NoSuchAlgorithmException 
	 */
    	public void addToHashDictionary(String filename) throws FileNotFoundException, NoSuchAlgorithmException {
    		BufferedReader reader = new BufferedReader(new FileReader(filename)); 
    		String line;
    		try {
    			hashDictionary = new HashMap<String, String>();
    		while((line = reader.readLine()) != null) {
    			String hashedpassword =  getPasswordHash(line);
    			hashDictionary.put(hashedpassword, line);
    		}
    		}catch(IOException e){
    			e.printStackTrace();
    			
    		}       
    }
	/**
	 * Do the dictionary attack.
	 * @throws NoSuchAlgorithmException 
	 * @throws FileNotFoundException 
	 */
	public void doDictionaryAttack() throws FileNotFoundException, NoSuchAlgorithmException {
		addToHashDictionary("password.txt");
		readPasswords("LeakedPasswords.txt");
		Set<String> set = passwordMap.keySet();
		Set<String> hashset = hashDictionary.keySet();
		for(String s:set) {
			if (hashset.contains(passwordMap.get(s))) {
				System.out.printf("password is:    %-10s for user: %-15s" ,hashDictionary.get(passwordMap.get(s)), s);
				System.out.println("");
			}
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
