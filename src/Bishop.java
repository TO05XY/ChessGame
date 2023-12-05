public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn && this.getMax(line, toLine) - this.getMin(line, toLine) == this.getMax(column, toColumn) - this.getMin(column, toColumn) && this.checkPos(line) && this.checkPos(column) && this.checkPos(toLine) && this.checkPos(toColumn) && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) && chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            } else {
                int fromL;
                int fromC;
                int toC;
                int[][] positions;
                int i;
                if (column == this.getMin(column, toColumn) && line == this.getMax(line, toLine) || toColumn == this.getMin(column, toColumn) && toLine == this.getMax(line, toLine)) {
                    fromL = this.getMax(line, toLine);
                    fromC = this.getMin(column, toColumn);
                    this.getMin(line, toLine);
                    toC = this.getMax(column, toColumn);
                    positions = new int[toC - fromC][1];

                    for(i = 1; i < toC - fromC; ++i) {
                        if (chessBoard.board[fromL - i][fromC + i] == null) {
                            positions[i - 1] = new int[]{fromL - i, fromC + i};
                        } else {
                            if (chessBoard.board[fromL - i][fromC + i].color.equals(this.color) || fromL - i != toLine) {
                                return false;
                            }

                            positions[i - 1] = new int[]{fromL - i, fromC + i};
                        }
                    }

                    return true;
                } else {
                    fromL = this.getMin(line, toLine);
                    fromC = this.getMin(column, toColumn);
                    this.getMax(line, toLine);
                    toC = this.getMax(column, toColumn);
                    positions = new int[toC - fromC][1];

                    for(i = 1; i < toC - fromC; ++i) {
                        if (chessBoard.board[fromL + i][fromC + i] == null) {
                            positions[i - 1] = new int[]{fromL + i, fromC + i};
                        } else {
                            if (chessBoard.board[fromL + i][fromC + i].color.equals(this.color) || fromL + i != toLine) {
                                return false;
                            }

                            positions[i - 1] = new int[]{fromL + i, fromC + i};
                        }
                    }

                    return true;
                }
            }
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "B";
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
