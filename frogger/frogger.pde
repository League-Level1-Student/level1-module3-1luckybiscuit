import ddf.minim.*;
Minim minim;  
AudioSample sound;  
AudioSample dedsound;  
void setup() {
  size(400,800);
  minim = new Minim (this);
  sound = minim.loadSample("GRAND DAD.mp3", 128);
  dedsound = minim.loadSample("DRAND GAD.mp3", 128);
  dedsound.trigger();
}
Car last = new Car(20, 50, 75, 15);
Car kachow = new Car(20,250, 50, 10);
Car howdy = new Car(380,300, 50, -5);
Car kerchuga = new Car(380,350, 50, 5);
Car oof = new Car(380,100, 30, 30);
Car owo = new Car(380,150, 230, 1);
Car a = new Car(380,400, 50, 3);
Car b = new Car(380,450, 60, -5);
Car c = new Car(380,500, 60, 5);
Car d = new Car(380,550, 150, 1);
Car e = new Car(380,600, 75, -3);
Car f = new Car(380,650, 50, 5);
Car g = new Car(380,700, 20, -20);
int yFrog = 775;
int xFrog = 200;
int frogLeg = 50;
void draw() {
  background(150,150,150);
  last.run();
  kerchuga.run();
  kachow.run();
  howdy.run();
  oof.run();
  owo.run();
  a.run();
  b.run();
  c.run();
  d.run();
  e.run();
  f.run();
  g.run();
  strokeWeight(5);
  stroke(150,150,150);
  fill(0,255,0);
  ellipse(xFrog, yFrog, 50, 50);
  invisWall();
}
void keyPressed()
{
      if(key == CODED){
            if(keyCode == UP)
            {
                  //Frog Y position goes up
                  yFrog-=frogLeg;
                  sound.trigger();
            }
            else if(keyCode == DOWN)
            {
                  //Frog Y position goes down 
                  yFrog+=frogLeg;
                  sound.trigger();
            }
            else if(keyCode == RIGHT)
            {
                  //Frog X position goes right
                  xFrog+=frogLeg;
                  sound.trigger();
            }
            else if(keyCode == LEFT)
            {
                  //Frog X position goes left
                  xFrog-=frogLeg;
                  sound.trigger();
            }
      }
}
void invisWall() {
  if(xFrog > 400) {
    xFrog = 375;
  }else if(xFrog < 0) {
    xFrog = 25;
  }
  if(yFrog > 800) {
    yFrog = 775;
  }else if(yFrog < 0) {
    yFrog = 25;
  }
}
public class Car {
  private int x;
  private int y;
  private int size;
  private int speed;
  float paint = random(255);
  Car(int x, int y, int size, int speed) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.speed = speed;
  }
  void display() {
      fill(250-paint,paint,paint/2);
      rect(x , y, size, 50);
}
  void move() {
    x += speed;
  }
  void snake() {
    if(x > 400) {
      x = 0-x;
    }else if(x < 0) {
      x = 400+x;
    }
  }
  int getX() {
      return x;
    }
    int getY() {
      return y;
    }
    int getSize() {
      return size;
    }
    void roadkill() {
  if(xFrog>=x && xFrog<=x + size && yFrog>=y && yFrog <=y+50) {
    yFrog = 775;
  }
}
  void run() {
    this.display();
    this.move();
    this.display();
    this.snake();
    this.display();
    this.roadkill();
  }
}