#pragma once
#include<string>
#include "LogHandler.hpp"
using namespace std;
class Logger {

  private:
    Logger() {

    }
    static LogHandler *logHandler;
  public:
    static void i(string message);

    static void d(string message);

    static void e(string message);

    static void logMessage(LogLevel logLevel, string message);
};
