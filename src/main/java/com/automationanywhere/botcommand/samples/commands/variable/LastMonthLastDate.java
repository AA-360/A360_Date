
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
        description = "Returns last month last date as a String format yyyy-MM-dd",
        name = "LastMonthLastDate",
        label = "",
        variable_return_type = DataType.STRING
)
public class LastMonthLastDate {

    @VariableExecute
    public StringValue get() {

        Date date = Calendar.getInstance().getTime();

        String d = Uteis.DateToString(date,"yyyy-MM-01");

        date = Uteis.StringToDate(d,"yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        c.setTime(date);

        c.add(Calendar.DATE, -1);

        String dt = Uteis.DateToString(c.getTime(),"yyyy-MM-dd");


        return new StringValue(dt);
    }

}
