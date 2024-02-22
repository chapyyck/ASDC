public class RegEx1 {
    public static void main(String[] args) {
        String s1 = "Privet,Menya,Zovut,Roman";

        String[] output = s1.split(",");
        System.out.println("count of parts: " + output.length);

        int delimiterCount = s1.length() - s1.replace(",", "").length();
        System.out.println("count of delimiter: " + delimiterCount);

        int count_parts = 0;
        for(String s : output){
            ++count_parts;
            System.out.println(s + " " + count_parts);
        }
    }
}
