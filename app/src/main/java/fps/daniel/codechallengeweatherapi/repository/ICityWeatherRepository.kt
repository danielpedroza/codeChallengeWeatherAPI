package fps.daniel.codechallengeweatherapi.repository

import fps.daniel.codechallengeweatherapi.response.CityWeatherResponse
import retrofit2.Response

interface ICityWeatherRepository {

    suspend fun getCityWeatherDescription(
        name: String
    ): Response<CityWeatherResponse>
}