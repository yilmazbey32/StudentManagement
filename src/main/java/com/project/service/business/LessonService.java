package com.project.service.business;

import com.project.repository.business.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LesssonService {
    private final LessonRepository lessonRepository;
}
