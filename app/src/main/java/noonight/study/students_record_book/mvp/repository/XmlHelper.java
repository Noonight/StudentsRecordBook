package noonight.study.students_record_book.mvp.repository;


import android.os.Environment;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import noonight.study.students_record_book.common.Log;
import noonight.study.students_record_book.mvp.model.Diplom;
import noonight.study.students_record_book.mvp.model.Eczamen;
import noonight.study.students_record_book.mvp.model.Eczameni;
import noonight.study.students_record_book.mvp.model.Kursovoi;
import noonight.study.students_record_book.mvp.model.Person;
import noonight.study.students_record_book.mvp.model.Sessions;
import noonight.study.students_record_book.mvp.model.Zachet;
import noonight.study.students_record_book.mvp.model.Zacheti;


public class XmlHelper {

    public static final String pathToFile = Environment.getExternalStorageDirectory().getPath();

    public static void writeXml() {
        Writer writer = new StringWriter();
        Serializer serializer = new Persister();
        try {
            ArrayList<Zachet> zacheti = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                zacheti.add(new Zachet(
                        "Predmet " + i,
                        "Ocenka " + i,
                        "Data Sdachi " + i,
                        "Prepodavatel " + i
                ));
            }
            ArrayList<Eczamen> eczameni = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                eczameni.add(new Eczamen(
                        "Predmet " + i,
                        "Ocenka " + i,
                        "Data Sdachi " + i,
                        "Prepodavatel " + i
                ));
            }
            ArrayList<Kursovoi> kursovois = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                kursovois.add(new Kursovoi(
                        "Predmet " + i,
                        "Ocenka " + i,
                        "Data Sdachi " + i,
                        "Prepodavatel " + i
                ));
            }
            ArrayList<Sessions> sessions = new ArrayList<>();
            sessions.add(new Sessions(1, new Zacheti(zacheti), new Eczameni(eczameni)));
            sessions.add(new Sessions(2, new Zacheti(zacheti), new Eczameni(eczameni)));
            sessions.add(new Sessions(3, new Zacheti(zacheti), new Eczameni(eczameni)));
            sessions.add(new Sessions(4, new Zacheti(zacheti), new Eczameni(eczameni)));
            sessions.add(new Sessions(5, new Zacheti(zacheti), new Eczameni(eczameni)));
            sessions.add(new Sessions(6, new Zacheti(zacheti), new Eczameni(eczameni)));

            Person person = new Person(
                "Никифоров Алексанр Федотович",
                    "Отделение № 1",
                    "Факультет мои",
                    250002,
                    "МОАИС",
                    sessions,
                    /*new Zacheti(zacheti),
                    new Eczameni(eczameni),*/
                    kursovois,
                    new Diplom("MY DIPLOM >ORG", "OTLICHNO")
            );
            //serializer.write(person, writer);
            //String xml = writer.toString();
            //Log.d(xml);
            File file = new File(pathToFile, "example.xml");
            serializer.write(person, file);
            serializer.write(person, writer);
            String xml = writer.toString();
            Log.d(xml);
            Log.d(pathToFile);
            //System.out.println(xml);
            //System.out.println(pathToFile);
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            Log.d(e.getMessage());
        }
    }

    public static Person readXml() {
        Serializer serializer = new Persister();
        File sourse = new File(pathToFile + "/example.xml");
        Person person = null;
        try {
            person = serializer.read(Person.class, sourse);
            Log.d(person.toString());
            //System.out.println(person);
        } catch (Exception e) {
            Log.d(e.getMessage());
        }
        return person;
    }

}
