package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFromWebsite {

	final String SYM  = "KO";

	public static void main(String[] args) {
		try {
			URL solTech = new URL("https://www.avanza.se/aktier/om-aktien.html/573878/soltech-energy-sweden");
			URL gomSpace = new URL("https://www.avanza.se/aktier/om-aktien.html/667935/gomspace-group");

			URLConnection urlConn = solTech.openConnection();
//			URLConnection urlConn = gomSpace.openConnection();


			InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
			BufferedReader br = new BufferedReader(inStream);

			String line;

			while ((line = br.readLine()) != null){
				//System.out.println(line);
				if (line.contains("\"Senast uppdaterad: ")){
					float res = regexChecker("[0-9]{1,},[0-9]{1,}", line);
					System.out.println("Senast: " + res);
				}

				if (line.contains("\"lowestPrice SText bold\"")){
					float res = regexChecker("[0-9]{1,},[0-9]{1,}", line);
					System.out.println("Lägsta idag: " + res);
				}

				if (line.contains("\"highestPrice SText bold\"")){
					float res = regexChecker("[0-9]{1,},[0-9]{1,}", line);
					System.out.println("Högsta idag: " + res);
				}
				if (line.contains("\"changePercent SText bold")){
					float res = regexChecker("-?[0-9]{1,},[0-9]{1,}", line);
					System.out.println("Ändring i procesent idag: " + res);
				}

			}





		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		[A-Za-z] - any characters you want
		[0-9]
		[^A-G] - ^ = not
		\\s - whiteSpace
		\\S - NOT whiteSpace
		\\w - any characters

		\\d - digit
		\\D - NOT a digit


		"\\s[A-Za-z]{2,20}\\s"

		"[0-9]{1,},[0-9]{1,}"

		120,0
		0,002
		0,99
		1,232


		 */
	}

	public static float regexChecker(String theRegex, String str2Check){
		Pattern checkRegex = Pattern.compile(theRegex);

		Matcher regexMatcher = checkRegex.matcher(str2Check);

		String priceString = "";
		float price = 0;

		while (regexMatcher.find()){
			if (regexMatcher.group().length() != 0){
				priceString = regexMatcher.group().trim().replace(",", ".");
			}
		}

		try {
			 price = Float.parseFloat(priceString);

		}catch (NumberFormatException e){
			e.printStackTrace();
		}

	 	return price;
	}
}
