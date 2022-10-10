# chainOfCities

The program reads a list of cities from a file:
Application design is based on SOLID principles:

The application is divided into separate modules.

The nio.* library is used for reading
The repository layer class gets valid data from a file,
handles errors related to getting data.

If the number of lines in the file exceeds the limit, an exception will be thrown.
If the specified file does not exist or there is no data in the file, an exception will be thrown.
If there is more than one word in a line, an exception will be thrown.
To prevent the possibility of duplicate data, the Set collection is used.
This class returns a set of strings.

The service layer class contains the business logic. And works with the received data.
The method **getChain(List<String> words)** 
returns the longest possible chain of cities in which the last letter of 
the previous city matches the first letter of the next one, case insensitive.
If the word begins or ends with a letter other than a letter, an exception will be thrown.

The program provides method tests using the Junit library

Application is containerized using Docker

You can run the application in the Main class
after specifying the relative path to the text file with data

Or in Docker using the command

    docker-compose up --build