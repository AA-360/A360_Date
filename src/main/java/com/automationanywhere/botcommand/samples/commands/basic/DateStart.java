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

package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.util.HashMap;
import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.CREDENTIAL;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;


 @BotCommand
 @CommandPkg(label = "DateStart", name = "startSession", description = "Start new session",
 icon = "pkg.svg", node_label = "start session {{sessionName}}|")

 public class DateStart {

     private static final Messages MESSAGES = MessagesFactory
             .getMessages("com.automationanywhere.botcommand.samples.messages");

     @Sessions
     private Map<String, Object> sessions;

     @Execute
     public void init(
             @Idx(index = "1", type = TEXT)
             @Pkg(label = "Session name",default_value_type = STRING, default_value = "Default")
             @NotEmpty String sessionName,
             @Idx(index = "2", type = TEXT)
             @Pkg(label = "Format")
             @NotEmpty String Format
     ) {

         // Check for existing session
         if (sessions.containsKey(sessionName))
             throw new BotCommandException(MESSAGES.getString("xml.SessionNameInUse", sessionName));

         // Do some operation
         Map<String, String> sessionValues = new HashMap<String, String>();
         sessionValues.put("sessionName", sessionName);
         sessionValues.put("format", Format);

         // Create new session
         sessions.put(sessionName, sessionValues);

     }

     public void setSessions(Map<String, Object> sessions) {
         this.sessions = sessions;
     }
 }

