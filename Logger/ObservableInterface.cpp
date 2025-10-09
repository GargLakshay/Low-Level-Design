#include "ObservableInterface.hpp"
using namespace std;

void ObservableInterface::addObserver(LogLevel logLevel, Observer* observer) {
    mp[logLevel].insert(observer);
}
void ObservableInterface::notifyObserver(LogLevel logLevel, string message) {
    for (auto observer : mp[logLevel]) {
        observer->printMessage(logLevel, message);
    }
}
