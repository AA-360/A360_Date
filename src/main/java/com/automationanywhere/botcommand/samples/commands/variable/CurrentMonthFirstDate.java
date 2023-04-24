
/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 *
 */
package com.automationanywhere.botcommand.samples.variable;

        import com.automationanywhere.botcommand.data.impl.StringValue;
        import com.automationanywhere.botcommand.samples.commands.utils.Uteis;
        import com.automationanywhere.commandsdk.annotations.BotCommand;
        import com.automationanywhere.commandsdk.annotations.CommandPkg;
        import com.automationanywhere.commandsdk.annotations.VariableExecute;
        import com.automationanywhere.commandsdk.model.DataType;

        import java.util.Calendar;
        import java.util.Date;

/**
 * This example shows how to create an Variable.
 * <p>
 * Here we are returning a static value of one, however more complicated logics to return a computed value can be used.
 *
 * @author Raj Singh Sisodia
 *
 */
@BotCommand(commandType = BotCommand.CommandType.Variable)
@CommandPkg(
        description = "Returns current month first date as a String format yyyy-MM-dd",
        name = "CurrentMonthFirstDate",
        label = "",
        variable_return_type = DataType.STRING
)
public class CurrentMonthFirstDate {

    @VariableExecute
    public StringValue get() {

        Date date = Calendar.getInstance().getTime();

        String d = Uteis.DateToString(date,"yyyy-MM-01");


        return new StringValue(d);
    }

}
