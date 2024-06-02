package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero
import com.example.repository.HeroRepository

const val PREV_PAGE = "prevPage"
const val NEXT_PAGE = "nextPage"

class HeroRepositoryImp : HeroRepository {
    override val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }

    override val page1 = listOf(
        Hero(
            id = 1,
            name = "Dr. Reetika Dembla",
            speciality = "Dentist",
            experience = "15 Years",
            gender = "Female",
            availability = "10:00 AM - 07:00 PM",
            address = "Darya Ram Hospital, Murthal, Sonipat"
        ),
        Hero(
            id = 2,
            name = "Dr. Hitender Jeet Pal",
            speciality = "Ear-Nose-Throat (ENT) Specialist",
            experience =  "11 Years",
            gender = "Male",
            availability =  "05:00 PM - 07:00 PM",
            address = "Tulip Multispeciality Hospital, Vivekanand Chowk, Landmark: Near TVS Showroom, Sonipat"
        ),
        Hero(
            id = 3,
            name = "Dr. Sakshi Bansal",
            speciality = "Gynecologist",
            experience =  "16 Years",
            gender = "Female",
            availability =  "10:00 AM - 06:30 PM",
            address = "Bansal Health Square And IVF Center, Plot Number 1, Phase 2, Sector 14, Main Market,  Sonipat"
        ),
        Hero(
            id = 4,
            name = "Dr. Sandeep Kumar Jangra",
            speciality = "Dentist",
            experience = "20 Years",
            gender = "Male",
            availability = "03:00 PM - 07:00 PM",
            address = "Tulip Multispeciality Hospital, Vivekanand Chowk, Sonipat"
        ),
        Hero(
            id = 5,
            name = "Dr. K Lal",
            speciality = "Ayurveda",
            experience =  "39 Years",
            gender = "Male",
            availability =  "12:00 PM - 07:00 PM",
            address = "Lal Clinic, Sikka Colony, Landmark: Near ICICI Bank, Sonipat"

        ),
        Hero(
            id = 6,
            name = "Dr. Mukul Sharma",
            speciality = "Homoeopath",
            experience =  "37 Years",
            gender = "Male",
            availability =  "10:00 AM - 08:00 PM",
            address = "Wellness First Homeopathic Clinic, A 59, Parker Mall, NH1, Landmark: Mukta Cinema, Sonipat"
        ),
        Hero(
            id = 7,
            name = "Dr. Akhil Saxena",
            speciality = "Surgeon",
            experience =  "35 Years",
            gender = "Male",
            availability =  "10:00 AM - 07:00 PM",
            address = "Saxena Multispeciality Hospital Pvt Ltd, 112-113, TP Scheme, Sonipat"
        ),
        Hero(
            id = 8,
            name = "Dr. Ankur Batra",
            speciality = "Cardiologist",
            experience =  "16 Years",
            gender = "Male",
            availability =  "09:00 AM - 07:00 PM",
            address = "Batra Heart and Lung Institute, House 19, Sector 15, Landmark: Opposite MG Mall, Sonipat"
        ),
        Hero(
            id = 9,
            name = "Dr. Vishal Chhabra",
            speciality = "Psychiatrist",
            experience =  "24 Years",
            gender = "Male",
            availability =  "10:00 AM - 01:30 PM",
            address = "Tulip Multispeciality Hospital, Vivekanand Chowk, Landmark: Near TVS Showroom, Sonipat"
        ),
        Hero(
            id = 10,
            name = "Mr. Manjit Singh",
            speciality = "Physiotherapist",
            experience =  "14 Years",
            gender = "Male",
            availability =  "09:00 AM - 12:00 PM",
            address = "Aanvi Physiotherapy Clinic, House Number 1600, HBC, Landmark: Near Gandhi Chowk, Sonipat"
        )
    )
    override val page2 = listOf(
        Hero(
            id = 11,
            name = "Dr. Mahesh Gupta",
            speciality = "Radiologist",
            experience =  "36 Years",
            gender = "Male",
            availability =  "09:00 AM - 01:30 PM",
            address = "Satyakiran Healthcare, Subhash Chowk, Landmark: Opposite Civil Lines Police Station, Sonipat"
        )
    )
    override val page3 = listOf(
        Hero(
            id = 12,
            name = "Dr. Vinod Sharma",
            speciality = "Opthalmologist",
            experience =  "34 Years",
            gender = "Male",
            availability =  "09:00 AM - 04:00 PM",
            address = "Sushanti Eye Hospital, Sonipat Road, Landmark: Near Public Rest House & Subzi Mandi, Sonipat"
        )
    )
    override val page4 = listOf(
        Hero(
            id = 13,
            name = "Dr. Robin Khosa",
            speciality = "Oncologist",
            experience =  "16 Years",
            gender = "Male",
            availability =  "10:30 AM - 11:30 PM",
            address = "Tulip Multispeciality Hospital, Vivekanand Chowk, Landmark: Near TVS Showroom, Sonipat"
        )
    )
    override val page5 = listOf(
        Hero(
            id = 14,
            name = "Dr. Harit Bansal",
            speciality = "Child Specialist",
            experience =  "19 Years",
            gender = "Male",
            availability =  "09:30 AM - 10:45 PM",
            address = "Bansal Health Square And IVF Center, Plot Number 1, Phase 2, Sector 14, Main Market,  Sonipat"
        )
    )

    override suspend fun getallheroes(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "Ok",
            prevPage = calculatepage(page = page)[PREV_PAGE],
            nextPage = calculatepage(page = page)[NEXT_PAGE],
            heroes = heroes[page]!!
        )
    }

    fun calculatepage(page: Int) :Map<String,Int?>{
        var prevPage :Int? = page
        var nextPage:Int? = page
        if (page in 1..4){
            nextPage = nextPage?.plus(1)!!
        }
        if (page in 2..5){
            prevPage = prevPage?.minus(1)!!
        }

        if (page==1){
            prevPage = null
        }

        if (page==5){
            nextPage = null
        }

        return mapOf(PREV_PAGE to prevPage, NEXT_PAGE to nextPage)

    }

    override suspend fun Searchheroes(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            heroes = searchHero(query = name)
        )
    }

    private fun searchHero(query: String?) : List<Hero> {
        val founded = mutableListOf<Hero>()
        return if (!query.isNullOrEmpty()){
            heroes.forEach{(_,heroes)->
                heroes.forEach{hero ->
                    if (hero.name.lowercase().contains(query.lowercase())){
                        founded.add(hero)
                    }
                }
            }
            founded
        }
        else{
            emptyList()
        }

    }

}