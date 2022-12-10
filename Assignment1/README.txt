Programming Paradigms Assignment 1. Simple java program that displays a new window to the user with a button that the user can click.

AUTHOR:
- Dawson Sanders

PURPOSE:
- Simple java program that displays a new window to the user with a button that the user can click.

TASKS:
- Write a shell script
- Create class called Assignment1
- Use JFrame and make a button 

USER INSTRUCTIONS:
- In order to compile and run this program please download the Assignment1.zip file and unzip it. There are multiple ways to compile this program and one of the ways is using the build.bash file provided here. Depending on where the new unzipped folder is stored on your device, navigate to the terminal and go into the correct directory where the new folder is stored. After, going into the new folder directory, type the command: chmod 755 build.bash and press enter. Next, type ./build.bash and press enter. The program will compile and run and the game window will appear.

***Note: The build.bash file will work with MacOS and Linux devices. If you have a windows device please change the build.bash file to a build.bat file and write these commands instead:

::@echo off
javac Assignment1.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Assignment1	
)
