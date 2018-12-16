import javax.swing.JOptionPane;

public class movieRunner {
	public static void main(String[] args) {
		Movie a = new Movie("Titanic", 1);
		Movie b = new Movie("Emoji Movie", 1);
		Movie c = new Movie("The Lorax", 3);
		Movie d = new Movie("Space Balls", 5);
		Movie e = new Movie("Monty Python and the Holy Grail", 100);
		NetflixQueue ueue = new NetflixQueue();
		ueue.addMovie(a);
		ueue.addMovie(b);
		ueue.addMovie(c);
		ueue.addMovie(d);
		ueue.addMovie(e);
		ueue.sortMoviesByRating();
		ueue.printMovies();
		JOptionPane.showMessageDialog(null, "The best movie is " + ueue.getBestMovie() + ".");
		JOptionPane.showMessageDialog(null, "The second best movie is " + ueue.getMovie(1) + ".");
	}
}
