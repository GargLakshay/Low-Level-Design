#pragma once

#include <string>
#include "LogLevel.hpp"
#include "ObservableInterface.hpp"
using namespace std;

class LogHandler {
  public:
    virtual void handleMessage(LogLevel logLevel, string message, ObservableInterface* observableInterface) = 0;
    virtual void setNext(LogHandler* LogHandler) = 0;
};