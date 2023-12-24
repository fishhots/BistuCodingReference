package cn.campsg.practical.bubble.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.campsg.practical.bubble.entity.Score;

/**
 * 该类用于等于score.conf配置文件,<br>
 * 被读取的分数数据将会被保存在Score组件中。
 * 
 * @author Frank.Chen
 * @version 1.0
 *
 */
public class Configuration {

	/* score.conf文件的路径 */
	public static final String CONF_PATH = "score.conf";

	/* 用于保存分数的对象 */
	private Score score = null;

	public Configuration() {

		score = new Score();

		try {

			// 读取score.conf配置文件
			BufferedReader br = new BufferedReader(new InputStreamReader(
					getClass().getClassLoader().getResourceAsStream(CONF_PATH)));// new
																					// FileReader(CONF_PATH));

			// 读取关卡分数，当前读取配置文件中的分数是默认第一关的通关分
			score.setLevelScore(Integer.parseInt(br.readLine()));
			// 读取通过后每次关卡的递增分，例如：第一关1000分，第二关levelScore + step分
			score.setStep(Integer.parseInt(br.readLine()));
			// 读取达到关卡倍增上限后的分数增值数，例如：达到第四关后，每关递增分数=step + increment
			score.setIncrement(Integer.parseInt(br.readLine()));
			// 读取关卡倍增数，每几关分数递增一次。
			score.setLength(Integer.parseInt(br.readLine()));

			br.close();

		} catch (FileNotFoundException e) {
			score = null;

		} catch (NumberFormatException | IOException e) {
			score = null;
		}
	}

	public Score getScore() {
		return score;
	}

	/**
	 * 根据本关卡计算出对应关的关卡得分
	 * 
	 * @param level
	 *            下一关关卡
	 * @return 本关的关卡得分
	 */
	public int nextLevelScore(int nextlevel) {

		if (score == null)
			return 0;

		// 更新保存本关的目标分数
		score.setLevelScore(score.getLevelScore() + (nextlevel - 1)
				/ score.getLength() * score.getIncrement() + score.getStep());

		// 返回本关目标分数
		return score.getLevelScore();

	}

}
