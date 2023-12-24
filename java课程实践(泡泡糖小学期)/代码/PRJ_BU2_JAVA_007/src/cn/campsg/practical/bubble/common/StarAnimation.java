package cn.campsg.practical.bubble.common;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public final class StarAnimation {



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


}