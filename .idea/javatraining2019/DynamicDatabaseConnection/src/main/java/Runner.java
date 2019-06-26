import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        EntityManagerFactory objEntityManagerFactory = Persistence.createEntityManagerFactory("ing.javatraining2019.ddb");

        EntityManager objEntityManager = objEntityManagerFactory.createEntityManager();

        EmployeeDetails employeeDetails = new EmployeeDetails();

        insert(employeeDetails);
        objEntityManager.getTransaction().begin();

        objEntityManager.persist(employeeDetails);

        List<Object> listResult = select(objEntityManager, "select  name from employeetable where corpkey='UJ18VN'");

        for (Object val : listResult) {
            System.out.println(val + "******");
        }
        Iterator<Object> item = listResult.iterator();
        while (item.hasNext()) {
            System.out.println(item.next() + "####");
        }
        objEntityManager.getTransaction().commit();
        objEntityManagerFactory.close();
    }

    public static void insert(EmployeeDetails employeeDetails) {
        employeeDetails.setCorpKey("WJ80VF");
        employeeDetails.setName("Ansari");
        employeeDetails.setEmail("abc@xyz.com");
        employeeDetails.setTribe("Customer Information Managment");
    }

    public static List<Object> select(EntityManager manager, String query) {
        Session session = manager.unwrap(Session.class);
        List<Object> listResult = (List<Object>) session.createSQLQuery(query).list();
        manager.close();
        return listResult;

    }
}
