package victor.ppool.site.util;

import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;

public class Beeper {
	
	public static void highBeep() {
		beep();
	}
	
	public static void lowBeep() {
		beep();
	}

	private static void beep() {
		new Thread(()->{
			File yourFile;
			AudioInputStream stream = null;
			AudioFormat format;
			DataLine.Info info;
			Clip clip;

			try {
				stream = AudioSystem.getAudioInputStream(new File("sounds\\beep-10.wav"));
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			} catch (UnsupportedAudioFileException | LineUnavailableException |IOException e) {
				e.printStackTrace();
			}

		}).start();
	}

	public static void main(String[] args) {
		try {

			beep();
			Thread.sleep(2000);
		} catch (Exception e) {
			// whatevers
			e.printStackTrace();
		}

	}

}