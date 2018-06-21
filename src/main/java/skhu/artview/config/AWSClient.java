package skhu.artview.config;

public class AWSClient {

	final private String accessKey = "AKIAJLHWKRXEFZOZZDBQ";
	final private String secretKey = "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";
	final private String bucket = "artview";
	final private String region = "ap-northeast-2";

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