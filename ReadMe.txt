When this program is run, there must be two text files "Sort Me" and "ImSorted" in the same folder as the java file. This is because the
program is coded to read names from a file called "Sort Me" and output the sorted names to a file called "ImSorted". The relative filepath 
implemented in the code assumes that the two text files are in the same folder as the program.

The names read in may be sorted primarily by length, and secondarily alphabetically or the reverse of this depending on which
option is chosen when the program is run.

There is a Shell Script "Test.sh" also included. This is a test which checks the success of the sort and reverse sort capabilities of the
program. This test must be run in the same folder as the java program due to relative filepaths.In order for the test to work there must 
be two more text files in the folder: "Sorted" and "revSorted". These files must contain the names from the "Sort Me" file sorted and
reverse sorted respectively. 
