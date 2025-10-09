#pragma once
#include "LogHandler.hpp"

class LoggerConfiguration {
  private:
    LoggerConfiguration() {

    }

  public:
    static LogHandler *infoHandler;
    static LogHandler *errorHandler;
    static LogHandler *debugHandler;
    static LogHandler *build();
};

