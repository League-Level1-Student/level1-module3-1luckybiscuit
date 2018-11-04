
public class Athlete {

     static int nextBibNumber = 1;
     static String raceLocation = "New York";
     static String raceStartTime = "9.00am";

     String name;
     int speed;
     int bibNumber;

Athlete (String name, int speed){
     this.name = name;
     this.speed = speed;
     bibNumber = nextBibNumber;
     nextBibNumber++;
}

public static void main(String[] args) {
	Athlete roadRunner = new Athlete("Road Runner", 50);
	Athlete wilyCoyote = new Athlete("Wile E. Coyote", 40);
	System.out.println(roadRunner.name + "\n" + roadRunner.bibNumber + "\n" + raceLocation);
	System.out.println(wilyCoyote.name + "\n" + wilyCoyote.bibNumber + "\n" + raceLocation);
     //create two athletes      //print their names, bibNumbers, and the location of their race. }
}
}