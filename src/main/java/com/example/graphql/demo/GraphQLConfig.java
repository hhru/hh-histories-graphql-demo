package com.example.graphql.demo;

import com.example.graphql.demo.resolvers.CandidateResolver;
import com.example.graphql.demo.resolvers.ResumeResolver;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

  private final CandidateResolver candidateResolver;
  private final ResumeResolver resumeResolver;

  public GraphQLConfig(CandidateResolver candidateResolver,
                       ResumeResolver resumeResolver) {
    this.candidateResolver = candidateResolver;
    this.resumeResolver = resumeResolver;
  }

  @Bean
  public GraphQLSchema getGraphQLSchema() {
    return new GraphQLSchemaGenerator()
      .withBasePackages("com.example.graphql.demo.models")
      .withOperationsFromSingletons(candidateResolver, resumeResolver)
      .generate();
  }

  @Bean
  public GraphQL getGraphQL(GraphQLSchema graphQLSchema) {
    return GraphQL.newGraphQL(graphQLSchema)
      .queryExecutionStrategy(new AsyncExecutionStrategy())
      .instrumentation(new CustomTracingInstrumentation())
      .build();
  }
}
