#pragma once
#include "LogHandler.hpp"
#include "LogLevel.hpp"
using namespace std;

class DebugHandler: public LogHandler {
    LogHandler *next = NULL;
    void handleMessage(LogLevel logLevel, string message) override;
    void setNext(LogHandler* logHandler) override;
};
