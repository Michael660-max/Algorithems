public class MigrationInformation {

    private String initialData;
    private String releaseDate;
    private String type;
    private String gender;
    private String age;
    private String amountOfPeople;

    public MigrationInformation(String initialDate, String releaseDate, String type, String gender, String age,
            String amountOfPeople) {
        this.initialData = initialDate;
        this.releaseDate = releaseDate;
        this.type = type;
        this.gender = gender;
        this.age = age;
        this.amountOfPeople = amountOfPeople;
    }

    public int getAmountOfPeople() {
        return Integer.parseInt(amountOfPeople);
    }

    public String getInfo() {
        return initialData + " " + releaseDate + " " + type + " " + gender + " " + age + " " + amountOfPeople;
    }

    public int size() {
        return 0;
    }

}
