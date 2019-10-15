class Piece {
    public boolean isValid(int x, int y) {
        System.out.println("Inside Base Class");
        if (x < 8 && y< 8) {
            return true;
        }
        return false;
    } 
}

class QueenPiece extends Piece {
    int x = 2;
    int y = 2;
    public boolean isValid(int x, int y) {
        if (super.isValid(x, y)) {
            System.out.println("Inside Derived Class");
            if (this.x == x) {
                return true;
            } else if(this.y == y) {
                return true;
            } else if(this.x + this.y == x + y) {
                return true;
            } else if(this.x - x == this.y - y) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}

public class Queen {
    public static void main(String[] args) {
        QueenPiece q = new QueenPiece();
        if(q.isValid(0, 0)) {
            System.out.println("Valid move");
        } else {
            System.out.println("Invalid move");
        }
        if(q.isValid(3, 4)) {
            System.out.println("Valid move");
        } else {
            System.out.println("Invalid move");
        }
    }
}
