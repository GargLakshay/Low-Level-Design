#include "ConsoleObserver.hpp"

void ConsoleObserver::printMessage(LogLevel logLevel, string message) {
    cout << "[CONSOLE] " + message << endl;
}
