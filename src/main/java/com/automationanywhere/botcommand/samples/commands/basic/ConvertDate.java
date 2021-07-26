package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.samples.commands.utils.Uteis;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(
        label = "ConvertDate",
        description = "Convert a string date to the required format",
        node_label = "Date to {{FormatOutput}} format and assign to {{returnTo}}",
        icon = "pkg.svg",
        name = "ConvertDate",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class ConvertDate {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = RADIO, options = {
                    @Idx.Option(index ="1.1", pkg = @Pkg(label = "today", value = "today")),
                    @Idx.Option(index ="1.2", pkg = @Pkg(label = "date", value = "date")),
                    @Idx.Option(index ="1.3", pkg = @Pkg(label = "number", value = "numberN")),
                    @Idx.Option(index ="1.4", pkg = @Pkg(label = "numberText", value = "numberT",description = "US format like: 432.00"))
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

            @Idx(index = "1.3.1", type = NUMBER)
            @Pkg(label = "Number:")
            @NotEmpty
                    Double NumberDate,

            @Idx(index = "1.4.1", type = TEXT)
            @Pkg(label = "NumberString")
            @NotEmpty
                    String NumberStr,

            @Idx(index = "2", type = TEXT)
            @Pkg(label = "Format Output")
            @NotEmpty
                    String FormatOutput
    ) {
        Date date;

        if(RadioDateType.equals("date")){
            date = Uteis.StringToDate(DateInput,FormatInput);
        }else if(RadioDateType.equals("today")){
            date = Calendar.getInstance().getTime();
        }else if(RadioDateType.equals("numberN")){
            date = DateUtil.getJavaDate((double) NumberDate);
        }else{
            date = DateUtil.getJavaDate((double) Double.parseDouble(NumberStr));
        }

        String strDate = Uteis.DateToString(date,FormatOutput);

        return new StringValue(strDate);
    }
}
