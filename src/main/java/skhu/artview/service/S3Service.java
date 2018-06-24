package skhu.artview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.FileDTO;
import skhu.artview.mapper.FileMapper;

@Service
public class S3Service {

	@Autowired FileMapper fileMapper;

	S3Uploader s3Uploader = new S3Uploader();

	public int fileUpload(MultipartFile file) {
		FileDTO uploadFile = new FileDTO();
		String result = s3Uploader.upload(file);
		if(result.equals("fail"))
			return 000;
		else {
			uploadFile.setName(result);
			fileMapper.insert(uploadFile);
			int fileId = fileMapper.getId(result);
			return fileId;
		}
	}

	public String getFileUrl(int id) {
		FileDTO file = fileMapper.findOne(id);
		String name = file.getName();
		return "https://s3.ap-northeast-2.amazonaws.com/artview/" + name;
	}
}