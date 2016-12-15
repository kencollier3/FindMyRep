package util;

import java.util.List;

import model.RepData;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private List<RepData> results;
    public Result() {
        // constructor
    }
    public Result(List<RepData> results) {
        this.results = results;
    }
    public List<RepData> getResults() {
        return results;
    }
}
