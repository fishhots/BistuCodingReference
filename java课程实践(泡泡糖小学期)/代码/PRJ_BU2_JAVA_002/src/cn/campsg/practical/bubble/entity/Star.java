package cn.campsg.practical.bubble.entity;

public class Star {
	public enum StarType{			//创建枚举类型，以便于识别Type属性
	 BLUE(0),GREEN(1),YELLOW(2),RED(3),PURPLE(4);
	 private int value;
	 StarType(){
			
		}
		StarType(int value){			//用于保存枚举值
			this.value=value;
		}
	private int getValue(){
		return value;
	}
	public int value(){				//实现枚举值向数值转换
        if(this==BLUE){
            return 0;
        }else if(this==GREEN){
            return 1;
        }else if(this==YELLOW){
            return 2;
        }else if(this==RED){
            return 3;
        }else if(this==PURPLE){
            return 4;
        }else{return -1;}
    }
    
    public static StarType valueOf(int value){	//实现数值向枚举值的转换
        switch(value){
        case 0:
            return BLUE;
        case 1:
            return GREEN;
        case 2:
            return YELLOW;
        case 3:
            return RED;
        case 4:
            return PURPLE;
        default:
            return null;
        }
    }
	}
	Position position;				//为Star增加Position和type属性
	StarType type;
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public StarType getType() {
        return type;
    }
    public void setType(StarType type) {
        this.type = type;
    }
    public Star(Position position,StarType type){
        this.position=position;
        this.type=type;
    }
    public Star(){
        this.type=StarType.BLUE;
    }   
    
	
}



