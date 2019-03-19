import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.threeten.extra.YearWeek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStatics {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String s = "2019-1-2";



    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DATE_T_MS_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String DEFAULT_DATE_T_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String[] PATTERNS = new String[] { DEFAULT_DATETIME_FORMAT,
            DEFAULT_DATE_T_FORMAT, DEFAULT_DATE_MS_FORMAT, DEFAULT_DATE_FORMAT,
            DEFAULT_DATE_T_MS_FORMAT };


//    @Test
//    public void parse() {
//        LocalDate d = LocalDate.parse(s,formatter);
//
//        System.out.println(d);
//
//    }

    @Test
    public void p() throws ParseException {
        Date d = DateUtils.parseDate(s, PATTERNS);
        System.out.println(d);

        LocalDate localDate = LocalDate.of(d.getYear() + 1900, d.getMonth()+1 , d.getDay() - 1);
        System.out.println(localDate);
    }



    @Test
    public void s1() throws ParseException {

        String input = "20190318";
        String format = "yyyyMMdd";
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = df.parse(input);

//        Date d = new Date();

        System.out.println(date2WeekNum(date));
    }

    public  int date2WeekNum(Date date) {
        ZonedDateTime now = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.printf("Week %d%n", now.get(IsoFields.WEEK_BASED_YEAR));

        return now.get(IsoFields.WEEK_BASED_YEAR);
    }


    @Test
    public void s2() throws ParseException {


        List<String> dataStrs = Lists.newArrayList("2019-03-16", "2019-03-17", "2019-03-18", "2019-03-19");

        for(String s: dataStrs) {
            Date d = DateUtils.parseDate(s, PATTERNS);
            int wNumber = YearWeek.from(
                    //LocalDate.of(d.getYear() + 1900, d.getMonth()+1 , d.getDay() - 1)
                    Instant.ofEpochMilli(d.getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()
            ).getWeek();

            System.out.println(String.format("%s\t%s", s, wNumber));
        }

    }

    @Test
    public void s4() throws ParseException {
        String content = "2018-12-18\t199\n" +
                "2018-12-19\t177\n" +
                "2018-12-20\t90\n" +
                "2018-12-21\t124\n" +
                "2018-12-22\t1\n" +
                "2018-12-23\t4\n" +
                "2018-12-24\t107\n" +
                "2018-12-25\t170\n" +
                "2018-12-26\t102\n" +
                "2018-12-27\t275\n" +
                "2018-12-28\t123\n" +
                "2018-12-29\t54\n" +
                "2018-12-30\t33\n" +
                "2018-12-31\t3\n" +
                "2019-01-01\t1\n" +
                "2019-1-2\t125\n" +
                "2019-1-3\t194\n" +
                "2019-1-4\t89\n" +
                "2019-1-5\t10\n" +
                "2019-1-6\t0\n" +
                "2019-1-7\t155\n" +
                "2019-1-8\t140\n" +
                "2019-1-9\t442\n" +
                "2019-1-10\t124\n" +
                "2019-1-11\t103\n" +
                "2019-1-12\t45\n" +
                "2019-1-13\t19\n" +
                "2019-1-14\t90\n" +
                "2019-1-15\t199\n" +
                "2019-1-16\t62\n" +
                "2019-1-17\t112\n" +
                "2019-1-18\t109\n" +
                "2019-1-19\t2\n" +
                "2019-1-20\t6\n" +
                "2019-1-21\t194\n" +
                "2019-1-22\t77\n" +
                "2019-1-23\t67\n" +
                "2019-1-24\t268\n" +
                "2019-1-25\t96\n" +
                "2019-1-26\t23\n" +
                "2019-1-27\t1\n" +
                "2019-1-28\t136\n" +
                "2019-1-29\t119\n" +
                "2019-1-30\t256\n" +
                "2019-1-31\t163\n" +
                "2019-2-1\t51\n" +
                "2019-2-2\t21\n" +
                "2019-2-3\t6\n" +
                "2019-2-4\t0\n" +
                "2019-2-5\t0\n" +
                "2019-2-6\t0\n" +
                "2019-2-7\t0\n" +
                "2019-2-8\t0\n" +
                "2019-2-9\t0\n" +
                "2019-2-10\t11\n" +
                "2019-2-11\t39\n" +
                "2019-2-12\t63\n" +
                "2019-2-13\t229\n" +
                "2019-2-14\t80\n" +
                "2019-2-15\t228\n" +
                "2019-2-16\t23\n" +
                "2019-2-17\t1\n" +
                "2019-2-18\t140\n" +
                "2019-2-19\t93\n" +
                "2019-2-20\t256\n" +
                "2019-2-21\t142\n" +
                "2019-2-22\t165\n" +
                "2019-2-23\t16\n" +
                "2019-2-24\t15\n" +
                "2019-2-25\t82\n" +
                "2019-2-26\t90\n" +
                "2019-2-27\t167\n" +
                "2019-2-28\t121\n" +
                "2019-3-1\t98\n" +
                "2019-3-2\t8\n" +
                "2019-3-3\t55\n" +
                "2019-3-4\t158\n" +
                "2019-3-5\t76\n" +
                "2019-3-6\t80\n" +
                "2019-3-7\t72\n" +
                "2019-3-8\t90\n" +
                "2019-3-9\t18\n" +
                "2019-3-10\t4\n" +
                "2019-3-11\t103\n" +
                "2019-3-12\t91\n" +
                "2019-3-13\t78\n" +
                "2019-3-14\t89\n" +
                "2019-3-15\t56\n" +
                "2019-3-16\t10\n" +
                "2019-3-17\t13";


        List<StatistisNumber> statistisNumbers = StatistisNumber.parse(content);
        for(StatistisNumber statistisNumber: statistisNumbers) {
            Date d = DateUtils.parseDate(statistisNumber.date, PATTERNS);
            int wNumber = YearWeek.from(
                    //LocalDate.of(d.getYear() + 1900, d.getMonth()+1 , d.getDay() - 1)
                    Instant.ofEpochMilli(d.getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()
            ).getWeek();

            statistisNumber.weekNumberOfYear = wNumber;
        }

//        statistisNumbers.stream().forEach(s -> {
//            System.out.println(s.toString());
//        });


        Map<Integer, Integer> o = statistisNumbers.stream().collect(Collectors.groupingBy(StatistisNumber::getWeekNumberOfYear,
                Collectors.summingInt(StatistisNumber::getNumber)));

        System.out.println(o);
    }



    @Data
    static class StatistisNumber {
        public static final String format = "%s\t%s\t%s";
        String date;
        int number;
        int weekNumberOfYear;

        public StatistisNumber(String date,int number) {
            this.date = date;
            this.number = number;
        }


        static List<StatistisNumber> parse(String content) {
            String[] lines = content.split("\n");

            List<StatistisNumber> result = new ArrayList<>();
            for (String l: lines) {
                String[] data = l.split("\t");
                result.add(new StatistisNumber(data[0], Integer.parseInt(data[1])));
            }

            return result;
        }

        public String getDate() {
            return date;
        }


        public String toString() {
            return String.format(format, date,weekNumberOfYear, number);
        }


        public int getNumber() {
            return number;
        }

        public int getWeekNumberOfYear() {
            return weekNumberOfYear;
        }
    }


}






