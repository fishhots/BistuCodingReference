package cn.campsg.practical.bubble.util;

import java.util.HashMap;
import java.util.Map;

import cn.campsg.practical.bubble.MainForm;
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
	public static void sort(StarList starList) {
		/*****PRJ-BU2-JAVA-012 Task1 【1/3 Start】*******/
		for (int i = 0; i < starList.size() - 1; i++) {
			for (int j = 0; j < starList.size() - i - 1; j++) {
				// 获取第N个泡泡糖
				Star preStar = starList.get(j);
				// 获取第N个泡泡糖的后一个泡泡糖（N+1）
				Star nextStar = starList.get(j + 1);
				//若前一个的列坐标大于后一个，进行交换
				if (preStar.getPosition().getColumn() > nextStar.getPosition()
						.getColumn()) {
					swap(preStar, nextStar);
				}
				//列坐标相同时判断行坐标
				else if(preStar.getPosition().getColumn() == nextStar.getPosition()
						.getColumn()){
					//若前一个行坐标大于后一个，进行交换
					if(preStar.getPosition().getRow() > nextStar.getPosition()
					.getRow()){
						swap(preStar, nextStar);
					}
				}
				
			}
		}
		
		/*****PRJ-BU2-JAVA-012 Task1 【1/3 End】********/
	}
	public static void main(String[] args) 
	{
		StarList starlist=new StarList();
		starlist.add(new Star(new Position(2,3),StarType.BLUE));
		starlist.add(new Star(new Position(1,5),StarType.GREEN));
		starlist.add(new Star(new Position(0,9),StarType.PURPLE));
		starlist.add(new Star(new Position(0,3),StarType.RED));
		starlist.add(new Star(new Position(0,8),StarType.YELLOW));
		//12.1
	//	System.out.println(starlist);
		//sort(starlist);
		Map<Integer,StarList> map=group(starlist);
	//	System.out.println(starlist);
		System.out.println(map);
	}

	/**
	 * 按升序规则交换两个泡泡糖在列表中的只
	 * 
	 * @param preStar
	 *            第N个泡泡糖
	 * @param nextStar
	 *            第N+1个泡泡糖
	 */
	private static void swap(Star preStar, Star nextStar) {
		// 创建临时交换泡泡糖对象
		Star tempStar = new Star();

		// 将第N个泡泡糖的数据保存入临时交换泡泡糖对象
		tempStar.getPosition().setRow(preStar.getPosition().getRow());
		tempStar.getPosition().setColumn(preStar.getPosition().getColumn());
		tempStar.setType(preStar.getType());

		// 将第N+1个泡泡糖的数据保存入第N个泡泡糖
		preStar.getPosition().setRow(nextStar.getPosition().getRow());
		preStar.getPosition().setColumn(nextStar.getPosition().getColumn());
		preStar.setType(nextStar.getType());

		// 将临时交换泡泡糖对象的数据保存入第N+1个泡泡糖
		nextStar.getPosition().setRow(tempStar.getPosition().getRow());
		nextStar.getPosition().setColumn(tempStar.getPosition().getColumn());
		nextStar.setType(tempStar.getType());
	}

	/**
	 * 按列号对泡泡糖集合中泡泡糖进行分组（相同列号的泡泡糖分在一个组别中）<br>
	 * 分组前应该先对泡泡糖集合进行排序。
	 * 
	 * @see sort
	 * 
	 * @param mStarList
	 *            待分组的泡泡糖列表
	 * @return 
	 *         分组结果，Map中的key是列号，value是相同列的泡泡糖集合，例如：1-{(1,2);(1,3);(1,4)}；2-{(2,2)
	 *         ;(2,3);(2,4)}
	 */
	/*****PRJ-BU2-JAVA-012 Task2 【2/3 Start】*******/
	public static Map<Integer,StarList> group(StarList starlist){
		Map<Integer,StarList> map=new HashMap<Integer,StarList>();
		sort(starlist);
		//遍历"待消除泡泡糖"集合
		for(int i=0;i<starlist.size();i++){
			//存储泡泡糖对象,泡泡糖的【列值】
			Star star=starlist.get(i);
			int column=starlist.get(i).getPosition().getColumn();
			//判断【列值】是否存在HashMap
			if(!map.containsKey(column)){
				//不存在，创建一个新StarList集合，并将泡泡糖并入
				StarList sl=new StarList();
				sl.add(star);
				//将对应【列值】和StarList集合存入HashMap
				map.put(column, sl);
			}
			else{
				//存在，取出对应【列值】对应的value集合，并将新泡泡糖加入集合
				StarList sl=map.get(column);
				sl.add(star);
				//将集合存入HashMap
				map.put(column, sl);
			}
		}
		return map;
	}
	/*****PRJ-BU2-JAVA-012 Task2 【2/3 End】*********/

	/**
	 * 克隆一个新的泡泡糖。
	 * 
	 * @param star
	 *            待克隆的泡泡糖
	 * @return 新的泡泡糖（独立内存地址的泡泡糖）。
	 */
	public static Star clone(Star star) {

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
