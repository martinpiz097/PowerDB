/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tigerdb.core.test;

import org.mpizutil.electrolist.structure.ElectroList;
import org.tigerdb.core.model.Database;
import org.tigerdb.core.model.Table;

import java.io.IOException;

/**
 *
 * @author martin
 */
public class TestMain {
    static long ti, tf;

    public static void main(String[] args) throws Exception {
        //execAddComparator();
        System.out.print("Limit: ");
        int lim = new java.util.Scanner(System.in).nextInt();
        
        start();
        Database dbPersonas;
        dbPersonas = new Database("dbPersonas");
        finish();
        printMsg("Cargar bd");
        
        start();
        if (!dbPersonas.hasTable("persona"))
            dbPersonas.createTable("persona", Person.class);
        
        finish();
        //10printMsg("Crear tabla");
        
        start();
        for (int i = 0; i < lim; i++)
            dbPersonas.insertInto("persona", new Person(
                    (int) (dbPersonas.selectCountFrom("persona")+1), "nom"+i));
        
        finish();
        printMsg("insert de "+lim+" elementos");

        System.out.println("Max: "+dbPersonas.selectMaxFrom("persona", "edad"));
        System.out.println("Min: "+dbPersonas.selectMinFrom("persona", "edad"));
        System.out.println("Sum: "+dbPersonas.selectSumFrom("persona", "edad"));
        System.out.println("Avg: "+dbPersonas.selectAvgFrom("persona", "edad"));
//        Cursor cursor = dbPersonas.getCursorFrom("persona");
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }

        Person selectFirstFrom = (Person) dbPersonas.selectFirstFrom("persona");
        System.out.println("Select first: "+selectFirstFrom);
        Person first = (Person) dbPersonas.selectFirstFrom("persona", "name", "nom4");
        System.out.println("First search: "+first);
        
        
        start();
        ElectroList<Person> list = dbPersonas.selectAllFrom("persona");
        for (Person p : list) {
            System.out.println(p);
        }
        finish();
        printMsg("selectAllFrom");

        long selectMaxFrom = dbPersonas.selectMaxFrom("persona", "name");
        
        start();
        dbPersonas.dropTable("persona");
        finish();
        printMsg("drop table");
    
//        start();
//        dbPersonas.drop();
//        finish();
//        printMsg("drop database");
    }
    
    public static long currentTime(){
        return System.currentTimeMillis();
    }
    
    public static void start(){
        ti = currentTime();
    }
    
    public static void finish(){
        tf = currentTime();
        tf-=ti;
    }
    
    public static void printMsg(String msg){
        System.out.println(msg+": "+tf);
    }

    private static void execTestProblemaLista() throws IOException, ClassNotFoundException {
        Database db = new Database("dbPersonas");
    
        Table<Person> tbl1 = db.getTable("persona");
        
        tbl1.insert(new Person(1, "nom1"));
        tbl1.insert(new Person(2, "nom2"));
        tbl1.insert(new Person(3, "nom3"));
        
        Table tbl2 = db.getTable("persona");
        
//        ElectroList<Person> selectAll = db.selectAllFrom("persona");
//        ElectroList<Person> selectTblGen = tbl1.selectAll();
//        ElectroList selectTblO = tbl2.selectAll();
//        ElectroList<Person> objectsStoreGen = tbl1.getStoreManager().getObjects();
//        ElectroList<Person> objectsStoreO = tbl2.getStoreManager().getObjects();
//        StoreManager<Person> store = new StoreManager<>(Person.class, new File(db.getStorePath(), "persona"));
//        
//        System.out.println("ListDB: "+selectAll);
//        System.out.println("ListTblGeneric: "+selectTblGen);
//        System.out.println("ListTblObject: "+selectTblO);
//        System.out.println("ListStoreGen: "+objectsStoreGen);
//        System.out.println("ListStoreObject: "+objectsStoreO);
//        System.out.println("ListStorePuro: "+store.getObjects());
        Person selectFirst = (Person) db.selectFirstFrom("persona", "name", "nom1");
    }
    
    /*private static void execAddComparator() throws IOException{
        final String TBL_NAME = "persona";
        System.out.print("Limit: ");
        int lim = new java.util.Scanner(System.in).nextInt();
        
        Database db = new Database("db2");
        if(!db.hasTable(TBL_NAME))
            db.createTable(TBL_NAME, Person.class);

        StoreManager<Person> store = (StoreManager<Person>)
                    db.getTable(TBL_NAME).getStoreManager();
        
        start();
        for (int i = 0; i < lim; i++) {
            store.addObject(new Person(i, "nom"+i));
        }
        finish();
        printMsg("addNormal");
        
        store.deleteAllObjects();
        store.startSaver();
        
        start();
        for (int i = 0; i < lim; i++) {
            store.addObject(new Person(i, "nom"+i));
        }
        finish();
        printMsg("addParallel");
        System.out.println("Cantidad de elementos: "+store.getObjectsCount());
 
        store.deleteAllObjects();
        System.exit(0);
    }*/
    
}
