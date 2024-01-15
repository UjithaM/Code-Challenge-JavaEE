package software.ujithamigara.codechallengejavaee.dao;

import software.ujithamigara.codechallengejavaee.dao.custom.impl.CustomerDAOImpl;
import software.ujithamigara.codechallengejavaee.dao.custom.impl.ItemDAOImpl;
import software.ujithamigara.codechallengejavaee.dao.custom.impl.OrderDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER, ITEM, ORDER;
    }

    public SuperDAO getDAO(DAOTypes type){
        switch (type){
            case CUSTOMER: return new CustomerDAOImpl();
            case ITEM: return new ItemDAOImpl();
            case ORDER: return new OrderDAOImpl();
            default: return null;
        }
    }
}
