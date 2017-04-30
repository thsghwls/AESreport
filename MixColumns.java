package test;

public class MixColumns {
	//	private int[][] mc = {
	//			{2, 3, 1, 1},
	//			{1, 2, 3, 1},
	//			{1, 1, 2, 3},
	//			{3, 1, 1, 2}
	//	};

	public MixColumns(char[][] plainText) {
//		System.out.println("\n>>MixColumns<<");
		int temp;
		for(int i = 0 ; i < 4; i++)
		{
			temp = 0x00000000;
			for(int j = 0; j < 4 ; j++)
			{
				temp |=(  mul(plainText[j]		[i],0x02)
						^ mul(plainText[(j+1)%4][i],0x03)
						^ plainText[(j+2)%4]	[i]
								^ plainText[(j+3)%4]	[i] 	 
						)  <<((3-j)*8);
				//				if(i==1){
				//					System.out.println(Integer.toBinaryString(mul(plainText[j]		[i],0x02)));
				//					System.out.println(Integer.toBinaryString(mul(plainText[(j+1)%4][i],0x03)));
				//					System.out.println(Integer.toBinaryString(plainText[(j+2)%4]	[i]));
				//					System.out.println(Integer.toBinaryString(plainText[(j+3)%4]	[i]));
				//					System.out.println(Integer.toBinaryString(temp));
				//				}
			}
			for(int k = 3 ; k >=0 ; k--)
			{
				plainText[k][i] = (char)(temp & 0x000000FF);
				temp >>= 8;
			}
		}
	}

	private int mul(char c, int b) {
		int sum = 0;
		int a = c;
		for(int i = 0 ; i < 4 ; i++)
		{
			if((b & 0x01) == 0x01)
			{
				sum ^= a;
			}
			b = b>>1;
		if((a&0x80)==0x80)
		{
			a=a<<1;
			a=a^0x1b;
		}
		else
			a = a<<1;
		}
		sum &= 0xFF;
		return sum;
	}
}
//	for(int i = 0 ; i < 4 ; i++)
//	{
//		int[] buf = { (int)plainText[0][i] , (int)plainText[1][i] , (int)plainText[2][i] , (int)plainText[3][i] };
//
//		System.out.println(Integer.toHexString(buf[0])+","+Integer.toHexString(buf[1])+
//				","+Integer.toHexString(buf[2])+","+Integer.toHexString(buf[3]));
//		for(int j = 0 ; j < 4 ; j++)
//		{
//			int sum = 0;
//			for(int k = 0 ; k < 4 ; k++)
//			{
//				if(mc[j][k] == 1) {
//					System.out.println("1인경우 : "+Integer.toHexString(buf[k]));
//					sum ^= buf[k];
//				}
//				else if(mc[j][k] == 2) {
//					System.out.println("2인경우 : "+Integer.toHexString(((buf[k]<<1)^0x1B)&0xFF));
//					sum ^= ((buf[k]<<1)^0x1B)&0xFF;
//				}
//				else if(mc[j][k] == 3) {	
//					System.out.println(Integer.toHexString(2*buf[k]) + "+"
//							+ Integer.toHexString(buf[k])
//							+ " = " + Integer.toHexString((2*buf[k])^(buf[k])));
//					sum ^= ((2*buf[k])^(buf[k]));
//				}
//			}
//			plainText[j][i] = (char)sum;
//			System.out.println("plainText["+j+"]["+i+"] :"+Integer.toHexString(plainText[j][i]));
//		}
//	}
//		for(int i = 0 ; i < 4 ; i++)
//		{
//			int[] buf = { (int)plainText[0][i] , (int)plainText[1][i] , (int)plainText[2][i] , (int)plainText[3][i] };
//
//			System.out.println(Integer.toHexString(buf[0])+","+Integer.toHexString(buf[1])+
//					","+Integer.toHexString(buf[2])+","+Integer.toHexString(buf[3]));
//			for(int j = 0 ; j < 4 ; j++)
//			{
//				int sum = 0;
//				for(int k = 0 ; k < 4 ; k++)
//				{
//					if(mc[j][k] != 3) {
//						System.out.println(Integer.toHexString(mc[j][k]*buf[k]));
//						sum ^= mc[j][k]*buf[k];
//					}
//					else if(mc[j][k]==3) {	
//						System.out.println(Integer.toHexString(2*buf[k]) + "+"
//								+ Integer.toHexString(buf[k])
//								+ " = " + Integer.toHexString((2*buf[k])^(buf[k])));
//						sum ^= ((2*buf[k])^(buf[k]));
//					}
//				}
//				plainText[j][i] = (char)sum;
//				System.out.println("plainText["+j+"]["+i+"] :"+Integer.toHexString(plainText[j][i]));
//			}
//		}
//		for(int i = 0 ; i < 4 ; i++)
//		{
//			int[] buf = { (int)plainText[0][i] , (int)plainText[1][i] , (int)plainText[2][i] , (int)plainText[3][i] };
//			for(int j = 0 ; j < 4 ; j++)
//			{
//				int sum = 0;
//				for(int k = 0 ; k < 4 ; k++)
//				{
//					if(mc[j][k]!=3)
//					{
//						sum ^= 0xFF&(buf[k]<<(mc[j][k]-1));
//					}
//					else
//					{
//						sum ^= 0xFF&(buf[k]<<1);
//						sum ^= 0xFF&(buf[k]);
//					}
//				}
//				plainText[j][i] = (char)sum;
//			}
//		}
//}
//		// plainText의 1행 1열 2행 1열 3행 1열 4행 1열을 가지고 mc의 1행 1열 1행 2열 1행 3열 1행 4열을 곱해 1행 1열에 넣는다.
//		for(int i = 0 ; i < 4 ; i++) {
//			System.out.printf(">>I %d회 <<\n", i+1);
//			for (int j = 0 ; j < 4 ; j++) {
//				System.out.printf(">>J %d회 <<\n", j+1);
//				//				System.out.print(plainText[j][i]);
//			}
//			for(int k = 0 ; k < 4 ; k++){
//				System.out.printf(">>K %d회 <<\n", k+1);
//				for(int p = 0 ; p < 4 ; p++) {
//					System.out.printf(">>P %d회 <<\n", p+1);
//					//					System.out.print(mc[k][p]);
//				}
//				//				System.out.println(" / ");
//			}
//			//			System.out.println("\n");
//		}
//	}