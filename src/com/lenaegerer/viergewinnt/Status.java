package com.lenaegerer.viergewinnt;

public enum Status {
    PLAYING(true),
    O_WINS(false),
    X_WINS(false),
    TIE(false);

    final boolean goOn;

    Status(boolean goOn) {

        this.goOn = goOn;
    }

    public boolean getGoOn(){
        return goOn;
    }
}
