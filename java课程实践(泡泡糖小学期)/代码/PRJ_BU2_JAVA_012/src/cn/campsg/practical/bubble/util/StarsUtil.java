package cn.campsg.practical.bubble.util;

import java.util.HashMap;
import java.util.Map;

import cn.campsg.practical.bubble.MainForm;
import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.entity.Star.StarType;

/**
 * ������/���ƶ�������ʵ���๤���࣬�ṩ���¹��ܣ�<br>
 * <ul>
 * <li>1. ����ָ���б��е�������-����������������ͬ������������ð�������㷨����</li>
 * <li>2. ��ָ���б��е������ǰ��з��顣</li>
 * <li>3. ��¡һ�������Ƕ���</li>
 * </ul>
 * 
 * @see cn.campsg.practical.bubble.entity.Star
 * @see cn.campsg.practical.bubble.entity.MovedStar
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 *
 */
public class StarsUtil {

	/**
	 * ����ָ���б��е�������<br>
	 * ������򣺰������������������ͬ������������<br>
	 * �����㷨��ð������
	 * 
	 * @param starList
	 *            ��������������б�
	 */
	public static void sort(StarList starList) {
		/*****PRJ-BU2-JAVA-012 Task1 ��1/3 Start��*******/
		for (int i = 0; i < starList.size() - 1; i++) {
			for (int j = 0; j < starList.size() - i - 1; j++) {
				// ��ȡ��N��������
				Star preStar = starList.get(j);
				// ��ȡ��N�������ǵĺ�һ�������ǣ�N+1��
				Star nextStar = starList.get(j + 1);
				//��ǰһ������������ں�һ�������н���
				if (preStar.getPosition().getColumn() > nextStar.getPosition()
						.getColumn()) {
					swap(preStar, nextStar);
				}
				//��������ͬʱ�ж�������
				else if(preStar.getPosition().getColumn() == nextStar.getPosition()
						.getColumn()){
					//��ǰһ����������ں�һ�������н���
					if(preStar.getPosition().getRow() > nextStar.getPosition()
					.getRow()){
						swap(preStar, nextStar);
					}
				}
				
			}
		}
		
		/*****PRJ-BU2-JAVA-012 Task1 ��1/3 End��********/
	}
	public static void main(String[] args) 
	{
		StarList starlist=new StarList();
		starlist.add(new Star(new Position(2,3),StarType.BLUE));
		starlist.add(new Star(new Position(1,5),StarType.GREEN));
		starlist.add(new Star(new Position(0,9),StarType.PURPLE));
		starlist.add(new Star(new Position(0,3),StarType.RED));
		starlist.add(new Star(new Position(0,8),StarType.YELLOW));
		//12.1
	//	System.out.println(starlist);
		//sort(starlist);
		Map<Integer,StarList> map=group(starlist);
	//	System.out.println(starlist);
		System.out.println(map);
	}

	/**
	 * ��������򽻻��������������б��е�ֻ
	 * 
	 * @param preStar
	 *            ��N��������
	 * @param nextStar
	 *            ��N+1��������
	 */
	private static void swap(Star preStar, Star nextStar) {
		// ������ʱ���������Ƕ���
		Star tempStar = new Star();

		// ����N�������ǵ����ݱ�������ʱ���������Ƕ���
		tempStar.getPosition().setRow(preStar.getPosition().getRow());
		tempStar.getPosition().setColumn(preStar.getPosition().getColumn());
		tempStar.setType(preStar.getType());

		// ����N+1�������ǵ����ݱ������N��������
		preStar.getPosition().setRow(nextStar.getPosition().getRow());
		preStar.getPosition().setColumn(nextStar.getPosition().getColumn());
		preStar.setType(nextStar.getType());

		// ����ʱ���������Ƕ�������ݱ������N+1��������
		nextStar.getPosition().setRow(tempStar.getPosition().getRow());
		nextStar.getPosition().setColumn(tempStar.getPosition().getColumn());
		nextStar.setType(tempStar.getType());
	}

	/**
	 * ���кŶ������Ǽ����������ǽ��з��飨��ͬ�кŵ������Ƿ���һ������У�<br>
	 * ����ǰӦ���ȶ������Ǽ��Ͻ�������
	 * 
	 * @see sort
	 * 
	 * @param mStarList
	 *            ��������������б�
	 * @return 
	 *         ��������Map�е�key���кţ�value����ͬ�е������Ǽ��ϣ����磺1-{(1,2);(1,3);(1,4)}��2-{(2,2)
	 *         ;(2,3);(2,4)}
	 */
	/*****PRJ-BU2-JAVA-012 Task2 ��2/3 Start��*******/
	public static Map<Integer,StarList> group(StarList starlist){
		Map<Integer,StarList> map=new HashMap<Integer,StarList>();
		sort(starlist);
		//����"������������"����
		for(int i=0;i<starlist.size();i++){
			//�洢�����Ƕ���,�����ǵġ���ֵ��
			Star star=starlist.get(i);
			int column=starlist.get(i).getPosition().getColumn();
			//�жϡ���ֵ���Ƿ����HashMap
			if(!map.containsKey(column)){
				//�����ڣ�����һ����StarList���ϣ����������ǲ���
				StarList sl=new StarList();
				sl.add(star);
				//����Ӧ����ֵ����StarList���ϴ���HashMap
				map.put(column, sl);
			}
			else{
				//���ڣ�ȡ����Ӧ����ֵ����Ӧ��value���ϣ������������Ǽ��뼯��
				StarList sl=map.get(column);
				sl.add(star);
				//�����ϴ���HashMap
				map.put(column, sl);
			}
		}
		return map;
	}
	/*****PRJ-BU2-JAVA-012 Task2 ��2/3 End��*********/

	/**
	 * ��¡һ���µ������ǡ�
	 * 
	 * @param star
	 *            ����¡��������
	 * @return �µ������ǣ������ڴ��ַ�������ǣ���
	 */
	public static Star clone(Star star) {

		Star ret = new Star();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}

	public static MovedStar toMovedStar(Star star) {

		MovedStar ret = new MovedStar();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}
}
