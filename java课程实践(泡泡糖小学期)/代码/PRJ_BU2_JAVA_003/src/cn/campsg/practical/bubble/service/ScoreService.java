package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.StarList;

public interface ScoreService {
	
	/* 剩余不可消除的泡泡奖励的最高得分 */
	public static final int TOP_AWARD_SCORE = 2000;

	/* 剩余不可消除的泡泡奖励的极限 */
	public static final int AWARD_LIMIT = 10;
	
	/* 剩余不可消除的泡泡单个奖励的最低得分  */
	public static final int LOWER_AWARD_SCORE = 20;
	
	/* 消除一个泡泡糖的最低得分 */
	public static final int LOWER_SCORE = 5;

	/**
	 * 计算出下一关的通关分数
	 * 
	 * @param 当前关卡
	 * @return 计算出的得分
	 * 
	 */
	public int nextScoreByLevel(int currentLevel);
	
	/**
	 * 获得当前关的通关分数
	 * 
	 * @return 计算出的得分
	 * 
	 */
	public int getCurrentLevelScore();

	/**
	 * 根据点击后获取的待消除泡泡糖计算出得分<br>
	 * 点击后泡泡糖消除得分规则: <br>
	 * 1. 消除第1颗泡泡糖 --> 得5分 <br>
	 * 2. 消除第2颗泡泡糖 --> 得15分 <br>
	 * 3. 消除第3颗泡泡糖 --> 得25分 <br>
	 * 4. 消除第4颗泡泡糖 --> 得35分<br>
	 * 5. 消除第5颗泡泡糖 --> 得45分<br>
	 * 
	 * @param stars 根据点击后获取的待消除泡泡糖集合
	 * @return 计算出的得分
	 * */
	public int getScoreByNum(StarList stars);

	/**
	 * 根据点击后获取的待消除泡泡糖数量计算出得分<br>
	 * 点击后泡泡糖消除得分规则: <br>
	 * 1. 消除第1颗泡泡糖 --> 得5分 <br>
	 * 2. 消除第2颗泡泡糖 --> 得15分 <br>
	 * 3. 消除第3颗泡泡糖 --> 得25分 <br>
	 * 4. 消除第4颗泡泡糖 --> 得35分<br>
	 * 5. 消除第5颗泡泡糖 --> 得45分<br>
	 * 
	 * @param stars 根据点击后获取的待消除泡泡糖数量
	 * @return 计算出的得分
	 * */
	public int getScoreByNum(int stars);

	/**
	 * 无可消除泡泡糖是，计算剩余无可消除泡泡可以获得奖励分数
	 * 
	 * @param awardStarNum剩余泡泡糖个数
	 * @return 剩余泡泡糖奖励分数
	 * */
	public int getAwardScore(int awardStarNum);

	/**
	 * 判断当前分数是否已经达到进入下一关的要求
	 * 
	 * @param score 当前得分
	 * @return true:允许进入下一关，false:不允许进入下一关
	 */
	public boolean isChangeLevel(int score);

	/**
	 * 根据得分与关卡号判断是否需要出现“恭喜通关”<br>
	 * 注意：在一关中，“恭喜通关”仅且仅能显示一次。
	 * 
	 * @param currentLevel 当前关卡等级   
	 * @param score 当前得分
	 * @return true:通知，false:不通知
	 */
	public boolean isNoticedPassLevel(int currentLevel, int score);
}
