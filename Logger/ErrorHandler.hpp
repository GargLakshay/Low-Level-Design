#pragma once
#include "LogHandler.hpp"
#include "LogLevel.hpp"
#include "ObservableInterface.hpp"
using namespace std;

class ErrorHandler: public LogHandler {
    LogHandler *next = NULL;
    void handleMessage(LogLevel logLevel, string message, ObservableInterface* observableInterface) override;
    void setNext(LogHandler* logHandler) override;
};
