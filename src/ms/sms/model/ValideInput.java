package ms.sms.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ValideInput {

	private static String Date;

	public static boolean specialSmsCharacter(String code) {
		// if (code.matches("[[0-9]|,|+]+")) // relative expression
		if (code.matches("[*|+|-|?|%|&|#|!|,|:|.|{|}||]+"))
			return true;
		return false;
	}

	public static boolean stringNumericTest3(String code) {
		// if (code.matches("[[0-9]|,|+]+")) // relative expression
		if (code.matches("[[a-z]|[A-Z]|ý|ü|ð|ç|ö|þ|Þ|Ö|Ç|Ð|Ü|I|*|?|-|^|(|)|=|{|}|.|_|:|;|+|/]+"))
			// // relative
			// expression

			return true;
		return false;
	}

	public static boolean stringNumericTest1(String user) {
		try {
			Integer.parseInt(user);
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
		return true;
	}

	public static List<String> splitNumbers(String numbers) {
		System.out.println("cellphone numbers  :" + numbers);
		String altnumber[] = numbers.split(",|  ");
		List<String> altnumbers = new ArrayList<String>();
		for (String str : altnumber) {
			System.out.println(str.trim()); // trim() bastan ve sondan
			altnumbers.add(str);
		}

		return altnumbers;

	}

	public static String sistemTarihiniGetir(String tarihFormati) {
		Calendar takvim = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(tarihFormati);
		return sdf.format(takvim.getTime());
	}

	public static String[] columnName() {
		String[] columnNames = { "paketid", "tarih", "durum", "baslik",
				"kredi", "adet", "basarili", "basarisiz", "zamanasimi",
				"bekleyen", "diger", "iade" };

		return columnNames;
	}

}
