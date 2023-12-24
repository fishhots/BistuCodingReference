package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Position;

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
	public StarList createStars() {
		//2.1������
	/*	Star star1=new Star();		
		star1.setPosition(new Position(0,0));
		star1.setType(Star.StarType.BLUE);
		Star star2=new Star(new Position(1,1),Star.StarType.GREEN);
		System.out.println("("+star1.getPosition().getColumn()+")"+","+"("+(star1.getPosition().getRow()+")"+" "+"-"+" "+star1.getType()));
		System.out.println("("+star2.getPosition().getColumn()+")"+","+"("+(star2.getPosition().getRow()+")"+" "+"-"+" "+star2.getType()));
	*/	
		//2.2������
	//	System.out.println(StarType.BLUE.value());   
	//	System.out.println(StarType.valueOf(1));
		
		//2.3������
		StarList sList= new StarList();					
		sList.add(new Star(new Position(0,0),StarType.BLUE));
		sList.add(new Star(new Position(1,1),StarType.RED));
		sList.add(new Star(new Position(2,2),StarType.YELLOW));
		sList.add(new Star(new Position(3,3),StarType.GREEN));
		sList.add(new Star(new Position(4,4),StarType.PURPLE));
		
		
		return sList;
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
