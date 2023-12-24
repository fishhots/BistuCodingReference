package cn.campsg.practical.bubble.entity;

public class Position {
    private int row;
    private int column;
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public Position(int row,int column){
        this.row=row;
        this.column=column;
    }
    public Position(){
        
    }
    
}
