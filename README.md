# Battleship
Simple battleship game in Java.

Guideline:

- Sort out classes
  - Player
  - Grid
  - Boat (which generalizes the three classes aircraft carrier, torpedo boat and cruiser)
  - GameState
- Sort out methods() for each class
  - Player:
      - player()
      - selectBoat(input): Boat
      - placeBoat(Boat: boat, coord: (x,y), orientation: String)
      - receivedAttack(int: x, int: y)
  - Grid
  - Boat
      - boat() 
  - GameState 
- Determine who needs to work with who
- Sort out attributes for each class
  - Player: 
      - board: Grid
      - boats: Boat[]  
  - Grid
  - Boat
      - length: int
      - hitpoints: int  
  - GameState
 
- RDD analyse and CRC cards

- Create the class diagram

- Create the sequence diagram (only for non-trivial parts of the game)

- Create the stateChart diagram (only for non-trivial parts of the game)

- Implement the code
  
