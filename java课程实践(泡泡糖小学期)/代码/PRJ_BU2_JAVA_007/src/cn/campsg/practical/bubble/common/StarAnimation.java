package cn.campsg.practical.bubble.common;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public final class StarAnimation {



	/**
	 * �Խ��䶯��ɾ����������������
	 * 
	 * @param mAnchorPane
	 *            ��������ʾ����
	 * @param starFrame
	 *            ��������������
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
	 * JFX���䶯��
	 * 
	 * @param starFrame
	 *            ���ý�������
	 * 
	 * @return �������
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