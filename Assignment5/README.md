# Assignment 5 Mario Inspired SideScroller Game

## Description
This sidescroller game involves a mario character that can throw fireballs at goombas to make them catch on fire and disappear as well as run into pipes. The user can create their own maps as they see fit by removing/placing pipes and goombas wherever they would like.

## User Instructions
In order to compile and run this program please download all files as a zip folder to your computer. After you unzip the folder there are multiple ways to compile this program and one of the ways is using the build.bash file provided here. Depending on where the new unzipped folder is stored on your device, navigate to the terminal and go into the correct directory where the new folder is stored. After, going into the new directory, type the command: chmod 755 build.bash and press enter. Next, type ./build.bash and press enter. The program will compile and run and the game window will appear to the screen.

**Note:** The build.bash file will work with MacOS and Linux devices. If you have a windows device please change the build.bash file to a build.bat file and write these commands instead:

::@echo off
javac Game.java View.java Controller.java Model.java Pipe.java Json.java Mario.java Goomba.java Fireball.java Sprite.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Game	
)




