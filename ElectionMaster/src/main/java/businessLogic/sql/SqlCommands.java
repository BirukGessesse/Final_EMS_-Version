package businessLogic.sql;

public class SqlCommands {
    public static final String CREATE_ELECTION_TABLE_SQL = "CREATE TABLE IF NOT EXISTS election (" +
            "election_id INT AUTO_INCREMENT PRIMARY KEY," +
            "election_name VARCHAR(255)," +
            "election_date VARCHAR(255)" +
            ")";

    public static final String INSERT_ELECTION_SQL = "INSERT INTO election (election_name, election_date) VALUES (?, ?)";
    public static final String SELECT_ALL_ELECTION_SQL = "SELECT * FROM election";
    public static final String DELETE_ELECTION_SQL = "DELETE FROM election WHERE election_id = ?";
    public static final String UPDATE_ELECTION_SQL = "UPDATE election SET election_name = ?, election_date = ? WHERE election_id = ?";
    // Other SQL commands...
    public static final String CREATE_CANDIDATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS candidate (" +
            "candidate_id INT AUTO_INCREMENT PRIMARY KEY," +
            "candidate_name VARCHAR(255)," +
            "candidate_age INT," +
            "candidate_gender VARCHAR(255)," +
            "candidate_elect INT," +
            "candidate_photo BLOB" +
            ")";
    public static final String INSERT_CANDIDATE_SQL = "INSERT INTO candidate (candidate_name, candidate_age, candidate_gender, candidate_elect, candidate_photo) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_CANDIDATE_SQL = "SELECT * FROM candidate";
    public static final String DELETE_CANDIDATE_SQL = "DELETE FROM candidate WHERE candidate_id = ?";
    public static final String UPDATE_CANDIDATE_SQL = "UPDATE candidate SET candidate_name = ?, candidate_age = ?, candidate_gender = ?, candidate_elect = ?, candidate_photo = ? WHERE candidate_id = ?";
    public static final String CREATE_VOTER_TABLE_SQL = "CREATE TABLE IF NOT EXISTS voters (" +
            "voter_id INT AUTO_INCREMENT PRIMARY KEY," +
            "voter_name VARCHAR(255)," +
            "voter_age INT," +
            "voter_gender VARCHAR(255)," +
            "voter_password VARCHAR(255)," +
            "voter_elect INT " +
            ")";
    //    public static final String SELECT_VOTING_BY_VOTER_ID_SQL = "SELECT * FROM voting WHERE voting_voter_id = ?";
    public static final String SELECT_VOTING_BY_VOTER_ID_AND_ELECTION_ID_SQL = "SELECT * FROM voting WHERE voting_voter_id = ? AND voting_election_id = ?";
    public static final String INSERT_VOTER_SQL = "INSERT INTO voters (voter_Name, voter_Age, voter_Gender, voter_Password, voter_Elect) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_VOTER_SQL = "SELECT * FROM voters";
    public static final String DELETE_VOTER_SQL = "DELETE FROM voters WHERE voter_id = ?";
    public static final String UPDATE_VOTER_SQL = "UPDATE voters SET voter_Name = ?, voter_Age = ?, voter_Password = ?, voter_Gender = ?, voter_Elect = ? WHERE voter_id = ?";
    public static final String CREATE_VOTING_TABLE_SQL = "CREATE TABLE IF NOT EXISTS voting (" +
            "voting_id INT AUTO_INCREMENT PRIMARY KEY," +
            "voting_candidate_id INT," +
            "voting_voter_id INT," +
            "voting_election_id INT" +

            ")";
    //            "FOREIGN KEY (voting_candidate_id) REFERENCES candidate(candidate_id)," +
//            "FOREIGN KEY (voting_voter_id) REFERENCES voters(voter_id)," +
//            "FOREIGN KEY (voting_election_id) REFERENCES election(election_id)" +
    public static final String INSERT_VOTING_SQL = "INSERT INTO voting (voting_candidate_id, voting_voter_id, voting_election_id) VALUES (?, ?, ?)";
    public static final String SELECT_ALL_VOTING_SQL = "SELECT * FROM voting";
    public static final String DELETE_VOTING_SQL = "DELETE FROM voting WHERE voting_id = ?";
    public static final String UPDATE_VOTING_SQL = "UPDATE voting SET voting_candidate_id = ?, voting_voter_id = ?, voting_election_id = ? WHERE voting_id = ?";
    public static final String query = "SELECT * FROM voters WHERE voter_name = ? AND voter_password= ?";
    public static final String SELECT_ELECTION_ID = "SELECT election_id FROM election";
    public static final String winner_sql = "SELECT voting_candidate_id, COUNT(*) as vote_count FROM voting WHERE voting_election_id = ? GROUP BY voting_candidate_id ORDER BY vote_count DESC LIMIT 1";
    public static final String totalVotesSql = "SELECT COUNT(*) as total_votes FROM voting WHERE voting_election_id = ?";
    public static final String candidateSql = "SELECT candidate_name, candidate_photo FROM candidate WHERE candidate_id = ?";

}