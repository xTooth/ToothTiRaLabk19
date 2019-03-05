# Implementation Document


## Program Structure

The program is divided into 4 separate parts, the solvers, the shuffler, the UI and the self created datastructures. Everything is accessed trought the text based UI. Which is just a rudimentary commandline tool for accessing the software.

### The solvers
There are three implemented solvers in the current version of the software.
#### MySolver
This is the first solver I wrote before doing any research on allready established solutions. This basically means that it doesn't function as well as I hoped it would. It uses a custom built weighing system to hopefully find the shortest path to the solution.
This algorithm uses a prioriryqueue(binary heap).

#### BFS
This solver on the other hand is a basic Breadth First Search. It simply brute forces its way trough the optional paths and returns the solution as soon as it finds one. The algorithm uses a priorityqueue(binary heap) and a hashtable.

#### A*
A* uses a manhattan score counter to determine the shortest path possible to the solution. This algorithm uses both a prioriryqueue(binary heap) and a hashtable.

### Shuffler

This is basically a functions that pics a random move to be made 40 times in a row to create a somewhat randomly shuffled puzzle. It utilizes a custom built random that uses system nano time as its seed.

### Datastructures

#### HashTable

The HashingishTable is my attempt to create a quick storing method to find allready visited states. It is built using an array of trees that contain visited states.

#### PriorityQueue

This datasrtucture is built using an array as a binaryheap.

#### Randomizer

A simple pseudorandom method using system nano time as its seed to generate integers between 0 and a given bound.

#### ArrayMethods

Basically just a toString method for chat arrays.

## Achieved Time and Space Requirements

HashingishTable:  
                 hashing -> O(n)
                 add -> worst case O(n), best case O(1)
                 contains ->worst case O(n), best case O(1)
		               space:  O(n)

BinaryHeapThingy:  
                  peek-> worst O(1))
		                poll-> average and worst(O(log n))
                  add -> average O(1) worst O(log n)
	                 space:  O(n)

Randomizer:   
                   time/space: random int -> O(1) ? | not quite sure whether this is correct.

BFS:
                  time: O(|V|)
                  space: O(|V|)

MySolver:  
                  time: O(|V|)  Poor heuristic.
                  space: O(|V|)

A*Solver:	
                  time: theoretically O(|E|) if the heuristic works as intended, in this case probably closer to O(|V| + |E|).
                  space: O(|E|) tai O(|V| + |E|)


## Perfoemance

### Initial Performance Testing

This is testing done trough the text UI. Solving each starting state with each of the three solving algorithms. 
Each added move is further from the solved state.

S = searched states

T = time to solve in ms.



| Algorithm  | Shuffles: 10 | Shuffles: 12  | Shuffles: 14 | Shuffles: 16  |
| ------------------ | ------------------ | ------------------ | ------------------ | ------------------ |
| BFS  | S: 3273 T: 16 |  S: 13090 T: 88  |  S: 53113 T: 1865   |  S: 193739 T: 13165   |
| MySolver  |  S: 7733 T: 14   |  S: 31178 T: 36 |  S: 615361 T: 691   |  S: 3961073 T: 11240 | 
| A*  |  S: 26 T: 0  |  S: 22 T: 0  |  S: 44 T: 0 |  S: 52 T: 0  |
| Solution String  |  R, D, R, D, R, D, L, U, L, U,  |  R, D, R, D, R, D, L, U, L, U, L, U   |  L, U, L, D, R, D, R, D, L, U, L, U, L, U |  U, U, L, U, L, D, R, D, R, D, L, U, L, U, L, U   |

So as we can see both the BFS and my own solution start to struggle really badly very fast. Where as the A* seems to handle these with ease.
However my A* is not perfect yet, as it couldn't handle a puzzle that required 80 moves to solve in reasonable time, this means 
I let it run for over 15 minutes, during which it didn't crash but didn't find a solution eiter. This might be due to the slowness 
of my hashtable implementation or some other error.


Test system: CPU: i7-8700k @stock, RAM: 16gb DDR4, OS: Windows 10 Professional 

### Testing after datastructure implementations

TODO

## Deficiensies and Improvements

Well judgng by the fact that none of the solvers are able to handle a max shuffled (80 moves) case, the efficiency needs a bit of work.
I believe this to be down to the heuristic I use, and possibly to the amount of information I save per iteration. However I really do not know how to make this better.

Another improvement would be to implement some sort of GUI. It is simply preferrable to a command line UI.

### Sources

https://en.wikipedia.org/wiki/Breadth-first_search

https://gist.github.com/leopd/5992493

https://www.sanfoundry.com/java-program-implement-binary-heap/

https://en.wikipedia.org/wiki/A*_search_algorithm

https://en.wikipedia.org/wiki/Binary_heap

https://en.wikipedia.org/wiki/Hash_table




