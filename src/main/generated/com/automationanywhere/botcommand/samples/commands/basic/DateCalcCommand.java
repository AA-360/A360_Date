package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DateCalcCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(DateCalcCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    DateCalc command = new DateCalc();
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

    if(parameters.containsKey("FormatOutput") && parameters.get("FormatOutput") != null && parameters.get("FormatOutput").get() != null) {
      convertedParameters.put("FormatOutput", parameters.get("FormatOutput").get());
      if(convertedParameters.get("FormatOutput") !=null && !(convertedParameters.get("FormatOutput") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","FormatOutput", "String", parameters.get("FormatOutput").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("FormatOutput") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","FormatOutput"));
    }

    if(parameters.containsKey("radio") && parameters.get("radio") != null && parameters.get("radio").get() != null) {
      convertedParameters.put("radio", parameters.get("radio").get());
      if(convertedParameters.get("radio") !=null && !(convertedParameters.get("radio") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","radio", "String", parameters.get("radio").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("radio") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","radio"));
    }
    if(convertedParameters.get("radio") != null) {
      switch((String)convertedParameters.get("radio")) {
        case "d" : {

        } break;
        case "M" : {

        } break;
        case "y" : {

        } break;
        case "h" : {

        } break;
        case "m" : {

        } break;
        case "s" : {

        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","radio"));
      }
    }

    if(parameters.containsKey("Number") && parameters.get("Number") != null && parameters.get("Number").get() != null) {
      convertedParameters.put("Number", parameters.get("Number").get());
      if(convertedParameters.get("Number") !=null && !(convertedParameters.get("Number") instanceof Double)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","Number", "Double", parameters.get("Number").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("Number") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","Number"));
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("RadioDateType"),(String)convertedParameters.get("DateInput"),(String)convertedParameters.get("FormatInput"),(String)convertedParameters.get("FormatOutput"),(String)convertedParameters.get("radio"),(Double)convertedParameters.get("Number")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
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
