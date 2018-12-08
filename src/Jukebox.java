/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, MouseListener {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
	}
	Song tunak = 	new Song("Tunak Tunak Tun Video.mp3"); 	//from default package 
    Song rick =	new Song("Never Gonna Give You Up.mp3"); 
    Song ali = 	new	Song("Ali-A.mp3"); 
    Song wayne =  	new	Song("Eye of the Tiger.mp3"); 
    Song chopin =	new	Song("Funeral.wav"); //Not Working
    Song funk = 	new	Song("celebration.wav"); //Not Working 
    	Song whatIs = new	Song("jeopardy.wav");  //Not Working
    	Song queen = new	Song("RockYou.mp3"); 
    	Song wii = new	Song("Mii Channel Music.mp3"); 
	JLabel c = loadImage("tunak.jpeg");
	JLabel d = loadImage("rickRolled.jpeg");
	JLabel e = loadImage("ali-a.jpg");
	JLabel f = loadImage("batman.jpg");
	JLabel g = loadImage("chopin.jpeg");
	JLabel h = loadImage("celebration.jpg");
	JLabel i = loadImage("jeopardy.jpg");
	JLabel j = loadImage("weWillRockYou.jpg");
	JLabel k = loadImage("miiChannel.jpeg");
           public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song
		// 5. Play the Song
		/*
		 * 6. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
        	int dimension = 370;
        	JFrame a = new JFrame();
        a.setVisible(true);
        a.setPreferredSize(new Dimension(1900, 780));
        	a.setTitle("JukeBox RoBlox");
        	a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	JPanel b = new JPanel();
        	a.add(b);
        	//Loads Image
        	//Adds mouse listener
        	c.addMouseListener(this);
        	d.addMouseListener(this);
        	e.addMouseListener(this);
        f.addMouseListener(this);
        g.addMouseListener(this);
        h.addMouseListener(this);
        i.addMouseListener(this);
        j.addMouseListener(this);
        k.addMouseListener(this);
        //Set image size
        c.setPreferredSize(new Dimension(dimension,dimension));
        d.setPreferredSize(new Dimension(dimension,dimension));
        e.setPreferredSize(new Dimension(dimension,dimension));
        f.setPreferredSize(new Dimension(dimension,dimension));
        g.setPreferredSize(new Dimension(dimension,dimension));
        h.setPreferredSize(new Dimension(dimension,dimension));
        i.setPreferredSize(new Dimension(dimension,dimension));
        j.setPreferredSize(new Dimension(dimension,dimension));
        k.setPreferredSize(new Dimension(dimension,dimension));
        //Adds to panel
        b.add(c);
        b.add(d);
        b.add(e);
        b.add(f);
        b.add(g);
        b.add(h);
        b.add(i);
        b.add(j);
        b.add(k);
        a.pack();
          }
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void mouseClicked(MouseEvent oof) {
		// TODO Auto-generated method stub
		tunak.stop();
		rick.stop();
		ali.stop();
		wayne.stop();
		chopin.stop();
		funk.stop();
		whatIs.stop();
		queen.stop();
		wii.stop();
	   	 JLabel drumClicked = (JLabel) oof.getSource();  
	   	 if(drumClicked == c) {
	   		 tunak.play();
	   	 }else if(drumClicked == d) {
	   		 rick.play();
	   	 }else if(drumClicked == e) {
	   		 ali.play();
	   	 }else if(drumClicked == f) {
	   		 wayne.play();
	   	 }else if(drumClicked == g) {
	   		chopin.play();
	   	 }else if(drumClicked == h) {
	   		 funk.play();
	   	 }else if(drumClicked == i) {
	   		 whatIs.play();
	   	 }else if(drumClicked == j) {
	   		 queen.play();
	   	 }else if(drumClicked == k) {
	   		 wii.play();
	   	 }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

