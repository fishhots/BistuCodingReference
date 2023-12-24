package cn.campsg.practical.bubble.service;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.util.StarsUtil;
import cn.campsg.practical.bubble.util.StarsUtil;

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

	private Logger logger = Logger.getLogger(StarServiceImpl.class);

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

		test(stars);

		return stars;

	}

	private void test(StarList stars) {

		stars.get(1).setType(Star.StarType.BLUE);

		stars.get(5).setType(Star.StarType.YELLOW);
		stars.get(15).setType(Star.StarType.YELLOW);
		stars.get(25).setType(Star.StarType.YELLOW);
		stars.get(35).setType(Star.StarType.YELLOW);
		stars.get(45).setType(Star.StarType.YELLOW);
		stars.get(55).setType(Star.StarType.YELLOW);
		stars.get(65).setType(Star.StarType.YELLOW);
		stars.get(75).setType(Star.StarType.YELLOW);
		stars.get(85).setType(Star.StarType.YELLOW);
		stars.get(95).setType(Star.StarType.YELLOW);

		stars.get(7).setType(Star.StarType.YELLOW);
		stars.get(17).setType(Star.StarType.YELLOW);
		stars.get(27).setType(Star.StarType.YELLOW);
		stars.get(37).setType(Star.StarType.YELLOW);
		stars.get(47).setType(Star.StarType.YELLOW);
		stars.get(57).setType(Star.StarType.YELLOW);
		stars.get(67).setType(Star.StarType.YELLOW);
		stars.get(77).setType(Star.StarType.YELLOW);
		stars.get(87).setType(Star.StarType.YELLOW);
		stars.get(97).setType(Star.StarType.YELLOW);

		stars.get(9).setType(Star.StarType.YELLOW);
		stars.get(19).setType(Star.StarType.YELLOW);
		stars.get(29).setType(Star.StarType.YELLOW);
		stars.get(39).setType(Star.StarType.YELLOW);
		stars.get(49).setType(Star.StarType.YELLOW);
		stars.get(59).setType(Star.StarType.YELLOW);
		stars.get(69).setType(Star.StarType.YELLOW);
		stars.get(79).setType(Star.StarType.YELLOW);
		stars.get(89).setType(Star.StarType.YELLOW);
		stars.get(99).setType(Star.StarType.YELLOW);

		stars.get(2).setType(Star.StarType.YELLOW);
		stars.get(12).setType(Star.StarType.YELLOW);
		stars.get(22).setType(Star.StarType.YELLOW);
		stars.get(32).setType(Star.StarType.YELLOW);
		stars.get(42).setType(Star.StarType.YELLOW);
		stars.get(52).setType(Star.StarType.YELLOW);
		stars.get(62).setType(Star.StarType.YELLOW);
		stars.get(72).setType(Star.StarType.YELLOW);
		stars.get(82).setType(Star.StarType.YELLOW);
		stars.get(92).setType(Star.StarType.RED);

		stars.get(93).setType(Star.StarType.YELLOW);
		stars.get(94).setType(Star.StarType.YELLOW);

		stars.get(96).setType(Star.StarType.YELLOW);
		stars.get(98).setType(Star.StarType.YELLOW);

		stars.get(0).setType(Star.StarType.PURPLE);
		stars.get(10).setType(Star.StarType.PURPLE);
		stars.get(20).setType(Star.StarType.PURPLE);
		stars.get(30).setType(Star.StarType.PURPLE);
		stars.get(40).setType(Star.StarType.PURPLE);
		stars.get(50).setType(Star.StarType.PURPLE);
		stars.get(60).setType(Star.StarType.PURPLE);
		stars.get(70).setType(Star.StarType.RED);
		stars.get(80).setType(Star.StarType.GREEN);
		stars.get(90).setType(Star.StarType.GREEN);

		stars.get(81).setType(Star.StarType.GREEN);
		stars.get(11).setType(Star.StarType.RED);

		stars.get(11).setType(Star.StarType.GREEN);
		stars.get(21).setType(Star.StarType.GREEN);
		stars.get(31).setType(Star.StarType.GREEN);
		stars.get(41).setType(Star.StarType.GREEN);
		stars.get(51).setType(Star.StarType.GREEN);
		stars.get(61).setType(Star.StarType.GREEN);
		stars.get(71).setType(Star.StarType.GREEN);
		stars.get(81).setType(Star.StarType.GREEN);
		stars.get(91).setType(Star.StarType.GREEN);

		stars.get(3).setType(Star.StarType.YELLOW);
		stars.get(13).setType(Star.StarType.YELLOW);
		stars.get(23).setType(Star.StarType.YELLOW);
		stars.get(33).setType(Star.StarType.YELLOW);
		stars.get(43).setType(Star.StarType.YELLOW);
		stars.get(53).setType(Star.StarType.YELLOW);
		stars.get(63).setType(Star.StarType.YELLOW);
		stars.get(73).setType(Star.StarType.YELLOW);
		stars.get(83).setType(Star.StarType.YELLOW);

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
			star = (Star) sList.lookup(row, (col - 1));
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.clone(star));
					// 继续按左侧路径步进判断。
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// 向右侧路径步进判断
		if (col + 1 < StarService.MAX_COLUMN_SIZE) {
			// 不碰到右侧边界的情况下，获取被点击泡泡糖的右侧泡泡糖
			star = (Star) sList.lookup(row, (col + 1));
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.clone(star));
					// 继续按右侧路径步进判断。
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// 向上方路径步进判断
		if (row - 1 >= 0) {
			// 不碰到上方边界的情况下，获取被点击泡泡糖的上方泡泡糖
			star = (Star) sList.lookup((row - 1), col);
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.clone(star));
					// 继续按上方路径步进判断。
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// 向下方路径步进判断
		if (row + 1 < MAX_ROW_SIZE) {
			// 不碰到下方边界的情况下，获取被点击泡泡糖的下方泡泡糖
			star = (Star) sList.lookup((row + 1), col);
			// 已经被消除的泡泡糖在界面上排列的泡泡糖列表中会以null表示
			// 已经被消除的泡泡糖与清除列表中已经存在的泡泡糖无需重复判断，否则会进入死循环。
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// 被点击泡泡糖与判定泡泡保持一致时，加入列表。
					clearStars.add(StarsUtil.clone(star));
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

		if (logger.isDebugEnabled())
			logger.debug("待清除的泡泡糖内存列表:" + clearStars);

		return clearStars;
	}

	/**
	 * 消除泡泡糖后，获取待移动泡泡糖列表(仅限垂直列表的泡泡糖)<br>
	 * 该功能固定在消除被点击泡泡糖之后运行
	 * 
	 * @param clearStars
	 *            待清除的泡泡糖列表（以此作为判定待移动泡泡糖的基础）
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 待移动泡泡糖列表
	 */
	/*****************PRJ-BU2-JAVA-012 Task3 【3/3 Start 】*****************/
	public StarList getYMovedStars(StarList clearStars,
			StarList currentStarList) {
		StarList tobeMoved=new StarList();
		 //获取group返回的Map对象
		 Map<Integer,StarList> map=StarsUtil.group(clearStars);
		 //创建Map对象中Key的迭代器
		 Iterator<Integer> key=map.keySet().iterator();
		 //遍历迭代器
		 while(key.hasNext()){
			 //获取迭代器的Key值
			 int column=key.next();
			 //获取Key值对应Map中的Value(StarList)，此为当前【待消除泡泡糖】集合
			 StarList tmpClearStars=new StarList();
			 tmpClearStars=map.get(column);
			 Star lastStar;
			 int moved=0;
			 //修改为当前【待消除泡泡糖】集合
			 lastStar=tmpClearStars.get(tmpClearStars.size()-1);
			 for(int i=lastStar.getPosition().getRow();i>=0;i--)
			 {
				 Star star=new Star();
				 //修改为指定行值和列值的star对象
				 star=currentStarList.lookup(i, column);
				 if(star==null)
					 break;
				 else if(clearStars.existed(star)){
					 moved++;
				 }
				 else
				 {
					 MovedStar movedStar=new MovedStar();
					 movedStar.setPosition(new Position(star.getPosition().getRow(),star.getPosition().getColumn()));
					 movedStar.setType(star.getType());
					 movedStar.setMovedPosition(new Position((star.getPosition().getRow()+moved),star.getPosition().getColumn()));
					 tobeMoved.add(movedStar);
				 }
			 }
		}
		return tobeMoved;

	}
	/*****************PRJ-BU2-JAVA-012 Task3 【3/3 End 】*****************/

	/**
	 * 判断是否还存在未消除的泡泡糖
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return true:任然有未消除的泡泡糖,false:没有未消除的泡泡糖
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {

		// 待消除泡泡糖列表
		StarList clearStars = new StarList();

		for (int i = 0; i < currentStarList.size(); i++) {

			Star star = currentStarList.get(i);

			if (star != null)
				findStarsByPath(star, currentStarList, clearStars);

			// 如果待消除泡泡糖列表不等于0，则表示还有可消除的泡泡糖，返回true
			if (clearStars.size() > 0)
				return true;
		}

		if (logger.isDebugEnabled())
			logger.debug("不存在可消除的泡泡糖个数=" + getLeftStarNum(currentStarList));

		return false;
	}

	/**
	 * 获取剩余泡泡糖个数
	 * 
	 * @param mCurretStars
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 剩余泡泡糖个数
	 * */
	private int getLeftStarNum(StarList currentStarList) {
		int leftStar = 0;
		// 遍历泡泡糖列表，把不为null的泡泡糖记为剩余泡泡糖
		for (int i = 0; i < currentStarList.size(); i++) {
			if (currentStarList.get(i) != null)
				leftStar++;
		}
		if (logger.isDebugEnabled())
			logger.debug("还剩余未消除的泡泡糖数量为" + leftStar);
		// 返回剩余泡泡糖数目
		return leftStar;
	}

	/**
	 * 获取无法消除泡泡糖列表
	 * 
	 * @param curretStars
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 无法消除泡泡糖列表
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		StarList awardStarList = new StarList();

		// 遍历curretStars，把不为null的泡泡糖加到奖励泡泡糖列表中
		for (int i = 0; i < curretStars.size(); i++) {
			// tempStar = curretStars.get(i);
			if (curretStars.get(i) != null) {
				awardStarList.add(StarsUtil.clone(curretStars.get(i)));
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("还剩余未消除的泡泡糖数量为" + awardStarList);
		// 返回奖励泡泡糖列表
		return awardStarList;

	}

}
