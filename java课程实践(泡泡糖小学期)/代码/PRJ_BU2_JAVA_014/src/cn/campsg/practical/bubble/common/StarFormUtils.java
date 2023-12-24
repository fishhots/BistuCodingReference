package cn.campsg.practical.bubble.common;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.service.StarService;

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

	/* 泡泡糖图标宽度 */
	public static final int STAR_WIDTH = 48;

	/* 泡泡糖图标高度 */
	public static final int STAR_HEIGHT = 48;

	/* 分数动画移动距离 */
	public static final int SCORE_MOVE_DISTANCE = 230;

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
	
//	/**
//	 * 将泡泡糖集合转化为Label视图集合
//	 * 
//	 * @param stars 泡泡糖集合
//	 * @return Label视图集合
//	 */
//	public static List<Label> convert(StarList stars) {
//		return convert(stars, null);
//	}

	/**
	 * 将泡泡糖集合转化为Label视图集合（含泡泡糖事件对象植入）
	 * 
	 * @param stars 泡泡糖集合
	 * @return Label视图集合
	 */
	public static List<Label> convert(StarList stars) {

		List<Label> starFrames = new ArrayList<Label>();

		int row = 0;
		int col = 0;

		for (int i = 0; i < stars.size(); i++) {
			if(stars.get(i) == null)
				continue;
			
			// 获取Star的行与列
			row = stars.get(i).getPosition().getRow();
			col = stars.get(i).getPosition().getColumn();

			if (row < 0 || row >= StarService.MAX_ROW_SIZE)
				continue;

			if (col < 0 || col >= StarService.MAX_COLUMN_SIZE)
				continue;

			// 创建并设置Label视图的长与宽
			Label starFrame = new Label();
			starFrame.setPrefWidth(STAR_WIDTH);
			starFrame.setPrefHeight(STAR_HEIGHT);

//			// 设置点击事件
//			if (handler != null)
//				starFrame.setOnMouseClicked(handler);

			// Label视图的ID为s+行号+列号（例如：s00,s01）
			starFrame.setId("s" + row + col);
			// 为Label设置一个固定传参属性，用于标记当前Label的行与列，便于判断
			starFrame.setUserData(row + ";" + col);
			// 设置Label的坐标
			starFrame.setLayoutX(col * STAR_WIDTH);
			starFrame.setLayoutY(row * STAR_HEIGHT);
			// 设置泡泡糖的样式
			starFrame.getStyleClass().add(
					mStarStylesheets.get(stars.get(i).getType().value()));

			// 添加入列表
			starFrames.add(starFrame);
		}

		return starFrames;
	}
	
	/**
	 * 从界面泡泡糖整列中寻找指定泡泡糖对应的Label视图对象。
	 * 
	 * @param stars			指定的泡泡糖对象集合
	 * @param parent		界面泡泡糖整列
	 * @return					Label视图对象集合
	 */
	public static List<Label> findFrames(StarList stars, Pane parent) {
		List<Label> starFrames = new ArrayList<Label>();

		for (int i = 0; i < stars.size(); i++) {
			
			Label label = findFrame(stars.get(i), parent);

			if (label != null)
				starFrames.add(label);
		}

		return starFrames;
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
	 * 获得所有待消除的泡泡糖的坐标，存放方式是一个泡泡糖占两个空间，第一个是x，第二个是y
	 * 
	 * @param clearStars待消除的泡泡糖列表
	 * @return 泡泡糖列表所对应的x,y坐标集合
	 * */
	public static List<Integer> getClearStarsCoordinate(StarList clearStars) {
		List<Integer> clearStarsCoordinate = new ArrayList<Integer>();

		for (int i = 0; i < clearStars.size(); i++) {
			// 遍历待消除泡泡糖的行与列
			int starRow = clearStars.get(i).getPosition().getRow();
			int starColumn = clearStars.get(i).getPosition().getColumn();
			// 把泡泡视图所在mAnchorPane的列转化为主面板root下对应的x坐标
			int starX = starColumn * STAR_WIDTH;
			// 把泡泡视图所在mAnchorPane的行转化为主面板root下对应的y坐标
			int starY = starRow * STAR_WIDTH + SCORE_MOVE_DISTANCE;
			// 把泡泡对应的坐标添加到List集合中
			clearStarsCoordinate.add(starX);
			clearStarsCoordinate.add(starY);

		}
		// 返回泡泡糖列表在root面板对应的坐标
		return clearStarsCoordinate;
	}

}
