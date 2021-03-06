**4.i)**

Contrary to the `.xdr` code generated by Sun RPC, data conversion in Java RMI is managed by stubs,
the skeleton on the side of private messenger or by proxy on the client side, which are generated by the compiler interfaces.

Parameter conversion is done by *marshaling*/*unmarshaling* of remote objects and parameters used.

**4.ii)**

*Client classes:*

* `Game.java` implementing game logic, with calls to the remote object methods registered in the directory names,
accessed via proxy (`TTTService`);

*Server classes:*

* `TTT.java` implementing the concrete class of the remote object game;

* `TTTServer.java` running the server program, registering the remote object in the directory java names,
so that it is available for remote connections;

*Both classes:*

* `TTTService.java` that is used both by the game server interface for the declaration of the game as a remote object as
the client to generate the proxy capable of responding to the game methods;
