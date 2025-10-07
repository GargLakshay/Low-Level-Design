#include <iostream>
#include <chrono>
#include <iomanip>
#include <ctime>
using namespace std;

class TimeStamp{
  private:
  TimeStamp(){
      
  }  
public:
    static string getTimestamp();
};
