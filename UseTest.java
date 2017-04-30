package test;

public class UseTest {

	public static void main(String[] args) {
		//단, 문자는 1byte짜리만 사용한다. 2byte의 한글이나 3byte의 한자는 사용불가.
		char[][] str = {
				{0x87, 0xF2, 0x4D, 0x97},
				{0x6e, 0x4C, 0x90, 0xEC},
				{0x46, 0xE7, 0x4A, 0xC3},
				{0xa6, 0x8C, 0xD8, 0x95}
		};
		char counter = 0x33;
		char[][] key = {
				{'8', 'f', '5', '3'},
				{'c', 'x', 't', '1'},
				{'h', 'o', 'P', 'W'},
				{'E', 'K', 'T', 'V'}
		};
		System.out.print(">> plainText        : "); printString(str);
		System.out.print(">> key              : "); printString(key);

		System.out.println("\n>> Generate RoundKeys <<");
		CounterRoundKeys roundkey = new CounterRoundKeys(key, counter);

		new XorRoundKey(str,key);
		for(int i = 0 ; i <= 10 ; i++) {
			printString(roundkey.getRoundKey(i));
		}

		System.out.println("\n>> Encryption <<");

		for(int i = 0 ; i < 10 ; i++)
		{

			new SubBytes(str);
			//			if(i==9){System.out.print(">> Encryption       : "); printString(str);}

			new ShiftRows(str);
			//			if(i==9){System.out.print(">> ShiftRows        : "); printString(str);}

			new MixColumns(str);
			//			if(i==9){System.out.print(">> MixColumes       : "); printString(str);}

			new XorRoundKey(str,roundkey.getRoundKey(i));

			new SubBytes(str);

			new ShiftRows(str);
		}
		
		new XorRoundKey(str,roundkey.getRoundKey(10));

		System.out.print(">> End Encryption : "); printString(str);

		new XorRoundKey(str,roundkey.getRoundKey(10));

		System.out.println("\n>> Decryption <<");
		for(int i = 9 ; i >= 0 ; i--)
		{
			new InverseShiftRows(str);
			
			new InverseSubBytes(str);

			new XorRoundKey(str,roundkey.getRoundKey(i));
			
			new InverseMixColumns(str);
//			if(i==9){System.out.print(">> InverseMixColumes: "); printString(str);}

			new InverseShiftRows(str);
//			if(i==9){System.out.print(">> InverseShiftRows : "); printString(str);}

			new InverseSubBytes(str);
//			if(i==9){System.out.print(">> Decryption       : "); printString(str);}
		}
		new XorRoundKey(str,key);
		
		System.out.print(">> End Decryption : "); printString(str);

	}
	public static void printString(char[][] str) {
		System.out.print("[ ");
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				System.out.print(Integer.toHexString(str[i][j]));
				if(!(i == 3 && j == 3))
					System.out.print(":");
			}
		}
		System.out.print(" ] \n");
	}
}
