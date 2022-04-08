public class DatabaseHandler extends Configs{
    Connection dbConnection;
    private ResultSet resultSet = null;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public ResultSet getID(String num){
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.SWEET_ID + " =?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, num);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int getIDnum() throws SQLException {
        String select = "SELECT COUNT(*) FROM " + Const.USER_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(resultSet.next()) {
            return Integer.parseInt(resultSet.getString(1));
        }
        return 0;
    }
}
