package adapter.MediaApplication;

public class VLC implements MediaPackage {
    @Override
    public void playFile(String fileName) {
        System.out.println("Playing VLC File " + fileName);
    }
}
