# Testing

## Initial Performance Testing

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
