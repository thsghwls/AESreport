package test;

public class SubBytes {
	private String[][] sb = {
			{"18","99","17","bf","0c","08","04","da","59","a0","2a","7d","7e","7f","7c","43"},
			{"19","9a","16","be","0d","09","e1","d9","58","a1","29","e0","21","20","7b","42"},
			{"69","9b","68","ed","67","66","65","d8","64","f1","63","62","61","e9","7a","60"},
			{"1a","e8","15","bd","fb","9e","f2","d7","57","a2","28","22","af","49","79","ef"},
			{"6a","90","c0","bc","6b","9d","6c","d6","6d","a3","8f","fc","ae","6e","78","6f"},
			{"1b","91","14","bb","c1","9c","03","d5","f7","a4","8e","23","ad","f0","77","41"},
			{"b2","92","ff","ba","0e","0a","e3","d4","56","a5","eb","5a","ac","48","76","40"},
			{"80","93","81","b9","82","83","84","d3","85","a6","86","e5","ab","87","88","89"},
			{"1c","94","13","b8","0f","f9","02","d2","55","a7","8d","5b","aa","47","ee","4a"},
			{"cf","ce","cd","cc","cb","ca","c9","fd","c8","c7","c6","c5","f8","c4","c3","c2"},
			{"05","95","f5","b7","06","07","01","d1","2d","fe","27","5c","a9","e4","75","4b"},
			{"1d","96","12","b6","1f","9f","54","d0","2c","db","8b","24","a8","46","74","4c"},
			{"50","97","51","f6","52","53","f3","2f","2b","dc","8a","25","5d","45","73","4d"},
			{"1e","ec","11","b5","e7","0b","00","2e","ea","dd","8c","26","5e","5f","72","fa"},
			{"b1","98","10","b4","3f","e6","3e","3d","3c","de","3b","f4","3a","e2","71","4e"},
			{"30","b0","31","b3","32","33","34","35","36","df","37","38","39","44","70","4f"},

	};
	public SubBytes(char[][] plainText) {
		int num, row ,column;
		String str;
//		System.out.println("\n>>SubBytes<<");
		for(int i=0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				num = (int)plainText[i][j];
				//			System.out.println("plainText : " + Integer.toHexString(num));
				row = (num & 0xf0)>>4;
			//		System.out.println("row : " + Integer.toHexString(row));
			column = (num & 0x0f);
			//		System.out.println("column : " + Integer.toHexString(column));
			str = sb[row][column];
			row = Integer.parseInt(String.valueOf(str.charAt(0)),16);
			column = Integer.parseInt(String.valueOf(str.charAt(1)),16);
			num = 0;
			num = (num | row)<<4;
			num = num | column;
			plainText[i][j] = (char)num;
			//		System.out.println("encrypt : " + plainText[i]+"\n");
			}
		}
	}
}
