package de.br.aff.matching.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "customer", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
@Getter //necessary to get the values
@NoArgsConstructor //necessary to deserialize
public class Match {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Match(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return String.format("Match[id=%s, firstName='%s', lastName='%s']", this.id,
                this.firstName, this.lastName);
    }

}