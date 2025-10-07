#include "LogHandler.hpp"
#include "LoggerConfiguration.hpp"
#include "InfoHandler.hpp"
#include "ErrorHandler.hpp"
#include "DebugHandler.hpp"
using namespace std;

LogHandler *LoggerConfiguration::infoHandler = new InfoHandler();
LogHandler *LoggerConfiguration::errorHandler = new ErrorHandler();
LogHandler *LoggerConfiguration::debugHandler = new DebugHandler();

LogHandler *LoggerConfiguration::build() {
    infoHandler->setNext(errorHandler);
    errorHandler->setNext(debugHandler);
    return infoHandler;
}
