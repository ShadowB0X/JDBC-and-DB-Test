package participantPerSport;

public class ParticipantsPerSport {

    private String sportName;
    private int participantCount;

    public ParticipantsPerSport(String sportName, int participantCount) {
        this.sportName = sportName;
        this.participantCount = participantCount;
    }


    public int getParticipantCount() {
        return participantCount;
    }

    public String getSportName() {
        return sportName;
    }



    @Override
    public String toString() {
        return "Sport name: " + sportName +"-"+ " Team Members: " + participantCount;
    }


}



