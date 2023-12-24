package cn.campsg.practical.bubble.util;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;

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
	public static void reorder(StarList starList) {
		for (int i = 0; i < starList.size() - 1; i++) {
			for (int j = 0; j < starList.size() - i - 1; j++) {
				// ��ȡ��N��������
				Star preStar = starList.get(j);
				// ��ȡ��N�������ǵĺ�һ�������ǣ�N+1��
				Star nextStar = starList.get(j + 1);

				if (preStar.getPosition().getRow() > nextStar.getPosition()
						.getRow()) {
					exchange(preStar, nextStar);
				}
			}
		}
	}
	
	/**
	 * ��������򽻻��������������б��е�ֻ
	 * 
	 * @param preStar
	 *            ��N��������
	 * @param nextStar
	 *            ��N+1��������
	 */
	private static void exchange(Star preStar, Star nextStar) {
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
	 * ��¡һ���µ������ǡ�
	 * 
	 * @param star
	 *            ����¡��������
	 * @return �µ������ǣ������ڴ��ַ�������ǣ���
	 */
	public static Star copy(Star star) {

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
