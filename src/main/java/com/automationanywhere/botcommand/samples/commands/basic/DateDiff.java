package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.*;

import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;
import static com.automationanywhere.commandsdk.model.DataType.NUMBER;

import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;


@BotCommand
@CommandPkg(label = "DateDiff",
        description = "Returns the difference between dates", icon = "pkg.svg", name = "DateDiff",
        return_description = "asdasdas", return_type = NUMBER, return_required = true)


public class DateDiff {

    @Execute
    public NumberValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Format")
            @NotEmpty String Format,

            @Idx(index = "2", type = RADIO, options = {
                    @Idx.Option(index ="2.1", pkg = @Pkg(label = "Day", value = "d")),
                    @Idx.Option(index ="2.2", pkg = @Pkg(label = "Month", value = "M")),
                    @Idx.Option(index ="2.3", pkg = @Pkg(label = "Year", value = "y")),
                    @Idx.Option(index ="2.4", pkg = @Pkg(label = "Hour", value = "h")),
                    @Idx.Option(index ="2.5", pkg = @Pkg(label = "Minute", value = "m")),
                    @Idx.Option(index ="2.6", pkg = @Pkg(label = "Second", value = "s"))
            })
            @Pkg(label = "Difference in:",default_value = "d", default_value_type = STRING)
            String radio,
            @Idx(index = "3", type = TEXT)
            @Pkg(label = "Date1")
            @NotEmpty String Date1,
            @Idx(index = "4", type = TEXT)
            @Pkg(label = "Date2")
            @NotEmpty String Date2
    ) {


            SimpleDateFormat formatter = new SimpleDateFormat(Format);
            Date dt1,dt2;
            try {
                dt1= formatter.parse(Date1);
                dt2= formatter.parse(Date2);
            } catch (ParseException e) {
                throw new BotCommandException(e.getMessage().toString());
            }


            LocalDateTime dTime1 = dt1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime dTime2 = dt2.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            long diff = 0;

            if (radio == "d")
                diff = dTime1.until(dTime2, ChronoUnit.DAYS);
            else if(radio == "M")
                diff = dTime1.until(dTime2, ChronoUnit.MONTHS);
            else if(radio == "y")
                diff = dTime1.until(dTime2, ChronoUnit.YEARS);
            else if(radio == "h")
                diff = dTime1.until(dTime2, ChronoUnit.HOURS);
            else if(radio == "m")
                diff = dTime1.until(dTime2, ChronoUnit.MINUTES);
            else
                diff = dTime1.until(dTime2, ChronoUnit.SECONDS);


            return new NumberValue(diff);

    }
}
