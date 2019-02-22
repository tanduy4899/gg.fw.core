package vn.gg.core.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtils {

	public static LocalDateTime localDateTimeNow() {
		Instant instant = Instant.now();
		ZoneId zoneId_Asia = ZoneId.of( "Asia/Ho_Chi_Minh");
		ZonedDateTime zdt_Asia = ZonedDateTime.ofInstant(instant , zoneId_Asia);
		return zdt_Asia.toLocalDateTime();
	}
}
