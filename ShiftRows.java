package test;

public class ShiftRows {

	public ShiftRows(char[][] plainText) {

//		System.out.println("\n>>ShiftRows<<");
		for(int i = 1 ; i < 4 ; i++) {
			int shift = 0;
			for(int j = 3 ; j >= 0 ; j--) {
				shift = (shift | ((0x00FF&plainText[i][3-j])<<j*8));
			}
			for(int j = 0 ; j < 4 ; j++) {
				plainText[i][j] = (char)(0x000000FF&(shift >> ((3-j+i)%4)*8));
			}
		}
		// TODO Auto-generated constructor stub
	}

}
