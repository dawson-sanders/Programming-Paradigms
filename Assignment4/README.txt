AUTHOR:
- Dawson Sanders

PURPOSE:
- This program allows users to click and add/remove pipes to the game window while in edit mode as well as make mario run and jump around on pipes. If a user clicks on a pipe that already exists then that pipe will be removed from the screen if you are in edit mode (press of 'e'). The user also will be able to scroll mario side to side using the left and right arrow keys. In additon, the user can press q/esc to exit the program, they can press s to save the world they created to a JSON file. 

TASKS:
- Clean up code from Assignment3 
- When user opens game the 'map' and mario should be loaded in automatically to the screen
- Add a boolean variable to switch between edit mode and play mode 
- Add mario images into game 
- Add gravity to mario
- Make ground so mario stops falling 
- Make methods for collison detection when mario runs into pipes
- Make method to get mario out of the pipe he collided with
- Enable mario to jump with the spacebar
- Use an iterator somewhere
- Lazy load images

USER INSTRUCTIONS:
- In order to compile and run this program please download the Assignment4.zip file and unzip it. There are multiple ways to compile this program and one of the ways is using the build.bash file provided here. Depending on where the new unzipped folder is stored on your device, navigate to the terminal and go into the correct directory where the new folder is stored. After, going into the new folder directory, type the command: chmod 755 build.bash and press enter. Next, type ./build.bash and press enter. The program will compile and run and the game window will appear.

***Note: The build.bash file will work with MacOS and Linux devices. If you have a windows device please change the build.bash file to a build.bat file and write these commands instead:

::@echo off
javac Game.java View.java Controller.java Model.java Pipe.java Json.java Mario.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Game	
)

The compiling process will be similar to MacOS and Linux, except use the command build.bat to compile and run instead.
