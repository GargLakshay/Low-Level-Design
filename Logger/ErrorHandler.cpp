#include "ErrorHandler.hpp"
#include <iostream>
using namespace std;

void ErrorHandler::handleMessage(LogLevel logLevel, string message) {
    if (logLevel == LogLevel::ERROR) {
        cout << "ERROR " + message << endl;
    }

    if (next != NULL) {
        next->handleMessage(logLevel, message);
    }
}

void ErrorHandler::setNext(LogHandler* logHandler) {
    next = logHandler;
}