
public class Board{
    public static final int BOARD_SIZE = 8;

    List<Pieces> piecelist = new ArrayList<Pieces>(); 

    Pieces [BOARD_SIZE][BOARD_SIZE] board;

    public Board(){
        System.out.println("Board created");

    }

    public void generateML(Piece piece){

        //make sure the move list is empty before generating a new move list depending on the current position
        piece.moveList = null;
        if (piece.moveList==null){

            //check the type of pieces
            if(piece instanceof Rook){
                Rook_MoveList(piece);
            }

            else if(piece instanceof Pawn){
                Pawn_MoveList(piece);
            }

            else if(piece instanceof Bishop){
                Bishop_MoveList(piece);
            }

            else if(piece instanceof King){
                King_MoveList(piece);
            }

            else if(piece instanceof Queen){
                Queen_MoveList(piece);
            }

            else if(piece instanceof Knight){
                Knight_MoveList(piece);
            }
        }
    }

    //Move list for Rook
    public void Rook_MoveList(Pieces piece){

        Pos temp; 

        //check the right side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x + i;
            temp.y = piece.pos.y;

            if( isInbound(temp)){
                if( !isOccupied(temp) || isEnemy(piece,temp)) {
                    piece.movelist.add(temp);
                }
            }
        }

        //check the left side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x - i;
            temp.y = piece.pos.y;

