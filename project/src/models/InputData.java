package models;


public class InputData {
    private String pathFrom;
    private String pathTo;
    private String result;
    private Integer key;

    public InputData(String pathFrom, String pathTo, Integer key) {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
        this.key = key;
    }

    public InputData(String pathFrom, String pathTo, String result) {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
        this.result = result;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getPathFrom() {
        return pathFrom;
    }

    public void setPathFrom(String pathFrom) {
        this.pathFrom = pathFrom;
    }

    public String getPathTo() {
        return pathTo;
    }

    public void setPathTo(String pathTo) {
        this.pathTo = pathTo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}

