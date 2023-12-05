public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPos(line) && this.checkPos(column) && this.checkPos(toLine) && this.checkPos(toColumn) && chessBoard.board[line][column] != null) {
            if (column != toColumn) {
                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) && chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
                }

                return false;
            }

            byte dir;
            byte start;
            if (this.color.equals("White")) {
                dir = 1;
                start = 1;
            } else {
                dir = -1;
                start = 6;
            }

            if (line + dir == toLine) {
                return chessBoard.board[toLine][toColumn] == null;
            }

            if (line == start && line + 2 * dir == toLine) {
                return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null;
            }
        }

        return false;
    }

    public String getSymbol() {
        return "P";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
