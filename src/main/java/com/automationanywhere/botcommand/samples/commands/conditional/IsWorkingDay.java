package com.automationanywhere.botcommand.samples.commands.conditional;



import static com.automationanywhere.commandsdk.annotations.BotCommand.CommandType.Condition;
import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.samples.commands.basic.DateCalc;
import com.automationanywhere.botcommand.samples.commands.basic.NextWorkingDay;
import com.automationanywhere.botcommand.samples.commands.utils.Uteis;
import com.automationanywhere.botcommand.samples.variable.Yesterday;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.ConditionTest;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * This example shows how to create an Condition.
 * <p>
 * Here we are checking of the provided boolean value is false.
 *
 *
 * @author Raj Singh Sisodia
 *
 */
@BotCommand(commandType = Condition)
@CommandPkg(
        label = "IsWorkingDay",
        name = "IsWorkingDay",
        description = "Checks id date is working date or not.",
        node_label = "Checks if {{date}} is a working day"
)
public class IsWorkingDay {

    @ConditionTest
    public Boolean validate(
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
            List<Value> Vholidays
    ) {

        Date date;
        //============================================================= DATE INPUT
        if(RadioDateType.equals("date")){
            date = Uteis.StringToDate(DateInput,FormatInput);
        }else{
            date = Calendar.getInstance().getTime();
        }
        String dateCompare = Uteis.DateToString(date,"yyyy-MM-dd");


        NextWorkingDay wkd = new NextWorkingDay();
        DateCalc dtc = new DateCalc();
        String dt_1 = dtc.action(RadioDateType,DateInput,FormatInput,"yyyy-MM-dd","d",-1.0).toString();
        String dt_2 = wkd.action("date",dt_1,"yyyy-MM-dd",1.0,IgnoreSaturday,IgnoreSunday,use_holidays,Vholidays,"yyyy-MM-dd").toString();



        return dateCompare.equals(dt_2);
    }

}
