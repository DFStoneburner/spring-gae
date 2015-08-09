package stone.spring.utils;

import java.util.Calendar;
import java.util.Date;

public class RandomDate {
	private RandomDate() {
	}

	public static Date next() {
		Calendar calendar = Calendar.getInstance();
		calendar.roll(Calendar.DAY_OF_MONTH, -1 * (int) Math.random());
		return calendar.getTime();
	}
}
