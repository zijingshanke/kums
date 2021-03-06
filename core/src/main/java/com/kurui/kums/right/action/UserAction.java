package com.kurui.kums.right.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kurui.kums.base.BaseAction;
import com.kurui.kums.base.Inform;
import com.kurui.kums.base.encrypt.MD5;
import com.kurui.kums.base.exception.AppException;
import com.kurui.kums.right.SysUser;
import com.kurui.kums.right.UserRightInfo;
import com.kurui.kums.right.biz.RightBiz;
import com.kurui.kums.right.biz.UserBiz;
import com.kurui.kums.system.LoginLog;
import com.kurui.kums.system.biz.LoginLogBiz;

public class UserAction extends BaseAction {
	private UserBiz userBiz;
	private LoginLogBiz loginlogBiz;
	private RightBiz rightBiz;

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// String forwardPage = "";
		SysUser user = (SysUser) form;
		Inform inf = new Inform();
		try {
			SysUser tempUser = userBiz.getUserByName(user.getUserName());
			if (tempUser != null && tempUser.getUserId() != user.getUserId()) {
				inf.setMessage("已经存在该用户，请重新填写名字或者帐号！");
				return forwardInformPage(inf, mapping, request);
			}

			tempUser = userBiz.getUserByNo(user.getUserNo());
			if (tempUser != null && tempUser.getUserId() != user.getUserId()) {
				inf.setMessage("已经存在该用户，请重新填写名字或者帐号！");
				return forwardInformPage(inf, mapping, request);
			}

			tempUser = (SysUser) userBiz.getUserById(user.getUserId());
			tempUser.setUserName(user.getUserName());
			tempUser.setUserNo(user.getUserNo());
			tempUser.setUserDepart(user.getUserDepart());
			// tempUser.setUserType(user.getUserType());
			// tempUser.setSerialNumber(user.getSerialNumber());
			tempUser.setUserEmail(user.getUserEmail());
			tempUser.setUserStatus(user.getUserStatus());
			userBiz.updateUserInfo(tempUser);
			request.setAttribute("user", tempUser);

			inf.setMessage("您已经成功更新了用户资料！");
			inf.setForwardPage("/user/userlist.do");
			inf.setParamId("thisAction");
			inf.setParamValue("list");


			return forwardInformPageNoBack(inf, mapping, request);
		} catch (Exception ex) {
			inf.setMessage("更新用户资料出错！错误信息是：" + ex.getMessage());
		}
		return forwardInformPage(inf, mapping, request);
	}

	public ActionForward editPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		String forwardPage = "";
		SysUser u = (SysUser) form;
		SysUser user = (SysUser) userBiz.getUserById(u.getUserId());
		user.setThisAction("updatePassword");
		request.setAttribute("user", user);
		forwardPage = "edituserpassword";

		return (mapping.findForward(forwardPage));
	}

	public ActionForward editMyPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		String forwardPage = "";
		SysUser u = (SysUser) form;
		SysUser user = userBiz.getUserById(u.getUserId());
		user.setThisAction("updatePassword");
		request.setAttribute("user", user);
		forwardPage = "editMyPassword";

		return (mapping.findForward(forwardPage));
	}

	public ActionForward updatePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// String forwardPage = "";
		SysUser user = (SysUser) form;
		Inform inf = new Inform();
		try {
			SysUser tempUser = userBiz.getUserById(user.getUserId());
			tempUser.setUserPassword(MD5.encrypt(user.getUserPassword1()));
			userBiz.updateUserInfo(tempUser);
			request.setAttribute("user", tempUser);

			inf.setMessage("您已经成功修改了用户的密码！");
			inf.setForwardPage("/user/userlist.do?thisAction=list");
			inf.setParamValue("list");
			return forwardInformPageNoBack(inf, mapping, request);
		} catch (Exception ex) {
			inf.setMessage("更新用户资料出错！错误信息是：" + ex.getMessage());
		}
		return forwardInformPage(inf, mapping, request);
	}

	public ActionForward updateMyPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		// String forwardPage = "";
		SysUser user = (SysUser) form;
		Inform inf = new Inform();
		SysUser use = getUserByURI(request);
		if (use != null) {
			if (!MD5.encrypt(user.getUserPassword()).equals(
					use.getUserPassword())) {
				inf.setMessage("原密码输入错误！");
			} else {
				try {
					SysUser tempUser = (SysUser) userBiz.getUserById(use
							.getUserId());
					tempUser.setUserNo(user.getUserNo());
					tempUser.setUserPassword(MD5.encrypt(user
							.getUserPassword1()));
					userBiz.updateUserInfo(tempUser);
					request.setAttribute("user", tempUser);

					inf.setMessage("您已经成功修改了用户的密码！返回登陆！");
					inf.setForwardPage("/user/user.do?thisAction=exit");
					inf.setParamValue("list");
					return forwardInformPageNoBack(inf, mapping, request);
				} catch (Exception ex) {
					inf.setMessage("更新用户资料出错！错误信息是：" + ex.getMessage());
				}
			}
		} else {
			request.getSession().invalidate();
			return mapping.findForward("exit");
		}
		return forwardInformPage(inf, mapping, request);
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// String forwardPage = "";
		SysUser user = (SysUser) form;
		Inform inf = new Inform();
		try {
			SysUser tempUser = userBiz.getUserByName(user.getUserName());
			if (tempUser != null) {
				inf.setMessage("已经存在该用户，请重新填写名字或者帐号！");
				return forwardInformPage(inf, mapping, request);
			}

			tempUser = userBiz.getUserByNo(user.getUserNo());
			if (tempUser != null) {
				inf.setMessage("已经存在该用户，请重新填写名字或者帐号！");
				return forwardInformPage(inf, mapping, request);
			}
			tempUser = new SysUser();
			tempUser.setUserName(user.getUserName());
			tempUser.setUserNo(user.getUserNo());
			tempUser.setUserStatus(user.getUserStatus());
			// tempUser.setSerialNumber(user.getSerialNumber());
			tempUser.setUserEmail(user.getUserEmail());
			tempUser.setUserDepart(user.getUserDepart());
			tempUser.setUserType(new Long(1));
			userBiz.saveUser(tempUser);

			request.setAttribute("user", tempUser);
			inf.setMessage("成功增加了用户！现在为该用户设置密码！");
			inf.setForwardPage("/user/user.do?thisAction=editPassword&userId="
					+ tempUser.getUserId());

			return forwardInformPageNoBack(inf, mapping, request);
		} catch (Exception ex) {
			inf.setMessage("增加用户出错！错误信息是：" + ex.getMessage());
		}
		return forwardInformPage(inf, mapping, request);
	}

	// 登录!
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		SysUser user = (SysUser) form;
		if (request.getSession().getAttribute("rand") != null
				&& user.getRand().toString().equals(
						request.getSession().getAttribute("rand").toString()))

		{
			SysUser tempUser = userBiz.login(user.getUserNo(), user
					.getUserPassword());

			if (tempUser != null && tempUser.getUserId() > 0) {

				if (tempUser.getUserStatus() == 2) {
					request.setAttribute("err", "statusError");
					System.out.print("statusError");
					return mapping.findForward("login");
				} else if (tempUser.getUserStatus() == 1) {
					LoginLog loginlog = new LoginLog();
					loginlog.setIp(request.getRemoteAddr());
					loginlog.setLocate(LoginLog.LOCATE_2);// 1:客户前台 2:管理后台
					loginlog.setStatus(LoginLog.STATUS_1);
					loginlog.setLoginTime(new Timestamp(System
							.currentTimeMillis()));
					loginlog.setLoginName(tempUser.getUserNo() + "-"
							+ tempUser.getUserName());
					loginlogBiz.saveLoginLog(loginlog);
					
					
					UserRightInfo uri = new UserRightInfo();

					uri.setUser(tempUser);
					rightBiz.setRights(uri, tempUser.getUserId());
					request.getSession().setAttribute("URI", uri);
					return mapping.findForward("index");
				}
				return null;
			} else {
				LoginLog loginlog = new LoginLog();
				loginlog.setIp(request.getRemoteAddr());
				loginlog.setLocate(LoginLog.LOCATE_2);
				loginlog.setStatus(LoginLog.STATUS_0);
				loginlog
						.setLoginTime(new Timestamp(System.currentTimeMillis()));
				loginlog.setLoginName(user.getUserName());
				loginlogBiz.saveLoginLog(loginlog);

				int i = userBiz.checkUser(user, user.getUserPassword());
				if (i == 1) {
					request.setAttribute("err", "nameError");
					return mapping.findForward("login");
				} else if (i == 2) {
					request.setAttribute("err", "passError");
					return mapping.findForward("login");
				}
				return null;
			}
		} else {
			request.setAttribute("err", "randError");
			return mapping.findForward("login");
		}
	}

	public ActionForward exit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		request.removeAttribute("URI");
		request.getSession().invalidate();
		return mapping.findForward("exit");
	}

	public SysUser getUserByURI(HttpServletRequest request) {
		UserRightInfo uri = (UserRightInfo) request.getSession().getAttribute(
				"URI");
		if (uri != null && uri.getUser() != null)
			return uri.getUser();
		else {
			return null;
		}
	}
	

	public void setLoginlogBiz(LoginLogBiz loginlogBiz) {
		this.loginlogBiz = loginlogBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public void setRightBiz(RightBiz rightBiz) {
		this.rightBiz = rightBiz;
	}


}