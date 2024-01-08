package com.project.payload.messages;

public class ErrorMessages {




    private ErrorMessages() {
    }

    public static final String NOT_PERMITTED_METHOD_MESSAGE = "You do not have any permission to do this operation ";

    public static final String PASSWORD_NOT_MATCHED = "Your passwords are not matched";

    public static final String ALREADY_REGİSTER_MESSAGE_USERNAME= "Error:USer with username %sis already registared" ;
    public static final String ALREADY_REGİSTER_MESSAGE_SSN= "Error:USer with ssn %sis already registared" ;
    public static final String ALREADY_REGİSTER_MESSAGE_PHONE= "Error:USer with phone number %sis already registared" ;
    public static final String ALREADY_REGİSTER_MESSAGE_EMAIL= "Error:USer with email %sis already registared" ;
    public static final String ROLE_NOT_FOUND ="There is no role like that check database";
    public static final String NOT_FOUND_USER_USERROLE_MESSAGE ="There is no role like that check database";
    public static final String NOT_FOUND_USER_MESSAGE ="Error: User not found with id : %s";
    public static final String NOT_FOUND_USER_WITH_ROLE_MESSAGE = "Error: The role information of the user with id %s is not role: %s";
    public static final String NOT_FOUND_USER_MESSAGE_WITH_USERNAME ="Error: User not found with username";
    public static final String NOT_FOUND_ADVISOR_MESSAGE ="Error: Advisor Teacher with id %s not found";
    public static final String ALREADY_EXIST_ADVISOR_MESSAGE = "Error: Advisor Teacher with id %s is already exist";
    public static final String EDUCATION_START_DATE_IS_EARLIER_THAN_LAST_REGISTRATION_DATE ="" ;
    public static final String EDUCATION_END_DATE_IS_EARLIER_THAN_START_DATE ="" ;
    public static final String EDUCATION_TERM_IS_ALREADY_EXIST_BY_TERM_AND_YEAR_MESSAGE ="" ;
    public static final String EDUCATION_TERM_CONFLICT_MESSAGE = "Error: There is a conflict regarding the dates of the education terms";
    public static final String EDUCATION_TERM_NOT_FOUND_MESSAGE = "Error: Education Term not found with id : %s";
    public static final String ALREADY_EXIST_LESSON_WITH_LESSON_NAME_MESSAGE = "Error: Lesson with lesson name : %s is already exist";
    public static final String NOT_FOUND_LESSON_WITH_ID_MESSAGE ="Error: Lesson with id: %s not found";
    public static final String NOT_FOUND_LESSON_WITH_LESSON_NAME = "Error : Lesson with lesson name : %s not found";
    public static final String NOT_FOUND_LESSON_IN_LIST = "Error: Lesson not found in the list";
    public static final String TIME_NOT_VALID_MESSAGE = "Error: incorrect time";
    public static final String NOT_FOUND_LESSON_PROGRAM_MESSAGE = "Error: Lesson Program not found with id : %s";
    public static final String NOT_FOUND_LESSON_PROGRAM_MESSAGE_WITHOUT_ID_LIST = "Error: Lesson program with this field not found ";
    public static final String LESSON_PROGRAM_ALREADY_EXIST = "Error: Course schedule can not be selected for the same hour and date";
}