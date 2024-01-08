package com.project.service.business;
import com.project.entity.concretes.business.EducationTerm;
import com.project.entity.concretes.business.Lesson;
import com.project.entity.concretes.user.User;
import com.project.entity.enums.RoleType;
import com.project.exception.ConflictException;
import com.project.payload.messages.ErrorMessages;
import com.project.payload.request.business.StudentInfoRequest;
import com.project.payload.response.ResponseMessage;
import com.project.payload.response.business.StudentInfoResponse;
import com.project.repository.business.StudentInfoRepository;
import com.project.service.UserService;
import com.project.service.helper.MethodHelper;
import com.project.service.user.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final StudentInfoRepository studentInfoRepository;
    private final MethodHelper methodHelper;
    private final UserService userService;
    private final LessonService lessonService;
    private final EducationTermService educationTermService;

    public ResponseMessage<StudentInfoResponse> saveStudentInfo(HttpServletRequest httpServletRequest, StudentInfoRequest studentInfoRequest) {
        String teacherUsername = (String) httpServletRequest.getAttribute("username");
        User student = methodHelper.isUserExist(studentInfoRequest.getStudentId());
        methodHelper.checkRole(student, RoleType.STUDENT);

        User teacher = methodHelper.isUserExistByUsername(teacherUsername);
        Lesson lesson = lessonService.isLessonExistById(studentInfoRequest.getLessonId());
       EducationTerm uducationTerm=educationTermService.findEducationTermById
               (studentInfoRequest.getEducationTermId());
       // TODO branş kontrolü
        // aynı ders için dublicate kontrolü
        checkSameLesson(studentInfoRequest.getStudentId(),lesson.getLessonName());




    }
    private void checkSameLesson(Long studentId, String lessonName){
       boolean isLessonDublicationexist=studentInfoRepository.getAllByStudentId_Id(studentId)
                .stream()
                .anyMatch(e->e.getLesson().getLessonName().equalsIgnoreCase(lessonName));
       if (isLessonDublicationexist){
           throw new ConflictException(String.format(ErrorMessages.LESSON_PROGRAM_ALREADY_EXIST,lessonName));
       }
    }

}