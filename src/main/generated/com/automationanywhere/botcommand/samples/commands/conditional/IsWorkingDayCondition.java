package com.automationanywhere.botcommand.samples.commands.conditional;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.Condition;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.Boolean;
import java.lang.ClassCastException;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class IsWorkingDayCondition implements Condition {
  private static final Logger logger = LogManager.getLogger(IsWorkingDayCondition.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  public boolean test(Map<String, Value> parameters) {
    return test(null, parameters, null);
  }

  public boolean test(GlobalSessionContext globalSessionContext, Map<String, Value> parameters,
      Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    IsWorkingDay command = new IsWorkingDay();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("RadioDateType") && parameters.get("RadioDateType") != null && parameters.get("RadioDateType").get() != null) {
      convertedParameters.put("RadioDateType", parameters.get("RadioDateType").get());
      if(convertedParameters.get("RadioDateType") !=null && !(convertedParameters.get("RadioDateType") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","RadioDateType", "String", parameters.get("RadioDateType").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("RadioDateType") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","RadioDateType"));
    }
    if(convertedParameters.get("RadioDateType") != null) {
      switch((String)convertedParameters.get("RadioDateType")) {
        case "today" : {

        } break;
        case "date" : {
          if(parameters.containsKey("DateInput") && parameters.get("DateInput") != null && parameters.get("DateInput").get() != null) {
            convertedParameters.put("DateInput", parameters.get("DateInput").get());
            if(convertedParameters.get("DateInput") !=null && !(convertedParameters.get("DateInput") instanceof String)) {
              throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","DateInput", "String", parameters.get("DateInput").get().getClass().getSimpleName()));
            }
          }
          if(convertedParameters.get("DateInput") == null) {
            throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","DateInput"));
          }

          if(parameters.containsKey("FormatInput") && parameters.get("FormatInput") != null && parameters.get("FormatInput").get() != null) {
            convertedParameters.put("FormatInput", parameters.get("FormatInput").get());
            if(convertedParameters.get("FormatInput") !=null && !(convertedParameters.get("FormatInput") instanceof String)) {
              throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","FormatInput", "String", parameters.get("FormatInput").get().getClass().getSimpleName()));
            }
          }
          if(convertedParameters.get("FormatInput") == null) {
            throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","FormatInput"));
          }


        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","RadioDateType"));
      }
    }

    if(parameters.containsKey("IgnoreSaturday") && parameters.get("IgnoreSaturday") != null && parameters.get("IgnoreSaturday").get() != null) {
      convertedParameters.put("IgnoreSaturday", parameters.get("IgnoreSaturday").get());
      if(convertedParameters.get("IgnoreSaturday") !=null && !(convertedParameters.get("IgnoreSaturday") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","IgnoreSaturday", "Boolean", parameters.get("IgnoreSaturday").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("IgnoreSaturday") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","IgnoreSaturday"));
    }

    if(parameters.containsKey("IgnoreSunday") && parameters.get("IgnoreSunday") != null && parameters.get("IgnoreSunday").get() != null) {
      convertedParameters.put("IgnoreSunday", parameters.get("IgnoreSunday").get());
      if(convertedParameters.get("IgnoreSunday") !=null && !(convertedParameters.get("IgnoreSunday") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","IgnoreSunday", "Boolean", parameters.get("IgnoreSunday").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("IgnoreSunday") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","IgnoreSunday"));
    }

    if(parameters.containsKey("use_holidays") && parameters.get("use_holidays") != null && parameters.get("use_holidays").get() != null) {
      convertedParameters.put("use_holidays", parameters.get("use_holidays").get());
      if(convertedParameters.get("use_holidays") !=null && !(convertedParameters.get("use_holidays") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","use_holidays", "Boolean", parameters.get("use_holidays").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("use_holidays") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","use_holidays"));
    }
    if(convertedParameters.get("use_holidays") != null && (Boolean)convertedParameters.get("use_holidays")) {
      if(parameters.containsKey("Vholidays") && parameters.get("Vholidays") != null && parameters.get("Vholidays").get() != null) {
        convertedParameters.put("Vholidays", parameters.get("Vholidays").get());
        if(convertedParameters.get("Vholidays") !=null && !(convertedParameters.get("Vholidays") instanceof List)) {
          throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","Vholidays", "List", parameters.get("Vholidays").get().getClass().getSimpleName()));
        }
      }
      if(convertedParameters.get("Vholidays") == null) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","Vholidays"));
      }

    }

    try {
      boolean result = command.validate((String)convertedParameters.get("RadioDateType"),(String)convertedParameters.get("DateInput"),(String)convertedParameters.get("FormatInput"),(Boolean)convertedParameters.get("IgnoreSaturday"),(Boolean)convertedParameters.get("IgnoreSunday"),(Boolean)convertedParameters.get("use_holidays"),(List<Value>)convertedParameters.get("Vholidays"));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","validate"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(), e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
