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
Car howdy = new Car(200,300, 50, -5);
Car kerchuga = new Car(200,350, 50, 5);
Car oof = new Car(200,100, 10, 40);
Car owo = new Car(380,150, 250, 1);
Car uwu = new Car(70,150, 250, 1);
//Car a = new Car(200,400, 50, 3);
Car b = new Car(200,450, 60, -5);
Car c = new Car(200,500, 60, 5);
Car d = new Car(200,550, 150, 1);
Car e = new Car(200,600, 75, -3);
Car f = new Car(200,650, 50, 5);
Car g = new Car(200,700, 20, -20);
int yFrog = 775;
int xFrog = 200;
int frogLeg = 50;
int deaths = 0;
void draw() {
  //victory royale
  if(yFrog<=50) {
  background(0,0,0);
  fill(255,255,255);
  textSize(70);
  text("YOU WON!\nDeaths: " + deaths, 20,350);
  }else{
  background(0,0,0);
  uwu.run();
  last.run();
  kerchuga.run();
  kachow.run();
  howdy.run();
  oof.run();
  owo.run();
 // a.run();
  b.run();
  c.run();
  d.run();
  e.run();
  f.run();
  g.run();
  textSize(30);
  text("Deaths: " + deaths,250,30);
  strokeWeight(5);
  stroke(0,0,0);
  fill(0,255,0);
  ellipse(xFrog, yFrog, 50, 50);
  invisWall();
  }
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
      x = 0-size;
    }else if(x < 0-size) {
      x = 400;
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
    deaths++;
    dedsound.trigger();
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