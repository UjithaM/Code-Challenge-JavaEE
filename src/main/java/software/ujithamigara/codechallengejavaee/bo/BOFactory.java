package software.ujithamigara.codechallengejavaee.bo;


import software.ujithamigara.codechallengejavaee.bo.custom.Impl.CustomerBOImpl;
import software.ujithamigara.codechallengejavaee.bo.custom.Impl.ItemBOImpl;
import software.ujithamigara.codechallengejavaee.bo.custom.Impl.OrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER, ITEM, ORDER;
    }

    public SuperBO getBO(BOTypes type){
        switch (type){
            case CUSTOMER: return new CustomerBOImpl();
            case ITEM: return new ItemBOImpl();
            case ORDER: return  new OrderBOImpl();
            default: return null;
        }
    }
}
