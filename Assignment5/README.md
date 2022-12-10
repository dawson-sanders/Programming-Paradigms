# Assignment 5 Mario Inspired Side-Scroller Game

## Description
This sidescroller game involves a mario character that can throw fireballs at goombas to make them catch on fire and disappear as well as run into pipes. The user can create their own maps as they see fit by removing/placing pipes and goombas wherever they would like. This is the final assignment written in java for this class.

## Tasks
- Clean up code from Assignment4 
- Make a super class about sprites
- Add goombas to the game 
- Allow user to add/remove goombas 
- Let mario throw fireballs to destroy goombas

## User Instructions to run program
In order to compile and run this program please download all files as a zip folder to your computer. After you unzip the folder there are multiple ways to compile this program and one of the ways is using the build.bash file provided here. Depending on where the new unzipped folder is stored on your device, navigate to the terminal and go into the correct directory where the new folder is stored. After, going into the new directory, type the command: **chmod 755 build.bash** and press enter. Next, type **./build.bash** and press enter. The program will compile and run and the game window will appear to the screen.

**Note:** The build.bash file will work with MacOS and Linux devices. If you have a windows device please change the build.bash file to a build.bat file and write these commands instead:

::@echo off <br />
javac Game.java View.java Controller.java Model.java Pipe.java Json.java Mario.java Goomba.java Fireball.java Sprite.java <br />
if %errorlevel% neq 0 ( <br />
	echo There was an error; exiting now. <br />
) else ( <br />
	echo Compiled correctly!  Running Game... <br />
	java Game <br />
) <br />

## Controls 
- Right arrow key moves mario in the right direction
- Left arrow key moves mario in the left direction
- Space makes mario jump
- Escape key exits the game
- Q key exits the game
- S key saves the current map
- L key loads the previous map to the screen
- E key lets user go into edit mode
- P key (only works while in edit mode) allows users to place pipes in game
- G key (only works while in edit mode) allows users to place goombas in game
- A key goes back to play mode from edit mode 
- Control key makes mario throw fireballs
- F key makes mario throw fireballs

## Demo
https://user-images.githubusercontent.com/95600754/206875960-bad390f0-131e-4b79-9b31-f863c4e54f6d.mp4



