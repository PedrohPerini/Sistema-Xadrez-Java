package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece [][] pieces;

    public Board(int rows, int columns) {

        if (rows < 1 || columns < 1) {
            throw new BoardException("Error ao criar o tabuleiro: tem que ter pelo menos uma linha e uma coluna");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Piece piece (int row, int columns){
        if(!positionExists(row, columns)){
            throw new BoardException("Erro : Posição não existe");
        }
            return pieces [row][columns];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Erro : Posição não existe");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece (Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("Já tem uma peça na posição: " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positionExists (Position position){

        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece (Position position){
        if(!positionExists(position)){
            throw new BoardException("Erro : Posição não existe");
        }
        return piece(position) != null;
    }


}
