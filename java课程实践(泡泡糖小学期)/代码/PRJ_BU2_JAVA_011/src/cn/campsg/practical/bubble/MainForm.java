package cn.campsg.practical.bubble;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import javafx.animation.ParallelTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.campsg.practical.bubble.common.Message;
import cn.campsg.practical.bubble.common.StarAnimation;
import cn.campsg.practical.bubble.common.StarFormUtils;
import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.service.ScoreService;
import cn.campsg.practical.bubble.service.StarService;

/**
 * 泡泡糖窗体类，用于显示泡泡糖阵列、处理泡泡糖点击事件与动画
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 */
public class MainForm extends Application {

	private Logger logger = Logger.getLogger(MainForm.class);

	private AnchorPane mRoot = null;

	private AnchorPane mAnchorPane = null;

	private Label scoreLabel = null;

	private StarList mCurretStars = null;

	private StarService mStarService = null;

	private ScoreService mScoreService = null;

	// 开始分数为0
	private static int score = 0;

	// 开始关卡为1
	private static int currentLevel = 1;

	// 保存通关上一关时的分数，也就是当前这一关的起始分数
	private static int lastLevelScore = 0;

	// 未通关时保存当前关卡的等级(初始值为第一关)
	private static int lastLevel = 1;

	// 未通过时当前通关的目标分数（初始目标分数1000）
	private static int lastLevelTargetScore = 0;
	
	public static void show(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		initServiceComponent();

		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("/res/layout/main_layout.fxml"));
			
			if (logger.isDebugEnabled())
				addDebugListener(root);

