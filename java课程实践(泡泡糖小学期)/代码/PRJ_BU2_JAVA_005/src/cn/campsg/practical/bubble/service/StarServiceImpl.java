package cn.campsg.practical.bubble.service;

import java.util.ArrayList;
import java.util.List;

import cn.campsg.practical.bubble.util.StarsUtil;
import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.entity.Star.StarType;

/**
 * 
 * ������ҵ���������࣬����Ϊ�����ṩ���·���<br>
 * 1. ������Ļ�������������<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	/**
	 * ������Ļ������������ǣ�10 * 10��
	 * 
	 * @return �������б�-��������ʾ
	 */
	@Override
	public StarList createStars() {
		StarList stars = new StarList();
		test(stars);
		return stars;

	}

	private void test(StarList stars) {
		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {
			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {
				stars.add(null);
			}
		}
		stars.add(new Star(new Position(0, 0), StarType.BLUE));
		stars.add(new Star(new Position(1, 0), StarType.PURPLE));
		stars.add(new Star(new Position(2, 0), StarType.GREEN));
		stars.add(new Star(new Position(3, 0), StarType.RED));
		stars.add(new Star(new Position(4, 0), StarType.GREEN));
		stars.add(new Star(new Position(5, 0), StarType.YELLOW));
		stars.add(new Star(new Position(6, 0), StarType.PURPLE));
		stars.add(new Star(new Position(7, 0), StarType.RED));
		stars.add(new Star(new Position(8, 0), StarType.RED));
		stars.add(new Star(new Position(9, 0), StarType.GREEN));
	}
	
	/**
	 * �Ը��������ǣ��û�����ģ�Ϊ�����������ҡ�����·������Ѱ����ͬ���͵�������
	 * 
	 * @param base
	 *            ���������ǣ��û�����ģ�
	 * @param sList
	 *            ԭʼ�������б����������е������ǣ�
	 * @param clearStars
	 *            ��������������б�
	 */
	private void findStarsByPath(Star base, StarList sList, StarList clearStars) {
		// ��ȡ��ǰ����������ǵ��к���
		int row = base.getPosition().getRow();
		int col = base.getPosition().getColumn();
		StarType type = base.getType();

		Star star = null;

		// �����·�������ж�
		if (col - 1 >= 0) {
			// ���������߽������£���ȡ����������ǵ����������
			star = (Star) sList.lookup(row, (col - 1));
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б�
					clearStars.add(StarsUtil.copy(star));
					// ���������·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// ���Ҳ�·�������ж�
		if (col + 1 < StarService.MAX_COLUMN_SIZE) {
			// �������Ҳ�߽������£���ȡ����������ǵ��Ҳ�������
			star = (Star) sList.lookup(row, (col + 1));
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б�
					clearStars.add(StarsUtil.copy(star));
					// �������Ҳ�·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// ���Ϸ�·�������ж�
		if (row - 1 >= 0) {
			// �������Ϸ��߽������£���ȡ����������ǵ��Ϸ�������
			star = (Star) sList.lookup((row - 1), col);
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б�
					clearStars.add(StarsUtil.copy(star));
					// �������Ϸ�·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// ���·�·�������ж�
		if (row + 1 < MAX_ROW_SIZE) {
			// �������·��߽������£���ȡ����������ǵ��·�������
			star = (Star) sList.lookup((row + 1), col);
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.isexisted(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б�
					clearStars.add(StarsUtil.copy(star));
					// �������·�·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// �����ĸ��ж϶����������ʾ���ܶ�û���������ˣ���ô�����ݹ鷽����
	}

	/**
	 * �û���������ǣ���ȡ���������������������б�
	 * 
	 * @param base
	 *            ���û������������
	 * @param sList
	 *            ��ǰ���������ݵ��б�
	 * @return ��Ҫ�����������
	 */
	@Override
	public StarList tobeClearedStars(Star base, StarList mCurrent) {
		// ���ڱ���������������
		StarList clearStars = new StarList();
		// �ӵ�ǰ�б��л�ȡָ������ָ���е������ǣ�base�����ǣ�
		// ������������Ϊ������󱣴����б���
		// ע�⣺���д�����������Ƕ�Ӧ����ԭʼ�Ľ����������б���
		clearStars.add(base);
		// �Ա����������Ϊ���������ҡ����²�ͬ·��Ѱ����ͬ���ͣ���ɫ���Ĵ����������
		findStarsByPath(base, mCurrent, clearStars);
		if (clearStars.size() == 1)
			clearStars.clear();
		return clearStars;
	}

	public StarList getYMovedStars(StarList clearStars,
			StarList currentStarList) {
		/******************** PRJ-BU2-EL-005 Task2 ********************/
		StarList MovedStarList=new StarList();
		StarList str = new StarList();
		int column = 0;
		for(int i=6;i>=0;i--){//ѭ����Χ��6��0���εݼ�
		MovedStar movedstar = new MovedStar(currentStarList.lookup(i, 0).getPosition(),currentStarList.lookup(i, column).getType(),new Position(i+2,0));
		str.add(movedstar);
		   
		}
		  
		return str;

		/**************************************************************/
	}

	/**
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(����ˮƽ�б��������)<br>
	 * �ù��̶ܹ��ڴ�ֱ�б��������֮������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * 
	 * @return ���ƶ��������б�
	 */
	public StarList getHMovedStars(StarList currentStarList) {
		// ��ȡ���б���������ǵ���
		List<Integer> nullColumns = getEmpyColumns(currentStarList);

		// û����ȫ����������ǵ��У�����null����֪����X�������ƶ�
		if (nullColumns == null || nullColumns.size() == 0)
			return null;

		StarList moveStars = new StarList();

		// ��ȡ�ж���ʾ��
		int starPosition = nullColumns.get(0) + 1;

		// ˮƽ�ƶ�����
		int span = 1;

		// ���ж���ʾ��->�Ҳ�߽�����ж�
		for (int column = starPosition; column < StarService.MAX_COLUMN_SIZE; column++) {
			// ����һ���б������ˮƽ�ƶ�����+1
			if (nullColumns.contains(column)) {
				span++;
				continue;
			}

			// ��ǰ�����������û�б���գ��򽫴��ƶ��������Ǽ��뵽�ƶ��б���
			for (int row = (StarService.MAX_ROW_SIZE - 1); row >= 0; row--) {

				Star star = currentStarList.lookup(row, column);

				if (star == null)
					break;

				
				MovedStar mStar = StarsUtil.toMovedStar(star);
				// ���������������ƶ�����
				mStar.getMovedPosition().setRow(mStar.getPosition().getRow());
				// ���޸�
				mStar.getMovedPosition().setColumn(
						mStar.getPosition().getColumn() - span);
				// ������ƶ���������
				moveStars.add(mStar);
			}
		}

		return moveStars;
	}

	/**
	 * �ж��Ƿ񻹴���δ������������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return true:��Ȼ��δ������������,false:û��δ������������
	 * 
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		// �������������б�
		StarList clearStars = new StarList();

		for (int i = 0; i < currentStarList.size(); i++) {

			Star star = currentStarList.get(i);

			if (star != null)
				findStarsByPath(star, currentStarList, clearStars);

			// ����������������б�����0�����ʾ���п������������ǣ�����true
			if (clearStars.size() > 0)
				return true;
		}

		return false;
	}

	/**
	 * ��ȡ�޷������������б�
	 * 
	 * @param curretStars
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return �޷������������б�
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		StarList awardStarList = new StarList();

		// ����curretStars���Ѳ�Ϊnull�������Ǽӵ������������б���
		for (int i = 0; i < curretStars.size(); i++) {
			// tempStar = curretStars.get(i);
			if (curretStars.get(i) != null) {
				awardStarList.add(curretStars.get(i));
			}
		}
		// ���ؽ����������б�
		return awardStarList;
	}
	
	/**
	 * ��ȡ��������������ǵ������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return ��������������ǵ�����ż���
	 */
	private List<Integer> getEmpyColumns(StarList currentStarList) {

		List<Integer> ret = new ArrayList<Integer>();

		// ���ÿ�еײ������������ǣ�����ײ��������ǲ����ڣ���ô������Ϊ�ѱ����
		for (int column = 0; column < StarService.MAX_COLUMN_SIZE; column++) {

			if (currentStarList.lookup((StarService.MAX_ROW_SIZE - 1), column) == null)
				ret.add(column);
		}

		return ret;
	}

}
