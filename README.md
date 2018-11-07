# Multiplayer P2P Ping Pong

### Identical to the project in the COP 290 Repository

* About the project
    * JDK 1.8.0_51
    * Java *swing* and *tween engine* libraries
    * *Sliding Layout* by *Aurelien Ribon*
    * Sounds integration - *sun.\**
* The game rules -
    * Be sure to read the *How to Play* and view the *Options* before you start
    * Don't let *any* of the balls hit your side
    * You score when someone else misses a ball you just hit
    * Lives are variable, decided by the initial host
    * Various difficulty levels and game speeds for various levels of challenge
    * You can change the ball speed and velocity by hitting it with a moving paddle
    * Game ends if you are out of lives or the time limit (2.5 minutes approximately) is up
* Multiplayer mode - 
    * Up to 4 players over network
    * handles contingencies by replacing lost node with AI player
    * Game rules/type decided by the host creating the lobby

* Key bindings are flexible can be edited in Options
    - Default: Q and A for Up/Left and Down/Right Movement respectively
