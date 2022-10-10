public class DeadFish {
    public static int[] parse(String data) {

        int counterOutput = 0;

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == 'o') {
                counterOutput++;
            }
        }

        int[] result = new int[counterOutput];
        counterOutput = 0;
        int toOutput = 0;

        for (int i = 0; i < data.length(); i++) {
            char check = data.charAt(i);
            switch (check) {
                case 'i' -> toOutput++;
                case 'd' -> toOutput--;
                case 's' -> toOutput = toOutput * toOutput;
                case 'o' -> {
                    result[counterOutput] = toOutput;
                    counterOutput++;
                }
            }
        }
        return result;
    }
}
