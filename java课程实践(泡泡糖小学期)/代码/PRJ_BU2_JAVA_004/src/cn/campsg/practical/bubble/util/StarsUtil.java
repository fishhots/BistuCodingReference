package cn.campsg.practical.bubble.util;
import cn.campsg.practical.bubble.entity.*;
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
	 * ��¡һ���µ������ǡ�
	 * 
	 * @param star
	 *            ����¡��������
	 * @return �µ������ǣ������ڴ��ַ�������ǣ���
	 */
	/******************** PRJ-BU2-JAVA-004 Task1 ********************/
	public static Star clone(Star star){
		Star cloneStar=new Star();
		cloneStar.setPosition(new Position(star.getPosition().getRow(),star.getPosition().getColumn()));
		cloneStar.setType(star.getType());
		return cloneStar;
	}
	
	//4.1
	public static void main(String[] args){
		Star star=new Star(new Position(5,5),StarType.RED);
		Star cloneStar=clone(star);
		System.out.println("ԭ�����ǵĶ���Ϊ:"+"("+star.getPosition().getRow()+","+star.getPosition().getColumn()+"-"+star.getType()+")");
		System.out.println("��¡�����Ƕ���Ϊ:"+"("+cloneStar.getPosition().getRow()+","+cloneStar.getPosition().getColumn()+"-"+cloneStar.getType()+")");
		System.out.println("�������Ƿ�һ��:"+star.equals(cloneStar));
		System.out.println("������������Ƿ�һ��:"+star.getPosition().equals(cloneStar.getPosition()));
	}

	/**************************************************************/
}
