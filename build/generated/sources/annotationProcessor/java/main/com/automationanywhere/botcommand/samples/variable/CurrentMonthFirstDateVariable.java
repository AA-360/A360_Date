package com.automationanywhere.botcommand.samples.variable;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.toolchain.runtime.variable.SystemVariable;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CurrentMonthFirstDateVariable implements SystemVariable<StringValue> {
  private static final Logger logger = LogManager.getLogger(CurrentMonthFirstDateVariable.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  private final CurrentMonthFirstDate command = new CurrentMonthFirstDate();

  @Deprecated
  public StringValue get() {
    return get(null);
  }

  public StringValue get(GlobalSessionContext globalSessionContext) {
    logger.traceEntry();
    CurrentMonthFirstDate command = new CurrentMonthFirstDate();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    try {
      StringValue result = command.get();
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","get"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
