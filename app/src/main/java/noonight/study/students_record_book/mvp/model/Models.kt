package noonight.study.students_record_book.mvp.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "Student")
data class Person(
        @field:Element(name = "Name")
        var name: String,
        @field:Element(name = "Otdelenie")
        var otdelenie: String,
        @field:Element(name = "Facultet")
        var facultet: String,
        @field:Element(name = "NumBook")
        var numBook: Int,
        @field:Element(name = "Specialnost")
        var specialnost: String,
        @field:ElementList(inline = true, name = "Zacheti")
        var zacheti: List<ZachetEczamen>,
        //@field:ElementList(inline = true, name = "Eczameni")
        //val eczameni: List<ZachetEczamen>,
        @field:ElementList(inline = true, name = "Kursovii")
        var kursovii: List<Kursovoi>,
        @field:Element(name = "Diplom")
        var diplom: Diplom
)

@Root(name = "ZachetEczamen")
data class ZachetEczamen(
        @field:Element(name = "Predmet")
        var predmet: String,
        @field:Element(name = "Ocenka")
        var ocenka: String,
        @field:Element(name = "DataSdachi")
        var dataSdachi: String,
        @field:Element(name = "Prepodavatel")
        var prepodavatel: String
)

@Root(name = "Kursovoi")
data class Kursovoi(
        @field:Element(name = "Predmet")
        var predmet: String,
        @field:Element(name = "Title")
        var title: String,
        @field:Element(name = "Ocenka")
        var ocenka: String ,
        @field:Element(name = "Prepodavatel")
        var prepodavatel: String
)

@Root(name = "Diplom")
data class Diplom(
        @field:Element(name = "Title")
        var title: String,
        @field:Element(name = "Ocenka")
        var ocenka: String
)
