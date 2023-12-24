package cn.campsg.practical.bubble.entity;

import java.io.Serializable;

/**
 * 
 * ������λ��ʵ���࣬���ڱ����������� 10 * 10����������λ��
 * 
 * @author Frank.Chen
 * @version 1.0
 *
 */
public class Position implements Serializable{
	
	private static final long serialVersionUID = 5429457710354730689L;
	/* �е�����λ�� */
	private int row;
	/* �е�����λ�� */
	private int column;

	public Position() {}

	public Position(int row, int column) {
		setRow(row);
		setColumn(column);
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}

	/******************** PRJ-BU2-JAVA-005 Task3 ********************/


	public String toString(){
        return "position:("+this.row+","+column+")";
    }
	
	
	
	
	
	
	
	/**************************************************************/
	
}
