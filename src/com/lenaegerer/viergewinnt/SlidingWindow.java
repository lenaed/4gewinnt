package com.lenaegerer.viergewinnt;

import java.util.LinkedList;

public class SlidingWindow {
    LinkedList <Symbol> symbols = new LinkedList<>();


    public Status getResult(){
        int countO = 0;
        int countX = 0;

        for (Symbol s :symbols){
            if(s==Symbol.O){
                countO++;
            }
            else if(s==Symbol.X){
                countX++;
            }
        }
        if(countO==4){
            return Status.O_WINS;
        }
        else if(countX==4){
            return Status.X_WINS;
        }
        return Status.PLAYING;
    }

    public void slide(Symbol s){
        symbols.add(s);
        if(symbols.size()>4){
            symbols.removeFirst();
        }
    }

}
