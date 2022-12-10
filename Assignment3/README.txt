AUTHOR:
- Dawson Sanders

PURPOSE:
- This program allows users to click and and add/remove pipes to the game window. If a user clicks on a pipe that already exists then that pipe will be removed from the screen. The user also will be able to scroll side to side using the left and right arrow keys. In additon, the user can press q/esc to exit the program, they can press s to save the world they created to a JSON file, and they can load their previous saved world to the the screen by pressing l.  

TASKS:
- Make a class named Pipe
- Load pipe image
- Delete turtle and button from last assignment 
- Make model hold an array list of pipes 
- Make view draw all the pipes
- Add pipe wherever user clicks
- Remove existing pipe when user clicks on it
- Enable view to scroll over larger model
- Allow for if user presses q or esc to exit program
- Allow for if user presses s to save the world to a JSON file
- Allow for if user presses l to load the previous saved world to the screen

USER INSTRUCTIONS:
- In order to compile and run this program please download the Assignment3.zip file and unzip it. There are multiple ways to compile this program and one of the ways is using the build.bash file provided here. Depending on where the new unzipped folder is stored on your device, navigate to the terminal and go into the correct directory where the new folder is stored. After, going into the new folder directory, type the command: chmod 755 build.bash and press enter. Next, type ./build.bash and press enter. The program will compile and run and the game window will appear.

***Note: The build.bash file will work with MacOS and Linux devices. If you have a windows device please change the build.bash file to a build.bat file and write these commands instead:

::@echo off
javac Game.java View.java Controller.java Model.Java Json.java Pipe.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Game	
)
