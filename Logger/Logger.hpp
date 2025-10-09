#pragma once
#include<string>
#include "LogHandler.hpp"
#include "ObservableInterface.hpp"
using namespace std;
class Logger {

  private:
    Logger() {

    }
    static LogHandler *logHandler;
    static ObservableInterface *observableInterface;
  public:
    static void i(string message);

    static void d(string message);

    static void e(string message);

    static void logMessage(LogLevel logLevel, string message);

    static ObservableInterface *buildObservableInterface();
};
