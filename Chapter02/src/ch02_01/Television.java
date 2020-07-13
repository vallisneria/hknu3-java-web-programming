package ch02_01;

public class Television {
    private int Volume;
    private int Channel;

    public void ChannelUp() {
        this.Channel++;
    }

    public void ChannelDown() {
        this.Channel--;
    }

    public void VolumeUp() {
        this.Volume++;
    }

    public void VolumeDown() {
        this.Volume--;
    }
}
