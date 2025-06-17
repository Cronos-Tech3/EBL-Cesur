package Constructor;

public class StringConstructor {

    private Long value;

    public String constructHelloSentence(String name) {
        String resultSentence = this.getSentence()  + name;
        System.out.println(resultSentence);
        return resultSentence;
    }

    private String getSentence() {
        return "Hello world! My name is ";
    }

    public void setValue(Long value) {
        this.value = value;
    }
}

