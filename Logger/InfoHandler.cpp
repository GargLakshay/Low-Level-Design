#include "InfoHandler.hpp"
#include <iostream>
using namespace std;

void InfoHandler::handleMessage(LogLevel logLevel, string message) {
    if (logLevel == LogLevel::INFO) {
        //here we have to direct the logs
        //to multiple outputs.
        cout << "INFO " + message << endl;
    }

    if (next != NULL) {
        next->handleMessage(logLevel, message);
    }
}

void InfoHandler::setNext(LogHandler* logHandler) {
    next = logHandler;
}
