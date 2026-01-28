package Models;

public class CryptoModel {
    private String pathFrom;
    private String pathTo;
    private int key;

    public CryptoModel(String pathFrom, String pathTo, int key) {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
        this.key = key;
    }

    public CryptoModel() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getPathTo() {
        return pathTo;
    }

    public void setPathTo(String pathTo) {
        this.pathTo = pathTo;
    }

    public String getPathFrom() {
        return pathFrom;
    }

    public void setPathFrom(String pathFrom) {
        this.pathFrom = pathFrom;
    }
}
