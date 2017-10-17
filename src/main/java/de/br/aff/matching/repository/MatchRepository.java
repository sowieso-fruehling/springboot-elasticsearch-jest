package de.br.aff.matching.repository;

import de.br.aff.matching.domain.Match;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MatchRepository extends ElasticsearchRepository<Match, String> {

    List<Match> findByFirstName(String firstName);

}