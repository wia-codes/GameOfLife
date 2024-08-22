# GameOfLife
John Conway's Game of Life.
## Overview
This project is an implementation of Conway's Game of Life in Java. The Game of Life is a cellular automaton devised by the British mathematician John Horton Conway in 1970. It consists of a cell grid that evolves over discrete time steps according to a set of simple rules.

## Features
- **Random Initial Generation**: The grid is initialized with a random pattern of live and dead cells.
- **Customizable Grid Size**: The grid size can be specified when creating a new game.
- **Multiple Generations**: The user can choose how many generations to simulate, or run the simulation indefinitely.
- **Visual Representation**: The state of the grid is displayed using Unicode characters to represent live and dead cells.

## Rules
1. **Underpopulation**: Any live cell with fewer than two live neighbours dies.
2. **Survival**: Any live cell with two or three live neighbours survives.
3. **Overpopulation**: Any live cell with more than three live neighbours dies.
4. **Reproduction**: Any dead cell with exactly three live neighbours becomes a live cell.
