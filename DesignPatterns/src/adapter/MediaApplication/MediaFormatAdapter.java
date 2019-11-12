package adapter.MediaApplication;

public class MediaFormatAdapter implements MediaPlayer {

    //This adapter implements the MediaPackage interface to MediaPlayer interface
    private MediaPackage mediaFile;

    MediaFormatAdapter(MediaPackage mediaFile){
        this.mediaFile = mediaFile;
    }

    @Override
    public void play(String fileName) {
        System.out.println("Using the adapter ----> ");
        mediaFile.playFile(fileName);
    }
}
