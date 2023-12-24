package cn.campsg.practical.bubble.common;

import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.service.ScoreService;

public final class StarAnimation {

	// 泡泡运动路径时间
	public static final int START_PATH_TIME = 300;
	// 泡泡渐变时间
	public static final int START_FADE_TIME = 300;
	// 出现自定义message的等级
	public static final int MESSAGE_LEVEL = 6;
	// 第一颗泡泡糖的分数
	public static final int FIRST_START_SCORE = 5;
	// 连消渐变时间
	public static final int SCORE_FADE_TIME = 1000;
	// 动画偏移时间
	public static final int OFFSET_TIME = 200;
	// 分数偏移量
	public static final int OFFSET_SCORE = 10;
	// 过关通知位置X坐标
	public static final int PASSNOTICE_X = 180;
	// 过关通知位置Y坐标
	public static final int PASSNOTICE_Y = 180;
	// 泡泡糖得分运动目标路径X坐标
	public static final double TARGET_PATH_X = 240;
	// 泡泡糖得分运动目标路径Y坐标
	public static final double TARGET_PATH_Y = 122;
	// 过关前显示泡泡糖剩余信息个数起始X坐标
	public static final double LEFTINF_START_X = 480;
	// 过关前显示泡泡糖剩余信息个数起始Y坐标
	public static final double LEFTINF_START_Y = 300;
	// 过关前显示泡泡糖个数终点坐标X
	public static final double LEFTINF_END_X = 0;
	// 过关前显示泡泡糖奖励信息起点Y坐标
	public static final double AWARDINF_START_Y = 350;
	// 泡泡糖剩余信息水平运动时间
	public static final double LEFTINF_PATH_TIME = 300;
	// 泡泡糖奖励信息水平运动时间
	public static final double AWARDINF_H_TIME = 300;
	// 泡泡糖奖励信息垂直运动时间
	public static final double AWARDINF_V_TIME = 300;
	// 通知下一关信息的X坐标
	public static final double CHANGE_LEVEL_NOTICE_X = 120;
	// 通知下一关信息的Y坐标
	public static final double CHANGE_LEVEL_NOTICE_Y = 160;

