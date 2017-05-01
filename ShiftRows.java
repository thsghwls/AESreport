package AESreport;

public class ShiftRows 
{

	public ShiftRows()
	{

	}

	public ShiftRows(char[][] plainText)
	{

		for(int i = 1 ; i < 4 ; i++)
		{
			int shift = 0;
			//shift에 row를 저장
			for(int j = 3 ; j >= 0 ; j--) 
			{
				shift = (shift | ((0x00FF&plainText[i][3-j])<<j*8));
			}
			
			//저장된 row를 순서에 맞게 분배
			for(int j = 0 ; j < 4 ; j++)
			{
				plainText[i][j] = (char)(0x000000FF&(shift >> ((3-j+i)%4)*8));
			}
		}
	}
	public void shiftRows(char[][] plainText)
	{
		for(int i = 1 ; i < 4 ; i++)
		{
			int shift = 0;
			//shift에 row를 저장
			for(int j = 3 ; j >= 0 ; j--) 
			{
				shift = (shift | ((0x00FF&plainText[i][3-j])<<j*8));
			}
			
			//저장된 row를 순서에 맞게 분배
			for(int j = 0 ; j < 4 ; j++)
			{
				plainText[i][j] = (char)(0x000000FF&(shift >> ((3-j+i)%4)*8));
			}
		}
	}
}
