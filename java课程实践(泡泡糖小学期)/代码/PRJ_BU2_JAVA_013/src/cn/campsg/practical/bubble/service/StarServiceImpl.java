package cn.campsg.practical.bubble.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.util.StarsUtil;

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

	private Logger logger = Logger.getLogger(StarServiceImpl.class);

	/**
	 * ������Ļ������������ǣ�10 * 10��
	 * 
	 * @return �������б�-��������ʾ
	 */
	@Override
	public StarList createBubbleMatrix() {

		StarList stars = new StarList();

		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {

			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {

				Star star = new Star();
				// �����������ڻ����ϵ�λ��
				star.setPosition(new Position(row, col));
				// ���������������
				int typeIndex = (int) (Math.random() * StarService.STAR_TYPES);
				star.setType(StarType.valueOf(typeIndex));
				// �����б�
				stars.add(star);
			}
		}

		test(stars);

		return stars;

	}

	private void test(StarList stars) {

		stars.get(5).setType(Star.StarType.YELLOW);
		stars.get(15).setType(Star.StarType.YELLOW);
		stars.get(25).setType(Star.StarType.YELLOW);
		stars.get(35).setType(Star.StarType.YELLOW);
		stars.get(45).setType(Star.StarType.YELLOW);
		stars.get(55).setType(Star.StarType.YELLOW);
		stars.get(65).setType(Star.StarType.YELLOW);
		stars.get(75).setType(Star.StarType.YELLOW);
		stars.get(85).setType(Star.StarType.YELLOW);
		stars.get(95).setType(Star.StarType.YELLOW);

		stars.get(7).setType(Star.StarType.YELLOW);
		stars.get(17).setType(Star.StarType.YELLOW);
		stars.get(27).setType(Star.StarType.YELLOW);
		stars.get(37).setType(Star.StarType.YELLOW);
		stars.get(47).setType(Star.StarType.YELLOW);
		stars.get(57).setType(Star.StarType.YELLOW);
		stars.get(67).setType(Star.StarType.YELLOW);
		stars.get(77).setType(Star.StarType.YELLOW);
		stars.get(87).setType(Star.StarType.YELLOW);
		stars.get(97).setType(Star.StarType.YELLOW);

		stars.get(9).setType(Star.StarType.YELLOW);
		stars.get(19).setType(Star.StarType.YELLOW);
		stars.get(29).setType(Star.StarType.YELLOW);
		stars.get(39).setType(Star.StarType.YELLOW);
		stars.get(49).setType(Star.StarType.YELLOW);
		stars.get(59).setType(Star.StarType.YELLOW);
		stars.get(69).setType(Star.StarType.YELLOW);
		stars.get(79).setType(Star.StarType.YELLOW);
		stars.get(89).setType(Star.StarType.YELLOW);
		stars.get(99).setType(Star.StarType.YELLOW);

		stars.get(2).setType(Star.StarType.YELLOW);
		stars.get(12).setType(Star.StarType.YELLOW);
		stars.get(22).setType(Star.StarType.YELLOW);
		stars.get(32).setType(Star.StarType.YELLOW);
		stars.get(42).setType(Star.StarType.YELLOW);
		stars.get(52).setType(Star.StarType.YELLOW);
		stars.get(62).setType(Star.StarType.YELLOW);
		stars.get(72).setType(Star.StarType.YELLOW);
		stars.get(82).setType(Star.StarType.YELLOW);
		stars.get(92).setType(Star.StarType.RED);

		stars.get(93).setType(Star.StarType.YELLOW);
		stars.get(94).setType(Star.StarType.YELLOW);

		stars.get(96).setType(Star.StarType.YELLOW);
		stars.get(98).setType(Star.StarType.YELLOW);

		stars.get(0).setType(Star.StarType.PURPLE);
		stars.get(10).setType(Star.StarType.PURPLE);
		stars.get(20).setType(Star.StarType.PURPLE);
		stars.get(30).setType(Star.StarType.PURPLE);
		stars.get(40).setType(Star.StarType.PURPLE);
		stars.get(50).setType(Star.StarType.PURPLE);
		stars.get(60).setType(Star.StarType.PURPLE);
		stars.get(70).setType(Star.StarType.RED);
		stars.get(80).setType(Star.StarType.GREEN);
		stars.get(90).setType(Star.StarType.GREEN);

		stars.get(81).setType(Star.StarType.GREEN);
		stars.get(11).setType(Star.StarType.RED);

		stars.get(1).setType(Star.StarType.GREEN);
		stars.get(11).setType(Star.StarType.GREEN);
		stars.get(21).setType(Star.StarType.GREEN);
		stars.get(31).setType(Star.StarType.GREEN);
		stars.get(41).setType(Star.StarType.GREEN);
		stars.get(51).setType(Star.StarType.GREEN);
		stars.get(61).setType(Star.StarType.GREEN);
		stars.get(71).setType(Star.StarType.GREEN);
		stars.get(81).setType(Star.StarType.GREEN);
		stars.get(91).setType(Star.StarType.GREEN);

		stars.get(3).setType(Star.StarType.YELLOW);
		stars.get(13).setType(Star.StarType.YELLOW);
		stars.get(23).setType(Star.StarType.YELLOW);
		stars.get(33).setType(Star.StarType.YELLOW);
		stars.get(43).setType(Star.StarType.YELLOW);
		stars.get(53).setType(Star.StarType.YELLOW);
		stars.get(63).setType(Star.StarType.YELLOW);
		stars.get(73).setType(Star.StarType.YELLOW);
		stars.get(83).setType(Star.StarType.YELLOW);

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
			if (star != null && !clearStars.existed(star)) {
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
			if (star != null && !clearStars.existed(star)) {
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
			if (star != null && !clearStars.existed(star)) {
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
			if (star != null && !clearStars.existed(star)) {
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

		if (logger.isDebugEnabled())
			logger.debug("��������������ڴ��б�:" + clearStars);

		return clearStars;
	}

	/**
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(���޴�ֱ�б��������)<br>
	 * �ù��̶ܹ������������������֮������
	 * 
	 * @param clearStars
	 *            ��������������б��Դ���Ϊ�ж����ƶ������ǵĻ�����
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return ���ƶ��������б�
	 */
	public StarList getVMovedStars(StarList clearStars,
			StarList currentStarList) {

		if (clearStars == null || clearStars.size() == 0)
			return null;

		// ���ڱ�����ƶ���������
		StarList moveStars = new StarList();

		// �Դ������������ִ�з������
		/*
		 * ����: ��������������Ϊ��(2,1);(3,1);(4,1);(2,2);(3,2);(4,2)
		 * �����1-{(2,1);(3,1);(4,1)}��2-{(2,2);(3,2);(4,2)}
		 */
		Map<Integer, StarList> groupedStars = StarsUtil.group(clearStars);

		// ���л�ȡ���д�ɾ���������ǣ�һ�п��ܶ�Ӧ���������ǣ�
		Iterator<Integer> keys = groupedStars.keySet().iterator();
		while (keys.hasNext()) {
			// ��ȡ�����
			Integer column = keys.next();
			// ��ȡ��ǰ�����ж�Ӧ��Ҫɾ������������
			StarList values = groupedStars.get(column);

			// ��������������������еײ������������ƶ��������ǣ�
			int starPosition = values.lastElement().getPosition().getRow();

			// �ƶ��������
			int span = 0;

			// �ӵײ������������ƶ���������
			for (int row = starPosition; row >= 0; row--) {
				// ��ȡ������
				Star star = currentStarList.lookup(row, column);
				// ��Ȼû�е������������ж��������ǵ�ǰ�����޿���������������ôֹͣ��ǰ������
				if (star == null)
					break;

				// ���������������������������У����ʾ�������Ǵ���������ƶ�
				// ��ô���ƶ�·�����ȼ�1
				if (clearStars.existed(star)) {
					span++;
					continue;
				}

				MovedStar mStar = StarsUtil.toMovedStar(star);
				// ���������������ƶ�����
				mStar.getMovedPosition().setRow(
						mStar.getPosition().getRow() + span);
				// ���޸�
				mStar.getMovedPosition().setColumn(
						mStar.getPosition().getColumn());
				// ������ƶ���������
				moveStars.add(mStar);

			}
		}
		if (logger.isDebugEnabled())
			logger.debug("���ƶ��������ڴ��б���ֱ�ƶ�����ģ�:" + moveStars + "���ƶ������Ǹ���Ϊ��"
					+ moveStars.size());

		return moveStars;
	}

	/**
	 * ��ȡ��������������ǵ������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return ��������������ǵ�����ż���
	 */
	/**************PRJ-BU2-JAVA-013 Task1  ��1/2 Start��*************/
	private ArrayList<Integer> getNullColumns(StarList currentList){
		//��������������ǵ��еļ���
		ArrayList<Integer> clearedColumn=new ArrayList<Integer>();
		//����ÿһ�����һ�е�������
		for(int i=0;i<MAX_COLUMN_SIZE;i++){
			//�жϸ�λ���Ƿ���ڡ���ײ������ǡ�
			if(currentList.existed(currentList.lookup(MAX_ROW_SIZE-1,i))){
				//���ڣ�����ѭ��
				continue;
			}
			else{
				//�����ڣ������м��롰����������ǵ��С�����
				clearedColumn.add(i);
			}
		}
		return clearedColumn;
	}

	
	
	
	
	
	/**************PRJ-BU2-JAVA-013 Task1  ��1/2 End��***************/

	/**
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(����ˮƽ�б��������)<br>
	 * �ù��̶ܹ��ڴ�ֱ�б��������֮������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * 
	 * @return ���ƶ��������б�
	 */
	public StarList getXMovedStars(StarList currentStarList) {
		/**************PRJ-BU2-JAVA-013 Task2  ��2/2 Start��*************/
		//13.1
		//ArrayList<Integer> emptyColumn=this.getNullColumns(currentStarList);
	//	System.out.println(emptyColumn);
		ArrayList<Integer> emptyColumn=this.getNullColumns(currentStarList);
		//�����м��ϲ����ڣ���X�������ƶ�������null����
		if(emptyColumn==null)
			return null;
		//���������ƶ������ǡ����ϣ����ڱ�������ˮƽ�����ƶ���������
		StarList beMovedStars=new StarList();
		//����X�ƶ��������洢�������ƶ����룬��ʼֵΪ0
		int Xmove=0;
		//�������м��ϵĳ�Ա
		for(int i=emptyColumn.get(0);i<MAX_COLUMN_SIZE;i++){
			//�ж��Ƿ�Ϊ����
			if(emptyColumn.contains(i)){
				//���У�X���ƶ�����+1��������һ��ѭ��
				Xmove++;
			}
			else{
				//���ǿ��У����뱣����ƶ������ǲ���
				//�Ե�����һ�λ�ȡ�ǿ����е�����������
				for(int j=MAX_ROW_SIZE-1;j>0;j--){
					//�жϻ�ȡ�������Ƿ�Ϊnull
					if(!currentStarList.existed(currentStarList.lookup(j, i))){
						//Ϊnull����ʾ�������������ǣ��ж�ѭ��
						break;
					}
					else{
						//��Ϊnull,��StarsUtil�ľ�̬����toMovedStar����ת��Ϊ"���ƶ�����������"
						MovedStar movedstar=StarsUtil.toMovedStar(currentStarList.lookup(j,i));
						//���ô��ƶ������ǵ�Ŀ���ƶ�λ��
						movedstar.setMovedPosition(new Position(movedstar.getPosition().getRow(),movedstar.getPosition().getColumn()-Xmove));
						//������ӵ������ƶ����ݡ�����
						beMovedStars.add(movedstar);
					}
				}
			}
		}
		//���ء����ƶ������ǡ�����
		return beMovedStars;
		/**************PRJ-BU2-JAVA-013 Task2  ��2/2 End��***************/
	}

	/**
	 * �ж��Ƿ񻹴���δ������������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return true:��Ȼ��δ������������,false:û��δ������������
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

		if (logger.isDebugEnabled())
			logger.debug("�����ڿ������������Ǹ���=" + getLeftStarNum(currentStarList));

		return false;
	}

	/**
	 * ��ȡʣ�������Ǹ���
	 * 
	 * @param mCurretStars
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return ʣ�������Ǹ���
	 * */
	private int getLeftStarNum(StarList currentStarList) {
		int leftStar = 0;
		// �����������б��Ѳ�Ϊnull�������Ǽ�Ϊʣ��������
		for (int i = 0; i < currentStarList.size(); i++) {
			if (currentStarList.get(i) != null)
				leftStar++;
		}
		if (logger.isDebugEnabled())
			logger.debug("��ʣ��δ����������������Ϊ" + leftStar);
		// ����ʣ����������Ŀ
		return leftStar;
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
				awardStarList.add(StarsUtil.copy(curretStars.get(i)));
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("��ʣ��δ����������������Ϊ" + awardStarList);
		// ���ؽ����������б�
		return awardStarList;

	}

}
