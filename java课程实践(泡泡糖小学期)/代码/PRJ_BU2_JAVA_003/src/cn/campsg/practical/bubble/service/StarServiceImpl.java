package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * ������ҵ���������࣬����Ϊ�����ṩ���·���<br>
 * 1. ������Ļ�������������<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	/**
	 * ������Ļ������������ǣ�10 * 10��
	 * 
	 * @return �������б�-��������ʾ
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
				Star s=new Star(new Position(i,j),StarType.valueOf((int)(Math.random()*STAR_TYPES)));//�����ȡö��ֵ
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
	 * �û���������ǣ���ȡ���������������������б�
	 * 
	 * @param base
	 *            ���û������������
	 * @param sList
	 *            ��ǰ���������ݵ��б�
	 * @return ��Ҫ�����������
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
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(����ˮƽ�б��������)<br>
	 * �ù��̶ܹ��ڴ�ֱ�б��������֮������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * 
	 * @return ���ƶ��������б�
	 */
	public StarList getXMovedStars(StarList currentStarList) {
		return null;
	}

	/**
	 * �ж��Ƿ񻹴���δ������������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return true:��Ȼ��δ������������,false:û��δ������������
	 * 
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		return false;
	}

	/**
	 * ��ȡ�޷������������б�
	 * 
	 * @param curretStars
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return �޷������������б�
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		return null;
	}

}
