package com.techacademy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
    @RequestMapping("/dayofweek/{dateStr}")
    public String dispDayOfWeek(@PathVariable String dateStr) throws ParseException {
        Date date = null;
        String[] week_name = { "日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日" };
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        int youbi = cal.get(Calendar.DAY_OF_WEEK);
        return year + "年" + month + "月" + day + "日は" + week_name[youbi - 1] + "です";
    }

    @RequestMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果は" + res + "です";
    }

    @RequestMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果は" + res + "です";
    }

    @RequestMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        long res = 0L;
        res = (long) val1 * (long) val2;
        return "計算結果は" + res + "です";
    }

    @RequestMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        float res = 0.0f;
        res = (float) val1 / (float) val2;
        return "計算結果は" + res + "です";
    }
}
