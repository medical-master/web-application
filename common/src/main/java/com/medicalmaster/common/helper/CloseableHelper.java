package com.medicalmaster.common.helper;

import java.io.Closeable;

/**
 * 可关闭对象
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class CloseableHelper {
	/***
	 * 资源关闭
	 * 
	 * @param closeable
	 */
	public static void close(Closeable closeable) {
		try {
			if(closeable != null){
				closeable.close();
				closeable  = null;
			}
		} catch (Exception exception) {

		}

	}
}
