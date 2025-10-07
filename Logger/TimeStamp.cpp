#include <iostream>
#include <chrono>
#include <iomanip>
#include <ctime>
#include <TimeStamp.hpp>
using namespace std;

string TimeStamp::getTimestamp() {
    auto now = chrono::system_clock::now();
    time_t t = chrono::system_clock::to_time_t(now);
    tm localTime;
#ifdef _WIN32
    localtime_s(&localTime, &t);  // Windows-safe version
#else
    localtime_r(&t, &localTime);  // Linux/macOS-safe version
#endif
    stringstream ss;
    ss << put_time(&localTime, "%Y-%m-%d %H:%M:%S");
    return ss.str();
}
