package com.example.graphql.demo.service;

import com.example.graphql.demo.models.Candidate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

  public List<Candidate> getCandidates() {
    return List.of(
      new Candidate(1, "Леонид", "Якубович", "leonid@yakubovich.ru", "88005553535"),
      new Candidate(2, "Леонид", "Агутин", "hophey@lalaley.com", "88005553030")
    );
  }
}
