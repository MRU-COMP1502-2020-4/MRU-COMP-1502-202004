# People Counter Project

Project to create a system where we can count the number of people in a building with multiple enterences. For now we assume a person at each enterence will keep track of people as they enter and exit and so the system should have a total count at any point in time so we can determine if more people should be allowed in.

## Public Interface

What behaviours do we expect the system to have

* Add an enterance to the build 
   * Since we want this to be generic, we should be set up any building with any number of enterances.
   
* At an enterance
   * Count a person entering
   * Count a person exiting
   * Get a count of the people who entered
   * Get a count of the people who exited
   
* Overall
   * Get a count of the current people inside
   * Get a count of total people over the day
