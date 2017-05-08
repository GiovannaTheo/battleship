# battleship
Simple battleship game in Java.

Guideline:

- Sort out classes
  - Player
  - Grid
  - Boat (which generalizes the three classes aircraft carrier, torpedo boat and cruiser)
  - GameState
  - Orientation
  - Case
  
- Sort out methods() for each class
  - Player:
      - player()
      - selectBoat(input): Boat
      - placeBoat(Boat: boat, coord: (x,y), orientation: String)
      - receiveAttack(int: x, int: y)
  - Grid
      - grid()
      - markCase(case: Case)
  - Boat
      - boat() 
  - GameState 
      - win()
      - start()
      - abandon()
  - Case
      - case()
      
- Sort out attributes for each class
  - Player: 
      - board: Grid
      - boats: Boat[]  
  - Grid
      - boatLeft: int
      - cases: case[][]
  - Boat
      - length: int
      - hitpoints: int  
  - GameState
      - turn: String
  - Orientation
    - left
    - right
    - up
    - down
  - Case
    - coord: Coordinates
    - isEmpty: bool
    - isBoat: bool
    - isDown: bool
    
 - Determine who needs to work with who
 
- RDD analyse and CRC cards

- Create the class diagram
  - Done.

- Create the sequence diagram (only for non-trivial parts of the game)
  - Done.

- Create the stateChart diagram (only for non-trivial parts of the game)
  - Done.
- Implement the code
  
