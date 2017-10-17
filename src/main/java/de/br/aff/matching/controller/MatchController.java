package de.br.aff.matching.controller;

import de.br.aff.matching.domain.Match;
import de.br.aff.matching.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository repository;

    @GetMapping("/matches")
    public List<Match> getMatches() {

        List<Match> matches = new ArrayList<>();

        repository.findAll().forEach(matches::add);

        return matches;
    }


    //get request example http://localhost:8080/match?name=John
    @GetMapping("/match")
    public List<Match> getMatch(@RequestParam String name) {

        List<Match> matches = new ArrayList<>();

        repository.findByFirstName(name).forEach(matches::add);

        return matches;
    }

}
