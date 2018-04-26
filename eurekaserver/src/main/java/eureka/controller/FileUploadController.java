package eureka.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class FileUploadController {

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public void fileUpload(HttpServletRequest req, @RequestBody MultipartFile multipartFile) throws IOException, ServletException {
		req.getParts();
		MultipartHttpServletRequest m = (MultipartHttpServletRequest) req;
		m.getFileNames();
		System.out.println();
	}
}
