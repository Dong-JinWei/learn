package com.dowei.service;

import java.util.List;

import com.dowei.pojo.Students;

public interface StudentsService {

	/**
	 * ����id��ѯ�û���Ϣ
	 * 
	 * @param stu
	 * @return ��������û�����Ϣ
	 */
	public Students queryStudents(String username);

	/**
	 * �޸�ѧ����Ϣ
	 * 
	 * @param stu
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean modifyStudents(Students stu);

	/**
	 * ����ѧ��
	 * 
	 * @param stu
	 * @return
	 */
	public boolean insertStudents(Students stu);

	/**
	 * �鿴����ѧ��
	 * 
	 * @return
	 */
	public List<Students> findStudents();

}
