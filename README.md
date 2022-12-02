# My Personal Project

For my personal project, I want to make an **interactive, choose your own adventure story game.** In this game, 
you will play as a character going through a spaceship. The application will allow the player to make their own 
choices on what the character does throughout the story and experience the outcome of their decision. 
Some features of the application include:

- *Multiple endings.*
- *Decisions on other characters living and dying.*
- *Saving your progress wherever you want.*

This project is of interest to me because I want to pursue a career in making video games. I also enjoy writing a lot,
and an interactive story game allows me to mix both of those things together. 
It's also a decently simple game to make, and it allows me to be more creative with the story.

## Current User Stories
- As a user, I want to be able to save my progress and items I have collected.
- As a user, I want to be able to go back to my saved game from the beginning of the game.

## Completed User Stories
- As a user, I want to be able to choose different paths through the game
- As a user, I want to be able to add an item to a list of items as many times as I want. 
- As a user, I want to be able to start over again during a game.
- As a user, I want to be able to see the items I have collected.

## Future User Stories
- As a user, I want my choices in the game to have meaning and effect the story.
- As a user, I want to be able to see my previous choices in my current game.

Citations:
JSON elements of code contained in model, persistence, ui, and test folders are modelled from code from:
https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git 

# Instructions for Grader
- You can generate the first required event related to adding Xs to a Y by clicking on the "Yes!" button. To get to this button,
from the beginning you must click:
- Start New Game
- Right
- Yes!
That will add one X to Y.
- You can generate the second required event related to adding Xs to a Y by clicking yes on the top right again. You can do this as many times as you want.
- You can locate my visual component on the frame after clicking Right.
- You can save the state of my application by clicking save game at any point in the game after the opening screen
- You can reload the state of my application by going back to the title screen (clicking the button on screen or closing application)
and then clicking "Load Saved Game" at the top left

# Phase 4: Task 2
/Users/calcav/Library/Java/JavaVirtualMachines/corretto-11.0.17/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=61627:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/calcav/IdeaProjects/project_o5g7z/out/production/Project-Starter:/Users/calcav/IdeaProjects/project_o5g7z/lib/json-20210307.jar ui.Main
Fri Dec 02 02:17:18 PST 2022
Item added!

Fri Dec 02 02:17:19 PST 2022
Item added!

Fri Dec 02 02:17:19 PST 2022
Item added!


Process finished with exit code 0

# Phase 4: Task 3
For most of my classes, such as the ones in model and persistence, I would not refactor anything.
However, I would heavily refactor my GameApp class. Here is what I would change:
- Make each "level" (such as p0s0c0()) into objects by making a new class in model.
This would also help with scaling up my program with more levels.
This would also allow me to write each level as a JSON file and then 
- Remove duplicated JFrame constructors in each method by having one instance of it before the constructor.

I feel that for GameApp, I went for the easy solution instead of the best solution. As long as it worked right now, it was good enough for me.
For future projects, I want to develop good programming and design habits so my code is the best it can be.