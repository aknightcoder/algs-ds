package problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class TwentyFourHourTime {

    public String timeConversion(String timeString) {

        if(!isValidInputTime(timeString))
            return "Invalid time value.";

        boolean isAm = timeString.substring(timeString.length() - 2).equals("AM");

        timeString = timeString.substring(0, timeString.length() - 2);

        String[] timeIncrements = timeString.split(":");

        int hours = Integer.valueOf(timeIncrements[0]);
        if(isAm){
            if (hours == 12)
                timeIncrements[0] = "00";

        }else {
            if (hours != 12) {
                int offset = 12;
                int twentyFourHours = offset + hours;
                timeIncrements[0] = Integer.toString(twentyFourHours);
            }
        }

        return String.format("%s:%s:%s", timeIncrements[0], timeIncrements[1], timeIncrements[2]);
    }

    private static boolean isValidInputTime(String timeString){

        if(timeString.isEmpty()) return false;

        DateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ssa");

        try{
            simpleDateFormat.parse(timeString);
        }
        catch(ParseException e){
            return false;
        }

        return true;
    }
}
