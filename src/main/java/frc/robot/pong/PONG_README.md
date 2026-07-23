# Intro
Here we have some code for the pong project! Again, all I did was essentially take our previous knowledge from the June Vibes subsystem stuff and give you guys some skeleton code for the pong project related to what we were talking about last time. You can still find the June Vibes stuff in the **reference** folder if you want to reference it (hence the name). Nothing that I've written up should be too new, but feel free to ask as many questions as you need.

# Skeleton Code
There are a few files you should be aware of. Most things are commented, but once again let me know if you need further clarification on what's been already written.

- PongGame.java manages all the purely simulated interactions. Right now, it's mostly just a bridge between the paddles and the rendering system.
- PaddleSubsystem.java defines each paddle and will control said paddle with a motor. This is where we'll do most of our work today.
- PongConstants.java just has some arbitrary values used around the code to standardize the game itself. Feel free to mess with the values and see what changes!
- PongVisualizer.java is responsible for drawing the paddles. You don't need to worry about this file, but if you're curious certainly explore it!
- RobotContainer.java is where all the paddles and the game will come together.

# Tasks
Each task corresponds to a numbered TODO comment in the code.
The first few tasks relate to programming the paddles' movement where we left off last time. Head to PaddleSubsystem.java
## Paddle Movement
1. Create the constructor to intialize each paddle's motor
2. Program the movement of the paddle using a motor control request, but make sure the paddle doesn't move too far!
3. Wrap your move method in a Command so that we can actually use it.
The next tasks are in RobotContainer.java and relate to connecting all the functionality together.
4. Construct the paddles from your subsystem.
5. Bind the controller's joystick axes to each paddle's move command to control them in real time!

## Ball Movement and Collision
Since the ball isn't a subsystem and is completely simulated, this code likely wants to love inside PongGame.java
6. Create relevant fields to store ball data
7. Move the ball around and check to make sure it stays in bounds each frame
8. Make the ball collide with the actual paddles so the game is playable

Congratulations on making Pong inside the robot simulation!! While this implementation may seem a bit detached, all these skills you're learning are completely applicable to the real robot code--motor control, java basics, and general problem solving skills.
If you finish all that, maybe try to make the paddle/ball interaction a bit truer to the traditional pong game if you are interested. If not, great work on Pong and get excited for your next project!
