#include "DebugHandler.hpp"
#include <iostream>
using namespace std;

void DebugHandler::handleMessage(LogLevel logLevel, string message) {
    if (logLevel == LogLevel::DEBUG) {
        cout << "DEBUG " + message << endl;
    }

    if (next != NULL) {
        next->handleMessage(logLevel, message);
    }
}

void DebugHandler::setNext(LogHandler* logHandler) {
    next = logHandler;
}