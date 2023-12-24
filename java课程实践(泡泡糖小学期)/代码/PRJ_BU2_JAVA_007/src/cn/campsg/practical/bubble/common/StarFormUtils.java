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
 * 窗体工具类，提供以下功能：<br>
 * <ul>
 * <li>1. 将Label视图对象转换为泡泡糖对象。</li>
 * <li>2. 将泡泡糖对象转化为Label视图对象。</li>
 * <li>3. 获得所有待消除的泡泡糖的坐标</li>
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
	 * 从界面泡泡糖整列中寻找指定泡泡糖对应的Label视图对象。
	 * 
	 * @param star			指定的泡泡糖对象
	 * @param parent		界面泡泡糖整列
	 * @return					Label视图对象
	 */
	public static Label findFrame(Star star, Pane parent) {
		int row = star.getPosition().getRow();
		int col = star.getPosition().getColumn();
		
		//通过id寻找泡泡糖的行和列前加s
		String id = "#s" + row + col;

		Label label = (Label) parent.lookup(id);

		return label;
	}

	/**
	 * 将Label视图转换为泡泡糖对象
	 * 
	 * @param starFrame
	 *            Label视图
	 * @return 泡泡糖对象
	 * 
	 * @see List<Label> convert(StarList stars, StartEventHandler handler)
	 */
	public static Star convert(Label starFrame) {
		Star star = new Star();

		// 获得Label视图在布局中对应的行和列，Label视图的行列来自于初始化时的赋值
		int row = Integer.parseInt(starFrame.getUserData().toString()
				.split("[;]")[0]);
		int col = Integer.parseInt(starFrame.getUserData().toString()
				.split("[;]")[1]);
		star.setPosition(new Position(row, col));

		// 设置样式
		int styleIndex = mStarStylesheets.indexOf(starFrame.getStyleClass()
				.get(starFrame.getStyleClass().size() - 1));
		star.setType(StarType.valueOf(styleIndex));

		return star;
	}
}
