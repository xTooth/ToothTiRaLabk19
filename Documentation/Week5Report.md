# Fifth week #

### What I did ###
This week I built a replacement implementation for the PriorityQueue the A* and my own algorithm use. I also worked on refactoring older
code, mostly removing copy paste and adding a "generalizer" for the different GameState implementations. This was done so that the 
BinaryHeapThingy could handle any gamestate regardless of how they look internally.

### What I learned ###
This week I basically relearned how to build a PriorityQueue. I also refreshed my memory on doing a code review (hope it turned out decently).

### Questions and unclear things ###
I ran into a wall when trying to figure out how to weigh the gameStates for the Djikstra algorithm. Am I allowed to use the default java random
in my shuffler? It's more of a nice to have and doesnt really have anything to do with the solvers or the task I'm working on.

### Next week ###
I intend to implement djikstra. Also if I have time I'll try to figure out how to implement a graphical interface. 
