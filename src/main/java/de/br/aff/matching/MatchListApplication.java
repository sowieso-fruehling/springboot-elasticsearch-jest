package de.br.aff.matching;

import de.br.aff.matching.domain.Match;
import de.br.aff.matching.repository.MatchRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {ElasticsearchAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class})
public class MatchListApplication {

//	either we use this or initializeElasticsearch method has MatchRepository repository argument
//	@Autowired
//	private MatchRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MatchListApplication.class, args);
	}

	@Bean
	InitializingBean initializeElasticsearch(MatchRepository repository)
	{
		return()->
		{
			repository.save(new Match("John", "Doe"));
			repository.save(new Match("Jane", "Smith"));
		};
	}

}