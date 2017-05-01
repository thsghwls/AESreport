package AESreport;

public class XorRoundKey {

	public XorRoundKey() {
		super();
	}
	public XorRoundKey(char[][]plainText, char[][] key) {
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				plainText[i][j] ^= key[i][j];
			}
		}
	}
	public void xorTextandKey(char[][]plainText, char[][] key) {
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				plainText[i][j] ^= key[i][j];
			}
		}
	}
	
}
