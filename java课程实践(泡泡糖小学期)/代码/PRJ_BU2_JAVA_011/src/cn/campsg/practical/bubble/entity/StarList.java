package cn.campsg.practical.bubble.entity;

import java.util.ArrayList;

import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.service.StarService;

/**
 * 
 * 泡泡糖集合类，该组件的作用：<br>
 * <ul>
 * 	<li>1. 在内存中保存完整的10 * 10泡泡糖阵列，由Service负责计算泡泡糖阵列。</li>
 * <li>2. 负责界面与服务类之间的泡泡糖结构通讯。</li>
 * <li>3. 为泡泡糖阵列的计算、处理、修改提供各种功能函数
 *     <ul>
 *         <li>3-1. 更新10 * 10内存泡泡糖阵列中某个泡泡糖的坐标（泡泡糖移动时使用）。</li>
 *         <li>3-2. 判断某个泡泡糖在10 * 10内存泡泡糖阵列中是否存在。</li>
 *         <li>3-3. 将某个泡泡糖在10 * 10内存泡泡糖阵列中替换成Null（标记该泡泡糖已被消除）。</li>
 *         <li>3-4. 根据坐标从10 * 10内存泡泡糖阵列中寻找对应的泡泡糖对象。</li>
 *         <li>3-5. 根据坐标从10 * 10内存泡泡糖阵列中寻找对应的泡泡糖索引。</li>
 *     </ul>
 * </li>
 * </ul> 
 * @see cn.campsg.practical.bubble.entity.Star
 * 
 * @author Frank.Chen
 * @version 1.0
 *
 */
public class StarList extends ArrayList<Star>{

	private static final long serialVersionUID = 1L;

	/**
	 * 根据坐标从10 * 10内存泡泡糖阵列中寻找对应的泡泡糖对象。
	 * 
	 * @param row			待寻找的泡泡糖行号
	 * @param column	待寻找的泡泡糖列号
	 */
	/*******PRJ-BU
	 * 2-JAVA-011 Task1 【1/3 Start】**********/
	 public Star lookup(int row,int column){
	    	for(int i=0;i<super.size();i++){
	    		//判断是否为空
	    		if(super.get(i)==null){
	    			continue;
	    		}
	    		//比较获取对象行列值是否相等
	    		else if(super.get(i).getPosition().getRow()==row && super.get(i).getPosition().getColumn()==column){
	    			return super.get(i);
	    		}
	    	}
	    	return null;
	}
	 //11.1
/*	 public static void main(String[] args) {
	    	StarList str = new StarList();
	    	for(int i=0;i<10;i++){
	    		str.add(new Star(new Position(i,0),StarType.BLUE));
	    	}
			System.out.println("(3,0)位置的泡泡糖"+str.lookup(3,0));
			System.out.println("(1,1)位置的泡泡糖"+str.lookup(1,1));
	    }

	/*******PRJ-BU2-JAVA-011 Task1 【1/3 End】***********/
	
	/**
	 * 根据坐标从10 * 10内存泡泡糖阵列中寻找对应的泡泡糖对象。
	 * 
	 * @param position	待寻找的泡泡糖位置
	 */
	/*******PRJ-BU2-JAVA-011 Task2 【2/3 Start】**********/
	 public Star lookup(Position position){
		 return this.lookup(position.getRow(), position.getColumn());
	 }
	 //11.2
	 public static void main(String[] args) {
	    	StarList str = new StarList();
	    	for(int i=0;i<10;i++){
	    		str.add(new Star(new Position(i,0),StarType.BLUE));
	    	}
			System.out.println("(3,0)位置的泡泡糖"+str.lookup(new Position(3,0)));
			System.out.println("(1,1)位置的泡泡糖"+str.lookup(new Position(1,1)));
	    }
	
	/*******PRJ-BU2-JAVA-011 Task2 【2/3 End】***********/

	/**
	 * 判断某个泡泡糖在10 * 10内存泡泡糖阵列中是否存在。
	 * 
	 * @param star 待判断的泡泡糖对象
	 * @return true:存在，false:不存在
	 */
	/*******PRJ-BU2-JAVA-011 Task3 【3/3 Start】*********/
	 public boolean existed(Star star){
		 if(star==null)
			 return false;
		 else if(this.lookup(star.getPosition())!=null)
			 {
			 return true;
			 }
		 else
			 return false;
	 }

