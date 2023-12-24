package cn.campsg.practical.bubble.util;

import cn.campsg.practical.bubble.entity.MovedStar;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
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
	 * 排序指定列表中的泡泡糖<br>
	 * 排序规则：按列升序排序，如果列相同按行升序排序<br>
	 * 排序算法：冒泡排序
	 * 
	 * @param starList
	 *            待排序的泡泡糖列表
	 */
	/************ PRJ-BU2-JAVA-010 Task2 【2/3 start】***************/
	public static void sort(StarList SL){
		//实现SL的row属性的排序功能
        //排序规则：row值从小到大
        for(int i=0;i<SL.size();i++){
            for(int j=0;j<SL.size()-i-1;j++){
            	//若前一项大于后一项，进行交换
                if(SL.get(j).getPosition().getRow()>SL.get(j+1).getPosition().getRow()){
                    swap(SL.get(j),SL.get(j+1));
                }
            }
        }
	}
	/************ PRJ-BU2-JAVA-010 Task2 【2/3 end】*****************/
	
	/**
	 * 交换两个泡泡糖在列表中的位置
	 * 
	 * @param preStar
	 *            第N个泡泡糖
	 * @param nextStar
	 *            第N+1个泡泡糖
	 */
	/************ PRJ-BU2-JAVA-010 Task1 【1/3 start】***************/
	private static void swap(Star star1,Star star2){
		Star startmp=new Star();
		startmp.setPosition(new Position(star1.getPosition().getRow(),star1.getPosition().getColumn()));
		star1.setPosition(new Position(star2.getPosition().getRow(),star2.getPosition().getColumn()));
		star2.setPosition(new Position(startmp.getPosition().getRow(),startmp.getPosition().getColumn()));
		star1.setType(star2.getType());
		star2.setType(startmp.getType());
	}

	public static void main(String[] args){
	//10.1
	/*	Star s1=new Star(new Position(0,0),StarType.BLUE);
		Star s2=new Star(new Position(1,1),StarType.GREEN);
		System.out.println("交换前:preStar"+s1.toString()+"nextStar"+s2.toString());
		swap(s1,s2);
		System.out.println("交换后:preStar"+s1.toString()+"nextStar"+s2.toString());
		*/
		StarList SL=new StarList();
		SL.add(new Star(new Position(2,0),StarType.BLUE));
		SL.add(new Star(new Position(5,0),StarType.GREEN));
		SL.add(new Star(new Position(9,0),StarType.PURPLE));
		SL.add(new Star(new Position(3,0),StarType.RED));
		SL.add(new Star(new Position(8,0),StarType.YELLOW));
		System.out.println(SL.toString());
		sort(SL);
		System.out.print(SL.toString());
	}
	
	
	
	
	
	
	/************ PRJ-BU2-JAVA-010 Task1 【1/3 end】*****************/

	/**
	 * 克隆一个新的泡泡糖。
	 * 
	 * @param star
	 *            待克隆的泡泡糖
	 * @return 新的泡泡糖（独立内存地址的泡泡糖）。
	 */
	public static Star copy(Star star) {

		Star ret = new Star();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}

	public static MovedStar toMovedStar(Star star) {

		MovedStar ret = new MovedStar();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}
}
