package cn.campsg.practical.bubble.entity;

public class MovedStar extends Star{
	private Position position;
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getMovedPosition() {
        return position;
    }
    public MovedStar(){
    	super();
    }
    public MovedStar(Position position,StarType type,Position position1){
        super.setPosition(position);
        super.setType(type);
        this.position = position1;
    }
    public static void main(String[] args){
    	//5.1
    /*	MovedStar movedstar=new MovedStar(new Position(0,0),StarType.RED,new Position(1,1));
    	System.out.println("泡泡糖原位置：("+movedstar.getPosition().getRow()+","+movedstar.getPosition().getColumn()+")");
    	System.out.println("泡泡糖移动的目标位置位置：("+movedstar.getMovedPosition().getRow()+","+movedstar.getMovedPosition().getColumn()+")");
    	System.out.println("泡泡糖的颜色为："+movedstar.getType());*/
    	
    	//5.2
    	MovedStar movedstar=new MovedStar(new Position(0,0),StarType.RED,new Position(1,1));
    	System.out.println(movedstar.toString());
    }
    public String toString(){
        return super.toString()+"\nnew "+position.toString();
    }
}
