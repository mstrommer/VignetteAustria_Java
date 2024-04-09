package oop.polymorph;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String dateInString = "01-01-2024";
        Date date = formatter.parse(dateInString);
        VignetteBase av = new AnnualVignette(date, "pkw", "W334342");
        System.out.println(av.validUntil());
        System.out.println(av.isExpired());
    }
}