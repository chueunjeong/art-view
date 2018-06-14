package skhu.artview.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import skhu.artview.config.AWSClient;

@Service
public class S3Uploader {

	AWSClient awsClient = new AWSClient(); //클라이언트 정보를 가져오기 위한 객체

	//현재 시간 + 원본 파일명으로 파일명 지정
	public String upload(MultipartFile file) {
		try {
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			upload(file.getInputStream(), fileName);
			return fileName;
		} catch (IOException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	//AmazonS3 객체에 파일과 버킷명을 입력하여 파일 업로드
	private void upload(InputStream inputStream, String fileName) {
		PutObjectRequest putObjectRequest = new PutObjectRequest(awsClient.getBucket(), fileName, inputStream, new ObjectMetadata());
		putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		AmazonS3 amazonS3 = this.s3Client();
		amazonS3.putObject(putObjectRequest);
		IOUtils.closeQuietly(inputStream);
	}

	//파일 업로드를 위해 accessKey와 secretKey로 AmazonS3 객체 생성
	public AmazonS3 s3Client(){
		System.out.println("s3Client");
		AWSCredentials creds = new BasicAWSCredentials(awsClient.getAccessKey(), awsClient.getSecretKey());
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(creds))
				.withRegion(awsClient.getRegion())
				.build();
	}

	//MultipartFile to File
    public File convert(MultipartFile multipart) throws IllegalStateException, IOException {
    	File convFile = new File( multipart.getOriginalFilename());
    	multipart.transferTo(convFile);
    	return convFile;
    }

    //url리턴 예제 소스
/*  public String upload(MultipartFile multipartFile, String dirName) throws IOException {
		System.out.println(bucket);
    	File uploadFile = convert(multipartFile);

    	return upload(uploadFile, dirName);
	}

	private String upload(File uploadFile, String dirName) {
    	String fileName = dirName + "/" + uploadFile.getName();
    	String uploadImageUrl = putS3(uploadFile, fileName);
    	return uploadImageUrl; //최종적으로 뷰에 url이 리턴됨
	}

*/

/*  private String putS3(File uploadFile, String fileName) {amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
    	return amazonS3Client.getUrl(bucket, fileName).toString();
	} */

}