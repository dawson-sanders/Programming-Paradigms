#!/bin/bash
set -u -e
javac Game.java View.java Controller.java Model.java Pipe.java Json.java Mario.java Goomba.java Fireball.java
java Game
rm -rf *.class
