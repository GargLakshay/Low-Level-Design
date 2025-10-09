#pragma once
#include <bits/stdc++.h>
#include "LogLevel.hpp"
using namespace std;

class Observer {
  public:
    virtual void printMessage(LogLevel logLevel, string message) = 0;
};