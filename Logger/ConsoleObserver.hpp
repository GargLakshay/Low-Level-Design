#pragma once
#include "Observer.hpp"
#include "LogLevel.hpp"

class ConsoleObserver: public Observer {
    void printMessage(LogLevel logLevel, string message) override;
};