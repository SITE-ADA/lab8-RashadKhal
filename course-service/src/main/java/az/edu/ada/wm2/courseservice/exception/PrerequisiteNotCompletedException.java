package az.edu.ada.wm2.courseservice.exception;

public class PrerequisiteNotCompletedException extends RuntimeException {

    public PrerequisiteNotCompletedException(Long prerequisiteId) {
        super("Student must complete prerequisite course with id: "
                + prerequisiteId);
    }
}