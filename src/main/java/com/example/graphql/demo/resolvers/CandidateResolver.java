package com.example.graphql.demo.resolvers;

import com.example.graphql.demo.service.CandidateService;
import com.example.graphql.demo.models.Candidate;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public class CandidateResolver {

  private final CandidateService candidateService;

  public CandidateResolver(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  @GraphQLQuery(name = "candidates")
  public CompletableFuture<List<Candidate>> getCandidates() {
    return CompletableFuture.supplyAsync(candidateService::getCandidates);
  }
}
