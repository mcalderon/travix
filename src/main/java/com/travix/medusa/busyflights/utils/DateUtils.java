package com.travix.medusa.busyflights.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class DateUtils {

    public static boolean areDatesEqual(LocalDate dateA, LocalDate dateB) {
        return dateA.isEqual(dateB);
    }

    public static boolean areDatesEqual(String dateA, String dateB) {
        return DateUtils.areDatesEqual(
            parseStringDate(dateA), parseStringDate(dateB)
        );
    }

    public static LocalDate parseStringDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException ex) {
            return LocalDateTime.parse(date).toLocalDate();
        }
    }
}
