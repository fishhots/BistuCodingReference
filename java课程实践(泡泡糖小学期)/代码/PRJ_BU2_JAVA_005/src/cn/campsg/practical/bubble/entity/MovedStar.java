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
    	System.out.println("������ԭλ�ã�("+movedstar.getPosition().getRow()+","+movedstar.getPosition().getColumn()+")");
    	System.out.println("�������ƶ���Ŀ��λ��λ�ã�("+movedstar.getMovedPosition().getRow()+","+movedstar.getMovedPosition().getColumn()+")");
    	System.out.println("�����ǵ���ɫΪ��"+movedstar.getType());*/
    	
    	//5.2
    	MovedStar movedstar=new MovedStar(new Position(0,0),StarType.RED,new Position(1,1));
    	System.out.println(movedstar.toString());
    }
    public String toString(){
        return super.toString()+"\nnew "+position.toString();
    }
}
