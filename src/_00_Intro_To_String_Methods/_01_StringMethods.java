package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	boolean longer = false;
    	if (s1.length () > s2.length ()) {
    		longer = true;
    	}
    	if (longer) {
    		return s1;
    	}
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	String s2 = s;
        if (s.contains("underscores")) {
        	s2 = s.replace(" ", "_");
        }
        return s2;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	s1 = s1.trim ();
    	s2 = s2.trim ();
    	s3 = s3.trim ();
    	int num = 0;
    	if (s1.substring(s1.indexOf(" ") + 1).compareTo(s2.substring(s2.indexOf(" ") + 1))<= 0) {
    		num = 1;
    	}else {
    		num = 2;
    	}
    	if (num == 1) {
    		if (s1.substring(s1.indexOf(" ") + 1).compareTo(s3.substring(s3.indexOf(" ") + 1)) > 0) {
    			num = 3;
    		}
    	}else {
    		if (s2.substring(s2.indexOf(" ") + 1).compareTo(s3.substring(s3.indexOf(" ") + 1)) > 0) {
    			num = 3;
    		}
    	}
    	if (num == 1) {
    		return s1;
    	}else if (num == 2) {
    		return s2;
    	}
        return s3;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (Character.isDigit(s.charAt(i))) {
        		sum += Integer.parseInt(s.substring(i, i+1));
        	}
        }
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int total = 0;
//        if (s.indexOf(substring) == -1){
//        	return 0;
//        }
        while (s.indexOf (substring) != -1) {
        	total++;
        	s = s.substring(s.indexOf(substring) + substring.length());
        }
        return total;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
        return Utilities.encrypt(s.getBytes(), (byte)key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	return Utilities.decrypt(s, (byte)key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	String[] words = s.split(" ");
    	int sum = 0;
    	for (int i = 0; i < words.length; i++) {
    		if (!(words [i].length() < substring.length())) {
    			words [i] = words [i].substring (words [i].length () - substring.length());
    			if (words [i].equals (substring)) {
    				sum++;
    			}
    		}
    	}
    	return sum;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        int first = s.indexOf(substring);
        int last = s.lastIndexOf(substring);
//        int chars = 0;
//        while (s2.indexOf (substring) != -1) {
//        	chars += s2.indexOf(substring)+1 + substring.length();
//        	s2 = s2.substring(s2.indexOf(substring) + substring.length());
//        }
//        return chars - first;
//        System.out.println(s);
//        System.out.println(first);
//        System.out.println(last);
        return last - first - substring.length();
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	s = s.replaceAll("[^A-Za-z0-9]", "");
    	System.out.println(s);
    	if (new StringBuilder (s).reverse ().toString().equalsIgnoreCase (s)) {
    		return true;
    	}
        return false;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
