package com.gmail.volodymyrdosenko.vttcreater;

import java.io.IOException;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

public class SimpleCreater {

	public static void main(String[] args) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3file = new Mp3File("mp3/scorpions_send_me_an_angel.mp3");

		System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
//		System.out.println("Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
//		System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
//
//		if (mp3file.hasId3v1Tag()) {
//			ID3v1 id3v1Tag = mp3file.getId3v1Tag();
//			System.out.println("Track: " + id3v1Tag.getTrack());
//			System.out.println("Artist: " + id3v1Tag.getArtist());
//			System.out.println("Title: " + id3v1Tag.getTitle());
//			System.out.println("Album: " + id3v1Tag.getAlbum());
//			System.out.println("Year: " + id3v1Tag.getYear());
//			System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
//			System.out.println("Comment: " + id3v1Tag.getComment());
//		}
		
		TextReader tr = new TextReader("mp3/scorpions_send_me_an_angel.txt");
		
		tr.createVtt();
	}
}