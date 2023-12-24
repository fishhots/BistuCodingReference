package cn.campsg.practical.bubble.entity;


/**
 * 
 * 泡泡糖实体类，用于保存泡泡糖基本属性
 * 
 * @author Frank.Chen
 * @version 1.0
 *
 */
public class Star {

	/**
	 * 泡泡糖类型枚举值
	 */
	public enum StarType {
		
		BLUE(0), GREEN(1), YELLOW(2), RED(3), PURPLE(4);
		
		private int value = 0;
		
		private StarType(int value) { // 必须是private的，否则编译错误
			this.value = value;
		}

		public int value() {
			return this.value;
		}
		
		public static StarType valueOf(int value) {
			switch (value) {
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

	/* 泡泡糖在 10 * 10阵列中坐标位置 */
	private Position position;

	/* 泡泡糖类型（颜色） */
	private StarType type;

	public Star() {
		position = new Position();
		type = StarType.BLUE;
	}

	public Star(Position position, StarType type) {
		this.position = position;
		this.type = type;
	}

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

	/******************** PRJ-BU2-JAVA-005 Task3 ********************/


	public String toString(){
        return this.getPosition().toString()+")"+"type:"+this.getType();
    }
	
	
	
	
	
	
	
	
	/**************************************************************/
	

}
