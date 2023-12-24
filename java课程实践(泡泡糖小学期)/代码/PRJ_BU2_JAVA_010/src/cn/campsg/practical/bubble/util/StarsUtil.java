package cn.campsg.practical.bubble.util;

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
	/************ PRJ-BU2-JAVA-010 Task2 ��2/3 start��***************/
	public static void sort(StarList SL){
		//ʵ��SL��row���Ե�������
        //�������rowֵ��С����
        for(int i=0;i<SL.size();i++){
            for(int j=0;j<SL.size()-i-1;j++){
            	//��ǰһ����ں�һ����н���
                if(SL.get(j).getPosition().getRow()>SL.get(j+1).getPosition().getRow()){
                    swap(SL.get(j),SL.get(j+1));
                }
            }
        }
	}
	/************ PRJ-BU2-JAVA-010 Task2 ��2/3 end��*****************/
	
	/**
	 * �����������������б��е�λ��
	 * 
	 * @param preStar
	 *            ��N��������
	 * @param nextStar
	 *            ��N+1��������
	 */
	/************ PRJ-BU2-JAVA-010 Task1 ��1/3 start��***************/
	private static void swap(Star star1,Star star2){
		Star startmp=new Star();
		startmp.setPosition(new Position(star1.getPosition().getRow(),star1.getPosition().getColumn()));
		star1.setPosition(new Position(star2.getPosition().getRow(),star2.getPosition().getColumn()));
		star2.setPosition(new Position(startmp.getPosition().getRow(),startmp.getPosition().getColumn()));
		star1.setType(star2.getType());
		star2.setType(startmp.getType());
	}

	public static void main(String[] args){
	//10.1
	/*	Star s1=new Star(new Position(0,0),StarType.BLUE);
		Star s2=new Star(new Position(1,1),StarType.GREEN);
		System.out.println("����ǰ:preStar"+s1.toString()+"nextStar"+s2.toString());
		swap(s1,s2);
		System.out.println("������:preStar"+s1.toString()+"nextStar"+s2.toString());
		*/
		StarList SL=new StarList();
		SL.add(new Star(new Position(2,0),StarType.BLUE));
		SL.add(new Star(new Position(5,0),StarType.GREEN));
		SL.add(new Star(new Position(9,0),StarType.PURPLE));
		SL.add(new Star(new Position(3,0),StarType.RED));
		SL.add(new Star(new Position(8,0),StarType.YELLOW));
		System.out.println(SL.toString());
		sort(SL);
		System.out.print(SL.toString());
	}
	
	
	
	
	
	
	/************ PRJ-BU2-JAVA-010 Task1 ��1/3 end��*****************/

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
