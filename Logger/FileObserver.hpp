#pragma once
#include "Observer.hpp"
#include "LogLevel.hpp"

class FileObserver: public Observer {
    void printMessage(LogLevel logLevel, string message) override;
};