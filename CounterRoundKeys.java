package AESreport;

import java.util.ArrayList;

public class CounterRoundKeys {
	private ArrayList<char[][]> key = new ArrayList<char[][]>();
	public CounterRoundKeys(char[][] key, char cnt) {
		for(int i = 0 ; i <= 10 ; i++) {
			char[][] buf = new char[4][4];
			for(int j = 0 ; j < 4 ; j++){
				for(int k=0 ; k < 4 ; k++) {
					buf[j][k] = (char) (key[j][k] ^ cnt);
				}
			}
			this.key.add(buf);
			cnt++;
		}
	}
	public char[][] getRoundKey(int round) {
		
		return key.get(round);
	}
}