	/*******PRJ-BU2-JAVA-011 Task3 【3/3 End】***********/

	/**
	 * 得到10 * 10内存泡泡糖阵列中最后一个泡泡糖
	 * 
	 * @return 最后一个泡泡糖
	 */
	public Star lastElement() {
		int size = size();

		if (size == 0)
			return null;

		return get(size - 1);
	}

	/**
	 * 根据坐标从10 * 10内存泡泡糖阵列中寻找对应的泡泡糖索引。
	 * eg:
	 * 	0 1 2
	 *  3 4 5
	 *  6 7 8
	 * 
	 * @param row			待寻找的泡泡糖行号
	 * @param column	待寻找的泡泡糖列号
	 * @return					泡泡糖在10 * 10内存泡泡糖阵列中索引
	 */
	public int indexOf(int row, int column) {

		int base = (int) Math.sqrt(size());

		return row * base + column;
	}
	
	/**
	 * 将某个泡泡糖在10 * 10内存泡泡糖阵列中替换成Null（标记该泡泡糖已被消除）
	 * 
	 * @param row			标记为Null的泡泡糖行号
	 * @param column	标记为Null的泡泡糖列号
	 */
	public void setNull(int row, int column) {
		//根据坐标寻找泡泡糖
		Star star = lookup(row, column);
		
		//获取泡泡糖在10 * 10内存泡泡糖阵列中索引号
		int seq = indexOf(star);

		if (seq < 0)
			return;
		
		//将10 * 10内存泡泡糖阵列中对应位置设置为Null
		set(seq, null);
	}
	
	/**
	 * 更新10 * 10内存泡泡糖阵列中某个泡泡糖的坐标（泡泡糖移动时使用）
	 * 
	 * @param orow			泡泡糖原始行号
	 * @param ocolumn		泡泡糖原始列号
	 * @param row				泡泡糖待更新的行号
	 * @param column		泡泡糖待更新的列号
	 */
	public void update(int orow, int ocolumn, int row, int column) {
		//根据行号与列号获取泡泡糖原始对象
		Star ostar = lookup(orow, ocolumn);
		//根据行号与列号获取泡泡糖目标对象
		Star star = lookup(row, column);

		//如果目标泡泡糖为空，那么为根据坐标创建一个目标泡泡糖
		if (star == null) {
			star = new Star();
			star.setPosition(new Position(row, column));
			//将泡泡求更新到目标位置
			set(indexOf(row, column), star);
		}
		
		//更新泡泡糖只需直接替换颜色即可（坐标无需变化）
		star.setType(ostar.getType());
		
		//原始泡泡糖位置设置为Null表示原始泡泡已经被消除
		setNull(orow, ocolumn);

	}
	
	@Override
	public String toString() {

		StringBuffer date = new StringBuffer("·");
		for (int seq = 0; seq < size(); seq++) {
			Star star = get(seq);
			if (star != null) {

				if(star instanceof MovedStar){
					MovedStar movedStar = (MovedStar)star;
					int orowNum = movedStar.getPosition().getRow();
					int ocolNum = movedStar.getPosition().getColumn();
					int rowNum = movedStar.getMovedPosition().getRow();
					int colNum = movedStar.getMovedPosition().getColumn();
					date.append("(" + orowNum + "," + ocolNum + ")->"+"(" + rowNum + "," + colNum + ")"+"\t");
				}else{
					int rowNum = star.getPosition().getRow();
					int colNum = star.getPosition().getColumn();
					date.append("(" + rowNum + "," + colNum + "-" + star.getType()
							+ ") \t");
				}
			} else {
				date.append("(null) \t\t");
			}

			if ((seq + 1) % StarService.MAX_COLUMN_SIZE == 0) {
				date.append("\n");
			} else {
				date.append(" ,");
			}
		}
		date.deleteCharAt(date.length()-1);

		return date.toString();
	}
}
