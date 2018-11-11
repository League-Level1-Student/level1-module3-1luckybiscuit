import ddf.minim.*;
Minim minim;  
AudioSample sound;  
AudioSample dedsound;  
void setup(){
  minim = new Minim (this);
  sound = minim.loadSample("pizzaTime.mp3", 128);
  dedsound = minim.loadSample("pizzaTimeTheme.mp3", 128);
  size(400,400);
  dedsound.trigger();
}
  int birdY = 100;
  int birdX = 50;
  int yVelocity = 0;
  float gravity = 1;
  int xPos = 400;
  int upperPipeHeight = (int) random(50, 190);
  int pipeGap = 130;
  int lowerPipeHeight = upperPipeHeight + pipeGap;
  int score = 0;
void draw(){
  background(50, 50, 200);
  if(hitPipe() == true) {
  fill(255,255,255);
  textSize(36);
  text("You got a concussion!\n          Score: " + score,10,200);
  }else if(hitBounds() == true) {
  fill(255,255,255);
  textSize(36);
  text("  You got vaporized \nby off-screen lazers!\n          Score: " + score,20,150);
  }else{
  telePipes();
  fill(255,255,255);
  textSize(20);
  text("Score: " + score, 1, 20);
  if(birdX == xPos) {
    score++;
  }
  fill(#F0DC02);
  stroke(#F0DC02);
  ellipse(birdX, birdY, 50, 50);
  stroke(#57C94D);
  fill(#57C94D);
  rect(xPos, -1, 50, upperPipeHeight); //upper pipe
  rect(xPos, lowerPipeHeight, 50, 400-lowerPipeHeight);
  birdY+=yVelocity;
  yVelocity += gravity;
  xPos-=5;
  }
}
void mousePressed(){
  gravity = 1;
  yVelocity = -10;
  sound.trigger();
}
void telePipes() {
  if(xPos == -50) {
    xPos = 400;
    upperPipeHeight = (int) random(50, 200);
    lowerPipeHeight = upperPipeHeight + pipeGap;
  }
}
boolean hitPipe() {
  if(birdY < upperPipeHeight && birdY > 0 && birdX >= xPos && birdX <= xPos +50) {
    return true;
  }else if(birdY < 400 && birdY > lowerPipeHeight && birdX >= xPos && birdX <= xPos +50) {
    return true;
  }else{
    return false;
  }
}
boolean hitBounds() {
  if(birdY<0 || birdY>400) {
    return true;
  }else{
    return false;
  }
}