import java.util.List;

public class VotingService {

    public void results(List<Student> studentList, Question question) {

        // variables use to keep track of students' input
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;

        // for each student in student list
        for (Student student : studentList) {
            // for i that's less than student input size
            for (int i = 0; i < student.getStudentAnswer().size(); i++) {
                // when student's answer is...
                switch (student.getStudentAnswer().get(i)) {
                    case 0:
                        a++;
                        break;
                    case 1:
                        b++;
                        break;
                    case 2:
                        c++;
                        break;
                    case 3:
                        d++;
                        break;
                    case 4:
                        e++;
                        break;
                    case 5:
                        f++;
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }
            }
        }

        // checking the question's option size to print the correct answer(s) form for the question
        // 6 options, multiple answers
        if (question.getSize() == 6) {
            System.out.println("Result:\n(0) " + a + "  (1) " + b + "  (2) " + c + "  (3) " + d + "  (4) " + e + "  (5) " + f);
        }
        // 4 options, only accept single answer
        else if (question.getSize() == 4){
            System.out.println("Result:\n(0) " + a + "  (1) " + b + "  (2) " + c + "  (3) " + d);
        }
        // 2 options, either true or false answer
        else {
            System.out.println("Result:\n(0) " + a + "  (1) " + b);
        }
    }
}
