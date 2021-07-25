package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import java.util.HashMap;
import java.util.Map;

@BotCommand
@CommandPkg(
        label = "DateCalc",
        description = "Returns a date according to a calculation required",
        node_label = "Calculate {{Number}} {{radio}}s from {{RadioDateType}} and assign to {{returnTo}}",
        icon = "pkg.svg",
        name = "Now",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class DateCalc {

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

            @Idx(index = "2", type = TEXT)
            @Pkg(label = "Format Output")
            @NotEmpty
                    String FormatOutput,
            @Idx(index = "3", type = RADIO, options = {
                    @Idx.Option(index ="3.1", pkg = @Pkg(label = "Day", value = "d")),
                    @Idx.Option(index ="3.2", pkg = @Pkg(label = "Month", value = "M")),
                    @Idx.Option(index ="3.3", pkg = @Pkg(label = "Year", value = "y")),
                    @Idx.Option(index ="3.4", pkg = @Pkg(label = "Hour", value = "h")),
                    @Idx.Option(index ="3.5", pkg = @Pkg(label = "Minute", value = "m")),
                    @Idx.Option(index ="3.6", pkg = @Pkg(label = "Second", value = "s"))
            })
            @Pkg(label = "Calculation Type",default_value = "d", default_value_type = STRING)
            @NotEmpty
                    String radio,
            @Idx(index = "4", type = NUMBER)
            @Pkg(label = "Number")
            @NotEmpty
                    Double Number
    ) {

            int qtd2 = Number.intValue();
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            SimpleDateFormat formatterInput = new SimpleDateFormat(FormatInput);
            SimpleDateFormat formatterOutput = new SimpleDateFormat(FormatOutput);

            if(RadioDateType == "date"){
                try {
                    date= formatterInput.parse(DateInput);
                } catch (ParseException e) {
                    throw new BotCommandException(e.getMessage().toString());
                }
            }

            c.setTime(date);

            if (radio == "d"){
                c.add(Calendar.DATE, qtd2);
            }else if(radio == "M"){
                c.add(Calendar.MONTH, qtd2);
            }else if(radio == "y"){
                c.add(Calendar.YEAR, qtd2);
            }else if(radio == "h"){
                c.add(Calendar.HOUR, qtd2);
            }else if(radio == "m"){
                c.add(Calendar.MINUTE, qtd2);
            }else{
                c.add(Calendar.SECOND, qtd2);
            }

            date = c.getTime();
            String strDate = formatterOutput.format(date);

            return new StringValue(strDate);

    }
}
