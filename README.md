# Snake
Simple Snake Game 

Main{
 + new Game
 + new Window
 + window.setGame(game)
}

Game{
+ start()
+ stop()
+ run()
+ tick()
+ render()

+ setState()	//Pause, Run
+ getState()
}

Menu{}

Window{
+ Window()

+ setWidth()
+ setHeight()
+ setTitle()
+ setGame()

+ getWidth()
+ getHeight()
+ getTitle()
+ getGameState()
}

GameObject{

+ collision(GameObject, GameObject)
+ setX(int x)
+ setY(int y)
+ getX()
+ getY()
+ setSpeed(int speed)
+ getSpeed()

  + tick()       // abstract
  + render()     // abstract
  + getBounds()	 // abstract
}

Creature extends GameObject{

  + eat(Inanimate) // abstract
  + death()
}

Snake extends Creature{
+ enum direction { UP, RIGHT, LEFT, DOWN}
+ int length

+ move()

- stretch()
- fatten()
- rush()

		
+ tick()
+ render()
+ getBounds()
}

Turtle extends Creature{ 

- close()

+ tick()
+ render()
+ getBounds()
}

Inanimate extend GameObject{
- eaten()
}

Apple extends Inanimate{}

KeyInput extends KeyAdapter {
  + keyPressed
}

Handler{
  + tick()
}

Spown{
  + randomSpown(Game, Handler, Inanimate)
}


