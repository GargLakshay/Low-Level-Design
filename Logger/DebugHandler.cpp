#include "DebugHandler.hpp"
#include <iostream>
using namespace std;

void DebugHandler::handleMessage(LogLevel logLevel, string message, ObservableInterface* observableInterface) {
    if (logLevel == LogLevel::DEBUG) {
        observableInterface->notifyObserver(logLevel, "DEBUG " + message);
    }

    if (next != NULL) {
        next->handleMessage(logLevel, message, observableInterface);
    }
}

void DebugHandler::setNext(LogHandler* logHandler) {
    next = logHandler;
}