package org.example.tdd;

public class TimeConverter {
    private final static double SECONDS_PER_MINUTE = 60;
    private final static double MINUTES_PER_HOUR = 60;
    private final static double HOURS_PER_DAY = 24;
    private final static int MINUTES_PER_DAY = 3600;

    public double secondsToMinutes(double seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Cannot convert negative seconds");
        }
        return seconds / SECONDS_PER_MINUTE;
    }
    public double minutesToSeconds(double minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Cannot convert negative minutes");
        }
        return minutes * SECONDS_PER_MINUTE;
    }
    public double minutesToHours(double minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Cannot convert negative minutes");
        }
        return minutes / MINUTES_PER_HOUR;
    }
    public double hoursToMinutes(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Cannot convert negative hours");
        }
        return hours * MINUTES_PER_HOUR;
    }
    public double hoursToDays(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Cannot convert negative hours");
        }
        return hours / HOURS_PER_DAY;
    }
    public double daysToHours(double days) {
        if (days < 0) {
        throw new IllegalArgumentException("Cannot convert negative days");
    }
        return days * HOURS_PER_DAY;
    }
    public String formatTime(int totalSeconds) {
        if (totalSeconds < 0) throw new IllegalArgumentException("Cannot convert negative seconds");

        int hours = totalSeconds / MINUTES_PER_DAY;
        int minutes = (totalSeconds % MINUTES_PER_DAY)/ (int) SECONDS_PER_MINUTE;
        int seconds = (totalSeconds % MINUTES_PER_DAY) % (int) SECONDS_PER_MINUTE;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    public int parseTime(String time) {
        if (time == null) throw new IllegalArgumentException("Time string cannot be null");
        String[] parts = time.split(":");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid time format");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * MINUTES_PER_DAY + minutes * (int) MINUTES_PER_HOUR + seconds;
    }
}
