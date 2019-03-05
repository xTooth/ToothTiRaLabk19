# Testing

The program is tested using extensive unit test. The tests can be run using the commands:  

Windows: gradlew test  

Linux/Mac: gradle test

By appending jacocotestreport to the command you'll also get a visual representation of the code coverage.
The only things not being tested are private methods and trivial tasks such as getters and setters. The entire main package is also excluded from testing due to its trivial nature.

Overall the test coverage is decent, and can be found [here](https://codecov.io/gh/xTooth/ToothTiRaLabk19) for quick access. 
