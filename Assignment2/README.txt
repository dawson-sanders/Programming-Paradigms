AUTHOR:
- Dawson Sanders

PURPOSE:
- This java program displays a cyan blue window with a button and an image of a turtle. By using the arrow keys or by clicking the mouse the user can make the turtle move around the window. 

TASKS:
- Make button remove itself
- Load turtle image
- Change background color of window
- Make new class called Model
- Animate it by giving controls to turtle

USER INSTRUCTIONS:
- In order to compile and run this program please download the Assignment2.zip file and unzip it. There are multiple ways to compile this program and one of the ways is using the build.bash file provided here. Depending on where the new unzipped folder is stored on your device, navigate to the terminal and go into the correct directory where the new folder is stored. After, going into the new folder directory, type the command: chmod 755 build.bash and press enter. Next, type ./build.bash and press enter. The program will compile and run and the game window will appear.

***Note: The build.bash file will work with MacOS and Linux devices. If you have a windows device please change the build.bash file to a build.bat file and write these commands instead:

::@echo off
javac Game.java View.java Controller.java Model.Java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Game	
)