			// 将主布局加入到视图场景中
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);

			// 页面加载时或重新开始新的泡泡糖棋局时候初始化泡泡糖
			initGameStars(root);

			primaryStage.setTitle("消灭泡泡糖-Popstar3");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void addDebugListener(AnchorPane root) {
		
		root.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				logger.debug(event.getTarget().getClass().getName());
				
				if(event.getTarget() instanceof Text) {
					logger.debug(((Text)event.getTarget()).getText());
				}
			}
		});
	}

	/**
	 * 页面加载时或重新开始新的泡泡糖棋局时候初始化泡泡糖
	 * 
	 * @param root
	 *            窗体总布局
	 * 
	 */
	private void initGameStars(AnchorPane root) {

		// 调用业务层获取随机10*10泡泡糖阵列
		mCurretStars = mStarService.createBubbleMatrix();

		if (mCurretStars == null || mCurretStars.size() == 0) {
			logger.error("服务端没有提供正确的泡泡糖阵列");
			return;
		}

		mRoot = root;

		// 获取泡泡糖布局对象
		mAnchorPane = (AnchorPane) root.lookup("#game_pane");
		
		// 调试状态下可显示泡泡糖的坐标
		if (logger.isDebugEnabled())
			showStarsCoordinate();

		StartEventHandler handler = new StartEventHandler();

		// 将StarList中的所有Star对象转换成Label视图对象
		List<Label> starFrames = StarFormUtils.convert(mCurretStars);
		for(Label starFrame : starFrames)
			starFrame.setOnMouseClicked(handler);

		// 将Label加入到视图布局中
		for (int i = 0; i < starFrames.size(); i++) {
			mAnchorPane.getChildren().add(starFrames.get(i));
		}

		// 获得第一关的通关分数
		lastLevelTargetScore = mScoreService.getCurrentLevelScore();

	}

	/**
	 * 调试状态下可显示泡泡糖的坐标
	 * 
	 * @param root
	 * @param pane
	 */
	private void showStarsCoordinate() {

		// 获取菜单对象
		FlowPane menu_title = (FlowPane) mRoot.lookup("#menu_title");

		menu_title.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				for (int i = 0; i < mAnchorPane.getChildren().size(); i++) {
					Label button = (Label) mAnchorPane.getChildren().get(i);
					button.setText("(" + button.getId() + ")");
				}
			}

		});

		menu_title.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				for (int i = 0; i < mAnchorPane.getChildren().size(); i++) {
					Label button = (Label) mAnchorPane.getChildren().get(i);
					button.setText("");
				}

			}

		});
	}

	/**
	 * 初始化并加载服务类组件
	 */
	private void initServiceComponent() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"service.xml");

		try {
			mStarService = (StarService) context.getBean("starService");

			mScoreService = (ScoreService) context.getBean("scoreService");

		} catch (Exception e) {

			logger.error("无法加载StarService和ScoreService，系统非法退出");
			System.exit(0);
		}
	}
	
	/**
	 * 泡泡糖被点击的事件处理对象
	 */
	public class StartEventHandler implements EventHandler<MouseEvent> {

		public StartEventHandler() {
			mAnchorPane = (AnchorPane) mRoot.lookup("#game_pane");
			scoreLabel = (Label) mRoot.lookup("#lblScore");
		}

		@Override
		public void handle(MouseEvent event) {

			// 获取被点击的泡泡糖视图
			Label starFrame = (Label) event.getTarget();

			// 将视图转换为泡泡糖实体
			Star base = StarFormUtils.convert(starFrame);

			// 从服务端获取需要清除的泡泡糖列表
			StarList clearStars = mStarService.tobeClearedStars(base,
					mCurretStars);

			// 无需消除泡泡糖，则停止点击事件的处理（例如：用户点击的泡泡糖周边没有关联颜色的泡泡糖）
			if (clearStars == null || clearStars.size() == 0)
				return;

			// 从服务端获取需要移动的泡泡糖（垂直方向的）
			StarList movedStars = mStarService.getVMovedStars(clearStars,
					mCurretStars);

			// 根据从服务端获取需要清除的泡泡糖列表，清除对应的视图
			clearStars(clearStars);

			if (logger.isDebugEnabled())
				logger.debug("清除后相关泡泡糖后，内存泡泡糖对象阵列:" + mCurretStars);

			// 创建线程同步器，用于保证水平泡泡糖移动慢于垂直移动
			CountDownLatch yLatch = new CountDownLatch(movedStars.size());

			// 移动界面上的泡泡糖，并保证水平移动在垂直移动后完成
			moveYStars(movedStars, yLatch);

			if (logger.isDebugEnabled())
				logger.debug("垂直方向泡泡糖移动后（Y轴），内存泡泡糖对象阵列:" + mCurretStars);

			// 移动水平方向的泡泡糖（在垂直方向星星完成后操作）
			new MoveXStarController(yLatch).start();

			// 显示分数动画
			showScore(clearStars);
			
		}

	}

	/**
	 * 每次消除一组泡泡糖后，显示分数动画
	 * 
	 * @param clearStars
	 *            待消除的泡泡糖列表
	 * 
	 */
	private void showScore(StarList clearStars) {

		int addScore = mScoreService.getScoreByStars(clearStars);

		if (addScore != 0) {

			// 获得所有待移动泡泡糖的坐标
			List<Integer> clearStarsCoordinate = StarFormUtils
					.getClearStarsCoordinate(clearStars);

			// 动画显示点击所得增加分数
			ParallelTransition parallelTransition = StarAnimation
					.getScoreAnimation(mRoot, clearStarsCoordinate,
							mScoreService);
			parallelTransition.play();

			score += addScore;

			// 刷新总得分
			scoreLabel.setText("分数: " + score);
		}

		// 当分数第一次达到每一关的目标分数时出现通关通知
		if (mScoreService.isNoticedPassLevel(currentLevel, score))
			StarAnimation.passedFlag(mAnchorPane);
	}

	private class RestartEvent implements EventHandler<MouseEvent> {
		private AnchorPane root = null;
		private Label failedNotice = null;

		public RestartEvent(AnchorPane root, Label failedNotice) {
			this.root = root;
			this.failedNotice = failedNotice;
		}

		@Override
		public void handle(MouseEvent event) {

			// 清楚失败通知
			StarAnimation.clearAwardLable(root, failedNotice);
			// 初始本关初始成绩
			score = lastLevelScore;
			// 重新初始化
			initGameStars(root);

			// 拿到通关等级和目标分数Label
			Label lastLevelNum = (Label) root.lookup("#lblCheckpoint");
			Label lastLevelTargetScore1 = (Label) root.lookup("#targetScore");
			Label rebackScore = (Label) root.lookup("#lblScore");

			// 初始通关等级
			lastLevelNum.setText("第" + lastLevel + "关");

			// 初始目标分数
			lastLevelTargetScore1.setText("" + lastLevelTargetScore);

			// 回滚得分总数
			rebackScore.setText("" + lastLevelScore);

		}

	}

