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
        case "numberN" : {
          if(parameters.containsKey("NumberDate") && parameters.get("NumberDate") != null && parameters.get("NumberDate").get() != null) {
            convertedParameters.put("NumberDate", parameters.get("NumberDate").get());
            if(convertedParameters.get("NumberDate") !=null && !(convertedParameters.get("NumberDate") instanceof Double)) {
              throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","NumberDate", "Double", parameters.get("NumberDate").get().getClass().getSimpleName()));
            }
          }
          if(convertedParameters.get("NumberDate") == null) {
            throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","NumberDate"));
          }


        } break;
        case "numberT" : {
          if(parameters.containsKey("NumberStr") && parameters.get("NumberStr") != null && parameters.get("NumberStr").get() != null) {
            convertedParameters.put("NumberStr", parameters.get("NumberStr").get());
            if(convertedParameters.get("NumberStr") !=null && !(convertedParameters.get("NumberStr") instanceof String)) {
              throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","NumberStr", "String", parameters.get("NumberStr").get().getClass().getSimpleName()));
            }
          }
          if(convertedParameters.get("NumberStr") == null) {
            throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","NumberStr"));
          }


        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","RadioDateType"));
      }
    }

    if(parameters.containsKey("opt_output") && parameters.get("opt_output") != null && parameters.get("opt_output").get() != null) {
      convertedParameters.put("opt_output", parameters.get("opt_output").get());
      if(convertedParameters.get("opt_output") !=null && !(convertedParameters.get("opt_output") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","opt_output", "String", parameters.get("opt_output").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("opt_output") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","opt_output"));
    }
    if(convertedParameters.get("opt_output") != null) {
      switch((String)convertedParameters.get("opt_output")) {
        case "custom" : {
          if(parameters.containsKey("FormatOutput") && parameters.get("FormatOutput") != null && parameters.get("FormatOutput").get() != null) {
            convertedParameters.put("FormatOutput", parameters.get("FormatOutput").get());
            if(convertedParameters.get("FormatOutput") !=null && !(convertedParameters.get("FormatOutput") instanceof String)) {
              throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","FormatOutput", "String", parameters.get("FormatOutput").get().getClass().getSimpleName()));
            }
          }
          if(convertedParameters.get("FormatOutput") == null) {
            throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","FormatOutput"));
          }


        } break;
        case "epoch" : {

        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","opt_output"));
      }
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("RadioDateType"),(String)convertedParameters.get("DateInput"),(String)convertedParameters.get("FormatInput"),(Double)convertedParameters.get("NumberDate"),(String)convertedParameters.get("NumberStr"),(String)convertedParameters.get("opt_output"),(String)convertedParameters.get("FormatOutput")));
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
