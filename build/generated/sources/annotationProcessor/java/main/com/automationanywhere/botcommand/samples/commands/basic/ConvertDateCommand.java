package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
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

public final class ConvertDateCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(ConvertDateCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    ConvertDate command = new ConvertDate();
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

    if(parameters.containsKey("FormatOut") && parameters.get("FormatOut") != null && parameters.get("FormatOut").get() != null) {
      convertedParameters.put("FormatOut", parameters.get("FormatOut").get());
      if(convertedParameters.get("FormatOut") !=null && !(convertedParameters.get("FormatOut") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","FormatOut", "String", parameters.get("FormatOut").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("FormatOut") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","FormatOut"));
    }

    if(parameters.containsKey("Date1") && parameters.get("Date1") != null && parameters.get("Date1").get() != null) {
      convertedParameters.put("Date1", parameters.get("Date1").get());
      if(convertedParameters.get("Date1") !=null && !(convertedParameters.get("Date1") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","Date1", "String", parameters.get("Date1").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("Date1") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","Date1"));
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("Format"),(String)convertedParameters.get("FormatOut"),(String)convertedParameters.get("Date1")));
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
