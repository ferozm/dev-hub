package com.fm.dsa;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DSALogger {
     private static final Logger LOGGER = Logger.getLogger("data-structures-algorithms");

     static {
          LOGGER.setUseParentHandlers(false);

          ConsoleHandler handler = new ConsoleHandler();
          handler.setFormatter(new Formatter() {
               @Override
               public String format(LogRecord record) {
//                    return record.getLevel() + ": " + formatMessage(record) + System.lineSeparator();
                    return "-> " + formatMessage(record) + System.lineSeparator();
               }
          });

          LOGGER.addHandler(handler);
     }

     public static void LOG(Object msg){

          LOGGER.info(String.valueOf(msg));

     }
}
