package com.gurkan.dms.util;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

public class DMSUtil {
    private static final String DEFAULT_USER = "TEST";

    private DMSUtil() {}

    /**
     * Sessiondaki kullanici bilgisini verir
     *
     * @param input decode halindeki yazi
     *
     * @return String
     */
    public static String encodeBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    /**
     * Sessiondaki kullanici bilgisini verir
     *
     * @param input encode halindeki yazi
     *
     * @return String
     */
    public static String decodeBase64(String input) {
        return new String(Base64.getDecoder().decode(input));
    }

    /**
     * Suanki tarihi verir
     *
     * @return LocalDate
     */
    public static LocalDate dateNow() {
        return LocalDate.now();
    }

    /**
     * Suanki zamani verir
     *
     * @return LocalTime
     */
    public static LocalTime timeNow() {
        return LocalTime.now();
    }

    /**
     * Sessiondaki kullanici bilgisini verir
     *
     * @return String
     */
    public static String sessionUser() {
        return DEFAULT_USER;
    }

    /**
     * 2 tarih arasındaki farkı verir
     *
     * @param startDate baslangic tarihi
     * @param endDate   bitis tarihi
     *
     * @return Period
     */
    public static Period difference(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate);
    }

    /**
     * 2 zaman arasındaki farkı verir
     *
     * @param startTime baslangic zamani
     * @param endTime   bitis zamani
     *
     * @return Duration
     */
    public static Duration difference(LocalTime startTime, LocalTime endTime) {
        return Duration.between(startTime, endTime);
    }

    /**
     * Tarih ve Zamanı birlestirir.
     *
     * @param date tarih
     * @param time zaman
     *
     * @return LocalDateTime
     */
    public static LocalDateTime toDateTime(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

    /**
     * verilen birim kadar sonrasini bulur. Orn. 2 ay sonra 10 yil sonra vb.
     *
     * @param date       tarih
     * @param chronoUnit birim
     *
     * @return LocalDate
     */
    public static LocalDate nUnitLater(LocalDate date, int n, ChronoUnit chronoUnit) {
        return date.plus(n, chronoUnit);
    }
}
