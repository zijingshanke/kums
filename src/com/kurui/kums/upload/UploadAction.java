package com.kurui.kums.upload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.kurui.kums.base.BaseAction;
import com.kurui.kums.base.Constant;
import com.kurui.kums.base.Inform;
import com.kurui.kums.base.file.FileUtil;

public class UploadAction extends BaseAction {
	public void doFinish(UploadForm theForm, HttpServletRequest request) {
		try {
			ArrayList listAttach;
			listAttach = (ArrayList) (request.getSession().getAttribute(theForm
					.getListAttachName()));

			if (listAttach == null)
				listAttach = new ArrayList();
			// System.out.println("length=" + listAttach.size());

			request.getSession().setAttribute(theForm.getListAttachName(),
					listAttach);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList listAttach;
			String forwardPage = "editattachpage";
			UploadForm theForm = (UploadForm) form;
			listAttach = (ArrayList) (request.getSession().getAttribute(theForm
					.getListAttachName()));

			if (listAttach == null || listAttach.size() < 1)
				return mapping.findForward(forwardPage);

			// System.out.println("length before=" + listAttach.size());

			Attachment a;
			for (int i = 0; i < listAttach.size(); i++) {

				if ((a = (Attachment) listAttach.get(i)).vname.equals(theForm
						.getFileKey())) {
					File file = new File(Constant.PROJECT_UPLOAD_PATH
							+ theForm.getPath() + File.separator + a.vname);
					if (file.isFile() && file.exists()) {
						file.delete();
						listAttach.remove(i);
					}
				}
			}

			// System.out.println("length after=" + listAttach.size());
			request.getSession().setAttribute(theForm.getListAttachName(),
					listAttach);
			theForm.setListAttach(listAttach);
			request.setAttribute("uf", theForm);
			return mapping.findForward(forwardPage);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ArrayList listAttach;
		UploadForm theForm = (UploadForm) form;
		listAttach = (ArrayList) (request.getSession().getAttribute(theForm
				.getListAttachName()));
		if (listAttach == null) {
			listAttach = new ArrayList();
		}
		String forwardPage = this.saveFile(listAttach, theForm, request);
		return mapping.findForward(forwardPage);
	}

	private String saveFile(ArrayList listAttach, UploadForm theForm,
			HttpServletRequest request) {
		FormFile file = theForm.getUploadFile();

		boolean writeFile = true;
		String data = null;

		try {
			Attachment attachment = new Attachment();
			attachment.setName(new String(file.getFileName().getBytes(),
					"UTF-8"));
			attachment.setVname(FileUtil.getVFileName(file.getFileName()));
			attachment.setContentType(file.getContentType());
			attachment.setSize(new Integer(file.getFileSize()));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			if (!writeFile) {
				// only write files out that are less than 1MB
				if (file.getFileSize() < (4 * 1024000)) {
					InputStream stream = file.getInputStream();
					byte[] buffer = new byte[8192];
					int bytesRead = 0;
					while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
						baos.write(buffer, 0, bytesRead);
					}
					data = new String(baos.toByteArray());

					listAttach.add(attachment);

					request.getSession().setAttribute(
							theForm.getListAttachName(), listAttach);

				} else {
					data = new String(
							"The file is greater than 4MB, "
									+ " and has not been written to stream."
									+ " File Size: "
									+ file.getFileSize()
									+ " bytes. This is a"
									+ " limitation of this particular web application, hard-coded"
									+ " in org.apache.struts.webapp.upload.UploadAction");
					Inform inf = new Inform();
					inf.setMessage("上传的文件不能大于" + "4M");
					inf.setBack(true);
					request.setAttribute("inf", inf);
					return "inform";
				}
			} else {
				// write the file to the file specified
				InputStream stream = file.getInputStream();
				File info = new File(Constant.PROJECT_UPLOAD_PATH
						+ theForm.getPath());
				if (!info.exists()) {
					info.mkdirs();
				}
				OutputStream bos = new FileOutputStream(
						Constant.PROJECT_UPLOAD_PATH + theForm.getPath()
								+ File.separator + attachment.getVname());

				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				bos.close();
				listAttach.add(attachment); // 

				request.getSession().setAttribute(theForm.getListAttachName(),
						listAttach);

				stream.close();

			}

			// close the stream
			theForm.setThisAction("");
			theForm.setListAttach(listAttach);
			request.setAttribute("uf", theForm);
			return "editattachpage";
		} catch (Exception ex) {
			Inform inf = new Inform();
			inf.setMessage("上传异常:" + ex);
			inf.setBack(true);
			request.setAttribute("inf", inf);
			return "inform";
		}

	}

//	private void delete(File file) {
//		File[] files = file.listFiles();
//		for (int i = 0; i < files.length; i++) {
//			if (files[i].isFile()) {
//				files[i].delete();
//			} else if (files[i].isDirectory()) {
//				if (!files[i].delete()) {
//					delete(files[i]);
//				}
//			}
//		}
//		deleteDirectory(file);
//	}
//
//	private void deleteDirectory(File file) {
//		File[] filed = file.listFiles();
//		for (int i = 0; i < filed.length; i++) {
//			deleteDirectory(filed[i]);
//			filed[i].delete();
//		}
//	}

}
