package AESreport;

public class InverseShiftRows 
{
	
	public InverseShiftRows() 
	{
		
	}
	
	public InverseShiftRows(char[][] cipherText)
	{
		for(int i = 1 ; i < 4 ; i++) 
		{
			int shift = 0;
			for(int j = 3 ; j >= 0 ; j--) 
			{
				shift = (shift | ((0x00FF&cipherText[i][3-j])<<j*8));
			}
			for(int j = 0 ; j < 4 ; j++) 
			{
				cipherText[i][j] = (char)(0x000000FF&(shift >> ((3-j-i)%4)*8));
			}
		}
	}
	
	public void inverseShiftRows(char[][] cipherText)
	{
		for(int i = 1 ; i < 4 ; i++) 
		{
			int shift = 0;
			for(int j = 3 ; j >= 0 ; j--) 
			{
				shift = (shift | ((0x00FF&cipherText[i][3-j])<<j*8));
			}
			for(int j = 0 ; j < 4 ; j++) 
			{
				cipherText[i][j] = (char)(0x000000FF&(shift >> ((3-j-i)%4)*8));
			}
		}
	}
}
