package com.example.graphql.demo.service;

import com.example.graphql.demo.models.Candidate;
import com.example.graphql.demo.models.Resume;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

  public List<Resume> getResumes(Candidate candidate) {
    if (candidate.getId() == 1) {
      return List.of(new Resume(501, "Ведущий шоу Поле чудес", "RUB", 40000));
    } else if (candidate.getId() == 2) {
      return List.of(new Resume(502, "Ведущий шоу Голос", "RUB", 50000));
    } else {
      return new ArrayList<>();
    }
  }
}
