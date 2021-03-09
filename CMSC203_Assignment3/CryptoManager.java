/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This program accepts user input text and encrypts the text using either
 * a Caesar Cipher, or a Bellaso Cipher. This program can also decrypt user provided text.
 * Due: 03/15/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Angela Minardi
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; //Distance between upper bound and lower bound plus one 

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//This method determines whether a string is within the bounds of ASCII codes
		//The method will return true if it is within bounds and false if it is out of bounds.
		//Angela Minardi
		
		boolean trueFalse = true; //New variable initialized to hold whether it's in bounds of ASCII, defaults to true
		
		for (int i = 0; i < plainText.length(); i++) //Iterates until it gets to the last letter in plainText
		{
			if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) //Runs if plainText is out of bounds (either higher or lower)
			{
				trueFalse = false; //Sets to false if out of bounds
			}
		}
		
		return trueFalse;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//This method implements the Caeser Cipher.
		//Variable key determines the offset and String plainText is replaced with the offset version
		//Angela Minardi
		
		String encryptedText = ""; //String that will hold encrypted value of plainText initialized
		char currentChar;
		int encryptedChar;
		
		if (stringInBounds(plainText) == true) //Checks the bounds of plainText
		{
			for (int i = 0; i < plainText.length(); i++) //Iterates over each character of plainText
			{	
				currentChar = plainText.charAt(i); //Assigns current character at place i to currentChar
				encryptedChar = (key + (int)currentChar); //Adds currentChar to key which results in the encrypted character
		
				while (encryptedChar > UPPER_BOUND)
				{
					encryptedChar -= RANGE;
				}
				
				encryptedText += (char)encryptedChar;
			}
		}
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//Uses the Bellaso Cipher to encrypt plainText according to the bellasoStr which
		//specifies the offsets for each character
		//Angela Minardi
		
		String bellasoKey = "";
		String encryptedBellaso = ""; //String initialized to hold encrypted plainText
		int result = 0;
        int j = 0;

        //Iterates until bellasoKey's length equals plainText's length 
        if(stringInBounds(plainText))
        {
        	while(bellasoKey.length() != plainText.length())
            {
                bellasoKey += bellasoStr.charAt(j); //Adds the character at j for bellasoStr to bellasoKey         
                j++; //Increments j by one

                if(j == bellasoStr.length()) //Runs if j is equal to the length of bellasoStr
                {
                    j = 0; //Sets j equal to 0
                }
            }

            //Iterates from the first to the last character in plainText
            for(int i = 0; i < plainText.length(); i++)
            {
                result = plainText.charAt(i) + bellasoKey.charAt(i); //Sets result equal to the sum of char(i) for plainText and bellasoKey

                if(result > UPPER_BOUND) //Runs if the result is larger than the upper bound
                {                 
                     while(result > UPPER_BOUND) //Iterates while result is greater than upper bound
                     {
                    	 result -= RANGE; //Subtracts range from result and assigns that value to result
                     }
                }        
                encryptedBellaso += (char)result; //Assigns the corresponding character of int result to the end of encryptedBellaos
            }
        }
        return encryptedBellaso;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//Decrypts a Caeser Cipher according to key provided
		//Angela Minardi
		
		String decryptedText = ""; //String to hold decrypted text initialized

		if (stringInBounds(encryptedText))
		{
			//Iterates through each character in encryptedTedt
			for (int i = 0; i < encryptedText.length(); i++)
			{
				char thisChar = encryptedText.charAt(i); //
				int decryptedCharint = ((int)thisChar-key);
				
				while (decryptedCharint < LOWER_BOUND)
				{
					decryptedCharint += RANGE;
				}
				
				decryptedText += (char)decryptedCharint;
			}
		}

		return decryptedText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//Decrypts the Bellaso Cipher according to bellasoStr provided which acts as the key
		//Angela Minardi
		
		//Initialize variables used in method
		 String bellasoKey = "";
         String decryptedText = "";
         int result = 0;
         int k = 0;

         if (stringInBounds(encryptedText))
         {
        	//Determines the key in while loop
             while(bellasoKey.length() != encryptedText.length()) //Iterates until bellasoKey is equal to the length of the text to decrypt
             {
                 bellasoKey += bellasoStr.charAt(k); //Sets bellasoKey equal to character at k of bellasoStr
                 k++; //j increments by 1 to go to the next letter in the string

                 if(k == bellasoStr.length()) //If k's value has reached the length of bellasoStr
                 {
                	 k = 0; //Set k = 0 so that it restarts at the first character of bellasoStr
                 }
             }
             
             //Applies the Bellaso Cipher according to the key
             for(int i = 0; i < encryptedText.length(); i++) //Iterates from the first to last character of the encrypted text
             {
            	//Assigns the difference in value of current character at i for the value of encryptedText to the same for bellasoKey
                 result = encryptedText.charAt(i) - bellasoKey.charAt(i); 

                 if(result < LOWER_BOUND) //If the difference assigned to result is less than the lower bound, runs contained code
                 {                 
                      while(result < LOWER_BOUND) //Iterates while result is lower than lower bound

                           result += RANGE; //Sets result to the result plus range
                 }            
                 decryptedText += (char)result; //Assigns the character corresponding to the value of result to the end of decryptedText
             }     
         }
        	 

    return decryptedText; //Returns the decrypted text
	}
}
