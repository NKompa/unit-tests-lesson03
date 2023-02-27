package seminars.third.tdd;

public class MoodAnalyser {
    public String analyse(String str) {
        if (str.contains("хорошее"))
            return "Happy";
        if (str.contains("плохое")) {
            return "Sad";
        }
        return "Normal";
    }
}
