
class Gameboard {
    final private int ROWS = 6;
    final private int COLUMNS = 7;

    final private Symbol[][] gameboard = new Symbol[ROWS][COLUMNS];

    private Symbol whosTurn = Symbol.O;

    @Override
    public String toString() {
        String values = "";
        for (Symbol[] row : gameboard) {

            for (Symbol c : row) {
                if (c != null) {
                    values += c;
                } else {
                    values += " ";
                }
            }
            values += "\n";

        }
        return values;
    }


    public void placePiece(int choice) {
        int row = ROWS - 1;
        int col = choice;
        while (gameboard[row][col] != null) {
            row--;
        }
        gameboard[row][col] = whosTurn;
        whosTurn = whosTurn == Symbol.X ? Symbol.O : Symbol.X;
    }

    public Status checkRows() {
        for (int row = 0; row <= ROWS - 1; row++) {
            SlidingWindow window = new SlidingWindow();
            for (int col = 0; col <= COLUMNS - 1; col++) {
                window.slide(gameboard[row][col]);
                Status whosWinner = window.getResult();
                if (!whosWinner.goOn) {
                    return whosWinner;
                }
            }
        }
        return Status.PLAYING;
    }

    public Status checkColumns() {
        for (int col = 0; col <= COLUMNS - 1; col++) {
            SlidingWindow window = new SlidingWindow();
            for (int row = 0; row <= ROWS - 1; row++) {
                window.slide(gameboard[row][col]);
                Status whosWinner = window.getResult();
                if (!whosWinner.goOn) {
                    return whosWinner;
                }
            }
        }
        return Status.PLAYING;
    }

    public boolean columnIsFull(int column) {
        for (int row =0; row<ROWS; row++) {
            if (gameboard[row][column]==null) {
                return false;
            }
        }
        return true;
    }

   public Status checkStatus(){
       Status rowsStatus = checkRows();
       if(rowsStatus.getGoOn()==false){
           return rowsStatus;
       }
       Status columnStatus = checkColumns();
       if (columnStatus.getGoOn()==false){
           return columnStatus;
       }

           //checkDiagonals

       return Status.PLAYING;
   }
}

