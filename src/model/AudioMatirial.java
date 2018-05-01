package model;

import javax.sound.sampled.*;
import java.net.URL;

class AudioMatirial extends Resource{
    private int playTime;

    public AudioMatirial(Library instance){super(instance);}
    public AudioMatirial(String author, String name, int year, URL source, int playTime, StorageType storage, Library instance){
        super(author,name,year,source,storage,instance);
        this.playTime = playTime;
    }
    public AudioMatirial(AudioMatirial ob){
        super(ob);
        playTime =ob.playTime;
    }

    public void setPlayTime(int playTime) {this.playTime = playTime;}

    public int getPlayTime(){ return playTime;}

    //оверайды Object
    @Override
    public String toString() {
        return super.toString() + playTime +"(MusicPartita).\n";
    }
    @Override
    public int hashCode() {
        return super.hashCode() + 15* playTime;
    }
    @Override
    public boolean equals (Object ob) {
        if(!super.equals(ob)) return false;
        AudioMatirial other=(AudioMatirial) ob;
        return (playTime ==other.playTime);
    }

    @Override
    public void reproduce() {
        Clip clipSound;
        try {
            AudioFileFormat aff = AudioSystem.getAudioFileFormat(source);
            AudioFormat af = aff.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, af);
            if (AudioSystem.isLineSupported(info)) {
                clipSound = (Clip) AudioSystem.getLine(info);
                AudioInputStream ais = AudioSystem.getAudioInputStream(source);
                clipSound.open(ais);
                clipSound.start();
                clipSound.stop();
                clipSound.close();
            }
            else
            {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
