package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.content.SharedPreferences;

public class Utility {

	public Utility() {
		// TODO Auto-generated constructor stub
	}

	// ���ڵ�ת������
	private int getCurrentcount() {
		// ����Ĭ���Լ���15����Ĭ�Ͽ�ѧʱ����15.9.1���ģ�֮��ᴫ������
		String S15before = "Wed Sep 1 09:22:14 �������α�׼ʱ��+0800 2015";
		Date d1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd", Locale.CHINA);

		Date dNow = formatDate2(d1.toString());
		Date d15 = formatDate2(S15before);

		long count = (dNow.getTime() - d15.getTime());
		count = count / 24 / 60 / 60 / 1000;
		count = count * 100 / 1399;
		int c = (int) count;
		return c;
	}

	public static Date formatDate2(String dateStr) {
		String[] aStrings = dateStr.split(" ");
		// 5
		if (aStrings[1].equals("Jan")) {
			aStrings[1] = "01";
		}
		if (aStrings[1].equals("Feb")) {
			aStrings[1] = "02";
		}
		if (aStrings[1].equals("Mar")) {
			aStrings[1] = "03";
		}
		if (aStrings[1].equals("Apr")) {
			aStrings[1] = "04";
		}
		if (aStrings[1].equals("May")) {
			aStrings[1] = "05";
		}
		if (aStrings[1].equals("Jun")) {
			aStrings[1] = "06";
		}
		if (aStrings[1].equals("Jul")) {
			aStrings[1] = "07";
		}
		if (aStrings[1].equals("Aug")) {
			aStrings[1] = "08";
		}
		if (aStrings[1].equals("Sep")) {
			aStrings[1] = "09";
		}
		if (aStrings[1].equals("Oct")) {
			aStrings[1] = "10";
		}
		if (aStrings[1].equals("Nov")) {
			aStrings[1] = "11";
		}
		if (aStrings[1].equals("Dec")) {
			aStrings[1] = "12";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = aStrings[5] + "-" + aStrings[1] + "-" + aStrings[2] + " "
				+ aStrings[3];
		Date datetime = null;
		try {
			datetime = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime;
	}

	public int getCurrentYear() {//��������   ��λ��   ���ڵ���   
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String s = year.substring(year.length() - 2, year.length());
		int currentYear = Integer.valueOf(s);
		return currentYear;
	}

	public int getAccountYear(String account) {//�������֣�����λ��   ����ǰ�˺Ŷ�Ӧ����
		String s = account.substring(0, 2);
		int year = Integer.valueOf(s);
		return year;
	}

	public static boolean isNumeric(String str) {//�ж��ǲ��������ȫ������
		if (str.matches("\\d*"))
			return true;
		else
			return false;
	}

	public boolean isOK(String s) {
		if (!isNumeric(s)) {// ����û�����Ĳ������֣�����false
			return false;
		} else if (getCurrentYear() == getAccountYear(s)// �������˺ŵ�����ͬһ�꣬�����Ǵ�һ������
				|| getCurrentYear() == getAccountYear(s) + 1// ������˺ŵ����һ�꣬�����Ǵ�һ�����ģ�
				|| getCurrentYear() == getAccountYear(s) + 2// ������˺ŵ�������꣬�����Ǵ��������ģ�
				|| getCurrentYear() == getAccountYear(s) + 3// ������˺ŵ�������꣬�����Ǵ�������ĵģ�
				|| getCurrentYear() == getAccountYear(s) + 4// ������˺ŵ�������꣬�����Ǵ��ĵĻ��Ѿ���ҵ��
				|| getCurrentYear() > getAccountYear(s)) {////�����ӵģ���ҵ֮��Ҳ�����ã�����������  ֻҪ�����ѧ�ŵ����Ϳ���     �����͵Ļ����Ȳ�������
			return true;
		}
		return false;
	}
}
