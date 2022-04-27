package fps.daniel.codechallengeweatherapi.repository

import fps.daniel.codechallengeweatherapi.network.ApiService
import fps.daniel.codechallengeweatherapi.response.CityWeatherResponse
import fps.daniel.codechallengeweatherapi.utils.Utils
import retrofit2.Response
import javax.inject.Inject

class CityWeatherRepository @Inject constructor(
    private val apiService: ApiService
): ICityWeatherRepository {
    override suspend fun getCityWeatherDescription(
        name: String
    ): Response<CityWeatherResponse> = apiService.getCityWeatherDescription(q = name, units = Utils.units, appId = Utils.appId)
}