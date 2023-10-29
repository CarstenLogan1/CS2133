public class Euler19 {
    public static void main(String[] args) {
        int day = 1;
        int monthDays;
        int counter = 0;

        for(int i = 1901; i <= 2000; i++){
            for(int j = 1; j<=12; j++){
                boolean b = j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12;
                if(i % 4 == 0 || i == 2000){
                    if(j == 4 || j == 6 || j==9 || j ==11){
                        monthDays = thirtyDay();
                        day = (monthDays + day) % 7;
                        if(day == 6){
                            counter++;
                        }
                    } else if(b){
                        monthDays = thirtyOneDay();
                        day = (monthDays + day) % 7;
                        if(day == 6){
                            counter++;
                        }
                    } else {
                        monthDays = twentyNineDay();
                        day = (monthDays + day) % 7;
                        if(day == 6){
                            counter++;
                        }
                    }
                } else {
                    if(j == 4 || j == 6 || j==9 || j ==11){
                        monthDays = thirtyDay();
                        day = (monthDays + day) % 7;
                        if(day == 6){
                            counter++;
                        }
                    } else if(b){
                        monthDays = thirtyOneDay();
                        day = (monthDays + day) % 7;
                        if(day == 6){
                            counter++;
                        }
                    } else {
                        monthDays = twentyEightDay();
                        day = (monthDays + day) % 7;
                        if(day == 6){
                            counter++;
                        }
                    }
                }
            }
        }

        System.out.println(counter);
    }

    private static int twentyEightDay() {
        return 28;
    }

    private static int twentyNineDay() {
        return 29;
    }

    private static int thirtyOneDay() {
        return 31;
    }

    private static int thirtyDay() {
        return 30;
    }
}
