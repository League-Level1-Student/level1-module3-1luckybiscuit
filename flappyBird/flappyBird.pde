void setup(){
  size(200,200);
}
  int yPos = 100;
  int yVelocity = 30;
void draw(){
  background(50, 50, 200);
  fill(200, 200, 0);
  stroke(255, 255, 0);
  ellipse(50, yPos, 50, 50);
  yPos+=5;
}