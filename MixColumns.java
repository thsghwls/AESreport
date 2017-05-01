package AESreport;

public class MixColumns
{
	//	private int[][] mc = {
	//			{2, 3, 1, 1},
	//			{1, 2, 3, 1},
	//			{1, 1, 2, 3},
	//			{3, 1, 1, 2}
	//	};

	public MixColumns()
	{

	}

	public MixColumns(char[][] plainText)
	{
		//교재보고 했음. 어려움
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
		sum &= 0xFF; //이게 없으니 carry가 발생하여 잘못된 결과 출력
		return sum;
	}
	public void mixColumns(char[][] plainText) {
		//교재보고 했음. 어려움
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
			}
			for(int k = 3 ; k >=0 ; k--)
			{
				plainText[k][i] = (char)(temp & 0x000000FF);
				temp >>= 8;
			}
		}
	}
}