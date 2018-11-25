package server;

/**
 *
 * @author Makaaah!
 */
import java.util.LinkedList;
import java.util.List;

public class ServerProt {

    QuestionHandler q;
    QuestionObject currentQuestion;

    ServerProt() {
        q = new QuestionHandler();
    }

    public List<String> getQandA(String category) {
        //This method returns a list containing Strings, looks like:
        //Category, question, correctanswer, wronganswer1, wronganswer2, wronganswer3

        List<String> CategoryList = q.getCategories();
        int requestedCategory = CategoryList.indexOf(category);
        List<List<QuestionObject>> l = q.getCategoryLists();
        List<QuestionObject> lista = l.get(requestedCategory);
        int QuestionNumber = (int) (Math.random() * lista.size());
        currentQuestion = lista.get(QuestionNumber);

        return currentQuestion.getQandA();
    }

    public String checkAnswer() {
        //gives the right answer to the current question
        return currentQuestion.getCorrectAnswer();
    }

    public List<String> getCategories() {
        //gives a list of the categories
        return q.getCategories();
    }

    public List<String> get3Categories() {
        //gives a String-list with 3 different random categories
        List<String> threeCategories = new LinkedList<>();
        while (threeCategories.size() != 3) {
            int random = (int) (Math.random() * q.getCategoryAmount());
            List<String> l = q.getCategories();
            String tempCat = l.get(random);
            if (!threeCategories.contains(tempCat)) {
                threeCategories.add(tempCat);
            }
        }
        return threeCategories;
    }

    public String getACategory() {
        int random = (int) (Math.random() * q.getCategoryAmount());
        return this.getCategories().get(random);
    }

    public static void main(String[] args) {
        ServerProt sp = new ServerProt();
        List<String> list = sp.getQandA(sp.getACategory());
        
        for (String string : list) {
            System.out.println(string);
        }
    }

}
