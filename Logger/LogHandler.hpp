#pragma once

#include <string>
#include "LogLevel.hpp"
using namespace std;

class LogHandler{
public:
  virtual void handleMessage(LogLevel logLevel, string message)=0; 
  virtual void setNext(LogHandler* LogHandler)=0;  	
};