package com.kurui.kums.agent.biz;

import java.util.List;

import com.kurui.kums.agent.ShareHolder;
import com.kurui.kums.agent.ShareHolderListForm;
import com.kurui.kums.base.exception.AppException;

public interface ShareHolderBiz {
	public List list(ShareHolderListForm shareHolderListForm)
			throws AppException;

	public void delete(long id) throws AppException;

	public long save(ShareHolder shareHolder) throws AppException;

	public long update(ShareHolder shareHolder) throws AppException;

	public ShareHolder getShareHolderById(long id) throws AppException;

	public ShareHolder getShareHolderByAgentId(long agentId)
			throws AppException;

	public ShareHolder getShareHolderByCompanyId(long accountId)
			throws AppException;

	public List<ShareHolder> getShareHolderList() throws AppException;

	public List<ShareHolder> getShareHolderList(Long type) throws AppException;

	public List<ShareHolder> getValidShareHolderList() throws AppException;
}
