/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


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

           public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song
        Song tunak = 	new Song("Tunak Tunak Tun Video.mp3"); 	//from default package 
        Song rick =	new Song("Never Gonna Give You Up.mp3"); 
        Song ali = 	new	Song("Ali-A.wav"); 
        Song wayne =  	new	Song("batman.wav"); 
        Song chopin =	new	Song("funeral-march.wav"); 
        Song funk = 	new	Song("celebration.mp3"); 
        	Song whatIs = new	Song("jeopardy.wav"); 
        	Song queen = new	Song("We Will Rock You.mp3"); 
        	Song wii = new	Song("Mii Channel Music.mp3"); 
		// 5. Play the Song
		/*
		 * 6. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
        	JFrame a = new JFrame();
        a.setVisible(true);
        a.setSize(1000, 1000);
        	a.setTitle("JukeBox RoBlox");
        	a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	JPanel b = new JPanel();
        	a.add(b);
        	JLabel c = loadImage("tunak.jpeg");
        	JLabel d = loadImage("rickRolled.jpeg");
        	JLabel e = loadImage("ali-a.jpeg");
        	JLabel f = loadImage("batman.jpeg");
        	JLabel g = loadImage("chopin.jpeg");
        	JLabel h = loadImage("celebration.jpeg");
        	JLabel i = loadImage("jeopardy.jpeg");
        	JLabel j = loadImage("weWillRockYou.jpeg");
        	JLabel k = loadImage("miiChannel.jpeg");
        	a.addMouseListener(this);
        	b.addMouseListener(this);
        	c.addMouseListener(this);
        	d.addMouseListener(this);
        	e.addMouseListener(this);
        f.addMouseListener(this);
        g.addMouseListener(this);
        h.addMouseListener(this);
        i.addMouseListener(this);
        j.addMouseListener(this);
        k.addMouseListener(this);
        a.pack();
        b.add(c);
        b.add(d);
        b.add(e);
        b.add(f);
        b.add(g);
        b.add(h);
        b.add(i);
        b.add(j);
        a.pack();
          }
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

