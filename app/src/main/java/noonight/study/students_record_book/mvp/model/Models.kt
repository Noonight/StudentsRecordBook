package noonight.study.students_record_book.mvp.model

import org.simpleframework.xml.*

@Root(name = "Student")
data class Person(
        @field:Element(name = "Name")
        var name: String="",
        @field:Element(name = "Otdelenie")
        var otdelenie: String="",
        @field:Element(name = "Facultet")
        var facultet: String="",
        @field:Element(name = "NumBook")
        var numBook: Int=-1,
        @field:Element(name = "Specialnost")
        var specialnost: String ="",
        /*@field:Element(name = "Zacheti")
        var zacheti: Zacheti,
        @field:Element(name = "Eczameni")
        val eczameni: Eczameni,*/
        @field:ElementList(name = "Sessions", inline = true)
        var sessions: List<Sessions>? = null,
        @field:ElementList(inline = true, name = "Kursovie")
        var kursovii: List<Kursovoi>? = null,
        @field:Element(name = "Diplom")
        var diplom: Diplom? = null
)

@Root(name = "Sessions")
data class Sessions(
        @field:Attribute(name = "numSessions")
        var numSessions: Int = -1,
        @field:Element(name = "Zacheti")
        var zacheti: Zacheti? = null,
        @field:Element(name = "Eczameni")
        var eczameni: Eczameni? = null
)

@Root(name = "Eczameni")
data class Eczameni(
        @field:ElementList(name = "Eczameni", inline = true)
        var eczameni: List<Eczamen>? = null
)

@Root(name = "Zacheti")
data class Zacheti(
        @field:ElementList(name = "Zacheti", inline = true)
        var zacheti: List<Zachet>? = null
)

@Root(name = "Zachet")
data class Zachet(
        @field:Element(name = "Predmet")
        var predmet: String="",
        @field:Element(name = "Ocenka")
        var ocenka: String="",
        @field:Element(name = "DataSdachi")
        var dataSdachi: String="",
        @field:Element(name = "Prepodavatel")
        var prepodavatel: String=""
)

@Root(name = "Eczamen")
data class Eczamen(
        @field:Element(name = "Predmet")
        var predmet: String="",
        @field:Element(name = "Ocenka")
        var ocenka: String="",
        @field:Element(name = "DataSdachi")
        var dataSdachi: String="",
        @field:Element(name = "Prepodavatel")
        var prepodavatel: String=""
)

@Root(name = "Kursovoi")
data class Kursovoi(
        @field:Element(name = "Predmet")
        var predmet: String="",
        @field:Element(name = "Title")
        var title: String="",
        @field:Element(name = "Ocenka")
        var ocenka: String="",
        @field:Element(name = "Prepodavatel")
        var prepodavatel: String=""
)

@Root(name = "Diplom")
class Diplom(
        @field:Element(name = "Title")
        var title: String ="",
        @field:Element(name = "Ocenka")
        var ocenka: String =""
)