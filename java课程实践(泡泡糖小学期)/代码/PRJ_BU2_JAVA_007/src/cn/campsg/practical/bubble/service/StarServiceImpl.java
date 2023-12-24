package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.util.StarsUtil;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.entity.Star.StarType;

/**
 * 
 * 泡泡糖业务计算服务类，用于为界面提供以下服务<br>
 * 1. 创建屏幕画布随机泡泡糖<br>
 * 2. 切关判定<br>
 * 3. 根据消除的泡泡计算得分<br>
 * 4. 计算剩余泡泡糖的得分奖励<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	/**
	 * 创建屏幕画布随机泡泡糖（10 * 10）
	 * 
	 * @return 泡泡糖列表-供画面显示
	 */
	@Override
	public StarList createBubbleMatrix() {
		StarList stars = new StarList();
		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {
			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {
				Star star = new Star();
				// 设置泡泡糖在画面上的位置
				star.setPosition(new Position(row, col));
				// 产生随机的泡泡糖
				int typeIndex = (int) (Math.random() * StarService.STAR_TYPES);
				star.setType(StarType.valueOf(typeIndex));
				// 加入列表
				stars.add(star);
			}
		}
		return stars;
	}

	/**
	 * 以给定泡泡糖（用户点击的）为基础，向左右、上下路径依次寻找相同类型的泡泡糖
	 * 
	 * @param base
	 *            基础泡泡糖（用户点击的）
	 * @param sList
	 *            原始泡泡糖列表（界面上排列的泡泡糖）
	 * @param clearStars
	 *            待清除的泡泡糖列表
	 */
	private void findStarsByPath(Star base, StarList sList, StarList clearStars) {
		// 获取当前被点击泡泡糖的行和列
		int row = base.getPosition().getRow();
		int col = base.getPosition().getColumn();
		StarType type = base.getType();

		Star star = null;

		// 向左侧路径步进判断
		if (col - 1 >= 0) {
			// 不碰到左侧边界的情况下，获取被点击泡泡糖的左侧泡泡糖
			star = (Star) sList.findout(row, (col - 1));
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.copy(star));
					// 继续按左侧路径步进判断。
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// 向右侧路径步进判断
		if (col + 1 < StarService.MAX_COLUMN_SIZE) {
			// 不碰到右侧边界的情况下，获取被点击泡泡糖的右侧泡泡糖
			star = (Star) sList.findout(row, (col + 1));
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.copy(star));
					// 继续按右侧路径步进判断。
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// 向上方路径步进判断
		if (row - 1 >= 0) {
			// 不碰到上方边界的情况下，获取被点击泡泡糖的上方泡泡糖
			star = (Star) sList.findout((row - 1), col);
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.copy(star));
					// 继续按上方路径步进判断。
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// 向下方路径步进判断
		if (row + 1 < MAX_ROW_SIZE) {
			// 不碰到下方边界的情况下，获取被点击泡泡糖的下方泡泡糖
			star = (Star) sList.findout((row + 1), col);
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.copy(star));
					// 继续按下方路径步进判断。
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// 以上四个判断都不进，则表示四周都没用泡泡糖了，那么跳出递归方法。
	}

	/**
	 * 用户点击泡泡糖，获取满足消除条件的泡泡糖列表
	 * 
	 * @param base
	 *            被用户点击的泡泡糖
	 * @param sList
	 *            当前画面上泡泡的列表
	 * @return 需要清除的泡泡糖
	 */
	@Override
	public StarList tobeClearedStars(Star base, StarList mCurrent) {
		// 用于保存待清除的泡泡糖
		StarList clearStars = new StarList();
		// 从当前列表中获取指定行与指定列的泡泡糖（base泡泡糖）
		// 将该泡泡糖作为清除对象保存于列表中
		// 注意：所有待清除的泡泡糖都应该在原始的界面泡泡糖列表中
		clearStars.add(base);
		// 以被点击泡泡糖为基础按左右、上下不同路径寻找相同类型（颜色）的待清除泡泡糖
		findStarsByPath(base, mCurrent, clearStars);
		if (clearStars.size() == 1)
			clearStars.clear();
		return clearStars;
	}

	public StarList getYMovedStars(StarList clearStars,
			StarList currentStarList) {
		return null;
	}

	/**
	 * 消除泡泡糖后，获取待移动泡泡糖列表(仅限水平列表的泡泡糖)<br>
	 * 该功能固定在垂直列表的泡泡糖之后运行
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * 
	 * @return 待移动泡泡糖列表
	 */
	public StarList getXMovedStars(StarList currentStarList) {
		return null;
	}

	/**
	 * 判断是否还存在未消除的泡泡糖
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return true:任然有未消除的泡泡糖,false:没有未消除的泡泡糖
	 * 
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		return false;
	}

	/**
	 * 获取无法消除泡泡糖列表
	 * 
	 * @param curretStars
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 无法消除泡泡糖列表
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		return null;
	}

}
