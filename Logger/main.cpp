#include<iostream>
#include "Logger.hpp"
#include "TimeStamp.hpp"
using namespace std;

int main() {
    Logger::i(TimeStamp::getTimestamp() + " This is info log");
    Logger::d(TimeStamp::getTimestamp() + " This is debug log");
    Logger::e(TimeStamp::getTimestamp() + " This is error log");
}