package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.*;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.entity.Star.StarType;

public class StarServiceTester implements StarService{

	@Override
	public StarList createStars() {
		// TODO Auto-generated method stub
		StarList starlist=new StarList();
		starlist.add(new Star(new Position(0,0),StarType.BLUE));
		starlist.add(new Star(new Position(0,1),StarType.GREEN));
		starlist.add(new Star(new Position(1,0),StarType.PURPLE));
		starlist.add(new Star(new Position(1,1),StarType.YELLOW));
		starlist.add(new Star(new Position(0,2),StarType.RED));
		return starlist;
	}
	public static void main(String[] args){
		StarServiceTester SST=new StarServiceTester();	
		System.out.println(SST.createStars().toString());		//若想改变格式，改变Star的toString()方法
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
	public boolean tobeEliminated(StarList currentStarList) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public StarList getAwardStarList(StarList currentStarList) {
		// TODO Auto-generated method stub
		return null;
	}
}
