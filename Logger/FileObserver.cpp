#include "FileObserver.hpp"

void FileObserver::printMessage(LogLevel logLevel, string message) {
    cout << "[FILE] " + message << endl;
}
