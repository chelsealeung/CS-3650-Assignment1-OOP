import java.util.ArrayList;
import java.util.Random;

public class Question {
    private String question;
    private ArrayList<Integer> choices = new ArrayList<>();

    // default constructor
    Question() {}

    public Question(String question, ArrayList<Integer> choices) {
        this.question = question;
        this.choices = new ArrayList<>();
        this.choices.addAll(choices);
    }

    // set question and it corresponding option type
    public void setQuestion() {
        // randomly select a question from 3 questions
        Random randomGenerator = new Random();
        int questionNumber = randomGenerator.nextInt(3);


        switch (questionNumber) {
            // when questionNumber == 0, use TFChoices
            case 0:
                question = "How's your day going?\n"
                        + "(0)Good\n(1)Bad\n";
                setTFChoices();
                break;

            // when questionNumber == 1, use singleChoices
            case 1:
                question = "What is my favorite color? (only one answer)\n"
                        + "(0)red\n(1)yellow\n(2)blue\n(3)green\n";
                setSingleChoices();
                break;

            // when questionNumber == 2, use multChoices
            case 2:
                question = "What kind of food do I like? (accept more than one answers)\n"
                        + "(0)steak\n(1)noodle\n(2)burger\n(3)in-n-out\n(4)rice\n(5)pho\n";
                setMultChoices();
                break;

            // default case
            default:
                System.out.println("Invalid Question");
        }
    }

    // use in case 0
    public void setTFChoices() {
        choices.add(0,0);
        choices.add(1,1);
    }

    // use in case 1
    public void setSingleChoices() {
        setTFChoices();
        choices.add(2,2);
        choices.add(3,3);
    }

    // use in case 2
    public void setMultChoices() {
        setSingleChoices();
        choices.add(4,4);
        choices.add(5,5);
    }

    // print out and return question prompt
    public String getQuestion() {
        System.out.println(question);
        return question;
    }

    // return choices
    public ArrayList<Integer> getChoices() {
        return choices;
    }

    // get the question's options size, useful in Student class when submitting answers
    public int getSize() {
        return choices.size();
    }
}
