For this exercise was required to create a `TTTService` interface that extends the Class `Remote`
and thus providing the signature of all the methods implemented by the `TTT` object that represents
the game, so that it can be remotely manipulated by a client, even if the `TTT` Class
and the concrete object are found only on the server side.

For this, the `TTTServer` when it is released, instantiates a concrete `ttt` object and register it in the
Java Names directory, in our case, the port 8080 of localhost.

After that the `TTTClient` progam (which implements the previously found logic 
Game in this class on the server side) tries to read the directory name, a remote object
that responds to the signature present in `TTTService` interface, thus that generating a proxy,
allows you to interact with the object without knowing its implementation.

For the evaluation exercise of the solution method to the remote interface, was added a [method](https://github.com/FMCalisto/ttt-java-rmi-noughts-crosses-game/blob/master/ttt/ttt-rmi-server/src/main/java/ttt/TTT.java#L107)
`int lastPlay(int player)`, implemented in the `TTT` concrete class as a function that, getting 
the player returns the last move made by him (for each of the players 2) or returning
`-1` if no move has been made by the respective player.

This remote method is invoked when the player writes 10 as a move, having for its
validation changed the range of possible moves in the game logic.

Our solution also implements a `restart()` method that allows you to restart a game board
to facilitate future testing.
