package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * ��������������Ϊ�����ṩ���¹���<br>
 * 1. ����ؿ�ͨ�ط���<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 1.1
 *
 */
public class ScoreServiceImpl implements ScoreService {

	/*******PRJ-BU2-JAVA-014 Test1 ��1/3 Start��************/
	/**
	 * ��õ�ǰ�ص�ͨ�ط���
	 * 
	 * @return ������ĵ÷�
	 * 
	 */
	//����Configuration����
	private Configuration cfg=null;
	//��ʼ��Configuration����
	public ScoreServiceImpl() {
		cfg=new Configuration();
	}
	@Override
	public int getCurrentLevelScore() {
		//���ص�ǰ�ؿ�ͨ��Ŀ���
		return cfg.getScore().getLevelScore();
	}
	/*******PRJ-BU2-JAVA-014 Test1 ��1/3 End��**************/
	
	/**
	 * ����Ҫ�л��Ĺؿ��ȼ���ȡĿ�����
	 * 	
	 * @param ��һ�عؿ�
	 * @return ������ĵ÷�
	 * 
	 */
	/*******PRJ-BU2-JAVA-014 Test2 ��2/3 Start��************/
	
	@Override
	public int nextScoreByLevel(int nextLevel) {
		//����ͨ�ط�
		cfg.getScore().setLevelScore(cfg.getScore().getLevelScore()+cfg.getScore().getStep()+((nextLevel-1)/cfg.getScore().getLength())*cfg.getScore().getIncrement());
		return cfg.getScore().getLevelScore();
	}
	/*******PRJ-BU2-JAVA-014 Test2 ��2/3 End��**************/

	/**
	 * ���ݱ��ؿ���������صĹؿ��÷�
	 * 
	 * @param level
	 *            ��һ�عؿ�
	 * @return ���صĹؿ��÷�
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
