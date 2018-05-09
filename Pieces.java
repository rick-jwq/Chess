class Pieces{
    Pos pos;
    String color;
    List<Pos> moveList = new ArrayList<Pos>();
    boolean isMoved;

} 

class Rook extends Pieces{
    
    
    public Rook(String _color, int x, int y){
        this.color = _color;
        this.pos.x = x; 
        this.pos.y = y;
        moveList = null; 
    }


}

class Bishop extends Pieces{
    public Bishop(String _color, int x, int y){
        this.color = _color;
        this.pos.x = x; 
        this.pos.y = y;
        moveList = null;
    }
} 

class Knight extends Pieces{
    public Knight(String _color, int x, int y){
        this.color = _color;
        this.pos.x = x; 
        this.pos.y = y;
        moveList = null;
    }

}

class King extends Pieces{
    public King(String _color, int x, int y){
        this.color = _color;
        this.pos.x = x; 
        this.pos.y = y;
        moveList = null;
    }

}

class Queen extends Pieces{
    public Queen(String _color, int x, int y){
        this.color = _color;
        this.pos.x = x; 
        this.pos.y = y;
        moveList = null;
    }

}

class Pawn extends Pieces{
        
    public Pawn(String _color, int x, int y){
        this.color = _color;
        this.pos.x = x; 
        this.pos.y = y;
        moveList = null;
        boolean isMoved = false;

    }

}

class Dummy extends Pieces{
    public Dummy(String _color, int x, int y){
        this.color = _color;
        this.pos.x = x; 
        this.pos.y = y;
        moveList = null;
    }
}
