import java.util.*;

public class SimulationDriver {

    // static method that helps to create a random ArrayList of numbers 1-9 without duplicates
    private static ArrayList noNameDuplicate()  {
        ArrayList integers = new ArrayList();
        for (int i = 0; i < 9; i++) {
            integers.add(i + 1);
        }
        Collections.shuffle(integers);
        return integers;
    }

    // main method
    public static void main(String[] args) {

        // set up questions and choices
        Question q = new Question();
        q.setQuestion();
        String currentQuestion = q.getQuestion();
        ArrayList<Integer> currentChoices = q.getChoices();

        // helpful to get an unique integer for setStudentID()
        ArrayList numbersList = noNameDuplicate();

        // list that contains all students, will be used to find result in VotingService
        List<Student> studentList = new ArrayList<>();

        // generate random number of students
        Random randomGenerator = new Random();
        int studentNumber = randomGenerator.nextInt(9) + 1;
        for (int i = 0; i < studentNumber; i++) {
            Student student = new Student();

            // give each student an unique ID
            int studentName = (int)numbersList.get(i);
            student.setStudentID(studentName);
            String id = student.getStudentID();

            // set each student answer(s)
            student.submitAnswer(currentQuestion, currentChoices);
            ArrayList<Integer> answerList = student.getStudentAnswer();

            // add the student with id and answer in the student list
            studentList.add(student);
            System.out.println(id + " final : " + answerList + "\n");
        }
        // calculate results
        VotingService vote = new VotingService();
        vote.results(studentList, q);
    }
}