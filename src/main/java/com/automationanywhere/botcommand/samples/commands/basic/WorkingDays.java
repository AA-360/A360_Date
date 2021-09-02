package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.utils.Uteis;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(
        label = "WorkingDays",
        name = "WorkingDays",
        description = "Get next working day by add/substract a number of days",
        node_label = "Get {{days}} days from {{RadioDateType}} and assign to {{returnTo}} ",
        icon = "pkg.svg",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class WorkingDays {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = RADIO, options = {
                    @Idx.Option(index ="1.1", pkg = @Pkg(label = "today", value = "today")),
                    @Idx.Option(index ="1.2", pkg = @Pkg(label = "date", value = "date"))
            })
            @Pkg(label = "Calculate from:",default_value = "today", default_value_type = STRING)
            @NotEmpty
                    String RadioDateType,
            @Idx(index = "1.2.1", type = TEXT)
            @Pkg(label = "Date")
            @NotEmpty
                    String DateInput,
            @Idx(index = "1.2.2", type = TEXT)
            @Pkg(label = "Format Input")
            @NotEmpty
                    String FormatInput,
            @Idx(index = "2", type = NUMBER)
            @Pkg(label = "Days")
            @NotEmpty
                    Double days,
            @Idx(index = "3", type = CHECKBOX)
            @Pkg(label = "Ignore Saturday:",default_value = "true",default_value_type = DataType.BOOLEAN)
            @NotEmpty
                    Boolean IgnoreSaturday,
            @Idx(index = "4", type = CHECKBOX)
            @Pkg(label = "Ignore Sunday:",default_value = "true",default_value_type = DataType.BOOLEAN)
            @NotEmpty
                    Boolean IgnoreSunday,
            @Idx(index = "5", type = CHECKBOX)
            @Pkg(label = "HolyDays:",description = "hollidays to ignore")
            @NotEmpty
                    Boolean use_holidays,
            @Idx(index = "5.1", type = LIST)
            @Pkg(label = "HolyDays:",description = "List of hollidays date format migth be yyyy-MM-dd")
            @NotEmpty
                    List<Value> Vholidays,
            @Idx(index = "6", type = TEXT)
            @Pkg(label = "Format Output")
            @NotEmpty
                    String FormatOutput
    ) {

        Date date;
        Calendar cal = Calendar.getInstance();
        List<String> holidays = new ArrayList<>();

        //============================================================= DATE INPUT
        if(RadioDateType.equals("date")){
            date = Uteis.StringToDate(DateInput,FormatInput);
        }else{
            date = Calendar.getInstance().getTime();
        }
        //System.out.println("dateIn:" + Uteis.DateToString(date,"yyyy-MM-dd"));
        cal.setTime(date);
        //=========================================================== NUMBER OF DAYS
        Integer addDay = days<0?-1:1;
        days = days<0?Math.abs(days):days;
        //=========================================================== HOLLYDAYS
        if(use_holidays) {
            for (Value v : Vholidays) {
                Uteis.StringToDate(v.toString(), "yyyy-MM-dd");      //VALIDATING DATE FORMAT
                holidays.add(v.toString());
            }
        }
        //========================================================== CALCULATE
        while(days>0){
            cal.add(Calendar.DATE,addDay);
            int dayOfWeek  = cal.get(Calendar.DAY_OF_WEEK);
            String dateStr = Uteis.DateToString(cal.getTime(),"yyyy-MM-dd");
            if((dayOfWeek == 7 && IgnoreSaturday) || (dayOfWeek == 1 && IgnoreSunday) || holidays.contains(dateStr)){
                continue;
            }
            days --;
        }

        String strDate = Uteis.DateToString(cal.getTime(),FormatOutput);

        return new StringValue(strDate);
    }
}