            if( isInbound(temp)){
                if(!isOccupied(temp) || isEnemy(piece,temp) ){
                    piece.movelist.add(temp);
                }
            }
        }

        //check the top side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x;
            temp.y = piece.pos.y - i;


            if( isInbound(temp)){
                if( !isOccupied(temp) || isEnemy(piece,temp) ){
                    piece.movelist.add(temp);
                }
            }
        }

        //check the bottom side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x;
            temp.y = piece.pos.y + i;

            if( isInbound(temp)){
                if( !isOccupied(temp) || isEnemy(piece,temp) ){
                    piece.movelist.add(temp);
                }
            }
        }
    }
    //End of Rook movelist/////////////////////////////////////////////


    //Move list for pawn///////////////////////////////////////
    public void Pawn_MoveList(Pieces piece){

        if(piece.color.equals("w") ){

            Pos temp;
            Pos temp2;            

            //En passant for w piece
            if( !piece.isMoved ){

                temp.x = piece.pos.x;
                temp.y = piece.pos.y - 1;

                temp2.x = piece.pos.x;
                temp2.y = piece.pos.y - 2;

                if( !isOccupied(temp) ){   
                    piece.moveList.add(temp);
                }
                else if ( !isOccupied(temp2) ){
                    piece.moveList.add(temp2);
                }
            }

            //all other moves for w pawns
            else{

                //account for pawn that reaches the enemy side
                //if( !isInbound(piece.pos.y - 1)) then turn the pawn piece to the user desire piece

                //White pawn moving forward 
                temp.x = piece.pos.x;
                temp.y = piece.pos.y - 1;
                if( !isOccupied(temp) ){ 
                    piece.moveList.add(temp);
                }

                //w pawn checking potential kill at right top
                temp.x = piece.pos.x + 1;
                temp.y = piece.pos.y - 1;
                if( isEnemy(piece,temp) ){
                    piece.moveList.add(temp);   
                }

                //w pawn checking potential kill at left top
                temp.x = piece.pos.x - 1;
                temp.y = piece.pos.y - 1;
                if( isEnemy(piece,temp) ){
                    piece.moveList.add(temp);
                }
            } 
        }

        ////////////////////////////////////////////////////////////
        //Move list for b pawn
        else{
            Pos temp;
            Pos temp2;            

            //En passant for b piece
            if( !piece.isMoved ){

                temp.x = piece.pos.x;
                temp.y = piece.pos.y + 1;

                temp2.x = piece.pos.x;
                temp2.y = piece.pos.y + 2;

                if( !isOccupied(temp) ){   
                    piece.moveList.add(temp);
                }
                else if ( !isOccupied(temp2) ){
                    piece.moveList.add(temp2);
                }
            }

            //all other moves for b pawns
            else{

                //account for pawn that reaches the enemy side
                //if( !isInbound(piece.pos.y + 1)) then turn the pawn piece to the user desire piece

                //b pawn moving forward 
                temp.x = piece.pos.x;
                temp.y = piece.pos.y + 1;
                if( !isOccupied(temp) ){ 
                    piece.moveList.add(temp);
                }

                //b pawn checking potential kill at right bottom
                temp.x = piece.pos.x + 1;
                temp.y = piece.pos.y + 1;
                if( isEnemy(piece,temp) ){
                    piece.moveList.add(temp);   
                }

                //b pawn checking potential kill at left bottom
                temp.x = piece.pos.x - 1;
                temp.y = piece.pos.y + 1;
                if( isEnemy(piece,temp) ){
                    piece.moveList.add(temp);
                }
            }           

        }
    }
    //End of Pawn movelist/////////////////////////////////////////


    //Move list for Bishop/////////////////////////////////////////
    public void Bishop_MoveList(Pieces piece){

        Pos temp;

        //left top
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x - i;
            temp.y = piece.pos.y - i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        } 

        //left bottom
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x - i;
            temp.y = piece.pos.y + i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        }

        //right top
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x + i;
            temp.y = piece.pos.y - i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        }

        //right bottom
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x + i;
            temp.y = piece.pos.y + i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        }
    }
    //End of Bishop movelist///////////////////////////////////////


    //Move list for Queen//////////////////////////////////////////
    public void Queen_MoveList(Pieces piece){

        Pos temp;

        //check the right side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x + i;
            temp.y = piece.pos.y;

            if( isInbound(temp)){
                if( !isOccupied(temp) || isEnemy(piece,temp)) {
                    piece.movelist.add(temp);
                }
            }
        }

        //check the left side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x - i;
            temp.y = piece.pos.y;

            if( isInbound(temp)){
                if(!isOccupied(temp) || isEnemy(piece,temp) ){
                    piece.movelist.add(temp);
                }
            }
        }

        //check the top side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x;
            temp.y = piece.pos.y - i;


            if( isInbound(temp)){
                if( !isOccupied(temp) || isEnemy(piece,temp) ){
                    piece.movelist.add(temp);
                }
            }
        }

        //check the bottom side of the piece
        for(int i =1; i<BOARD_SIZE;i++){

            temp.x = piece.pos.x;
            temp.y = piece.pos.y + i;

            if( isInbound(temp)){
                if( !isOccupied(temp) || isEnemy(piece,temp) ){
                    piece.movelist.add(temp);
                }
            }
        }

        //left top
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x - i;
            temp.y = piece.pos.y - i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        } 

        //left bottom
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x - i;
            temp.y = piece.pos.y + i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        }

        //right top
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x + i;
            temp.y = piece.pos.y - i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        }

        //right bottom
        for(int i=1; i < BOARD_SIZE; i++){

            temp.x = piece.pos.x + i;
            temp.y = piece.pos.y + i;

            if( isInbound(temp) ){
                if( !isOccupied(temp) || isEnemy(temp) ){
                    piece.moveList.add(temp);
                }
            }
        }
    }
    //End of Queen movelsit/////////////////////////////////////////


    //Move list for Knight////////////////////////////////////////
    public void Knight_MoveList(Pieces piece){

        Pos temp;

        //case 1: x+1 y-2
        temp.x = piece.pos.x + 1;
        temp.y = piece.pos.y - 2;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }

        //case 2: x+2 y-1
        temp.x = piece.pos.x + 2;
        temp.y = piece.pos.y - 2;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }

        //case 3: x+2 y+1
        temp.x = piece.pos.x + 2;
        temp.y = piece.pos.y + 1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }

        //case 4: x+1 y+2
        temp.x = piece.pos.x + 1;
        temp.y = piece.pos.y + 2;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }

        //case 5: x-1 y+2
        temp.x = piece.pos.x - 1;
        temp.y = piece.pos.y + 2;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }

        //case 6: x-2 y+1
        temp.x = piece.pos.x - 2;
        temp.y = piece.pos.y + 1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }

        //case 7: x-2 y+1
        temp.x = piece.pos.x - 2;
        temp.y = piece.pos.y + 1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }

        //case 8: x-1 y-2
        temp.x = piece.pos.x - 1;
        temp.y = piece.pos.y - 2;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) ){
                piece.moveList.add(temp);
            }
        }
    }
    //End of Knight movelist//////////////////////////////////////

    //Move list for king
    public void King_MoveList(Pieces piece){

        Pos temp;

        temp.x = piece.pos.x-1;
        temp.y = piece.pos.y-1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }

        temp.x = piece.pos.x;
        temp.y = piece.pos.y-1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }
        
        temp.x = piece.pos.x+1;
        temp.y = piece.pos.y-1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }
        
        temp.x = piece.pos.x+1;
        temp.y = piece.pos.y;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }

        temp.x = piece.pos.x+1;
        temp.y = piece.pos.y+1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }

        temp.x = piece.pos.x;
        temp.y = piece.pos.y+1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }

        temp.x = piece.pos.x-1;
        temp.y = piece.pos.y+1;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }

        temp.x = piece.pos.x-1;
        temp.y = piece.pos.y;
        if( isInbound(temp) ){
            if( !isOccupied(temp) || isEnemy(piece,temp) || !isDying(temp) ){
                piece.moveList.add(temp);
            }
        }
    }
    //End of king movelsit//////////////////////////////////////////

    public void putPiecesOnBoard(){
        
        //creating pieces
        
        //kings
        piecelist.add(new King("w",3,7));
        piecelist.add(new King("b",3,0));
        
        board[3][7] = new King("w",3,7);
        board[3][0] = new King("b",3,0);

        //Queens
        piecelist.add(new Queen("w",4,7));
        piecelist.add(new Queen("b",4,0));

        //Rooks
        piecelist.add(new Rook("w",0,7));
        piecelist.add(new Rook("w",7,7));
        piecelist.add(new Rook("b",0,0));
        piecelist.add(new Rook("b",7,0));

        //Knights
        piecelist.add(new Knight("w",1,7));
        piecelist.add(new Knight("w",6,7));
        piecelist.add(new Knight("w",1,0));
        piecelist.add(new Knight("b",6,0));

        //Bishops
        piecelist.add(new Bishop("w",2,7));
        piecelist.add(new Bishop("w",5,7));
        piecelist.add(new Bishop("b",2,0));
        piecelist.add(new Bishop("b",5,0));

        //w pawns
        piecelist.add(new Pawn("w",0,6));
        piecelist.add(new Pawn("w",1,6));
        piecelist.add(new Pawn("w",2,6));
        piecelist.add(new Pawn("w",3,6));
        piecelist.add(new Pawn("w",4,6));
        piecelist.add(new Pawn("w",5,6));
        piecelist.add(new Pawn("w",6,6));
        piecelist.add(new Pawn("w",7,6));
        
        //b pawns
        piecelist.add(new Pawn("b",0,1));
        piecelist.add(new Pawn("b",1,1));
        piecelist.add(new Pawn("b",2,1));
        piecelist.add(new Pawn("b",3,1));
        piecelist.add(new Pawn("b",4,1));
        piecelist.add(new Pawn("b",5,1));
        piecelist.add(new Pawn("b",6,1));
        piecelist.add(new Pawn("b",7,1));
        

    }

    public Pieces Move(Pieces from, Pieces to){

    }    

    public boolean isOccupied(Pos p){

        for(int i =0; i<piecelist.size(); i++){
            if( (p.x = piecelist.get(i).pos.x) && (p.y = piecelist.get(i).pos.y) ){
                return true;
            }
        }
        return false;
    }

    public boolean isInbound(Pos p){
        if( (p.x<BOARD_SIZE && p.x >= 0) || (p.y<BOARD_SIZE && P.Y >= 0) ){
            return true;
        }
        return false;
    }

    public boolean isEnemy(Piece piece, Pos p){

        for( int i = 0; i<piecelist.size(); i++){
            if( piecelist.get(i).color.equals(piece.color) && ((p.x = piecelist.get(i).pos.x) && (p.y = piecelist.get(i).pos.y)) ){
                return true;
            }    
        }
        return false;
    }

    public boolean isDying(temp){

        
        return false;
    }


}