//	/**
//	 * 垂直方向泡泡糖的移动线程
//	 * 
//	 * @author csg-czk
//	 *
//	 */
//	class MoveYStarController extends Thread {
//
//		private StarList yStars = null;
//		private StarList movedStars = null;
//		private CountDownLatch yLatch = null;
//
//		public MoveYStarController(StarList yStars,
//				StarList movedStars, CountDownLatch yLatch) {
//			this.yStars = yStars;
//			this.movedStars = movedStars;
//			this.yLatch = yLatch;
//		}
//
//		@Override
//		public void run() {
//			// 移动界面上的泡泡糖，并保证水平移动在垂直移动后完成
//			moveYStars(movedStars, yStars, yLatch);
//
//			if (logger.isDebugEnabled())
//				logger.debug("垂直方向泡泡糖移动后（Y轴），内存泡泡糖对象阵列:" + mCurretStars);
//		}
//
//	}

	/**
	 * 水平方向泡泡糖的移动线程（它将在垂直方向线程移动后执行）
	 * 
	 */
	class MoveXStarController extends Thread {

		private CountDownLatch latch = null;

		public MoveXStarController(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {

			try {
				// 确保水平移动在垂直移动后完成
				latch.await();
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 获取需要移动的定星球
			StarList xStars = mStarService.getHMovedStars(mCurretStars);

			int size = xStars == null ? 0 : xStars.size();

			// 当没有可清除目标时进入判断是否切关
			CountDownLatch xLatch = new CountDownLatch(size);

			if (size == 0) {
				// 判断是否因为全部泡泡糖消除完毕之后才使得size为0，若是，则清屏操作
				if (!mStarService.tobeEliminated(mCurretStars))
					new ClearScreenController(xLatch, size).start();
				return;
			}

			new ClearScreenController(xLatch, size).start();

			Platform.runLater(new Runnable() {

				// @Override
				public void run() {

					// 移动水平方向的泡泡糖
					moveXStars(xStars, xLatch);

					if (logger.isDebugEnabled())
						logger.debug("水平方向泡泡糖移动后（X轴），内存泡泡糖对象阵列:" + mCurretStars);
				}
			});

		}

	}

	/**
	 * 当无可消除的泡泡糖的清屏线程
	 *
	 */
	class ClearScreenController extends Thread {

		private CountDownLatch latch = null;

		private int size = 0;

		public ClearScreenController(CountDownLatch latch, int size) {
			this.latch = latch;
			this.size = size;
		}

		@Override
		public void run() {

			if (size != 0) {
				try {
					// 确保水平移动在垂直移动后完成
					latch.await();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 当Y轴方向与X轴方向泡泡糖都已经移动完毕后（线程执行完毕后）
			// 再判定是否还有可消除的泡泡糖，如果有再执行清屏与奖励动画
			if (mStarService.tobeEliminated(mCurretStars))
				return;

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// 执行清屏与奖励动画
					runAwardAnimation();
				}

			});

		}
	}

	/**
	 * 移动界面上的泡泡糖，并保证水平移动在垂直移动后完成
	 * 
	 * @param movedStars
	 *            所有需要移动的泡泡糖列表（x轴+y轴）
	 * @param yStars
	 *            仅垂直方向需要移动的泡泡糖列表（y轴）
	 * @param latch
	 *            线程同步器，用于确保水平移动在垂直移动后完成
	 */
	private void moveYStars(StarList movedStars, CountDownLatch latch) {

		for (int i = 0; i < movedStars.size(); i++) {
			// 获取待移动的泡泡糖
			MovedStar mStar = (MovedStar) movedStars.get(i);

			// 移动后需要更细内存中泡泡糖的坐标与样式
			mCurretStars.update(mStar.getPosition().getRow(), mStar
					.getPosition().getColumn(), mStar
					.getMovedPosition().getRow(), mStar.getMovedPosition()
					.getColumn());

			// 转换为视图对象
			Label starFrame = StarFormUtils.findFrame(mStar,
					mAnchorPane);

			// 动画移动泡泡糖
			StarAnimation.slideYStar(
					starFrame,
					mStar.getMovedPosition().getRow()
							* StarFormUtils.STAR_HEIGHT).setOnFinished(
					new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							latch.countDown();
						}
					});

			// 更新控件的ID值
			starFrame.setId("s" + mStar.getMovedPosition().getRow()
					+ mStar.getMovedPosition().getColumn());
			// 更新控件的传参属性
			starFrame.setUserData(mStar.getMovedPosition().getRow() + ";"
					+ mStar.getMovedPosition().getColumn());

			// 更新列坐标
			mStar.getPosition()
					.setColumn(mStar.getMovedPosition().getColumn());

		}

	}

	/**
	 * 移动界面上水平方向的泡泡糖
	 * 
	 * @param xStars
	 *            仅水平方向需要移动的泡泡糖列表（x轴）
	 */
	private void moveXStars(StarList xStars, CountDownLatch xLatch) {

		for (int i = 0; i < xStars.size(); i++) {
			// 获取待移动的泡泡糖
			MovedStar mStar = (MovedStar)xStars.get(i);

			// 移动后需要更细内存中泡泡糖的坐标与样式
			mCurretStars.update(mStar.getPosition().getRow(), mStar
					.getPosition().getColumn(), mStar
					.getMovedPosition().getRow(), mStar.getMovedPosition()
					.getColumn());

			// 转换为视图对象
			Label starFrame = StarFormUtils.findFrame(mStar,
					mAnchorPane);

			// 动画移动泡泡糖
			StarAnimation.slideXStar(
					starFrame,
					mStar.getMovedPosition().getColumn()
							* StarFormUtils.STAR_WIDTH).setOnFinished(
					new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							if (xStars != null && xStars.size() > 0)
								xLatch.countDown();
						}
					});

			// 更新控件的ID值
			starFrame.setId("s" + mStar.getMovedPosition().getRow()
					+ mStar.getMovedPosition().getColumn());
			starFrame.setUserData(mStar.getMovedPosition().getRow() + ";"
					+ mStar.getMovedPosition().getColumn());

		}
	}

	/**
	 * 根据从服务端获取需要清除的泡泡糖列表，清除对应的视图
	 * 
	 * @param clearStars
	 *            从服务端获取需要清除的泡泡糖列表
	 */
	private void clearStars(StarList clearStars) {
		if (clearStars == null || clearStars.size() == 0)
			return;

		for (Star star : clearStars) {

			Label starFrame = StarFormUtils.findFrame(star, mAnchorPane);

			// 删除界面上的泡泡糖
			StarAnimation.clearStarLable(mAnchorPane, starFrame);

			// 删除内存中的泡泡糖（与界面保持一致）
			mCurretStars.setNull(star.getPosition().getRow(), star
					.getPosition().getColumn());
		}
	}

	/**
	 * 执行清屏与奖励动画
	 */
	private void runAwardAnimation() {
		// 将视图中不能消除的泡泡糖转化为待消除泡泡糖
		StarList awardStarList = mStarService.getAwardStarList(mCurretStars);
		// 设置计数器，确保全部泡泡糖消除后再切关
		CountDownLatch slach = new CountDownLatch(awardStarList.size());
		// 奖励分数初始值为0
		int awardScore = mScoreService.getAwardScore(awardStarList.size());
		// 动画显示奖励分数，并且在显示奖励分数后触发清屏事件
		StarAnimation.awardAnimation(mRoot, awardScore, awardStarList)
				.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						// 清除泡泡糖
						// clearStars(awardStarList);

						score += awardScore;
						// 刷新总得分
						scoreLabel.setText("分数: " + score);
						// 每消除一个泡泡糖，待消除泡泡糖计数器减1
						clearLeftStar(awardStarList, slach);
						// 保证清除完泡泡糖后看是否切关
						new ChangeLevelThread(slach).start();

					}
				});
	}

	/**
	 * 
	 * 切关动画控制器，该动画控制器必须在清屏线程执行完毕后才可以执行
	 *
	 */
	class ChangeLevelThread extends Thread {
		private CountDownLatch latch = null;

		public ChangeLevelThread(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				latch.await();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// 是否满足切关要求
					if (mScoreService.isChangeLevel(score)) {
						// 切关
						changeLevel();
					} else {
						// 通关失败，显示失败通知
						Label failedNotice = new Label(Message.LEVEL_FAULT);
						failedNotice.setFont(new Font(40.0));
						failedNotice.setLayoutX(63.0);
						failedNotice.setLayoutY(280.0);
						failedNotice.setTextFill(Color.WHITE);
						mRoot.getChildren().add(failedNotice);

						// 注册鼠标事件，选择是否继续通关
						RestartEvent restart = new RestartEvent(mRoot,
								failedNotice);
						failedNotice.setOnMouseClicked(restart);

					}
				}
			});

		}

	}

	// 计数要清除的泡泡糖个数
	private void clearLeftStar(StarList awardStarList,
			CountDownLatch awardStarLatch) {
		if (awardStarList == null || awardStarList.size() == 0) {
			return;
		}

		for (Star star : awardStarList) {
			Label starFrame = StarFormUtils.findFrame(star, mAnchorPane);
			// 删除界面上的奖励泡泡糖,并且在消除一个泡泡糖后将待消除泡泡糖个数减1
			StarAnimation.clearAwardLable(mAnchorPane, starFrame)
					.setOnFinished(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// 删除内存中的泡泡糖（与界面保持一致）
							mCurretStars.setNull(star.getPosition().getRow(),
									star.getPosition().getColumn());
							// 待清除泡泡糖个数计数器1
							awardStarLatch.countDown();
							if (logger.isDebugEnabled()) {
								logger.debug("当前剩余泡泡糖数量=====" + awardStarList
										+ "countDl=="
										+ awardStarLatch.getCount());
							}
						}

					});

		}

	}

	/**
	 * 切关动画
	 */
	private void changeLevel() {
		// 切换关卡，游戏等级加1
		currentLevel++;
		// 保存切换关卡等级，用于闯关失败恢复
		lastLevel = currentLevel;
		// 保存切换关卡分数，用于失败恢复初始分数
		lastLevelScore = score;
		// 返回切换关卡时的对应的目标分数

		int nextLevelTargetScore = mScoreService.nextScoreByLevel(currentLevel);
		// 显示下一关卡等级和目标分数完成后再进入下一关
		StarAnimation.passNotice(mAnchorPane, currentLevel,
				nextLevelTargetScore).setOnFinished(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						initGameStars(mRoot);
						// 拿到关卡等级
						Label levelNum = (Label) mRoot.lookup("#lblCheckpoint");

						// 拿到目标得分视图对象
						Label targetScore = (Label) mRoot
								.lookup("#targetScore");
						// 设置关卡等级
						levelNum.setText("第" + currentLevel + "关");
						// 设置目标分数
						targetScore.setText("" + nextLevelTargetScore);
						// 保存目标分数，用于失败恢复时设置目标分数
						lastLevelTargetScore = nextLevelTargetScore;
						return;

					}

				});
	}

}
