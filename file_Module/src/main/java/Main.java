

import beans.Person;
import org.apache.commons.lang3.StringUtils;
import factories.AbstractManagerFactory;
import factories.PersonManagerFromFileFactory;
import managers.PersonManager;

public class Main {
    public static void main(String[] args) {

        /*
         *  Work with CSV file
         */

        AbstractManagerFactory FileManager = new PersonManagerFromFileFactory();
        PersonManager pmF = FileManager.createPersonManager();

        Person pF = new Person("Dzmitry",35);
        Person pF1 = new Person("Sergey",35);
        pmF.writePerson(pF);
        pmF.writePerson(pF1);

        pF = pmF.readPerson();
        System.out.println("read last from file ->    "+ StringUtils.trim(pF.getName())+" , " + pF.getAge());

        pF = pmF.readPerson("Sergey");
        System.out.println("read by name from file ->   "+ StringUtils.trim(pF.getName())+" , " + pF.getAge());

        Person pF3 = new Person("Stas",31);
        pmF.writePerson(pF3);

        String name1 = "Stas";
        pF = pmF.readPerson(name1);
        if (pF.getName() != null) {
            System.out.println("Write and read written by name from File ->   " + pF.getName() + " , " + pF.getAge());
        }else {
            System.out.println("Entries with name " + name1 + " not found in file storage.");
        }
    }
}
