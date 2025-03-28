package com.example.cropulse_kritrim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.cropulse_kritrim.databinding.ActivityWeatherBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//613a470048821b0bbcdcd0eca93cb54c
class WeatherActivity : AppCompatActivity() {
    private val binding: ActivityWeatherBinding by lazy {
        ActivityWeatherBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backBtn.setOnClickListener {
            finish()
        }
        fetchWeatherData("jaipur")
        searchCity()
    }

    private fun searchCity() {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    fetchWeatherData(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    private fun fetchWeatherData(city:String){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)
        val response = retrofit.getWeatherData(city , "613a470048821b0bbcdcd0eca93cb54c", "metric")
        response.enqueue(object : Callback<WeatherApp>{
            override fun onResponse(p0: Call<WeatherApp>, p1: Response<WeatherApp>) {
                val resposeBody = p1.body()
                if(p1.isSuccessful && resposeBody != null){
                    val temperature = resposeBody.main.temp.toString()
                    val humidity = resposeBody.main.humidity
                    val windSpeed = resposeBody.wind.speed
                    val sunRise = resposeBody.sys.sunrise.toLong()
                    val sunSet = resposeBody.sys.sunset.toLong()
                    val seaLevel = resposeBody.main.sea_level
                    val weather = resposeBody.weather.firstOrNull()?.main?:"unknown"
                    val maxTemp = resposeBody.main.temp_max
                    val minTemp = resposeBody.main.temp_min
                    val condition = resposeBody.weather.firstOrNull()?.main?:"Unknown"
                    //Log.d("Check", "onResponse: $temperature")
                    binding.temperature.text = "$temperature °C"
                    binding.weather.text = weather
                    binding.maxTemp.text = "Max Temp: $maxTemp °C"
                    binding.minTemp.text = "Min Temp: $minTemp °C"
                    binding.humidityTV.text = "$humidity %"
                    binding.windSpeedTV.text = "$windSpeed m/s"
                    binding.sunRiseTV.text = "${time(sunRise)}"
                    binding.sunSetTV.text = "${time(sunSet)}"
                    binding.seaTV.text = "$seaLevel hPa"
                    binding.weatherConditionTV.text = condition
                    binding.dayTV.text = dayName(System.currentTimeMillis())
                    binding.dateTV.text = date()
                    binding.cityName.text = "$city"

                    changeImageWithWeather(condition)

                }
            }

            override fun onFailure(p0: Call<WeatherApp>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun changeImageWithWeather(conditions : String) {
        when (conditions){
            "Clear","Sunny","Clear Sky" ->{
                binding.root.setBackgroundResource(R.drawable.sunnybackground)
                binding.lottieAnimationView.setAnimation(R.raw.sun02)
            }
            "Haze" ->{
                binding.root.setBackgroundResource(R.drawable.cloudybackground)
                binding.lottieAnimationView.setAnimation(R.raw.cloud02)
            }
            "Partly Cloud","Clouds","Overcast","Mist","Foggy"->{
                binding.root.setBackgroundResource(R.drawable.cloudybackground)
                binding.lottieAnimationView.setAnimation(R.raw.cloud02)
            }
            "Light Rain","Drizzle","Moderate Rain","Showers","Heavy Rain"->{
                binding.root.setBackgroundResource(R.drawable.rainybackground)
                binding.lottieAnimationView.setAnimation(R.raw.rain)
            }
            "Light Snow","Moderate Snow","Heavy Snow","Blizzards"->{
                binding.root.setBackgroundResource(R.drawable.snowbackground)
                binding.lottieAnimationView.setAnimation(R.raw.snow)
            }
            else ->{
                binding.root.setBackgroundResource(R.drawable.sunnybackground)
                binding.lottieAnimationView.setAnimation(R.raw.sun02)
            }
        }
        binding.lottieAnimationView.playAnimation()
    }

    private fun dayName(timeStamp : Long): String {
        val sdf = SimpleDateFormat("EEEE" , Locale.getDefault())
        return sdf.format(Date())
    }

    private fun date():String{
        val sdf = SimpleDateFormat("dd MMMM yyyy" , Locale.getDefault())
        return sdf.format(Date())
    }
    private fun time(timeStamp: Long):String{
        val sdf = SimpleDateFormat("HH:mm" , Locale.getDefault())
        return sdf.format(Date(timeStamp*1000))
    }


}