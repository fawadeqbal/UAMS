package model.validators;

import java.util.Date;
import model.dto.CourseDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;
import model.dto.UserDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonValidator {

    public static void validateUser(UserDTO objUser, Response objResponse) {
        isValidEmail(objUser.getEmail(), objResponse);
        isValidPassword(objUser.getPassword(), objResponse);
    }

    public static void validateStudent(StudentDTO student, Response responseObj) {
        validateRegNo(student.getRegNo(), responseObj);
        validateName(student.getName(), responseObj);
        validateFatherName(student.getFatherName(), responseObj);
        validateDOB(student.getDob(), responseObj);
        validateCNIC(student.getCnic(), responseObj);
        validatePhoneNumber(student.getPhoneNumber(), responseObj);
        isValidEmail(student.getUserEmail(), responseObj);
    }

    public static void validateTeacher(TeacherDTO teacher, Response response) {
        validateTeacherID(teacher.getId(), response);
        validateName(teacher.getName(), response);
        validatePhoneNumber(teacher.getPhoneNumber(), response);
        isValidEmail(teacher.getEmail(), response);

    }

    public static void validateCourse(CourseDTO objCOurse, Response objResponse) {
        isValidCourseCode(objCOurse.getCourseCode(), objResponse);
        isValidCourseName(objCOurse.getCourseName(), objResponse);
    }

    private static void isValidCourseName(String courseName, Response objResponse) {
        if (courseName == null || courseName.length() == 0) {
            objResponse.messagesList.add(new Message("Course Name is not valid, Provide valid Course Name.", MessageType.Error));
        }
    }

    private static void isValidCourseCode(String courseCode, Response objResponse) {
        if (courseCode == null || courseCode.length() == 0) {
            objResponse.messagesList.add(new Message("Course Code is not valid, Provide valid Course Code.", MessageType.Error));
        }
    }

    private static void isValidEmail(String email, Response objResponse) {
        if (email == null || email.length() < 3) {
            objResponse.messagesList.add(new Message("Email is not valid, Provide valid email with at least 3 characters.", MessageType.Error));
            return;
        }

        // Regular expression pattern for a valid email format
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            objResponse.messagesList.add(new Message("Email format is not valid, Provide a valid email address.", MessageType.Error));
        }
    }

    private static void isValidPassword(String password, Response objResponse) {
        if (password == null || password.length() < 3) {
            objResponse.messagesList.add(new Message("Password is not valid, Provide valid password with at least 3 characters.", MessageType.Error));
        }

    }

    private static void validateRegNo(String regNo, Response responseObj) {
        if (regNo == null || regNo.length() < 12) {
            responseObj.messagesList.add(new Message("Reg No# is not valid, Provide valid Reg No# with at least 12 characters.", MessageType.Error));
        }
    }

    private static void validateName(String name, Response responseObj) {
        if (name == null || name.length() < 3) {
            responseObj.messagesList.add(new Message("Name is not valid, Provide valid Name with at least 3 characters.", MessageType.Error));
        }
    }

    private static void validateFatherName(String fatherName, Response responseObj) {
        if (fatherName == null || fatherName.length() < 3) {
            responseObj.messagesList.add(new Message("Father's name cannot be less than 3 characters..", MessageType.Error));
        }
    }

    private static void validateDOB(Date dob, Response responseObj) {
        Date currentDate = new Date(); // Get the current date

        if (dob.after(currentDate)) {
            responseObj.messagesList.add(new Message("Invalid date of birth. Date cannot be in the future.", MessageType.Error));
        }
    }

    private static void validateCNIC(String cnic, Response responseObj) {
        if (cnic == null || cnic.length() < 13) {
            responseObj.messagesList.add(new Message("CNIC length cannot be less than 13.", MessageType.Error));
        }
    }

    private static void validatePhoneNumber(String phoneNumber, Response responseObj) {
        if (phoneNumber == null || phoneNumber.length() < 6) {
            responseObj.messagesList.add(new Message("Phone number length cannot be less than 6.", MessageType.Error));
        }
    }


    private static void validateTeacherID(int id, Response response) {
        if (id == 0) {
            response.messagesList.add(new Message("Faculty ID cannot be 0.", MessageType.Error));
        } else if (id < 5000) {
            response.messagesList.add(new Message("Faculty ID cannot be less than 5000.", MessageType.Error));

        }
    }

}
