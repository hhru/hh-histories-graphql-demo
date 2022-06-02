package com.example.graphql.demo.resolvers;

import com.example.graphql.demo.models.Candidate;
import com.example.graphql.demo.models.Resume;
import com.example.graphql.demo.service.ResumeService;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public class ResumeResolver {

  private final ResumeService resumeService;

  public ResumeResolver(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  @GraphQLQuery(name = "resumes")
  public CompletableFuture<List<Resume>> getResumes(@GraphQLContext Candidate candidate) {
    return CompletableFuture.supplyAsync(() -> resumeService.getResumes(candidate));
  }
}
