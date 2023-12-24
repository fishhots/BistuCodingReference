package cn.campsg.practical.bubble.common;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;

/**
 * 
 * ���幤���࣬�ṩ���¹��ܣ�<br>
 * <ul>
 * <li>1. ��Label��ͼ����ת��Ϊ�����Ƕ���</li>
 * <li>2. �������Ƕ���ת��ΪLabel��ͼ����</li>
 * <li>3. ������д������������ǵ�����</li>
 * </ul>
 * 
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 */
public final class StarFormUtils {

	public static List<String> mStarStylesheets = null;

	static {
		mStarStylesheets = new ArrayList<String>();
		mStarStylesheets.add("blue_star");
		mStarStylesheets.add("green_star");
		mStarStylesheets.add("yellow_star");
		mStarStylesheets.add("red_star");
		mStarStylesheets.add("purple_star");
	}
	
	/**
	 * �ӽ���������������Ѱ��ָ�������Ƕ�Ӧ��Label��ͼ����
	 * 
	 * @param star			ָ���������Ƕ���
	 * @param parent		��������������
	 * @return					Label��ͼ����
	 */
	public static Label findFrame(Star star, Pane parent) {
		int row = star.getPosition().getRow();
		int col = star.getPosition().getColumn();
		
		//ͨ��idѰ�������ǵ��к���ǰ��s
		String id = "#s" + row + col;

		Label label = (Label) parent.lookup(id);

		return label;
	}

	/**
	 * ��Label��ͼת��Ϊ�����Ƕ���
	 * 
	 * @param starFrame
	 *            Label��ͼ
	 * @return �����Ƕ���
	 * 
	 * @see List<Label> convert(StarList stars, StartEventHandler handler)
	 */
	public static Star convert(Label starFrame) {
		Star star = new Star();

		// ���Label��ͼ�ڲ����ж�Ӧ���к��У�Label��ͼ�����������ڳ�ʼ��ʱ�ĸ�ֵ
		int row = Integer.parseInt(starFrame.getUserData().toString()
				.split("[;]")[0]);
		int col = Integer.parseInt(starFrame.getUserData().toString()
				.split("[;]")[1]);
		star.setPosition(new Position(row, col));

		// ������ʽ
		int styleIndex = mStarStylesheets.indexOf(starFrame.getStyleClass()
				.get(starFrame.getStyleClass().size() - 1));
		star.setType(StarType.valueOf(styleIndex));

		return star;
	}
}
