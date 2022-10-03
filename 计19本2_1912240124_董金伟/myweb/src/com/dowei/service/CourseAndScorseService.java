package com.dowei.service;

import java.util.List;

import com.dowei.pojo.CourseAndScorse;

public interface CourseAndScorseService {
	/**
	 * ����id��ѯ�û���Ϣ
	 * 
	 * @param username
	 * @return ��������û�����Ϣ
	 */
	public List<CourseAndScorse> queryScourseAndScorse(String username);

	/**
	 * ѡ��ϵͳ
	 * 
	 * @param courseAndScorse
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int selectScorse(CourseAndScorse courseAndScorse);

	/**
	 * �޸ĳɼ�
	 * 
	 * @param courseAndScorse
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int insertScorse(CourseAndScorse courseAndScorse);

}
