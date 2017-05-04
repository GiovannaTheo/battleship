# Battleship
Simple battleship game in Java.

Guideline:

```
  . Sort out classes
      - player
      - grid
      - boat (which generalizes the three classes aircraft carrier, torpedo boat and cruiser)
      - gameState
  . Sort out methods() for each class
      . player:
          - player()
          - selectBoat(input): Boat
          - placeBoat(Boat: boat, coord: (x,y), orientation: String)
          - receivedAttack(int: x, int: y)
      . grid
      . boat
          - boat()
      . gameState
  . Determine who needs to work with who
  . Sort out attributes for each class
      . player: 
          - board: Grid
          - boats: Boat[]
      . grid
      . boat
          - length: int
          - hitpoints: int
      . gameState
  . RDD analyse and CRC cards
  . Create the class diagram
  . Create the sequence diagram (only for non-trivial parts of the game)
  . Create the stateChart diagram (only for non-trivial parts of the game)
  . Implement the code
  
