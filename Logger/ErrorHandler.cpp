#include "ErrorHandler.hpp"
#include <iostream>
using namespace std;

void ErrorHandler::handleMessage(LogLevel logLevel, string message, ObservableInterface* observableInterface) {
    if (logLevel == LogLevel::ERROR) {
        observableInterface->notifyObserver(logLevel, "ERROR " + message);
    }

    if (next != NULL) {
        next->handleMessage(logLevel, message, observableInterface);
    }
}

void ErrorHandler::setNext(LogHandler* logHandler) {
    next = logHandler;
}