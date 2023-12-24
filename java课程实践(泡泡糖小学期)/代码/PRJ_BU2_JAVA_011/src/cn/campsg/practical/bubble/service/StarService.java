package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;

public interface StarService {
	
	/* 泡泡糖最大行数 */
	public static final int MAX_ROW_SIZE = 10;
	
	/* 泡泡糖最大列数 */
	public static final int MAX_COLUMN_SIZE = 10;
	
	/* 泡泡糖的种类数 */
	public static final int STAR_TYPES = 5;
		
	/**
	 * 创建屏幕画布随机泡泡糖（10 * 10）
	 * 
	 * @return 泡泡糖列表-供画面显示
	 */
	public StarList createBubbleMatrix();
	
	/**
	 * 用户点击泡泡糖，获取满足消除条件的泡泡糖列表
	 * 
	 * @param base 被用户点击的泡泡糖
	 * @param sList 当前画面上泡泡的列表
	 * @return 需要清除的泡泡糖
	 */
	public StarList tobeClearedStars(Star base,StarList sList);
	
	/**
	 * 消除泡泡糖后，获取待移动泡泡糖列表(仅限垂直列表的泡泡糖)<br>
	 * 该功能固定在消除被点击泡泡糖之后运行
	 * 
	 * @see tobeClearedStars
	 * 
	 * @param clearStars 待清除的泡泡糖列表（以此作为判定待移动泡泡糖的基础）
	 * @param currentStarList 当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 待移动泡泡糖列表
	 */
	public StarList getVMovedStars(StarList clearStars,StarList currentStarList);
	
	/**
	 * 消除泡泡糖后，获取待移动泡泡糖列表(仅限水平列表的泡泡糖)<br>
	 * 该功能固定在垂直列表的泡泡糖之后运行
	 * 
	 * @see getYMovedStars
	 * 
	 * @param currentStarList 当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 待移动泡泡糖列表
	 */
	public StarList getHMovedStars(StarList currentStarList);
	
	/**
	 * 判断是否还存在未消除的泡泡糖
	 * 
	 * @param currentStarList 当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return true:任然有未消除的泡泡糖,false:没有未消除的泡泡糖
	 */
	public boolean tobeEliminated(StarList currentStarList);
	
	/**
	 * 获取无法消除泡泡糖列表
	 * 
	 * @param curretStars 当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 无法消除泡泡糖列表
	 * */
	public StarList getAwardStarList(StarList currentStarList);
	

}
