#include<iostream>
#include "Logger.hpp"
#include "LoggerConfiguration.hpp"
#include "ConsoleObserver.hpp"
#include "FileObserver.hpp"
using namespace std;

LogHandler *Logger::logHandler = LoggerConfiguration::build();
ObservableInterface *Logger::observableInterface = Logger::buildObservableInterface();

void Logger::i(string message) {
    logMessage(LogLevel::INFO, message);
}
void Logger::d(string message) {
    logMessage(LogLevel::DEBUG, message);
}

void Logger::e(string message) {
    logMessage(LogLevel::ERROR, message);
}


void Logger::logMessage(LogLevel logLevel, string message) {
    logHandler->handleMessage(logLevel, message, observableInterface);
}

ObservableInterface *Logger::buildObservableInterface() {
    ObservableInterface* observableInterface = new ObservableInterface();
    Observer* consoleObserver = new ConsoleObserver();
    Observer* fileObserver = new FileObserver();

    observableInterface->addObserver(LogLevel::INFO, consoleObserver);

    observableInterface->addObserver(LogLevel::DEBUG, fileObserver);

    observableInterface->addObserver(LogLevel::ERROR, consoleObserver);
    observableInterface->addObserver(LogLevel::ERROR, fileObserver);

    return observableInterface;
}