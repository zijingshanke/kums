package com.kurui.kums.right.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.kurui.kums.base.database.hibernate.BaseDAOSupport;
import com.kurui.kums.base.database.hibernate.Hql;
import com.kurui.kums.base.encrypt.MD5;
import com.kurui.kums.base.exception.AppException;
import com.kurui.kums.right.SysUser;
import com.kurui.kums.right.UserListForm;

public class UserDAOImp extends BaseDAOSupport implements UserDAO {
	private TransactionTemplate transactionTemplate;

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionTemplate = new TransactionTemplate(transactionManager);
	}

	public long save(SysUser user) throws AppException {
		this.getHibernateTemplate().saveOrUpdate(user);
		return user.getUserId();
	}
	

	public long merge(SysUser user) throws AppException {
		this.getHibernateTemplate().merge(user);
		return user.getUserId();
	}

	public long update(SysUser user) throws AppException {
		if (user.getUserId() > 0)
			return save(user);
		else
			throw new IllegalArgumentException("id isn't a valid argument.");
	}

	public void deleteById(long id) throws AppException {
		if (id > 0) {
			SysUser user = (SysUser) this.getHibernateTemplate().get(
					SysUser.class, new Long(id));
			this.getHibernateTemplate().delete(user);

		}
	}

	public SysUser getUserById(long id) {
		SysUser user;
		try {
			if (id > 0) {

				user = (SysUser) this.getHibernateTemplate().get(SysUser.class,
						new Long(id));
				return user;
			} else
				return new SysUser();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new SysUser();
	}

	public SysUser login(String userNo, String userPassword)
			throws AppException {
		Hql hql = new Hql("from SysUser where (userNo=? or userName=?) and userPassword=? and userStatus=1");
		hql.addParamter(userNo);
		hql.addParamter(userNo);
		hql.addParamter(MD5.encrypt(userPassword));
		Query query = this.getQuery(hql);
		try {
			if (query != null) {
				List list = query.list();
				if (list != null && list.size() > 0) {
					SysUser user = (SysUser) list.get(0);
					if ((user.getUserNo().equals(userNo)||user.getUserName().equals(userNo))
							&& user.getUserPassword().equals(
									MD5.encrypt(userPassword))) {
						return user;
					} else {
						return null;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public SysUser queryById(long id) throws AppException {
		Hql hql = new Hql("from SysUser where userId=" + id);

		Query query = this.getQuery(hql);
		try {
			if (query != null && query.list() != null
					&& query.list().size() > 0) {
				return (SysUser) query.list().get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List list() throws AppException {
		String hql = "from SysUser where 1=1";
		return this.list(hql);
	}

	public List list(UserListForm ulf) throws AppException {
		Hql hql = new Hql();
		hql.add("from SysUser where 1=1");
		if ((ulf.getUserName().toString().trim() != "")
				&& (ulf.getUserName() != null)) {
			hql.add(" and userName like ? ");
			hql.addParamter("%" + ulf.getUserName().trim() + "%");
		}
		if (!ulf.getUserNo().toString().trim().equals("")
				&& ulf.getUserNo() != null) {
			hql.add(" and userNo like ? ");
			hql.addParamter("%" + ulf.getUserNo() + "%");
		}

		if (ulf.getUserDepart() > 0) {
			hql.add(" and userDepart=? ");
			hql.addParamter(ulf.getUserDepart());
		}
		
		if (ulf.getUserStatus() > 0) {
			hql.add(" and userStatus=? ");
			hql.addParamter(ulf.getUserStatus());
		}
		if (ulf.getUserEmail() != null && !"".equals(ulf.getUserEmail())) {
			hql.add(" and userEmail like ?");
			hql.addParamter("%" + ulf.getUserEmail() + "%");
		}

		return this.list(hql, ulf);
	}
	
	public SysUser getUserByNo(String userNo) throws AppException {
		String hql = "from SysUser where userNo='" + userNo + "'";
		Query query = this.getQuery(hql);
		if(query!=null){
			List list=query.list();
			if(list!=null){
				if(list.size()>0){
					return (SysUser)list.get(0);
				}
			}
		}
		return null;
	}


	public SysUser getUserByNo(SysUser user) throws AppException {
		String hql = "from SysUser where userNo='" + user.getUserNo() + "'";
		Query query = this.getQuery(hql);
		if (query != null && query.list() != null && query.list().size() > 0) {
			return (SysUser) query.list().get(0);
		}
		return null;
	}

	public SysUser getUserByName(String userName) throws AppException {
		String hql = "from SysUser where userName='" + userName + "'";
		Query query = this.getQuery(hql);
		if (query != null && query.list() != null && query.list().size() > 0) {
			return (SysUser) query.list().get(0);
		}
		return null;
	}

}
