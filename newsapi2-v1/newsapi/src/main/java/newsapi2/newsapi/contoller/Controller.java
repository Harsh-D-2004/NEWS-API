package newsapi2.newsapi.contoller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import newsapi2.newsapi.entities.Articles;
import newsapi2.newsapi.entities.NewsResponse;

@RestController
@JsonIgnoreProperties(ignoreUnknown=true)
public class Controller {

	@GetMapping("/topnews")
	public List<Articles> getnews()
	{
		try {
			String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=464eaef5688147f0a7893b022e158730";
			RestTemplate template = new RestTemplate();
			Object[] objects = new Object[]{template.getForObject(url , Object.class)};
			
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			List<Articles> news = Arrays.stream(objects).map(o->objectMapper.convertValue(o, NewsResponse.class))
					.map(NewsResponse::getArticles)
					.collect(Collectors.toList()).get(0);
			
			return news;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
