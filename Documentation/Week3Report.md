# Third Week

## What I did

Most of this week has been spent trying to resolve  heap space errors. I cannot seem to find what and where Im going wrong in the newly added A* algorithm. Quite a bit of time went into reseaching Manhattan scoring and how that is supposed to work, but I have to say I had very little luck with a default manhattan search. -> Basic manhattan A* took: well I stopped running the test after a minute, cause the inevitable incoming heapspace error. Which is odd since the materials I read online suggest it should work extremly well. where as my verison: manhattan * madeMoves returns the correct answer in 1ms after searching 122 vertices. Which is over 4 seconds faster than the standard BFS. This latter test can be run by running the demo cases in the textbased UI. 

## What I learned

The biggest thing I learned is that optimizing the solver/s is going to be alot more difficult than I previously imagined.

## Questions

Well to be honest I feel kind of stuck since the limited material found online about this problem really hasn't helped me a whole lot. Especially the manhattan scoring baffles me since it should work according to several sources, but I just end up in a situation where the algorithm grabs the best initial move and DFS:s that to oblivion. And my "fixed" version runs out of heapspace at some point, when there are enough states in the priorityqueue.

Also, I didnt remove the gradlefiles just yet, do I really have to remove basically  everything but the "src/" and the documentation?

## Next Week

Hopefully fix the algorithms and  do some testing aswell as beginning work on datastructures, like the HashSet and PriorityQueue.


#### Note
Test coverage is down a bit due to lots of private classes, which I cant test. Hope its still satisfactory. 
