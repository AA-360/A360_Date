package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import java.util.HashMap;
import java.util.Map;

@BotCommand
@CommandPkg(label = "DateRef",
        description = "Returns a date according to a calculation required", icon = "pkg.svg", name = "Now",
        return_description = "asdasdas", return_type = STRING, return_required = true)


public class DateRef {

    @Execute
    public StringValue action(
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
            @Pkg(label = "Calculation Type",default_value = "d", default_value_type = STRING)
            @NotEmpty
            String radio,
            @Idx(index = "3", type = NUMBER)
            @Pkg(label = "Number")
            @NotEmpty
            Double Number
    ) {
            //if (true)
            //    return new StringValue(radio);
            int qtd2 = Number.intValue();
            Date date = new Date();
            Calendar c = Calendar.getInstance();
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
            DateFormat dateFormat = new SimpleDateFormat(Format);  
            String strDate = dateFormat.format(date);

            return new StringValue(strDate);

    }
}
