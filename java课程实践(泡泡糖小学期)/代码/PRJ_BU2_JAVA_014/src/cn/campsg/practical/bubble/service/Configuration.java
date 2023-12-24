package cn.campsg.practical.bubble.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.campsg.practical.bubble.entity.Score;

public class Configuration {
	public static final String CONF_PATH="score.conf";
	private Score score;
	public Score getScore(){
		return this.score;
	}
	public Configuration() {
		//实例化Score对象
		score=new Score();
		try{
		//创建字符流缓存读取器，读取配置文件
		BufferedReader br=new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(CONF_PATH)));
		//读取的属性为String，需要parseInt来强制转换类型
		//每关的通关目标
		score.setLevelScore(Integer.parseInt(br.readLine()));
		//每关的通关递增分
		score.setStep(Integer.parseInt(br.readLine()));
		//难度追加递增分
		score.setIncrement(Integer.parseInt(br.readLine()));
		//难度追加关卡间隔数
		score.setLength(Integer.parseInt(br.readLine()));
		//关闭字符流
		br.close();
		}
		//监视所读取配置文件不存在情形
		catch(FileNotFoundException e){
			score=null;
		}
		//监视读取出现问题情形
		catch(IOException e){
			score=null;
		}
	}
	
}
