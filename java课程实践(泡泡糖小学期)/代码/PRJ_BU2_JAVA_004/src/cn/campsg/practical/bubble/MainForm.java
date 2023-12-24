package cn.campsg.practical.bubble;

import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.campsg.practical.bubble.common.StarAnimation;
//import cn.campsg.practical.bubble.common.StarAnimation;
import cn.campsg.practical.bubble.common.StarFormUtils;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.service.StarService;

/**
 * 泡泡糖窗体类，用于显示泡泡糖阵列、处理泡泡糖点击事件与动画
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 */
public class MainForm extends Application {

	private AnchorPane mRoot = null;

	private AnchorPane mAnchorPane = null;

	private StarList mCurretStars = null;

	private StarService mStarService = null;

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
	
	/**
	 * 页面加载时或重新开始新的泡泡糖棋局时候初始化泡泡糖
	 * 
	 * @param root
	 *            窗体总布局
	 * 
	 */
	private void initGameStars(AnchorPane root) {

		// 调用业务层获取随机10*10泡泡糖阵列
		mCurretStars = mStarService.createStars();

		if (mCurretStars == null || mCurretStars.size() == 0) {
			return;
		}

		mRoot = root;

		// 获取泡泡糖布局对象
		mAnchorPane = (AnchorPane) root.lookup("#game_pane");
		
		StartEventHandler handler = new StartEventHandler();

		// 将StarList中的所有Star对象转换成Label视图对象
		List<Label> starFrames = StarFormUtils.convert(mCurretStars);
		for(Label starFrame : starFrames)
			starFrame.setOnMouseClicked(handler);

		// 将Label加入到视图布局中
		for (int i = 0; i < starFrames.size(); i++) {
			mAnchorPane.getChildren().add(starFrames.get(i));
		}

		Label lastLevelTargetScore1 = (Label) root.lookup("#targetScore");
		lastLevelTargetScore1.setText(lastLevelTargetScore+"");
	}

	/**
	 * 初始化并加载服务类组件
	 */
	private void initServiceComponent() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"service.xml");
		try {
			mStarService = (StarService) context.getBean("starService");
		} catch (Exception e) {
			System.exit(0);
		}
	}
	
	protected boolean isClickAvailable = true;
	
	/**
	 * 泡泡糖被点击的事件处理对象
	 */
	public class StartEventHandler implements EventHandler<MouseEvent> {

		public StartEventHandler() {
			mAnchorPane = (AnchorPane) mRoot.lookup("#game_pane");
		}

		@Override
		public void handle(MouseEvent event) {

//			if(isClickAvailable == false)
//				return;
//			
//			isClickAvailable = false;
//			
			// 获取被点击的泡泡糖视图
			Label starFrame = (Label) event.getTarget();

			// 将视图转换为泡泡糖实体
			Star base = StarFormUtils.convert(starFrame);

			// 从服务端获取需要清除的泡泡糖列表
			StarList clearStars = mStarService.tobeClearedStars(base,
					mCurretStars);

			// 无需消除泡泡糖，则停止点击事件的处理（例如：用户点击的泡泡糖周边没有关联颜色的泡泡糖）
//			if (clearStars == null || clearStars.size() == 0){
//				isClickAvailable = true;
//				return;
//			}
//
//			// 从服务端获取需要移动的泡泡糖（垂直方向的）
//			StarList movedYStars = mStarService.getVMovedStars(clearStars,
//					mCurretStars);

			// 根据从服务端获取需要清除的泡泡糖列表，清除对应的视图
			clearStars(clearStars);


			// 创建线程同步器，用于保证水平泡泡糖移动慢于垂直移动
//			CountDownLatch yLatch = new CountDownLatch(movedYStars.size());
//
//			// 移动界面上的泡泡糖，并保证水平移动在垂直移动后完成
//			moveYStars(movedYStars, yLatch);
//
//
//			// 移动水平方向的泡泡糖（在垂直方向星星完成后操作）
//			new MoveXStarController(yLatch).start();
//
//			// 显示分数动画
//			showScore(clearStars);
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

}
