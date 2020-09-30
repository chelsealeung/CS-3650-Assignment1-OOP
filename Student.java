import java.util.*;

public class Student extends Question {
    private String studentID;
    private ArrayList<Integer> studentAnswer = new ArrayList<>();

    // default constructor
    Student() { }

    Student(String studentID, ArrayList<Integer> studentAnswer, String question, ArrayList<Integer> choices) {
        super(question, choices);
        this.studentID = studentID;
        this.studentAnswer = studentAnswer;
    }

    // set a name to the student
    public void setStudentID(int studentName) {
        switch (studentName) {
            case 1:
                studentID = "Ada";
                break;
            case 2:
                studentID = "Bobby";
                break;
            case 3:
                studentID = "Cathy";
                break;
            case 4:
                studentID = "Daniel";
                break;
            case 5:
                studentID = "Emily";
                break;
            case 6:
                studentID = "Frank";
                break;
            case 7:
                studentID = "Gilbert";
                break;
            case 8:
                studentID = "Hailey";
                break;
            case 9:
                studentID = "Josh";
                break;
            default:
                studentID = "Chelsea";
        }
    }

    // students will give the correct form of answer(s) by checking the question's option size
    public void submitAnswer(String question, ArrayList<Integer> choices) {
        Question currentQuestion = new Question(question, choices);

        // 6 options, multiple answers
        if (currentQuestion.getSize() == 6) {
            setMultChoices();
            System.out.println(studentID + " : " + studentAnswer);
        }
        // 4 options, only accept single answer
        else if (currentQuestion.getSize() == 4){
            setSingleChoices();
            System.out.println(studentID + " : " + studentAnswer);
        }
        // 2 options, either true or false answer
        else {
            setTFChoices();
            System.out.println(studentID + " : " + studentAnswer);
        }

        // jump to changeAnswers to check if student wants to change answer
        changeAnswers(question, choices);
    }

    // randomly generate if the student wants to change answer
    public void changeAnswers(String question, ArrayList<Integer> choices) {
        Random randomGenerator = new Random();
        boolean hasChange = randomGenerator.nextBoolean();

        // if boolean is true, student will change answer by jumping back to submitAnswer()
        if (hasChange) {
            System.out.println(studentID + " is changing answer...");
            studentAnswer.clear();
            submitAnswer(question, choices);
        }
    }

    // return student answer list
    public ArrayList<Integer> getStudentAnswer() {
        return this.studentAnswer;
    }

    // return student ID
    public String getStudentID() {
        return this.studentID;
    }

    // generate only one right or wrong answer
    public void setTFChoices() {
        Random randomGenerator = new Random();
        int trueFalseAnswer = randomGenerator.nextInt(2);
        studentAnswer.add(trueFalseAnswer);
    }

    // generate one answer out of 4 options
    public void setSingleChoices() {
        Random randomGenerator = new Random();
        int singleAnswer = randomGenerator.nextInt(4);
        studentAnswer.add(singleAnswer);    }

    // generate more than one answer from 6 options
    public void setMultChoices() {
        Random randomGenerator = new Random();
        int howManyAnswer = randomGenerator.nextInt(6) + 1;
        for (int i = 0; i < howManyAnswer; i++) {
            int multipleAnswer = randomGenerator.nextInt(6);
            checkDuplicate(studentAnswer, multipleAnswer);

        }
    }

    // only add to the array list when the item has not yet existed in the list
    public void checkDuplicate (ArrayList studentAnswer, int answer) {
        if (!studentAnswer.contains(answer)){
            studentAnswer.add(answer);
        }
    }
}
