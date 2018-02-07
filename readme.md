Prerequisites
=============

Java 1.8 or higher 
May run on Java 1.5 or higher but not tested below 1.8

Gradle wrapper
==============

This project includes the gradle wrapper, which lets you run the gradle build without having gradle installed.  
NOTE: the first time you run the gradle wrapper, it will take a while to download a local copy of gradle, just for this project.  If you have a gradle install, you're better off using that instead.

Run the gradle wrapper as follows:

Linux:  
`./gradlew <command>`

Windows  
`gradlew <command>`

 
Commands are:

*eclipse* - generates eclipse project and classpath files  
*build* - builds the project  
*test* - runs tests and puts a test report in ./build/reports/tests/test/index.html  
*install* - packages and installs the application to ./build/install/test1
  
How to run
==========

Linux  
```
  ./gradlew install (see above)  
  cd ./build/install/test1/bin   
  ./test1 <date1> <date2>
```

Windows  
```
gradlew install (see above)  
cd build\install\test1\bin  
test1 <date1> <date2>
```

The day difference will be printed to STDOUT.




 
