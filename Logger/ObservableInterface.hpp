#pragma once
#include <bits/stdc++.h>
#include "LogLevel.hpp"
#include "Observer.hpp"
using namespace std;

class ObservableInterface {
  public:
    map<LogLevel, set<Observer *>> mp;
    void addObserver(LogLevel logLevel, Observer* observer);
    void notifyObserver(LogLevel logLevel, string message);
};