package com.dowei.dao;

import java.util.List;

import com.dowei.pojo.CourseAndScorse;

public interface CourseAndScorseDao {

	/**
	 * �����û����ֲ鿴�û��ɿγ̺ͳɼ�
	 * 
	 * @param username �û���
	 * @return �����������CourseAndScorese
	 */
	public List<CourseAndScorse> queryScoreByName(String username);

	/**
	 * ѡ��γ�
	 * 
	 * @param courseAndScorse
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int selectScorse(CourseAndScorse courseAndScorse);

	/**
	 * ¼��ɼ�
	 * 
	 * @param courseAndScorse
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int insertScorse(CourseAndScorse courseAndScorse);
}
