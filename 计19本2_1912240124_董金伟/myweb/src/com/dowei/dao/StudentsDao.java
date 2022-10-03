package com.dowei.dao;

import java.util.List;

import com.dowei.pojo.Students;

public interface StudentsDao {

	/**
	 * �����û����鿴�û�����Ϣ
	 * 
	 * @param sId
	 * @return �Ż��������students
	 */
	public Students queryStudentsBySId(String username);

	/**
	 * �޸�ѧ����Ϣ
	 * 
	 * @param students
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int updateStudents(Students students);

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param students
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int saveStudents(Students students);

	/**
	 * ��ѯ���е�ѧ��
	 * 
	 * @return
	 */
	public List<Students> queryAllStudents();

}
