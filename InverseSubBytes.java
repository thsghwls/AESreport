package test;

public class InverseSubBytes {
	private String[][] isb = {
			{"d6","a6","86","56","06","a0","a4","a5","05","15","65","d5","04","14","64","84"},
			{"e2","d2","b2","82","52","32","12","02","00","10","30","50","80","b0","d0","b4"},
			{"1d","1c","3b","5b","bb","cb","db","aa","3a","1a","0a","c8","b8","a8","d7","c7"},
			{"f0","f2","f4","f5","f6","f7","f8","fa","fb","fc","ec","ea","e8","e7","e6","e4"},
			{"6f","5f","1f","0f","fd","cd","bd","8d","6d","3d","8f","af","bf","cf","ef","ff"},
			{"c0","c2","c4","c5","b6","88","68","38","18","08","6b","8b","ab","cc","dc","dd"},
			{"2f","2c","2b","2a","28","26","25","24","22","20","40","44","46","48","4d","4f"},
			{"fe","ee","de","ce","be","ae","6e","5e","4e","3e","2e","1e","0e","0b","0c","0d"},
			{"70","72","74","75","76","78","7a","7d","7e","7f","ca","ba","da","8a","5a","4a"},
			{"41","51","61","71","81","a1","b1","c1","e1","01","11","21","55","45","35","b5"},
			{"09","19","39","49","59","69","79","89","bc","ac","8c","7c","6c","5c","4c","3c"},
			{"f1","e0","60","f3","e3","d3","b3","a3","83","73","63","53","43","33","13","03"},
			{"42","54","9f","9e","9d","9b","9a","99","98","96","95","94","93","92","91","90"},
			{"b7","a7","87","77","67","57","47","37","27","17","07","b9","c9","d9","e9","f9"},
			{"1b","16","ed","66","ad","7b","e5","d4","31","2d","d8","6a","d1","23","8e","3f"},
			{"5d","29","36","c6","eb","a2","c3","58","9c","85","df","34","4b","97","a9","62"}
	};
	public InverseSubBytes(char[][] cipherText) {
		int num, row ,column;
		String str;
//		System.out.println("\n>>InverseSubBytes<<");
		for(int i=0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				num = (int)cipherText[i][j];
				//			System.out.println("cipherText : " + Integer.toHexString(num));
				row = (num & 0xf0)>>4;
			//		System.out.println("row : " + Integer.toHexString(row));
			column = (num & 0x0f);
			//		System.out.println("column : " + Integer.toHexString(column));
			str = isb[row][column];
			row = Integer.parseInt(String.valueOf(str.charAt(0)),16);
			column = Integer.parseInt(String.valueOf(str.charAt(1)),16);
			num = 0;
			num = (num | row)<<4;
			num = num | column;
			cipherText[i][j] = (char)num;
			//		System.out.println("decrypt : " + cipherText[i]+"\n");
			}
		}
	}
}
