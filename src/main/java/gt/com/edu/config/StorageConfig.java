package gt.com.edu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class StorageConfig {
	
	
	
	//key de accesso de bucket S3 AWS
			@Value("${cloud.aws.credentials.access-key}")
			private String accessKey;
			//key secreta bucket S2 AWS
			@Value("${cloud.aws.credentials.secret-key}")
			private String accessSecret;
			// Region de bucket S3 AWS
			@Value("${cloud.aws.region.static}")
			private String region;
			
			@Bean
			public  AmazonS3 s3client() {
				
				AWSCredentials credentials=new  BasicAWSCredentials(accessKey, accessSecret);
				return AmazonS3ClientBuilder.standard()
						.withCredentials(new AWSStaticCredentialsProvider(credentials))
						.withRegion(region).build();
				

			}
			
		

}
