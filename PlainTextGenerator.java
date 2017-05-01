package AESreport;

public class PlainTextGenerator {
	private char[][] text = new char[4][4];

	public PlainTextGenerator(String str) {
		int count = 0;
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(count!=str.length()) {
					text[i][j] = str.charAt(count);
					count++;
				}
			}
		}
		// TODO Auto-generated constructor stub
	}
	public char[][] getText() {

		return text;
	}
}
