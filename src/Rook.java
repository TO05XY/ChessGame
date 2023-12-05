public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPos(line) && this.checkPos(column) && this.checkPos(toLine) && this.checkPos(toColumn)) {
            int i;
            if (column == toColumn) {
                for(i = this.getMin(line, toLine); i < this.getMax(line, toLine); ++i) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column] == this && i == this.getMax(line, toLine)) {
                            return false;
                        }

                        if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine) {
                            return false;
                        }

                        if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine) {
                            return true;
                        }

                        if (i != toLine && i != line) {
                            return false;
                        }
                    }
                }

                if (chessBoard.board[toLine][column] != null) {
                    if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this) {
                        return false;
                    } else {
                        return !chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this;
                    }
                } else {
                    return true;
                }
            } else if (line != toLine) {
                return false;
            } else {
                for(i = this.getMin(toColumn, column); i < this.getMax(column, toColumn); ++i) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i] == this && i == this.getMax(column, toColumn)) {
                            return false;
                        }

                        if (chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn) {
                            return false;
                        }

                        if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn) {
                            return true;
                        }

                        if (i != toLine && i != column) {
                            return false;
                        }
                    }
                }

                if (chessBoard.board[toLine][toColumn] != null) {
                    if (chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this) {
                        return false;
                    } else {
                        return !chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this;
                    }
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "R";
    }

    public int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public int getMin(int a, int b) {
        return Math.min(a, b);
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
