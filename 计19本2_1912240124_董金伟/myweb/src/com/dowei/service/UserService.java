package com.dowei.service;

import java.util.List;

import com.dowei.pojo.User;

public interface UserService {

	/**
	 * ע���û�
	 * 
	 * @param user
	 */
	public void registUser(User user);

	/**
	 * ɾ���û�
	 * 
	 * @param user
	 */
	public boolean deleteUser(Integer id);

	/**
	 * ��¼
	 * 
	 * @param user
	 * @return �������null��˵����¼ʧ�ܣ�������ֵ���ǵ�¼�ɹ�
	 */
	public User login(User user);

	/**
	 * ����û����Ƿ����
	 * 
	 * @param username
	 * @return ����true��ʾ�û����Ѵ��ڣ�����false��ʾ�û�������
	 */
	public boolean existsUsername(Integer userID);

	/**
	 * �鿴�����û�
	 * 
	 * @return
	 */
	public List<User> findUser();

	/**
	 * �޸��û���Ϣ
	 * 
	 * @return
	 */
	public boolean modifyUser(User user);

}
