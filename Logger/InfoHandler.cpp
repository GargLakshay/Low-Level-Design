#include "InfoHandler.hpp"
#include <iostream>
using namespace std;

void InfoHandler::handleMessage(LogLevel logLevel, string message, ObservableInterface* observableInterface) {
    if (logLevel == LogLevel::INFO) {
        observableInterface->notifyObserver(logLevel, "INFO " + message);
    }

    if (next != NULL) {
        next->handleMessage(logLevel, message, observableInterface);
    }
}

void InfoHandler::setNext(LogHandler* logHandler) {
    next = logHandler;
}