	/**
	 * 动画垂直移动泡泡糖视图对象
	 * 
	 * @param starFrame
	 *            泡泡糖视图对象
	 * @param span
	 *            移动距离
	 */
	public static Timeline slideYStar(Label starFrame, int span) {
		final Timeline timeline = new Timeline();
		// 移动模式，param0：移动的坐标系，param1：坐标系对应的移动距离
		final KeyValue kv = new KeyValue(starFrame.layoutYProperty(), span);
		// 设置移动时间
		final KeyFrame kf = new KeyFrame(Duration.millis(200), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();

		return timeline;
	}

	/**
	 * 动画水平移动泡泡糖视图对象
	 * 
	 * @param starFrame
	 *            泡泡糖视图对象
	 * @param span
	 *            移动距离
	 */
	public static Timeline slideXStar(Label starFrame, int span) {
		final Timeline timeline = new Timeline();
		// 移动模式，param0：移动的坐标系，param1：坐标系对应的移动距离
		final KeyValue kv = new KeyValue(starFrame.layoutXProperty(), span);
		// 设置移动时间
		final KeyFrame kf = new KeyFrame(Duration.millis(200), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();

		return timeline;
	}

	/**
	 * 以渐变动画删除待消除的泡泡糖
	 * 
	 * @param mAnchorPane
	 *            泡泡糖显示阵列
	 * @param starFrame
	 *            待消除的泡泡糖
	 */
	public static void clearStarLable(AnchorPane mAnchorPane, Label starFrame) {
		fadeOut(starFrame).setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mAnchorPane.getChildren().remove(starFrame);
			}
		});
	}

	/**
	 * JFX渐变动画
	 * 
	 * @param starFrame
	 *            设置渐变的组件
	 * 
	 * @return 动画组件
	 */
	public static FadeTransition fadeOut(Label starFrame) {
		FadeTransition ft = new FadeTransition(Duration.millis(10), starFrame);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setAutoReverse(false);
		ft.play();
		return ft;
	}

	public static FadeTransition clearAwardLable(AnchorPane mAnchorPane,
			Label starFrame) {
		FadeTransition starFade = fadeOut(starFrame);
		fadeOut(starFrame).setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mAnchorPane.getChildren().remove(starFrame);
			}
		});
		return starFade;
	}

	/**
	 * 
	 * 消除泡泡糖的得分动画
	 * 
	 * @param root
	 *            泡泡糖显示阵列
	 * @param clearStarsCoordinate
	 *            待消除泡泡糖的坐标集合
	 * @param scoreService
	 *            得分服务类
	 * @return 消除泡泡糖的动画集合
	 */
	public static ParallelTransition getScoreAnimation(AnchorPane root,
			List<Integer> clearStarsCoordinate, ScoreService scoreService) {
		// 根据集合大小计算消除的泡泡糖个数为集合一半，（每个泡泡糖有X,Y坐标）
		int starNum = clearStarsCoordinate.size() / 2;
		// 根据消除泡泡糖个数计算总得分
		String addScore = "" + scoreService.getScoreByNum(starNum);
		// 获取需要学生点击得分的Label
		Label scoreLabel = (Label) root.lookup("#lblMessage");
		// 添加显示内容如2连消20
		scoreLabel.setText(starNum + "连消" + addScore);

		// 生成可以并行执行动画的对象
		ParallelTransition parallelTransition = new ParallelTransition();
		int j = 0;
		for (int i = 0; i < starNum; i++) {
			// 依次取出第i个泡泡糖x坐标
			int starX = clearStarsCoordinate.get(j);
			j++;
			// 依次取出第i个泡泡糖y坐标
			int starY = clearStarsCoordinate.get(j);
			j++;
			// 设置第i个泡泡糖位置（ starX, starY），显示分数(5+StarFormUtils.OFFSET_SCORE*i)
			Text starLabel = addNode(
					root,
					25,
					starX,
					starY,
					""
							+ (StarAnimation.FIRST_START_SCORE + StarAnimation.OFFSET_SCORE
									* i));
			// 设置第i个泡泡糖位置（ starX,
			// starY）运动到（StarFormUtils.TARGET_PATH_X,StarFormUtils.TARGET_PATH_Y）
			PathTransition starPath = scorePath(starX, starY,
					StarAnimation.TARGET_PATH_X, StarAnimation.TARGET_PATH_Y,
					StarAnimation.START_PATH_TIME + StarAnimation.OFFSET_TIME
							* i, starLabel);
			// 设置第i个泡泡糖渐变时间
			FadeTransition starFade = scoreFadeOut(
					StarAnimation.START_FADE_TIME + StarAnimation.OFFSET_TIME
							* i, starLabel);
			starFade.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().remove(starLabel);
				}
			});
			parallelTransition.getChildren().addAll(starPath, starFade);
			if (i == StarAnimation.MESSAGE_LEVEL) {
				addScore = Message.MESSAGE;
				break;
			}
		}
		// 所点击泡泡糖获得总分数的显示坐标，初始值为所点击泡泡糖的坐标
		int clickPointX = clearStarsCoordinate.get(0);
		int clickPointY = clearStarsCoordinate.get(1);

		// 判断第一个泡泡是否在第1,2列，则显示总分坐标加1列，点击坐标两端可能不会完整显示点击得分
		if (clickPointX == 0 || clickPointX == StarFormUtils.STAR_WIDTH) {
			clickPointX = clickPointX + StarFormUtils.STAR_WIDTH;
		}

		// 设置点击总得分addScore
		Text clickPoint = addNode(root, 20, clickPointX, clickPointY, addScore);
		// 设置显示点击总得分在600毫秒完成从放大4倍到原始大小
		ScaleTransition clickPointScale = scoreScale(300, clickPoint, 4, 1);
		// 设置点击得分数渐变时间10毫秒
		FadeTransition clickPointFade = scoreFadeOut(10, clickPoint);
		clickPointFade.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().remove(clickPoint);
			}
		});

		// 生成连续执行对象：clickPoint点击得分先clickPointScale（缩放）停留50毫秒，再渐变消失
		SequentialTransition seqTransition = new SequentialTransition(
				clickPointScale, new PauseTransition(Duration.millis(50)),
				clickPointFade);
		// 设置显示连消scoreLabel的渐变时间2200毫秒
		FadeTransition scoreLabelFade = scoreFadeOut(
				StarAnimation.SCORE_FADE_TIME, scoreLabel);
		parallelTransition.getChildren().addAll(seqTransition, scoreLabelFade);

		// 设置循环次数
		parallelTransition.setCycleCount(1);

		return parallelTransition;

	}

	/**
	 * 设置节点的渐变效果
	 * 
	 * @param duration设置渐变时间
	 * @param scoreLabel设置目标渐变节点
	 * 
	 * */
	public static FadeTransition scoreFadeOut(int duration, Node scoreLabel) {
		// 设置要进行渐变的目标scoreLabel，及渐变时间duration
		FadeTransition fadeTransition = new FadeTransition(
				Duration.millis(duration), scoreLabel);
		// 设置渐变起始值
		fadeTransition.setFromValue(1.0f);
		// 渐变终止值
		fadeTransition.setToValue(0.0);
		// 设置循环次数和是否反转
		fadeTransition.setCycleCount(1);
		fadeTransition.setAutoReverse(false);
		return fadeTransition;
	}

	/**
	 * 设置目标节点的运动路径
	 * 
	 * @param scoreLabelX节点运动起始位置x坐标
	 * @param scoreLabelY节点运动起始位置y坐标
	 * @param duration节点运动时间
	 * @param scoreLabel运动的目标节点
	 * 
	 * */
	public static PathTransition scorePath(double scoreLabelX,
			double scoreLabelY, double targetX, double targetY,
			double duration, Node scoreLabel) {
		Path path = new Path();
		// 设置目标路径的起始坐标scoreLabelX，scoreLabelY
		path.getElements().add(new MoveTo(scoreLabelX, scoreLabelY));
		// 设置运动轨迹，按照直线运动到目标坐标(targetX, targetY)
		path.getElements().add(new LineTo(targetX, targetY));
		// new 出路径对象
		PathTransition pathTransition = new PathTransition();
		// 设置到达目标路径时间
		pathTransition.setDuration(Duration.millis(duration));
		// 设置按照path路径运动
		pathTransition.setPath(path);
		// 设置所要运动的label
		pathTransition.setNode(scoreLabel);
		// 设置循环次数和是否反转
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}

	/**
	 * 设置Node节点的缩放效果
	 * 
	 * @param duration缩放时间
	 * @param scoreLabel缩放的目标节点
	 * @param setFrom缩放起始大小
	 * @param setTo缩放的目标大小
	 * 
	 * */
	public static ScaleTransition scoreScale(int duration, Node scoreLabel,
			int setFrom, int setTO) {

		ScaleTransition scaleTransition = new ScaleTransition(
				Duration.millis(duration), scoreLabel);
		// 设置缩放的X,Y方向大小起始
		scaleTransition.setFromX(setFrom);
		scaleTransition.setFromY(setFrom);
		// 设置缩放X,Y方向的目标大小
		scaleTransition.setToX(setTO);
		scaleTransition.setToY(setTO);
		// 设置循环显示次数
		scaleTransition.setCycleCount(1);
		// 是否自动反转
		scaleTransition.setAutoReverse(false);

		return scaleTransition;
	}

	/**
	 * 增加上升分数的节点
	 * 
	 * @param fatherNode所要增加节点的父节点
	 * @param fontSize节点填充内容的字体大小
	 * @param scoreLabelX节点的x起始坐标
	 * @param scoreLabelY节点的起始坐标
	 * @param addScore节点所填内容
	 * 
	 * @return 返回新生成的节点
	 * */
	public static Text addNode(AnchorPane fatherNode, int fontSize,
			double scoreLabelX, double scoreLabelY, String addScore) {

		// 每个泡泡糖逐个上升时的分数
		Text scorePer = new Text();
		// 设置显示内容字体大小和颜色
		scorePer.setFont(Font.font(null, FontWeight.BOLD, fontSize));
		scorePer.setFill(Color.WHITE);
		// 设置增加Text的位置坐标
		scorePer.setX(scoreLabelX);
		scorePer.setY(scoreLabelY);
		// 设置添加内容
		scorePer.setText("" + addScore);
		// 把Text添加到要显示的面板fatherNode
		fatherNode.getChildren().add(scorePer);
		return scorePer;
	}

	/**
	 * 达到过关得分后动画通知
	 * */
	public static void passedFlag(AnchorPane mAnchorPane) {
		// 设置过关通知的位置和内容（恭喜过关）
		Text passNotice = (Text) addNode(mAnchorPane, 40,
				StarAnimation.PASSNOTICE_X, StarAnimation.PASSNOTICE_Y,
				Message.LEVEL_OK);
		passNotice.setFill(Color.WHITE);
		// 设置奖励内容缩放时间，内容先放大3倍再
		ScaleTransition noticeScale = scoreScale(1000, passNotice, 3, 1);
		// 设置奖励内容渐变时间1s
		FadeTransition noticeFade = scoreFadeOut(1000, passNotice);

		SequentialTransition passNoticeTransition = new SequentialTransition(noticeScale,
				new PauseTransition(Duration.millis(50)), noticeFade);
		passNoticeTransition.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mAnchorPane.getChildren().remove(passNotice);
			}
		});
		passNoticeTransition.play();
	}

	/**
	 * 动画显示奖励分数
	 * 
	 * @param root动画要显示的跟节点
	 * @param awardScore奖励分数
	 * @param leftStarNum剩余泡泡糖个数
	 */
	public static ParallelTransition awardAnimation(AnchorPane root,
			int awardScore, StarList mCurretStars) {
		// 获取泡泡糖数量
		int leftStarNum = mCurretStars.size();
		// 创建显示信息球剩余数量对象leftInf
		Text leftInf = (Text) addNode(root, 40, StarAnimation.LEFTINF_START_X,
				StarAnimation.LEFTINF_START_Y, "剩余 " + leftStarNum);
		// 创建奖励分数对象awardInf
		Text awardInf = (Text) addNode(root, 38, StarAnimation.LEFTINF_START_X,
				StarAnimation.AWARDINF_START_Y, "奖励" + awardScore);
		// 创建泡泡糖剩余信息运动前半段路径
		PathTransition firstLeftInfPathTransition = scorePath(
				StarAnimation.LEFTINF_START_X, StarAnimation.LEFTINF_START_Y,
				StarAnimation.TARGET_PATH_X, StarAnimation.LEFTINF_START_Y,
				StarAnimation.LEFTINF_PATH_TIME, leftInf);
		// 创建泡泡糖剩余信息后半段运动路径
		PathTransition secondLeftInfPathTransition = scorePath(
				StarAnimation.TARGET_PATH_X, StarAnimation.LEFTINF_START_Y,
				StarAnimation.LEFTINF_END_X, StarAnimation.LEFTINF_START_Y,
				StarAnimation.LEFTINF_PATH_TIME, leftInf);
		// 创建奖励分数水平运动方向
		Polyline polylineX = new Polyline();
		// 创建奖励分数垂直运动方向
		Polyline polylineY = new Polyline();
		polylineX.getPoints().addAll(
				new Double[] {
						// 添加水平运动起始点（LEFTINF_START_X, AWARDINF_START_Y,）
						// 终点(TARGET_PATH_X,AWARDINF_START_Y )
						StarAnimation.LEFTINF_START_X,
						StarAnimation.AWARDINF_START_Y,
						StarAnimation.TARGET_PATH_X,
						StarAnimation.AWARDINF_START_Y });
		// 奖励分数大于0，设置垂直运动方向，否则水平移出
		if (awardScore > 0) {
			// 添加水平运动起始点（TARGET_PATH_X, AWARDINF_START_Y,）
			// 终点(TARGET_PATH_X,TARGET_PATH_Y )
			polylineY.getPoints().addAll(
					new Double[] { StarAnimation.TARGET_PATH_X,
							StarAnimation.AWARDINF_START_Y,
							StarAnimation.TARGET_PATH_X,
							StarAnimation.TARGET_PATH_Y });
		} else {
			// 奖励为0，水平运动
			polylineY.getPoints().addAll(
					new Double[] { StarAnimation.TARGET_PATH_X,
							StarAnimation.AWARDINF_START_Y,
							StarAnimation.LEFTINF_END_X,
							StarAnimation.AWARDINF_START_Y });
		}
		// 创建水平方向运动路径对象
		PathTransition awardInfPathTransitionX = new PathTransition(
				Duration.millis(StarAnimation.AWARDINF_H_TIME), polylineX);
		// 创建垂直方向运动路径对象
		PathTransition awardInfPathTransitionY = new PathTransition(
				Duration.millis(StarAnimation.AWARDINF_V_TIME), polylineY);
		// 设置要运动的对象
		awardInfPathTransitionX.setNode(awardInf);
		awardInfPathTransitionY.setNode(awardInf);

		// 设置剩余泡泡糖与奖励分数渐变时间
		FadeTransition leftInfFade = scoreFadeOut(10, leftInf);
		FadeTransition awardInfFade = scoreFadeOut(10, awardInf);
		// 剩余泡泡糖依次执行水平运动，暂停1s渐变,水平运动移出
		SequentialTransition leftInfSwq = new SequentialTransition(
				firstLeftInfPathTransition, new PauseTransition(
						Duration.millis(1500)), secondLeftInfPathTransition,
				leftInfFade);
		leftInfFade.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().remove(leftInf);
			}
		});
		// 奖励分数依次执行水平运动，暂停1s，垂直（或水平）运动，渐变
		SequentialTransition awardInfSwq = new SequentialTransition(
				awardInfPathTransitionX, new PauseTransition(
						Duration.millis(1500)), awardInfPathTransitionY,
				awardInfFade);
		awardInfSwq.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().remove(awardInf);
			}
		});
		// 创建并行执行对象
		ParallelTransition parallelTransition = new ParallelTransition();
		// 添加要并行执行的对象
		parallelTransition.getChildren().addAll(leftInfSwq, awardInfSwq);
		// 开启并行
		parallelTransition.setCycleCount(1);
		parallelTransition.play();

		return parallelTransition;

	}

	/**
	 * 切换关时出现提示信息（关数和目标分数）
	 * 
	 * @param mAnchorPane
	 *            要显示出现信息的面板
	 */
	public static SequentialTransition passNotice(AnchorPane mAnchorPane,
			int nextLevel, int targetScore) {
		// 获取所要添加面板的X轴坐标
		double noticeX = StarAnimation.CHANGE_LEVEL_NOTICE_X;
		// 获取所要添加面板的Y轴坐标
		double noticeY = StarAnimation.CHANGE_LEVEL_NOTICE_Y;
		// 设置添加内容，通关等级和目标分数
		Text passNotice = new Text("       第" + nextLevel + "关\n" + "目标分数："
				+ targetScore);
		passNotice.setLayoutX(noticeX);
		passNotice.setLayoutY(noticeY);
		passNotice.setFill(Color.WHITE);
		passNotice.setFont(Font.font(null, FontWeight.BOLD, 35));
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				mAnchorPane.getChildren().add(passNotice);
			}
		});

		// 设置passNotice渐变时间
		FadeTransition passFade = scoreFadeOut(10, passNotice);
		// 依次执行：停留2s后执行渐变
		SequentialTransition seqTransition = new SequentialTransition(
				new PauseTransition(Duration.millis(2000)), // 暂停2s
				passFade);
		seqTransition.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mAnchorPane.getChildren().remove(passNotice);
			}
		});
		seqTransition.play();
		return seqTransition;
	}

}