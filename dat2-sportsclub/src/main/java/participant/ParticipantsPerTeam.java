package participant;

public class ParticipantsPerTeam {


   private String team_id;
   private int member_id;

    public ParticipantsPerTeam(String team_id, int member_id) {
        this.team_id = team_id;
        this.member_id = member_id;

    }

    public int getMember_id() {
        return member_id;
    }

    public String getTeam_id() {
        return team_id;
    }


    @Override
    public String toString() {
        return "Team ID" + team_id + " Team Members: " + member_id;
    }
}
