package businessLogic;

/**
 * This class represents a Winner entity.
 */
public class Winner {
    private String name;
    private byte[] photo;
    private double percentage;
    private int votes;

    /**
     * Constructor with parameters.
     *
     * @param name       the name of the winner
     * @param photo      the photo of the winner
     * @param percentage the percentage of votes the winner received
     * @param votes      the total votes the winner received
     */
    public Winner(String name, byte[] photo, double percentage, int votes) {
        this.name = name;
        this.photo = photo;
        this.percentage = percentage;
        this.votes = votes;
    }

    /**
     * Retrieves the total votes the winner received.
     *
     * @return the total votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * Sets the total votes the winner received.
     *
     * @param votes the total votes
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }

    /**
     * Retrieves the photo of the winner.
     *
     * @return the photo of the winner
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * Retrieves the name of the winner.
     *
     * @return the name of the winner
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the percentage of votes the winner received.
     *
     * @return the percentage of votes
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * Sets the name of the winner.
     *
     * @param name the name of the winner
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the photo of the winner.
     *
     * @param photo the photo of the winner
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /**
     * Sets the percentage of votes the winner received.
     *
     * @param percentage the percentage of votes
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}