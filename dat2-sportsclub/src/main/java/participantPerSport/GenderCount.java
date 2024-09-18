package participantPerSport;

public class GenderCount {
        private String gender;
        private int count;

        public GenderCount(String gender, int count) {
            this.gender = gender;
            this.count = count;
        }

    public int getCount() {
        return count;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Gender: " + gender + ", Count: " + count;
    }


}
