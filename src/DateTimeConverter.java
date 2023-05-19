import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {
    public static LocalDateTime convertToUTC() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime localZonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        ZonedDateTime utcZonedDateTime = localZonedDateTime.withZoneSameInstant(ZoneOffset.UTC);
        return utcZonedDateTime.toLocalDateTime();
    }

    public static LocalDateTime convertFromUTC() {
        LocalDateTime utcDateTime = LocalDateTime.now(ZoneOffset.UTC);
        ZonedDateTime utcZonedDateTime = utcDateTime.atZone(ZoneOffset.UTC);
        ZonedDateTime localZonedDateTime = utcZonedDateTime.withZoneSameInstant(ZoneId.systemDefault());
        return localZonedDateTime.toLocalDateTime();
    }

    public static void main(String[] args) {
        LocalDateTime utcDateTime = convertToUTC();
        LocalDateTime localDateTime = convertFromUTC();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
        System.out.println("**********************************************************************************");
        System.out.println();
        System.out.println("Current Local Date and Time: " + LocalDateTime.now().format(formatter));
        System.out.println("**********************************************************************************");
        System.out.println();

        String pattern ="|__   __/ __ \\           | |  | |__   __/ ____| \n" +
                "    | | | |  | |  ______  | |  | |  | | | |      \n" +
                "    | | | |  | | |______| | |  | |  | | | |      \n" +
                "    | | | |__| |          | |__| |  | | | |____  \n" +
                "    |_|  \\____/            \\____/   |_|  \\_____| \n" +
                "                                                ";

        System.out.println(pattern);
        System.out.println("UTC Date and Time: " + utcDateTime.format(formatter));
        System.out.println("****************************************************************");
        System.out.println();
        String pattern2 = "  _______ ____             _      ____   _____          _      \n" +
                " |__   __/ __ \\           | |    / __ \\ / ____|   /\\   | |     \n" +
                "    | | | |  | |  ______  | |   | |  | | |       /  \\  | |     \n" +
                "    | | | |  | | |______| | |   | |  | | |      / /\\ \\ | |     \n" +
                "    | | | |__| |          | |___| |__| | |____ / ____ \\| |____ \n" +
                "    |_|  \\____/           |______\\____/ \\_____/_/    \\_\\______|\n" +
                "                                                               \n" +
                "                                                              ";
        System.out.println(pattern2);
        System.out.println("Converted Local Date and Time: " + localDateTime.format(formatter));
    }
}
