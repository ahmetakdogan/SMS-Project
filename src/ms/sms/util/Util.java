package ms.sms.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

	private static final String USER = "HAKANAYDIN28";
	private static final String PWD = "fethifethi28";
	private static String xml = "<?xml version='1.0' encoding='utf-8'?><smsorig ka='"
			+ USER + "' pwd='" + PWD + "'/>";
	private static String link = "https://smsgw.mutlucell.com/smsgw-ws/gtorgex";
	private static String link1 = "https://smsgw.mutlucell.com/smsgw-ws/gtcrdtex";
	private static String xml1 = "<?xml version='1.0' encoding='utf-8'?><smskredi ka='"
			+ USER + "' pwd='" + PWD + "'/>";
	private static String linkSend = "https://smsgw.mutlucell.com/smsgw-ws/sndblkex";
	private static String linkBulk = "https://smsgw.mutlucell.com/smsgw-ws/gtblkrprtex";
	private static int gidenSmsId;
	private static String linkRapor = "https://smsgw.mutlucell.com/smsgw-ws/gtsummaryex";
	private static String xmlRapor = "<?xml version='1.0' encoding='UTF-8'?><gonrapor ka='"
			+ USER
			+ "' pwd='"
			+ PWD
			+ "' tarih='2014-07-19 14:30' bitis='2014-07-23 13:40' />";

	public static List getOrig() throws Exception {

		String result = HTTPUtil.httppost(link, xml);
		List orig = new ArrayList();
		String[] getOrig = result.split("\t");

		for (String or : getOrig) {
			orig.add(or);
			System.out.println("or: " + or);
		}

		return orig;

	}

	public static double getCredit() throws Exception {

		String result = HTTPUtil.httppost(link1, xml1);
		System.out.println("getcredit : "
				+ Double.valueOf(result.substring(1)).intValue());
		return Double.valueOf(result.substring(1)).intValue();

	}

	public static Double sendSms(String message, List origi,
			List<String> numbers) throws Exception {

		try {
			String result;
			System.out.println("numbers : " + numbers);

			String xml = "<?xml version='1.0' encoding='utf-8'?><smspack  ka='"
					+ USER + "' pwd='" + PWD + "' org='" + origi.get(0)
					+ "'><mesaj><metin>" + xmlEncode(message)
					+ "</metin><nums>" + numbers + "</nums></mesaj></smspack>";
			result = HTTPUtil.httppost(linkSend, xml);
			System.out.println(xml);
			System.out.println("sms");
			System.out.println(origi);
			System.out.println("utilresult :" + result);

			String kalanKontor[] = {};
			if (result.startsWith("$")) {
				kalanKontor = result.split("#");
				return Double.parseDouble(kalanKontor[1]);
			}

			if (result.equals("20")) {
				throw new RuntimeException("Post edilen xml eksik veya hatalý!");
			} else if (result.equals("21")) {
				throw new RuntimeException(
						"Kullanýlan originatöre sahip deðilsiniz!");
			} else if (result.equals("22")) {
				throw new RuntimeException("Kontörünüz yetersiz!");
			} else if (result.equals("23")) {
				throw new RuntimeException(
						"Kullanýcý adý ya da parolanýz hatalý!");
			} else if (result.equals("24")) {
				throw new RuntimeException(
						"Þu anda size ait baþka bir iþlem aktif!");
			} else if (result.equals("25")) {
				throw new RuntimeException(
						" iþlemi 1-2 dk sonra tekrar deneyin!");
			} else if (result.equals("30")) {
				throw new RuntimeException("Hesap Aktivasyonu saðlanmamýþ!");
			}

		} catch (Exception e) {
			throw e;

		}
		return 0.0;

	}

	public static String[] getBulk() throws Exception {

		int id = gidenSmsId;// GÃ¶nderilen paketin ID si

		String xml = "<?xml version='1.0' encoding='utf-8'?><smsrapor ka='"
				+ USER + "' pwd='" + PWD + "' id='" + id + "'/>";

		String result = HTTPUtil.httppost(linkBulk, xml);
		System.out.println("resultgetbulk : " + result);
		// String[] report = result.split("\t");

		return result.split("\t");
		// return null;
	}

	public static Object[][] Rapor() throws Exception {

		String result = HTTPUtil.httppost(linkRapor, xmlRapor);
		// System.out.println("resultgetbulk : \n" + result);
		String[] report = result.split("\t|\n");// hem satýr hem de

		Object[][] rapors = new Object[report.length / 12][12];

		int counter = 0;
		for (int i = 0; i < report.length / 12; i++) {

			for (int j = 0; j < 12; j++) {
				String str = report[counter];
				if (j == 2) {
					rapors[i][j] = durum(str);
				} else

					rapors[i][j] = str;

				counter++;
			}
		}

		return rapors;
	}

	private static String xmlEncode(String s) {
		s = s.replace("&", "&amp;");
		s = s.replace("<", "&lt;");
		s = s.replace(">", "&gt;");
		s = s.replace("'", "&apos;");
		s = s.replace("\"", "&quot;");
		return s;
	}

	public static String durum(String gondermeDurumu) {
		System.out.println("drum metodu");
		String str = null;
		switch (Integer.parseInt(gondermeDurumu)) {
		case 2:
			str = "BEKLEMEDE";
			break;

		case 3:
			str = "GÖNDERÝLDÝ";
			break;

		case 4:
			str = "ÝPTAL EDÝLDÝ";
			break;
		default:
			break;
		}

		return str;
	}

}
