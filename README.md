# Elevator

Coding challenge for Bluestaq application.

Simulates an elevator.

## Prerequisites

* Java > 18.0.1.1

## Building

```bash
cd src/
javac main/Main.java
```

## Running

To run with the default number of floors:

```bash
cd src/
java main/Main
```

To customize the number of floors:

```bash
# Customize to 42 floors
cd src/
java main/Main 42
```

The frontend has the floor buttons simulating the internal elevator controls (i.e. - the button
panel). Clicking these buttons will cause the elevator to "move". Updates can be seen in the
console. Some example output is shown below:

```
Moving to floor 13...
Idle at floor 13
Moving to floor 15...
Idle at floor 15
Moving to floor 19...
Idle at floor 19
Swapping direction...
Moving to floor 12...
Idle at floor 12
Moving to floor 3...
Idle at floor 3
Swapping direction...
Moving to floor 4...
Idle at floor 4
```

## FAQ

### Why are there no unit tests?

Because I tried getting set up with JUnit and couldn't figure out how to mock/spy on functions.
Given the time constraint, I determined that I would learn Java unit testing later.

### Why is there only the internal button panel (no external buttons)?

I attempted to implement a version that adds external buttons. Feel free to check out the
`experimental/external_controls` branch if you're curious. However, the behavior isn't what I
wanted and getting such behavior would lead to reduced code readability and more branching. So,
again, I determined that I would provide the cleaner implementation with internal controls only
until I have more time to work out a cleaner design for the alternative.

### Why isn't this running in Docker?

I tried getting it to run in Docker, but getting the JFrame to display while running in a container
is difficult. All the solutions I could find were either too complex or device-specific. I also
tried making it CLI-based, but (1) I couldn't get key detection to work, and (2) it's not as
user-friendly, and some use cases would be harder to test without a dedicated frontend.

### Why does the code violate [insert Java convention here]?

This is the first program I've ever written in Java, so I'm unfamiliar with the general practices.

### Why are there fun facts in constructor docstrings?

That's a thing that I do because I think the description in a docstring for something that is
obviously a constructor is unneccesary. It's a waste of space and a waste of time (both to read
and to write). So my solution has been to make that comment (which is usually required by linter)
useful by inserting a fun fact.


## Features Not Implemented

Here are the features that I thought about implementing (and might have if I was using a
language that I'm strong in):

1. External controls (i.e. - the hallway buttons that are direction-specific)
2. Elevator door simulation
3. Button illumination when floor is selected
4. Emergency features (shutoff, alarm, etc.)
5. Current floor marker in frontend
6. Direction marker in frontend
7. Enhanced thread safety (mutex) for selected floor list in controller
