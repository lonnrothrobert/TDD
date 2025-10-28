import org.example.tdd.TimeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeConverterTest {
    private TimeConverter converter;
    @BeforeEach
    public void setUp() {
        converter = new TimeConverter();
    }
    @Nested
    @DisplayName("Seconds to Minutes Conversion")
    public class SecondsToMinutesTests{
        @Test
        @DisplayName("Should convert 60 seconds to 1 minute")
        public void shouldConvert60SecondsTo1Minute()
        {
            double seconds = 60;
            assertEquals(1, converter.secondsToMinutes(seconds));
        }
        @Test
        @DisplayName("Should convert 120 seconds to 2 minutes")
        public void shouldConvert120SecondsTo2Minutes()
        {
            double seconds = 120;
            assertEquals(2, converter.secondsToMinutes(seconds));
        }
        @Test
        @DisplayName("Should convert 90 seconds to 1.5 minutes")
        public void shouldConvert90SecondsTo1Minute()
        {
            double seconds = 90;
            assertEquals(1.5, converter.secondsToMinutes(seconds));
        }
        @Test
        @DisplayName("Should throw exception for negative seconds")
        public void shouldThrowExceptionForNegative(){
            double seconds = -1;
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> converter.secondsToMinutes(seconds)
            );
            assertEquals("Cannot convert negative seconds", exception.getMessage());

        }

    }
    @Nested
    @DisplayName("Minutes to Seconds Conversion")
    public class MinutesToSecondsTests{
        @Test
        @DisplayName("Should convert 1 minute to 60 seconds")
        public void shouldConvert1MinutesTo60Seconds()
        {
            double minutes = 1;
            assertEquals(60, converter.minutesToSeconds(minutes));
        }
        @Test
        @DisplayName("Should convert 2.5 minutes to 150 seconds")
        public void shouldConvert2point5MinutesTo150Seconds()
        {
            double minutes = 2.5;
            assertEquals(150, converter.minutesToSeconds(minutes));
        }
        @Test
        @DisplayName("Should maintain value through round-trip conversion")
        public void maintainValueThroughRoundTripConversion()
        {
            double minutes = 1.456456;
            assertEquals(1.456456, converter.secondsToMinutes(converter.minutesToSeconds(minutes)));
        }

    }
    @Nested
    @DisplayName("Minutes to Hours Conversion")
    public class MinutesToHoursTests{
        @Test
        @DisplayName("Should convert 60 minutes to 1 hour")
        public void shouldConvert60MinutesTo1Hour()
        {
            double minutes = 60;
            assertEquals(1, converter.minutesToHours(minutes));
        }
        @Test
        @DisplayName("Should convert 120 minutes to 2 hours")
        public void shouldConvert120MinutesTo2Hours()
        {
            double minutes = 120;
            assertEquals(2, converter.minutesToHours(minutes));
        }
        @Test
        @DisplayName("Should convert 90 minutes to 1.5 hours")
        public void shouldConvert90MinutesTo1Hour()
        {
            double minutes = 90;
            assertEquals(1.5, converter.minutesToHours(minutes));
        }

    }
    @Nested
    @DisplayName("Hours to Minutes Conversion")
    public class HoursToMinutesTests{
        @Test
        @DisplayName("Should convert 1 hour to 60 minutes")
        public void shouldConvert1hoursTo60Minutes()
        {
            double hours = 1;
            assertEquals(60, converter.hoursToMinutes(hours));
        }
        @Test
        @DisplayName("Should convert 2.5 hours to 150 minutes")
        public void shouldConvert2point5MinutesTo150Minutes()
        {
            double hours = 2.5;
            assertEquals(150, converter.hoursToMinutes(hours));
        }
        @Test
        @DisplayName("Should maintain value through round-trip conversion")
        public void shouldMaintainValueThroughRoundTripConversion()
        {
            double hours = 3;
            assertEquals(3, converter.minutesToHours(converter.hoursToMinutes(hours)));
        }

    }
    @Nested
    @DisplayName("Hours to Days Conversion")
    public class HoursToDaysTests{
        @Test
        @DisplayName("Should convert 24 hours to 1 day")
        public void shouldConvert24hoursTo1Day()
        {
            double hours = 24;
            assertEquals(1, converter.hoursToDays(hours));
        }
        @Test
        @DisplayName("Should convert 48 hours to 2 days")
        public void shouldConvert48hoursTo2Days()
        {
            double hours = 48;
            assertEquals(2, converter.hoursToDays(hours));
        }
        @Test
        @DisplayName("Should convert 12 hours to 0.5 days")
        public void shouldConvert12hoursTo1Day()
        {
            double hours = 12;
            assertEquals(0.5, converter.hoursToDays(hours));
        }

    }
    @Nested
    @DisplayName("Days to Hours Conversion")
    public class DaysToHoursTests{
        @Test
        @DisplayName("Should convert 1 day to 24 hours")
        public void shouldConvert1dayTo24Hours()
        {
            double days = 1;
            assertEquals(24, converter.daysToHours(days));
        }
        @Test
        @DisplayName("Should convert 7 days (1 week) to 168 hours")
        public void shouldConvert7daysTo168Hours()
        {
            double days = 7;
            assertEquals(168, converter.daysToHours(days));
        }

    }
    @Nested
    @DisplayName("Time Formatting as HH:MM:SS")
    public class TimeFormattingTests {
        @Test
        @DisplayName("Should format 3661 seconds as 01:01:01")
        public void shouldFormat3661SecondsAs01_01_01()
        {
            int seconds = 3661;
            assertEquals("01:01:01", converter.formatTime(seconds));
        }
        @Test
        @DisplayName("Should format 3600 seconds as 01:00:00")
        public void shouldFormat3600SecondsAs01_01_00()
        {
            int seconds = 3600;
            assertEquals("01:00:00", converter.formatTime(seconds));
        }
        @Test
        @DisplayName("Should format 90 seconds as 00:01:30")
        public void shouldFormat90SecondsAs00_01_30()
        {
            int seconds = 90;
            assertEquals("00:01:30", converter.formatTime(seconds));
        }
        @Test
        @DisplayName("Should format 0 seconds as 00:00:00")
        public void shouldFormat0SecondsAs00_00()
        {
            int seconds = 0;
            assertEquals("00:00:00", converter.formatTime(seconds));
        }

    }
    @Nested
    @DisplayName("Time Parsing from HH:MM:SS")
    public class TimeParsingTests {
        @Test
        @DisplayName("Should parse '01:01:01' to 3661 seconds")
        public void shouldParse01_01_01_01As3661Seconds()
        {
            String time = "01:01:01";
            assertEquals(3661, converter.parseTime(time));
        }
        @Test
        @DisplayName("Should parse '01:00:00' to 3600 seconds")
        public void shouldParse01_00_00As3600Seconds()
        {
            String time = "01:00:00";
            assertEquals(3600, converter.parseTime(time));
        }
        @Test
        @DisplayName("Should parse '00:01:30' to 90 seconds")
        public void shouldParse00_01_30As90()
        {
            String time = "00:01:30";
            assertEquals(90, converter.parseTime(time));
        }
        @Test
        @DisplayName("Should maintain value through format and parse round-trip")
        public void shouldMaintainValueRoundTripConversion()
        {
            String time = "00:01:30";
            assertEquals("00:01:30", converter.formatTime(converter.parseTime(time)));
        }
        @Test
        @DisplayName("Should throw exception for null input")
        public void shouldThrowExceptionForNullInput()
        {
            String time = null;
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> converter.parseTime(time)
            );
            assertEquals("Time string cannot be null", exception.getMessage());
        }
        @Test
        @DisplayName("Should throw exception for invalid format")
        public void shouldThrowExceptionForInvalidFormat()
        {
            String time = "01:01:01:01";
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> converter.parseTime(time)
            );
            assertEquals("Invalid time format", exception.getMessage());
        }

    }
}
