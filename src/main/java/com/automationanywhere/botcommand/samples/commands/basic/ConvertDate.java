package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(label = "ConvertDate",
        description = "Convert a string date to the required format", icon = "pkg.svg", name = "ConvertDate",
        return_description = "", return_type = STRING, return_required = true)


public class ConvertDate {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Format Input")
            @NotEmpty String Format,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "Format Output")
            @NotEmpty String FormatOut,
            @Idx(index = "3", type = TEXT)
            @Pkg(label = "Date1")
            @NotEmpty String Date1
    ) {
        try{
            DateFormat dateFormat = new SimpleDateFormat(Format);
            DateFormat dateFormatOut = new SimpleDateFormat(FormatOut);
            Date date = dateFormat.parse(Date1);
            String out = dateFormatOut.format(date);

            return new StringValue(out);
        }
        catch(Exception ex){
            return new StringValue(ex.getMessage());
        }    
    }
}
