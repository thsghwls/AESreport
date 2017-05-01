package AESreport;

public class AESmain {

	public static void main(String[] args) {
		//>> AES 암호화 프로그램 <<
		//단, 문자는 1byte짜리만 가능합니다. (2byte의 한글이나 3byte의 한자는 사용불가).

		//PlainText
		//		char[][] str = {
		//				{0x87, 0xF2, 0x4D, 0x97},
		//				{0x6e, 0x4C, 0x90, 0xEC},
		//				{0x46, 0xE7, 0x4A, 0xC3},
		//				{0xa6, 0x8C, 0xD8, 0x95}
		//		};
		
		//KEY는 CTR 방식을 흉내내 봤습니다.
		char counter = 0xF3; //Counter 값
		char[][] key = {	 //Key 값
				{'8', 'f', '5', '3'},
				{'c', 'x', 't', '1'},
				{'h', 'o', 'P', 'W'},
				{'E', 'K', 'T', 'V'}
		};
		
		//평문입력시 128bit씩 끊어서 char[4][4]짜리 평문을 생성합니다.
		PlainTextGenerator ptg = new PlainTextGenerator("This is plaintext");
		char[][]str = ptg.getText();
		
		System.out.print(">> plainText      : "); printString(str);
//		System.out.print(">> key            : "); printString(key);
		
//		System.out.println("\n>> Generate RoundKeys <<");
		CounterRoundKeys roundkey = new CounterRoundKeys(key, counter);

//		for(int i = 0 ; i <= 10 ; i++){
//			System.out.printf("%2d번째 RKey : ",i);printString(roundkey.getRoundKey(i));
//		}
		
		System.out.println("\n>> Encryption <<"); //굳이 클래스로 만들지 않았습니다.
		
		//01.평문과 key를 XOR합니다.
		XorRoundKey xrk = new XorRoundKey(str,key);
		
		SubBytes   sb   = new SubBytes();
		ShiftRows  sr   = new ShiftRows();
		MixColumns mc   = new MixColumns();
		
		//02.Round를 10회 합니다.
		for(int i = 0 ; i < 10 ; i++)
		{
			sb.subBytes(str);
			sr.shiftRows(str);
			mc.mixColumns(str);
			
			xrk.xorTextandKey(str,roundkey.getRoundKey(i)); //roundkey 0~9까지
			sb.subBytes(str);
			sr.shiftRows(str);
		}
		//03.평문과 roundkey(10)를 XOR합니다.
		xrk.xorTextandKey(str,roundkey.getRoundKey(10));
		System.out.print(">> End Encryption : "); printString(str);

		System.out.println("\n>> Decryption <<");
		//01.평문과 roundkey(10)를 XOR합니다.
		xrk.xorTextandKey(str,roundkey.getRoundKey(10));
		
		InverseShiftRows  isr = new InverseShiftRows();
		InverseSubBytes   isb = new InverseSubBytes();
		InverseMixColumns imc = new InverseMixColumns();
		
		//02.Round를 10회 합니다.
		for(int i = 9 ; i >= 0 ; i--)
		{
			isr.inverseShiftRows(str);
			isb.inverseSubBytes(str);
			xrk.xorTextandKey(str,roundkey.getRoundKey(i));

			imc.inverseMixColumns(str);
			isr.inverseShiftRows(str);
			isb.inverseSubBytes(str);
		}
		
		//03.평문과 key를 XOR합니다.
		xrk.xorTextandKey(str,key);
		System.out.print(">> End Decryption : "); printString(str);

	}
	
	public static void printString(char[][] str)
	{
		System.out.print("[ ");
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				System.out.print(Integer.toHexString(str[i][j]));
				if(!(i == 3 && j == 3))
					System.out.print(":");
			}
		}
		System.out.print(" ] \n");
	}
}
