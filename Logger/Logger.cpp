#include<iostream>
#include "Logger.hpp"
#include "LoggerConfiguration.hpp"
using namespace std;

LogHandler *Logger::logHandler = LoggerConfiguration::build();

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
    logHandler->handleMessage(logLevel, message);
}