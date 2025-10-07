#pragma once
#include<string>
#include "LogHandler.hpp"
using namespace std;


class InfoHandler: public LogHandler {
    LogHandler *next = nullptr;

  public:
    void handleMessage(LogLevel logLevel, string message) override;
    void setNext(LogHandler* logHandler) override;
};
