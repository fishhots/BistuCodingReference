package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;

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
	/*public StarList createStars() {

		StarList stars = new StarList();
		/******************** PRJ-BU2-JAVA-003 ********************/
		//3.1
		/*for(int i=0;i<MAX_COLUMN_SIZE;i++){
				Star s=new Star(new Position(0,i),StarType.RED);
				stars.add(s);
			}
	*/
		//3.2
	/*	for(int i=0;i<MAX_COLUMN_SIZE;i++){
			for(int j=0;j<MAX_ROW_SIZE;j++){
				Star s=new Star(new Position(i,j),StarType.RED);
				stars.add(s);
			}
		}
		
		//3.3
	/*	for(int i=0;i<MAX_COLUMN_SIZE;i++){
			for(int j=0;j<MAX_ROW_SIZE;j++){
				Star s=new Star(new Position(i,j),StarType.valueOf((int)(Math.random()*STAR_TYPES)));//随机获取枚举值
				stars.add(s);
			}
		}
		
		/**************************************************************/
	//	return stars;
	//}
	public StarList createStars() {
		StarList stars = new StarList();
		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {
			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {
				if(row!=6&&col!=3){
				Star star = new Star();
				star.setPosition(new Position(row, col));		
				int typeIndex = (int) (3);
				star.setType(StarType.valueOf(typeIndex));
				stars.add(star);
				}
			}
		}
		if(true){
			Star star=new Star();
			star.setPosition(new Position(6,3));
			star.setType(StarType.RED);
			stars.add(star);
		}
		for(int i=0;i<MAX_COLUMN_SIZE;i++)
		{
			if(i!=3){
			Star star=new Star();
			star.setPosition(new Position(6,i));
			star.setType(StarType.YELLOW);
			stars.add(star);
		}
		}
		for(int i=0;i<10;i++)
		{
			if(i!=6){
				Star star=new Star();
				star.setPosition(new Position(i,3));
				star.setType(StarType.BLUE);
				stars.add(star);
			}
		}
		
		return stars;
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
		return null;
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
