package businessLogic;

public class Winner {
    private String name;
    private byte[] photo;
    private double percentage;
    private int votes;

    public Winner(String name, byte[] photo, double percentage, int votes) {
        this.name = name;
        this.photo = photo;
        this.percentage = percentage;
        this.votes = votes;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}