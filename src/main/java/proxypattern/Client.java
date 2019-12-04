package proxypattern;

import proxypattern.cglib.CglibProxyFactory;
import proxypattern.dynamicpattern.DynamicProxyFactory;
import proxypattern.staticproxy.ProxyTeacherDao;

public class Client {
    public static void main(String[] args) {
        TeacherDao target = new TeacherDao();
        ProxyTeacherDao proxyTeacherDao = new ProxyTeacherDao(target);
        proxyTeacherDao.teach();

        DynamicProxyFactory dynamicProxyFactory = new DynamicProxyFactory(target);
        ITeacherDao instance = (ITeacherDao) dynamicProxyFactory.getProxyInstance();
        instance.teach();

        Tearch2Dao target2 = new Tearch2Dao();
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(target2);
        Tearch2Dao tearch2Dao = (Tearch2Dao) cglibProxyFactory.getProxyInstance();
        tearch2Dao.teach();

    }
}
