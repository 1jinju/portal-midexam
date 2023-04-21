package kr.ac.jejunu.portalmidexam.user;

public class DaoFactory {
    public UserDao getUserDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    public ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
