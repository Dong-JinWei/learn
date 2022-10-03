package com.dowei.dao;

import java.util.List;

import com.dowei.pojo.User;

public interface UserDao {

	/**
	 * �����û�����ѯ��Ϣ
	 * 
	 * @param username
	 * @return �������null��˵��û������û�
	 */
	public User queryUserByUsername(Integer userID);

	/**
	 * ɾ���û�
	 * 
	 * @param user
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int deleteUser(Integer id);

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param user
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int updateUser(User user);

	/**
	 * �����û�id�������ѯ
	 * 
	 * @param id       �û�id
	 * @param password �û�����
	 * @return �������null��˵���û�id���������
	 */
	public User queryUserByUsernameAndPassword(Integer id, String username, String password);

	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 * @return ����-1 ��ʾʧ�ܣ���������sql���Ӱ�������
	 */
	public int saveUser(User user);

	/**
	 * ��ѯ���е��û�
	 * 
	 * @return
	 */
	public List<User> queryAllUser();

}
