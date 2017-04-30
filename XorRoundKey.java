package test;

public class XorRoundKey {

	public XorRoundKey(char[][]plainText, char[][] key) {
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				plainText[i][j] ^= key[i][j];
			}
		}
	}
	
	
}
