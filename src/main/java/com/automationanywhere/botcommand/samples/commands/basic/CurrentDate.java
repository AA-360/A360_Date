package com.automationanywhere.botcommand.samples.commands.basic;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  



//@BotCommand
@CommandPkg(
        label = "CurrentDate",
        description = "Returns current date according to the required format",
        node_label = "",
        icon = "pkg.svg",
        name = "CurrentDate",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class CurrentDate {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Format")
            @NotEmpty String Format

    ) {
        try{ 
            
            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat(Format);  
            String strDate = dateFormat.format(date);

            return new StringValue(strDate);
        }
        catch(Exception e){
            throw new BotCommandException(e.getMessage());
        }    
    }
}
