package exTentor;

public class Translate {

	public Translate(){

	}

	public String translate(String swedish){
		String temp = "";
		String[] words = swedish.split(" ");
		StringBuilder sb = new StringBuilder();

		for (String word : words){
			int dotIndex = word.indexOf(".");
			int commaIndex = word.indexOf(",");

			temp = word;
			if (dotIndex != -1)temp = temp.substring(0, dotIndex);
			//substring returns a string to ending at the last index but the index before the last.
			if (commaIndex != -1)temp = temp.substring(0, commaIndex);
			sb.append(temp);
			if (dotIndex != - 1)sb.append('.');
			if (commaIndex != - 1)sb.append(',');
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Translate translate = new Translate();
		System.out.println(translate.translate("Jag kan programmera, vilket är roligt."));
	}
}
