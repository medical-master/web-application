package com.medicalmaster.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.helper.CloseableHelper;
import com.medicalmaster.common.helper.MD5Helper;
import com.medicalmaster.common.helper.ResourceTypeHelper;
import com.medicalmaster.dal.SysResource;

/**
 * 文件上传帮助类
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月10日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class FileUploadHelper {

	// 日志记录器
	protected static Logger logger = LoggerFactory.getLogger(FileUploadHelper.class);
	// 缓存大小 10M 大于10M则使用缓存
	protected static int TEMPSIZE = 1024 * 1024;
	// 保存文件名类型
	protected String saveFileNameType = "";

	/**
	 * 生成文件保存目录
	 * 
	 * @param fileType
	 *            文件类型
	 * @return
	 * @throws IOException
	 */
	String getSaveDir(String fileType) throws IOException {
		// 处理参数数据
		if (fileType == null || fileType.length() == 0) {
			fileType = ResourceConstants.RESOURCE_TYPE_DEFAULT;
		}

		// 拼接路径
		final StringBuffer savePath = new StringBuffer(ResourceConstants.SAVE_BASE_PATH);
		savePath.append(fileType);
		savePath.append(File.separator);

		File file = new File(savePath.toString());
		if (!file.exists()) {
			FileUtils.forceMkdir(new File(savePath.toString()));
		}

		return savePath.toString();
	}

	String getTempDir() throws IOException {
		String path = ResourceConstants.SAVE_BASE_PATH + File.separator + "tmp";

		File file = new File(path);
		if (!file.exists()) {
			FileUtils.forceMkdir(file);
		}

		return path;
	}

	/**
	 * 保存数据
	 * 
	 * @param request请求对象
	 * @param savePath
	 *            保存路径
	 * @param tempPath临时缓存路径
	 * @return
	 */
	public List<SysResource> saveFiles(final HttpServletRequest request) throws Exception {
		List<SysResource> resources = new ArrayList<SysResource>();

		// 准备保存参数
		final DiskFileItemFactory factory = new DiskFileItemFactory();
		String tempPath = getTempDir();

		// 设置缓存路径
		factory.setRepository(new File(tempPath));
		// 设置缓存大小
		factory.setSizeThreshold(TEMPSIZE);
		final ServletFileUpload upload = new ServletFileUpload(factory);

		final List<FileItem> fileList = upload.parseRequest(request);
		for (final FileItem item : fileList) {
			if (item.isFormField()) {
				continue;
			}

			SysResource resource = new SysResource();

			String fileName = item.getName();
			fileName = Calendar.getInstance().getTimeInMillis() + "_" + fileName;
			resource.setResourceName(fileName);

			final String suffixName = getSuffixName(fileName);
			Integer resourceType = ResourceTypeHelper.getResourceType(suffixName);
			resource.setResourceType(resourceType);
			resource.setAllowDownload(1);

			String savePath = getSaveDir(resourceType.toString());
			String fileUrl = savePath + fileName;
			resource.setFileUrl(fileUrl);
			resource.setFileSize((int) item.getSize());

			File file = new File(fileUrl);
			writeFile(item, file);
			resource.setMd5(MD5Helper.getFileMD5(file));
		}
		return resources;
	}

	/**
	 * 将FileItem写入文件
	 * @param item
	 * @param file
	 * @throws IOException
	 */
	void writeFile(FileItem item, File file) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			in = item.getInputStream();

			int length = 0;
			final byte[] buf = new byte[1024];

			while ((length = in.read(buf)) != -1) {
				byte[] _buf = new byte[length];

				_buf = buf;

				out.write(_buf, 0, length);
			}

			// 文件存储完成后 删除临时文件
			item.delete();
		} finally {
			CloseableHelper.close(in);
			CloseableHelper.close(out);
		}

	}

	/**
	 * 文件扩展名
	 * 
	 * @param fileName
	 * @return
	 */
	String getSuffixName(final String fileName) {
		if (StringUtils.isBlank(fileName)) {
			return "";
		}
		String suffixName = "";
		final int suffixIndex = fileName.lastIndexOf(".");
		if (suffixIndex != -1 && (suffixIndex + 1) < fileName.length()) {
			suffixName = fileName.substring(suffixIndex + 1);
		}
		return suffixName;
	}
}
