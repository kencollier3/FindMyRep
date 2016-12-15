package util;

public class State {
    private String mStateName;
    private String mStateAbbrev;
    public State(String stateName, String stateAbbrev) {
        mStateName = stateName;
        mStateAbbrev = stateAbbrev;
    }
    public String getmStateAbbrev() {
        return mStateAbbrev;
    }
    public void setmStateAbbrev(String mStateAbbrev) {
        this.mStateAbbrev = mStateAbbrev;
    }
    public String getmStateName() {
        return mStateName;
    }
    public void setmStateName(String mStateName) {
        this.mStateName = mStateName;
    }

    @Override
    public String toString() {
        return mStateName;
    }
}
