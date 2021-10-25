#!/bin/sh
javac csc499hw1.java
echo "n" | java Csc499Hw1
if diff ImSorted.txt Sorted.txt
    then
        echo "Sort pass"
else
        echo "sort fail"
fi
echo "r" | java Csc499Hw1
if diff ImSorted.txt revSorted.txt
    then
        echo "Reverse Sort pass"
else
        echo "Reverse sort fail"
fi