package skhu.artview.config;

//AWS 접속을 위한 설정을 해주는 클래스, gitignore 등록 필요, 등록 후 실제 값을 채워넣어야 함
//gitIgnoreTest
public class AWSClient {

	final private String accessKey = "accessKey";
	final private String secretKey = "secretKey";
	final private String bucket = "bucket";
	final private String region = "region";

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getBucket() {
		return bucket;
	}

	public String getRegion() {
		return region;
	}

}