This Program creates a 2d array filled randomly wth ones and zeros, then uses a backtracking algorithm to find the largest group of 1's that touch(an island of 1's in an ocean of 0's). The program displays the size of the largest island and prints out the 2d array, but the 1's of the largest island are turned into X's.

Test Case 1:

A randomly initialized 2d array of size 10x20

The largest island is of size 10

 0 X 0 X 0 0 0 0 0 0 1 1 0 1 1 0 0 0 0 0
 
 X 0 0 0 X X 0 0 0 1 1 0 0 0 0 0 0 0 1 0
 
 0 X X X 0 0 0 1 0 0 0 0 0 0 1 0 0 1 0 1
 
 X 0 0 0 0 1 0 0 0 1 0 0 1 0 0 0 0 0 0 0
 
 X 0 0 0 0 1 1 0 0 1 0 1 1 1 0 0 0 1 1 0
 
 0 0 0 1 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1

 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 1 1
 
 0 0 0 0 1 0 0 0 1 0 0 1 0 1 0 0 0 0 0 0
 
 0 1 1 0 0 0 1 1 0 0 0 0 1 0 0 0 1 0 0 0
 
 0 1 1 1 1 0 0 0 1 0 0 0 1 0 0 1 0 1 0 0
 
 Test Case 2:

A randomly initialized 2d array of size 5x5

The largest island is of size 4

 0 0 0 0 0
 
 0 0 1 0 0
 
 X 0 0 1 0
 
 X X 0 0 0
 
 X 0 0 0 0
 
 Test Case 2:

A randomly initialized 2d array of size 20x30

The largest island is of size 51

 1 0 0 1 0 0 1 0 1 0 1 1 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0
 
 0 1 1 0 1 1 1 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 1 1 1
 
 0 0 0 1 0 1 0 0 0 1 1 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 1 0 0
 
 1 0 0 0 0 0 1 0 1 1 1 0 0 1 0 0 0 0 0 1 1 0 0 0 0 0 0 0 1 0
 
 0 0 1 0 1 0 0 0 0 1 1 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 1 1
 
 0 0 1 0 1 0 1 0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 1 1 0 0 1 0 0 0
 
 0 0 0 0 0 0 1 0 1 0 0 1 1 1 0 0 1 1 0 1 0 0 1 1 0 0 1 1 1 1
 
 0 0 0 1 1 1 0 1 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 1
 
 X X 0 0 0 1 1 0 1 0 0 1 0 0 1 1 0 0 0 0 0 0 1 0 0 0 1 0 0 0
 
 0 X 0 0 1 1 0 1 0 0 1 0 1 0 1 0 0 0 1 1 1 1 1 1 1 0 0 0 0 1
 
 X 0 0 1 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1
 
 0 X 0 0 1 0 0 0 0 X 0 0 1 0 0 0 0 1 0 0 1 0 1 0 0 0 0 0 1 0
 
 0 0 X 0 0 0 0 X X X 0 0 0 0 0 0 0 0 0 0 1 0 1 0 1 1 1 0 1 0
 
 0 X 0 X 0 0 0 0 X 0 0 1 0 1 0 1 0 0 0 1 0 0 1 0 0 0 1 1 0 0
 
 0 X X 0 X X 0 X X X 0 0 0 0 1 0 0 0 0 0 1 0 0 1 0 0 0 1 1 1
 
 X 0 X 0 0 X X X 0 0 0 X 0 0 0 0 1 0 0 0 0 0 0 1 0 0 1 0 0 1
 
 X X X X 0 X X 0 X 0 X 0 0 X X 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0
 
 0 X X 0 0 X 0 0 X 0 X 0 X X 0 0 0 0 0 0 0 0 0 0 0 1 1 1 0 1
 
 0 0 X 0 0 0 X X 0 X 0 X 0 X 0 0 0 0 1 0 0 0 0 0 1 0 0 1 1 0
 
 0 X 0 0 1 0 0 0 X 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1 0 1
