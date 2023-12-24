package cn.campsg.practical.bubble.util;
import cn.campsg.practical.bubble.entity.*;
import cn.campsg.practical.bubble.entity.Star.StarType;
/**
 * 泡泡糖/待移动泡泡糖实体类工具类，提供以下功能：<br>
 * <ul>
 * <li>1. 排序指定列表中的泡泡糖-按列升序排序，列相同按行升序排序（冒泡排序算法）。</li>
 * <li>2. 对指定列表中的泡泡糖按行分组。</li>
 * <li>3. 克隆一个泡泡糖对象</li>
 * </ul>
 * 
 * @see cn.campsg.practical.bubble.entity.Star
 * @see cn.campsg.practical.bubble.entity.MovedStar
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 *
 */
public class StarsUtil {
	/**
	 * 克隆一个新的泡泡糖。
	 * 
	 * @param star
	 *            待克隆的泡泡糖
	 * @return 新的泡泡糖（独立内存地址的泡泡糖）。
	 */
	/******************** PRJ-BU2-JAVA-004 Task1 ********************/
	public static Star clone(Star star){
		Star cloneStar=new Star();
		cloneStar.setPosition(new Position(star.getPosition().getRow(),star.getPosition().getColumn()));
		cloneStar.setType(star.getType());
		return cloneStar;
	}
	
	//4.1
	public static void main(String[] args){
		Star star=new Star(new Position(5,5),StarType.RED);
		Star cloneStar=clone(star);
		System.out.println("原泡泡糖的对象为:"+"("+star.getPosition().getRow()+","+star.getPosition().getColumn()+"-"+star.getType()+")");
		System.out.println("克隆泡泡糖对象为:"+"("+cloneStar.getPosition().getRow()+","+cloneStar.getPosition().getColumn()+"-"+cloneStar.getType()+")");
		System.out.println("两对象是否一致:"+star.equals(cloneStar));
		System.out.println("两对象的坐标是否一致:"+star.getPosition().equals(cloneStar.getPosition()));
	}

	/**************************************************************/
}
