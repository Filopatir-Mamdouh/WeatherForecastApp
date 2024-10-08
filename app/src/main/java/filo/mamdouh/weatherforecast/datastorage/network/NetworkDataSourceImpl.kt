package filo.mamdouh.weatherforecast.datastorage.network

import filo.mamdouh.weatherforecast.models.CurrentWeather
import filo.mamdouh.weatherforecast.models.Location
import filo.mamdouh.weatherforecast.models.SearchRoot
import filo.mamdouh.weatherforecast.models.WeatherForecast
import retrofit2.Response

class NetworkDataSourceImpl : NetworkDataSource {
    private val api : ApiServices = RetrofitClient.apiServices
    override suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
        units: String
    ): Response<CurrentWeather> = api.getCurrentWeather(lat,lon,units)


    override suspend fun getWeatherForecast(
        lat: Double,
        lon: Double,
        units: String
    ): Response<WeatherForecast> = api.getWeatherForecast(lat,lon,units)

    override suspend fun getLocationByName(name: String, limit : Int): Response<SearchRoot> {
        return api.getLocationByName("https://api.api-ninjas.com/v1/city/",name, limit)
    }

    override suspend fun getLocationByCoordinates(lat: Double, lon: Double): Response<Location> {
        return api.getLocationByCoordinates(lat,lon)
    }

}