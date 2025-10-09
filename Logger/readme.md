g++ -std = c++17 - I . .\main.cpp .\Logger.cpp .\LoggerConfiguration.cpp .\InfoHandler.cpp .\DebugHandler.cpp .\ErrorHandler.cpp .\TimeStamp.cpp ObservableInterface.cpp ConsoleObserver.cpp FileObserver.cpp - o .\main.exe

           Designing a Logging Framework
           Requirements

           The framework must support various log levels, including DEBUG, INFO, WARNING, ERROR, and FATAL.

           Each log entry should include a timestamp, severity level, and message content.

           Logs should be able to be directed to multiple outputs, such as the console, files, or a database.

           A configuration system should be provided to define the log level and select the output destination.

           The framework should be thread - safe to manage simultaneous logging from multiple threads.

           It should be designed for extensibility, enabling the addition of new log levels and output targets in the future.