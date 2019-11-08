package adapter.MediaApplication;

public class MP4 implements MediaPackage {
    @Override
    public void playFile(String fileName) {
        System.out.println("Playing MP4 File " + fileName);
    }
}
