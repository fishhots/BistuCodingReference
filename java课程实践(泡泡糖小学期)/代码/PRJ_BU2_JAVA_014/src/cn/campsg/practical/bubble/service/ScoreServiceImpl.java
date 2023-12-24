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

	/*******PRJ-BU2-JAVA-014 Test1 【1/3 Start】************/
	/**
	 * 获得当前关的通关分数
	 * 
	 * @return 计算出的得分
	 * 
	 */
	//创建Configuration对象
	private Configuration cfg=null;
	//初始化Configuration对象
	public ScoreServiceImpl() {
		cfg=new Configuration();
	}
	@Override
	public int getCurrentLevelScore() {
		//返回当前关卡通关目标分
		return cfg.getScore().getLevelScore();
	}
	/*******PRJ-BU2-JAVA-014 Test1 【1/3 End】**************/
	
	/**
	 * 根据要切换的关卡等级获取目标分数
	 * 	
	 * @param 下一关关卡
	 * @return 计算出的得分
	 * 
	 */
	/*******PRJ-BU2-JAVA-014 Test2 【2/3 Start】************/
	
	@Override
	public int nextScoreByLevel(int nextLevel) {
		//设置通关分
		cfg.getScore().setLevelScore(cfg.getScore().getLevelScore()+cfg.getScore().getStep()+((nextLevel-1)/cfg.getScore().getLength())*cfg.getScore().getIncrement());
		return cfg.getScore().getLevelScore();
	}
	/*******PRJ-BU2-JAVA-014 Test2 【2/3 End】**************/

	/**
	 * 根据本关卡计算出本关的关卡得分
	 * 
	 * @param level
	 *            上一关关卡
	 * @return 本关的关卡得分
	 */
	
	@Override
	public boolean isChangeLevel(int score) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public int getScoreByStars(StarList stars) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScoreByStars(int stars) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAwardScore(int awardStarNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNoticePassLevel(int currentLevel, int score) {
		// TODO Auto-generated method stub
		return false;
	}

}
