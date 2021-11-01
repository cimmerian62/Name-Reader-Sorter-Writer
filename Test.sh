#!/bin/sh
javac Csc499Hw1.java
echo "n" | java Csc499Hw1
if diff ImSorted.txt Sorted.txt
    then
        echo "Sort pass"
else
        echo "sort fail"
        exit 1
fi
echo "r" | java Csc499Hw1
if diff ImSorted.txt revSorted.txt
    then
        echo "Reverse Sort pass"
else
        echo "Reverse sort fail"
        exit 1
fi