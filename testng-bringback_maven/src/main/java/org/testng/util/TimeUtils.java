package org.testng.util;

import org.testng.internal.RuntimeBehavior;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/** A Utility class that deals with time. */
public final class TimeUtils {
  private TimeUtils() {}

  /**
   * @param timeInMilliSeconds - The time in milliseconds
   * @param format - A format that can be used by {@link SimpleDateFormat}
   * @return - A formatted string representation of the time in the timezone as obtained via {@link
   *     RuntimeBehavior#getTimeZone()}
   */
  public static String formatTimeInLocalOrSpecifiedTimeZone(
      long timeInMilliSeconds, String format) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    TimeZone timeZone = RuntimeBehavior.getTimeZone();
    sdf.setTimeZone(timeZone);
    return sdf.format(timeInMilliSeconds);
  }
}
