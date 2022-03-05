package dailyPractice.jianzhi;

public class Q5 {
    public static void main(String[] args) {
        String string = "We are happy.";
        Q5 q5 = new Q5();
        System.out.println(q5.replaceSpace(string));
    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
//        String[] strings = s.split(" ");
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < strings.length - 1; i++) {
//            stringBuffer.append(strings[i]);
//            stringBuffer.append("%20");
//        }
//        stringBuffer.append(strings[strings.length - 1]);
//        return stringBuffer.toString();
    }
}
