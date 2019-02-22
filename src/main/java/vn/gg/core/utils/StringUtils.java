package vn.gg.core.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {

	public static String unAccent(String s) {
		if (s != null && !"".equals(s)) {
			String temp = Normalizer.normalize(s.toLowerCase(), Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			String result = pattern.matcher(temp).replaceAll("").replaceAll("đ", "d").replaceAll("[^a-zA-Z0-9 -]", "");
			return result.replace(" +", " ");
		}
		return "";
	}
	
	public static String replaceVietnameseLetter(String str_) {
		String value = str_ == null ? "" : str_.trim();
		String lower = value.toLowerCase();
		lower = lower.replaceAll(",", " ");
		lower = lower.replaceAll("[à,á,ạ,ả,ã,â,ầ,ấ,ậ,ẩ,ẫ,ă,ằ,ắ,ặ,ẳ,ẵ]", "a");
		lower = lower.replaceAll("[đ]", "d");
		lower = lower.replaceAll("[è,é,ẹ,ẻ,ẽ,ê,ề,ế,ệ,ể,ễ]", "e");
		lower = lower.replaceAll("[ì,í,ị,ỉ,ĩ]", "i");
		lower = lower.replaceAll("[ò,ó,ọ,ỏ,õ,ô,ồ,ố,ộ,ổ,ỗ,ơ,ờ,ớ,ợ,ở,ỡ]", "o");
		lower = lower.replaceAll("[ù,ú,ụ,ủ,ũ,ư,ừ,ứ,ự,ử,ữ]", "u");
		lower = lower.replaceAll("[ỳ,ý,ỵ,ỷ,ỹ]", "y");
		return lower;
	}
	
}
