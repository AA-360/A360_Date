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

public final class DateRefCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(DateRefCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    DateRef command = new DateRef();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("Format") && parameters.get("Format") != null && parameters.get("Format").get() != null) {
      convertedParameters.put("Format", parameters.get("Format").get());
      if(convertedParameters.get("Format") !=null && !(convertedParameters.get("Format") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","Format", "String", parameters.get("Format").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("Format") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","Format"));
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
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("Format"),(String)convertedParameters.get("radio"),(Double)convertedParameters.get("Number")));
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
