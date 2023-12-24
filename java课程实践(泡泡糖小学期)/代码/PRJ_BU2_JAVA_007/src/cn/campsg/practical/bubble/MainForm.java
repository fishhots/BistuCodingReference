package cn.campsg.practical.bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import cn.campsg.practical.bubble.common.StarAnimation;
import cn.campsg.practical.bubble.common.StarFormUtils;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.service.StarService;
import cn.campsg.practical.bubble.service.StarServiceImpl;

/**
 * 泡泡糖窗体类，用于显示泡泡糖阵列、处理泡泡糖点击事件与动画
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 */
public class MainForm extends Application {
	
	/** 从服务端获取的完整10*10泡泡糖列表  **/
	private StarList mCurretStars = null;
	
	/** 窗体中显示泡泡糖的区域 **/
	private AnchorPane mStarForm = null;

	public static void show(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

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

		// 返回窗体中显示泡泡糖的区域
		mStarForm = (AnchorPane) root.lookup("#game_pane");

		// 创建消灭泡泡糖业务类
		StarService starService = getStarService();

		// 创建调用创建泡泡糖代码
		mCurretStars = starService.createBubbleMatrix();

		// 循环遍历所有泡泡糖，将泡泡糖对象Star转化为界面显示控件Label
		for (int i = 0; i < mCurretStars.size(); i++) {
			// 从泡泡糖集合中取出一个泡泡糖
			Star star = mCurretStars.get(i);

			// 创建界面泡泡糖显示控件Label
			Label starFrame = new Label();
			starFrame.setPrefWidth(48);
			starFrame.setPrefHeight(48);

			// 获取泡泡糖对象Star的行与列
			int row = star.getPosition().getRow();
			int col = star.getPosition().getColumn();
			
			// 为泡泡糖显示控件Label设置唯一标识ID，ID规则为s+行号+列号（例如：s00,s01）
			starFrame.setId("s" + row + col);
			// 将泡泡糖的坐标位置保存起来用于识别泡泡糖在界面中的位置。
			starFrame.setUserData(row + ";" + col);
			// 设置泡泡糖显示控件Label在界面的呈现坐标
			starFrame.setLayoutX(col * 48);
			starFrame.setLayoutY(row * 48);

			// 设置泡泡糖显示控件Label显示外观
			switch (star.getType().value()) {
			case 0:
				starFrame.getStyleClass().add("blue_star");
				break;
			case 1:
				starFrame.getStyleClass().add("green_star");
				break;
			case 2:
				starFrame.getStyleClass().add("yellow_star");
				break;
			case 3:
				starFrame.getStyleClass().add("red_star");
				break;
			case 4:
				starFrame.getStyleClass().add("purple_star");
				break;
			}
			
			/******************** PRJ-BU2-JAVA-007 Task1 ********************/
			StarEventHandler SEH=new StarEventHandler((StarServiceImpl)getStarService());
			starFrame.setOnMouseClicked(SEH);
			

			
			
			
			
			
			
			
			
			/******************************************************/
			
			// 将泡泡糖加入到窗体中显示泡泡糖的区域
			mStarForm.getChildren().add(starFrame);
		}

	}
	
	/**
	 * 泡泡糖被点击的事件处理对象
	 */


	
	public class StarEventHandler  implements EventHandler {

		@Override
		public void handle(Event event) {
			// TODO Auto-generated method stub
			//获取被点击泡泡糖的Label
			Label starFrame = (Label) event.getTarget();
			//将被点击Label转换成泡泡糖对象Star
			Star base= StarFormUtils.convert(starFrame);
		//7.1测试语句	
			System.out.println(base.toString());
			//获取【待消除泡泡糖】集合
			StarList SL=SS.tobeClearedStars(base, mCurretStars);
			//判断【待消除泡泡糖】集合是否为空
			if(SL.size()==0||SL==null){
				//为空，跳出【点击事件】
				return;
			}
			else{
				//不为空，遍历【待消除泡泡糖】集合，执行消除操作
				for(int i=0;i<SL.size();i++)
				{
					Star star=SL.get(i);
					Label frame= StarFormUtils.findFrame(star, mStarForm);
					//执行清除动画，并清除界面上的泡泡糖控件
					StarAnimation.clearStarLable(mStarForm, frame);
					//同步清除【待消除泡泡糖列表】的泡泡糖对象
					SL.setNull(star.getPosition().getRow(), star.getPosition().getColumn());
				}
			}
		}
		StarService SS=new StarService() {
			
			@Override
			public boolean tobeEliminated(StarList currentStarList) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public StarList tobeClearedStars(Star base, StarList sList) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StarList getYMovedStars(StarList clearStars, StarList currentStarList) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StarList getXMovedStars(StarList currentStarList) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StarList getAwardStarList(StarList currentStarList) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StarList createBubbleMatrix() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		public StarEventHandler(StarServiceImpl SSI) {
			SS=SSI;
			
		}
		public StarEventHandler(){
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * 基于接口动态创建泡泡糖服务类，服务类名保存与bean.conf配置文件中
	 * 
	 * @return 泡泡糖服务类
	 */
	private StarService getStarService() {
		//创建JVM类加载器
		ClassLoader loader = this.getClass().getClassLoader();

		//从配置文件bean.conf中读取泡泡糖服务类[类全名]
		String className = getClassName();

		try {
			//加载泡泡糖服务类
			Class<?> clazz = loader.loadClass(className);
			//动态创建并返回泡泡糖服务类的实例
			return (StarService) clazz.newInstance();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 从配置文件bean.conf中读取泡泡糖服务类[类全名]
	 * 
	 * @return 泡泡糖服务类[类全名]
	 */
	private String getClassName() {
		// 读取bean.conf配置文件
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass()
				.getClassLoader().getResourceAsStream("bean.conf")));
		
		try {
			//读取第一行数据
			String line = br.readLine();
			//返回等号右侧的泡泡糖服务类[类全名]字符串
			return line.split("=")[1];
		} catch (IOException e) {
			return "";
		}
	}
}
