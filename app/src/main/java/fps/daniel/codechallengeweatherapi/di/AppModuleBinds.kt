package fps.daniel.codechallengeweatherapi.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import fps.daniel.codechallengeweatherapi.repository.CityWeatherRepository
import fps.daniel.codechallengeweatherapi.repository.ICityWeatherRepository

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModuleBinds {

    @Binds
    abstract fun bindCityWeatherRepository(repository: CityWeatherRepository): ICityWeatherRepository
}