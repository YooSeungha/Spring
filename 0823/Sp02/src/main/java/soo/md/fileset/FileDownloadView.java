package soo.md.fileset;

import java.io.*;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;
import lombok.extern.log4j.Log4j;

@Log4j
public class FileDownloadView extends AbstractView {
	public FileDownloadView() {
		setContentType("application/download;charset=utf-8");
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//downloadFile�� �޾Ƽ�  client���� fis���� ���� �� 
		
		File file = (File)model.get("downloadFile");
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		String value = "attachment; filename="+java.net.URLEncoder.encode(file.getName(), "utf-8") + ";";
		response.setHeader("Content-Disposition", value);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		FileInputStream fis = null;//�ٿ���(������ ���� ��Ʈ��)
		OutputStream os = response.getOutputStream();//������(Ŭ���̾�Ʈ�� ���� ��Ʈ��)
//		byte bs[] = new byte[512];
//        int count = 0; 
        try {
	        fis = new FileInputStream(file);
	        FileCopyUtils.copy(fis, os);
//			while((count = fis.read(bs)) != -1) {
//				os.write(bs, 0, count);
//			}
			os.flush();
        }catch(IOException ie) {
        	log.info("#FileDownloadView ie : " + ie);
        }finally {
        	if(fis != null) fis.close();
        	if(os != null) os.close();
        }
	}

}