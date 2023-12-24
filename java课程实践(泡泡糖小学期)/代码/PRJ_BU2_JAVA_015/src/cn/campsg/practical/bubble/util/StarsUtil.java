package cn.campsg.practical.bubble.util;

import java.util.HashMap;
import java.util.Map;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;

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
	private static void reorder(StarList starList) {

		for (int i = 0; i < starList.size() - 1; i++) {
			for (int j = 0; j < starList.size() - i - 1; j++) {
				// 获取第N个泡泡糖
				Star preStar = starList.get(j);
				// 获取第N个泡泡糖的后一个泡泡糖（N+1）
				Star nextStar = starList.get(j + 1);

				// 判断第N个泡泡糖的列是否大于第N+1个泡泡糖的列
				if (preStar.getPosition().getColumn() > nextStar.getPosition()
						.getColumn()) {
					// 如果第N个泡泡糖的列大于第N+1个泡泡糖的列
					// 那么互换两个泡泡糖保证列号大的泡泡糖在底部
					exchange(preStar, nextStar);
					continue;
				}

				// 如果第N个泡泡糖的列等于第N+1个泡泡糖的列
				if (preStar.getPosition().getColumn() == nextStar.getPosition()
						.getColumn()) {
					// 那么判定两个相等列号的泡泡糖的行号
					// 行号更大的泡泡糖向后交换，保证排序规则是升序。
					if (preStar.getPosition().getRow() > nextStar.getPosition()
							.getRow()) {
						exchange(preStar, nextStar);
					}
				}
			}
		}
	}

	/**
	 * 按升序规则交换两个泡泡糖在列表中的只
	 * 
	 * @param preStar
	 *            第N个泡泡糖
	 * @param nextStar
	 *            第N+1个泡泡糖
	 */
	private static void exchange(Star preStar, Star nextStar) {
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
	public static Map<Integer, StarList> group(StarList starList) {

		Map<Integer, StarList> ret = new HashMap<Integer, StarList>();

		reorder(starList);

		for(int i=0;i<starList.size();i++){
			Star star = starList.get(i);
			if (!ret.containsKey(star.getPosition().getColumn())) {
				// 如果返回结果中没有当前列号，则新建一个成员
				StarList starQueue = new StarList();
				starQueue.add(star);
				ret.put(star.getPosition().getColumn(), starQueue);
			} else {
				// 如果返回结果有当前列号，那么直接使用当前列号对应的数据
				ret.get(star.getPosition().getColumn()).add(star);
			}
		}

		return ret;
	}

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
