package fps.daniel.codechallengeweatherapi.network

import fps.daniel.codechallengeweatherapi.response.CityWeatherResponse
import fps.daniel.codechallengeweatherapi.utils.Utils
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET(Utils.ENDPOINT_CITY_WEATHER)
    suspend fun getCityWeatherDescription(
        @Query(Utils.QUERY_Q) q: String,
        @Query(Utils.QUERY_UNITS) units: String,
        @Query(Utils.QUERY_APP_ID) appId: String
    ): Response<CityWeatherResponse>
}