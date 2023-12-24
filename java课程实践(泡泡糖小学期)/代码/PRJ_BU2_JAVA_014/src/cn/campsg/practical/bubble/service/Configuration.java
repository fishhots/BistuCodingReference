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
		//ʵ����Score����
		score=new Score();
		try{
		//�����ַ��������ȡ������ȡ�����ļ�
		BufferedReader br=new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(CONF_PATH)));
		//��ȡ������ΪString����ҪparseInt��ǿ��ת������
		//ÿ�ص�ͨ��Ŀ��
		score.setLevelScore(Integer.parseInt(br.readLine()));
		//ÿ�ص�ͨ�ص�����
		score.setStep(Integer.parseInt(br.readLine()));
		//�Ѷ�׷�ӵ�����
		score.setIncrement(Integer.parseInt(br.readLine()));
		//�Ѷ�׷�ӹؿ������
		score.setLength(Integer.parseInt(br.readLine()));
		//�ر��ַ���
		br.close();
		}
		//��������ȡ�����ļ�����������
		catch(FileNotFoundException e){
			score=null;
		}
		//���Ӷ�ȡ������������
		catch(IOException e){
			score=null;
		}
	}
	
}
