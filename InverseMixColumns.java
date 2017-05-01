package AESreport;

public class InverseMixColumns
{
//	private int[][] imc = {
//			{14, 11, 13, 9},
//			{9, 14, 11, 13},
//			{13, 9, 14, 11},
//			{11, 13, 9, 14}
//	};

	public InverseMixColumns()
	{
		
	}
	
	public InverseMixColumns(char[][] cipherText)
	{
		int temp;
		
		for(int i = 0 ; i < 4 ; i++)
		{
			temp = 0x00000000;
			for(int j = 0 ; j < 4 ; j++)
			{
				temp = temp | ((mul(cipherText[j][i],0x0e))
						^mul(cipherText[(j+1)%4][i],0x0b)
						^mul(cipherText[(j+2)%4][i],0x0d)
						^mul(cipherText[(j+3)%4][i],0x09))<<((3-j)*8);
			}
			
			for(int k = 3 ; k >= 0 ; k--)
			{
				cipherText[k][i] = (char)(temp&0x000000FF);
				temp >>=8;
			}
		}
	}

	public void inverseMixColumns(char[][] cipherText)
	{
		int temp;
		
		for(int i = 0 ; i < 4 ; i++)
		{
			temp = 0x00000000;
			for(int j = 0 ; j < 4 ; j++)
			{
				temp = temp | ((mul(cipherText[j][i],0x0e))
						^mul(cipherText[(j+1)%4][i],0x0b)
						^mul(cipherText[(j+2)%4][i],0x0d)
						^mul(cipherText[(j+3)%4][i],0x09))<<((3-j)*8);
			}
			
			for(int k = 3 ; k >= 0 ; k--)
			{
				cipherText[k][i] = (char)(temp&0x000000FF);
				temp >>=8;
			}
		}
	}
	private int mul(char c, int b)
	{
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
		{
			a = a<<1;
		}
		sum &= 0xFF; //이게 없어서 자꾸 수가 틀림
		}
		return sum;
	}
}