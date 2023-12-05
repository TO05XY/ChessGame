public abstract class ChessPiece {
    String color;
    boolean check = true;
    public ChessPiece(String color) {
        this.color = color;
    }
    public abstract String getColor();
    public abstract Boolean canMoveToPosition(ChessBoard var1, int var2, int var3, int var4, int var5);
    public abstract String getSymbol();
}
