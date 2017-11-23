package noonight.study.students_record_book.mvp.repository;


import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import noonight.study.students_record_book.common.Log;
import noonight.study.students_record_book.mvp.model.Diplom;
import noonight.study.students_record_book.mvp.model.Kursovoi;
import noonight.study.students_record_book.mvp.model.Person;
import noonight.study.students_record_book.mvp.model.ZachetEczamen;

public class XmlHelper {

    public static void writeXml() {
        Writer writer = new StringWriter();
        Serializer serializer = new Persister();
        try {
            ArrayList<ZachetEczamen> zachetEczamen = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                zachetEczamen.add(new ZachetEczamen(
                        "Predmet " + i,
                        "Ocenka " + i,
                        "Data Sdachi " + i,
                        "Prepodavatel " + i
                ));
            }
            ArrayList<ZachetEczamen> zachetEczamen2 = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                zachetEczamen.add(new ZachetEczamen(
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
            Person person = new Person(
                "Никифоров Алексанр Федотович",
                    "Отделение № 1",
                    "Факультет мои",
                    250002,
                    "МОАИС",
                    zachetEczamen,
                    //zachetEczamen2,
                    kursovois,
                    new Diplom("MY DIPLOM >ORG", "OTLICHNO")
            );
            serializer.write(person, writer);
            String xml = writer.toString();
            Log.d(xml);
        } catch (Exception e) {
            Log.d(e.getMessage());
        }
    }

}
