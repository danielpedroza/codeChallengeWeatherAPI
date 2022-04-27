package fps.daniel.codechallengeweatherapi.ui.cityWeather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import fps.daniel.codechallengeweatherapi.MainActivity
import fps.daniel.codechallengeweatherapi.R
import fps.daniel.codechallengeweatherapi.databinding.FragmentCityWeatherBinding
import fps.daniel.codechallengeweatherapi.resource.Status
import fps.daniel.codechallengeweatherapi.ui.cityWeather.viewModel.CityWeatherViewModel
import fps.daniel.codechallengeweatherapi.utils.showAlert

@AndroidEntryPoint
class CityWeatherFragment : Fragment() {

    private lateinit var binding: FragmentCityWeatherBinding
    private lateinit var viewModel: CityWeatherViewModel
    private val args: CityWeatherFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityWeatherBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(CityWeatherViewModel::class.java)
        getCityWeatherDescription()
        return binding.root
    }

    private fun getCityWeatherDescription() {
        viewModel.getCityWeather(args.passingName).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when(resource.status) {
                    Status.SUCCESS -> {
                        hideProgressBar()
                        showItems()
                        verifyCityImage(args.passingName)
                        binding.textView2.text = resource.data?.body()?.name
                        binding.textView3.text = getString(R.string.feels_like, resource.data?.body()?.main?.feels_like.toString())
                        binding.textView4.text = getString(R.string.temp_min, resource.data?.body()?.main?.temp_min.toString())
                        binding.textView5.text = getString(R.string.temp_max,  resource.data?.body()?.main?.temp_max.toString())
                        binding.textView6.text = getString(R.string.wind_speed, resource.data?.body()?.wind?.speed.toString())
                        binding.textView7.text = getString(R.string.weather_description, resource.data?.body()!!.weather[0].description)
                    }
                    Status.ERROR -> {
                        hideProgressBar()
                        hideItems()
                        showAlert(
                            activity,
                            binding.root,
                            "ERRO"
                        )
                    }
                    Status.LOADING -> {
                        showProgressBar()
                        hideItems()
                    }
                }
            }
        })
    }

    private fun verifyCityImage(city: String){
        when (city) {
            "Lisbon" -> {
                binding.imageView2.setImageResource(R.drawable.background_lisbon)
            }
            "Madrid" -> {
                binding.imageView2.setImageResource(R.drawable.background_madrid)
            }
            "Paris" -> {
                binding.imageView2.setImageResource(R.drawable.background_paris)
            }
            "Berlin" -> {
                binding.imageView2.setImageResource(R.drawable.background_berlin)
            }
            "Copenhagen" -> {
                binding.imageView2.setImageResource(R.drawable.background_copenhagen)
            }
            "Rome" -> {
                binding.imageView2.setImageResource(R.drawable.background_rome)
            }
            "London" -> {
                binding.imageView2.setImageResource(R.drawable.background_london)
            }
            "Dublin" -> {
                binding.imageView2.setImageResource(R.drawable.background_dublin)
            }
            "Prague" -> {
                binding.imageView2.setImageResource(R.drawable.background_prague)
            }
            "Vienna" -> {
                binding.imageView2.setImageResource(R.drawable.background_vienna)
            }
        }
    }

    private fun showItems(){
        binding.imageView2.visibility = View.VISIBLE
        binding.view2.visibility = View.VISIBLE
        binding.textView2.visibility = View.VISIBLE
        binding.textView3.visibility = View.VISIBLE
        binding.textView4.visibility = View.VISIBLE
        binding.textView5.visibility = View.VISIBLE
        binding.textView6.visibility = View.VISIBLE
        binding.textView7.visibility = View.VISIBLE
    }

    private fun hideItems(){
        binding.imageView2.visibility = View.INVISIBLE
        binding.view2.visibility = View.INVISIBLE
        binding.textView2.visibility = View.INVISIBLE
        binding.textView3.visibility = View.INVISIBLE
        binding.textView4.visibility = View.INVISIBLE
        binding.textView5.visibility = View.INVISIBLE
        binding.textView6.visibility = View.INVISIBLE
        binding.textView7.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        (requireActivity() as MainActivity).showProgressBar()
    }

    private fun hideProgressBar() {
        (requireActivity() as MainActivity).hideProgressBar()
    }



}