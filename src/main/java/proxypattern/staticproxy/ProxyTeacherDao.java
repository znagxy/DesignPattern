package proxypattern.staticproxy;

import proxypattern.ITeacherDao;

public class ProxyTeacherDao implements ITeacherDao {

    ITeacherDao target;

    public ProxyTeacherDao(ITeacherDao target){
        this.target = target;
    }

    public void teach() {
        start();
        target.teach();
        end();
    }


    private void start(){
        System.out.println("start static proxy...");
    }

    private void end(){
        System.out.println("end static proxy...");
    }
}
