// Importing for Scanning operation 
// for input purpose
import java.util.Scanner;

/**
 * Youhave aquired only 1 byte for performing 7 bit operation  1 1 1 1 1 1 1 = total is 256
 * because ASCII character is between 0 to 255 
 * Array with 0 and 1 is good, but binary with only 0, or almost, is even better! 
 * Originally, this is a concept designed by Chuck Norris to send so called unary messages.
 * 
 * The Encoding principle:
 * -The input message consists of ASCII characters (7-bit)
 * -The encoded output message consists of blocks of 0 and 1
 * -A block is separated from another block by a space
 * -Two consecutive blocks are used to produce a series of same value bits (only 1s or 0s):
 * 		-First block: it is always 0 or 00. If it is 0, then the series contains 1s, if not, it contains 0s
 * 		-Second block: the number of 0s in this block is the number of bits in the series
 * 
 * Write a program that takes an incoming message as input and displays as output the message encoded 
 * using Chuck Norris’ method.
 * 
 * INPUT:
 * Line 1: the message consisting of N ASCII characters 
 * 
 * OUTPUT:
 * The encoded message with 0 blocks
 * 
 *
 * 
 *
 */
public class ChuckNorris{

	public static void main(String[] args) {
	  ChuckNorris c = new ChuckNorris();
	  String Encoded = c.getEncodedData();
	  System.out.println(Encoded);
	
		}
	
	public String getEncodedData(){
	
		//get data from Input
		Scanner in = new Scanner(System.in);
		
		//Convert input into Character Arrray
		char[] message = in.nextLine().toCharArray();
		
		//convert data into binary format
		StringBuilder binary = new StringBuilder();
		for(char c : message) {
		
			String stringTemp = Integer.toBinaryString(c);
			
			// This is required becuase you are going to perform 7 bit length binary 
			while(stringTemp.length() < 7) stringTemp = '0' + stringTemp;
			
			// We will append this new string into StringBuilder
			binary.append(stringTemp);
		}
		
		//convert to unary and print to console
		int i = 0;
		char currentChar;
		String str = "";
		
		while(i < binary.length()) {
			if(binary.charAt(i) == '0') {
			
			  str = str + "00 ";
				currentChar = '0';
			}
			else {
			  str = str + "0 ";
				currentChar = '1';
			}
			while(binary.charAt(i) == currentChar) {
				str = str + "0";
				i++;
				if(i >= binary.length()) break;
			}
			if(i < binary.length()) str = str + "0" ;
		}
		in.close();
		return str;
	}
}
