package software.ujithamigara.codechallengejavaee.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}
