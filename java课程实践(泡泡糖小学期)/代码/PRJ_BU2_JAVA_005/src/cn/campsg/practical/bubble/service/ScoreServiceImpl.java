package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * 分数服务类用于为界面提供以下功能<br>
 * 1. 计算关卡通关分数<br>
 * 2. 切关判定<br>
 * 3. 根据消除的泡泡计算得分<br>
 * 4. 计算剩余泡泡糖的得分奖励<br>
 * 
 * @author Frank.Chen
 * @version 1.1
 *
 */
public class ScoreServiceImpl implements ScoreService {

	/* 分数配置文件工具类 */
	private ScoreManager mConfiguration = null;

	/* 用于判定当前关卡“恭喜通关”是否已经被通知过一次 */
	public static int mLevelCounter = 1;

	public ScoreServiceImpl() {
		mConfiguration = ScoreManager.getInstance();
	}

	/**
	 * 根据要切换的关卡等级获取目标分数
	 * 
	 * @param 当前关卡
	 * @return 计算出的得分
	 * 
	 */
	@Override
	public int nextScoreByLevel(int currentLevel) {

		return mConfiguration.nextLevelTarget(currentLevel);
	}
	
	/**
	 * 获得当前关的通关分数
	 * 
	 * @return 计算出的得分
	 * 
	 */
	@Override
	public int getCurrentLevelScore() {

		return mConfiguration.getScore().getLevelScore();
	}

	/**
	 * 根据点击后获取的待消除泡泡糖计算出得分<br>
	 * 点击后泡泡糖消除得分规则: <br>
	 * 1. 消除第1颗泡泡糖 --> 得5分 <br>
	 * 2. 消除第2颗泡泡糖 --> 得15分 <br>
	 * 3. 消除第3颗泡泡糖 --> 得25分 <br>
	 * 4. 消除第4颗泡泡糖 --> 得35分<br>
	 * 5. 消除第5颗泡泡糖 --> 得45分<br>
	 * 
	 * @param stars
	 *            根据点击后获取的待消除泡泡糖集合
	 * @return 计算出的得分
	 * */
	@Override
	public int getScoreByNum(StarList stars) {

		return getScoreByNum(stars.size());
	}

	/**
	 * 根据点击后获取的待消除泡泡糖数量计算出得分<br>
	 * 点击后泡泡糖消除得分规则: <br>
	 * 1. 消除第1颗泡泡糖 --> 得5分 <br>
	 * 2. 消除第2颗泡泡糖 --> 得15分 <br>
	 * 3. 消除第3颗泡泡糖 --> 得25分 <br>
	 * 4. 消除第4颗泡泡糖 --> 得35分<br>
	 * 5. 消除第5颗泡泡糖 --> 得45分<br>
	 * 
	 * @param stars
	 *            根据点击后获取的待消除泡泡糖数量
	 * @return 计算出的得分
	 * 
	 * */
	@Override
	public int getScoreByNum(int stars) {

		if (stars <= 0)
			return 0;

		// 计算点击后满足消除条件泡泡糖的总得分
		int score = LOWER_SCORE * stars * stars;

		return score;
	}

	/**
	 * 无可消除泡泡糖是，计算剩余无可消除泡泡可以获得奖励分数
	 * 
	 * 无可消除泡泡糖奖励得分规则: <br>
	 * 1. 剩余1颗泡泡糖 --> 奖励1620分 <br>
	 * 2. 剩余2颗泡泡糖 --> 奖励1280分 <br>
	 * 3. 剩余3颗泡泡糖 --> 奖励980分 <br>
	 * 4. 剩余4颗泡泡糖 --> 奖励720分 <br>
	 * 5. 剩余5颗泡泡糖 --> 奖励500分 <br>
	 * 
	 * @param awardStarNum剩余泡泡糖个数
	 * @return 剩余泡泡糖奖励分数
	 * */
	@Override
	public int getAwardScore(int leftStarNum) {

		// 判断是否达到剩余泡泡糖奖励范围
		if (leftStarNum < AWARD_LIMIT)
			return LOWER_AWARD_SCORE*(leftStarNum - AWARD_LIMIT)*(leftStarNum - AWARD_LIMIT);
		else
			return 0;

	}

	/**
	 * 判断当前分数是否已经达到进入下一关的要求
	 * 
	 * @param score 当前得分
	 * @return true:允许进入下一关，false:不允许进入下一关
	 */
	@Override
	public boolean isChangeLevel(int score) {

		int targetScore = mConfiguration.getScore().getLevelScore();

		return score >= targetScore ? true : false;

	}

	/**
	 * 根据得分与关卡号判断是否需要出现“恭喜通关”<br>
	 * 注意：在一关中，“恭喜通关”仅且仅能显示一次。
	 * 
	 * @param currentLevel 当前关卡等级   
	 * @param score 当前得分
	 * @return true:通知，false:不通知
	 */
	@Override
	public boolean isNoticedPassLevel(int currentLevel, int score) {
		
		//判断分数是否已经达到通关要求
		if (!isChangeLevel(score))
			return false;

		// 判断当前关卡是否已经显示“恭喜通关”字样。
		if (currentLevel != mLevelCounter) 
			return false;
		
		//如果没有显示过“恭喜通关”，那么返回true，并且通过累加mLevelCounter防止多次出现“恭喜通关”
		mLevelCounter++;
		return true;

	}

}
