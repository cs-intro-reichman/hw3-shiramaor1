/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lor Voldemort")); // false
		System.out.println(isAnagram(" "," ")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		System.out.println(preProcess("SHiR  45!!/8Ama o!r"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code 
		String newStr1 = preProcessNoSpaces(str1);
		String newStr2 = preProcessNoSpaces(str2);
		String temp = newStr2;
		boolean match = false;

		if (newStr1.length() != newStr2.length()) {
			return false;
		}
		if ( newStr1.length() == 0 && newStr2.length() == 0) {
			return true;
		}

		for (int i = 0; i < newStr1.length(); i++) {
			char ch1 = newStr1.charAt(i);
			match = false;
			for (int j = 0 ; j < newStr2.length() ; j++) {
				char ch2 = temp.charAt(j);
				if (ch1 == ch2 ) {
					temp.replace(ch1, ' ') ;
					match = true;
					
				}
			}
			if (match != true) {
				return false;
			}
			
		}
		return match;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch > 64 && ch < 123 || ch == ' ') {
				newString = newString + ch;  
			} else {
				newString = newString + "";
			}
		}
		String afterProcess = newString.toLowerCase();
		
		return afterProcess;
	} 
	public static String preProcessNoSpaces(String str) {
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch > 64 && ch < 123) {
				newString = newString + ch;  
			} else {
				newString = newString + "";
			}
		}
		String afterProcess = newString.toLowerCase();
		
		return afterProcess;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr = preProcessNoSpaces(str);
		String temp = newStr;
		String finalStr = "";
		int random = 0;

		for(int i = 0; i < newStr.length(); i++ ) {
			random = (int) (Math.random() * temp.length());
			finalStr +=  temp.charAt(random);
			
			String builtString= "";
			for (int j = 0; j < temp.length(); j++) {
				if (j != random) {
					builtString += temp.charAt(j);
				}
			}
			temp = builtString;
		}
		return finalStr;
	}
}
