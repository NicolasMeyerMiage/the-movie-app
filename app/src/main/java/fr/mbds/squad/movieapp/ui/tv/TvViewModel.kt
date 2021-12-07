package fr.mbds.squad.movieapp.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.mbds.squad.idbdata.data.Category
import fr.mbds.squad.idbdata.data.Token
import fr.mbds.squad.idbdata.data.Tv
import fr.mbds.squad.idbdata.repository.TvRepository
import fr.mbds.squad.idbdata.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvViewModel(private val repository: TvRepository) : ViewModel() {

    private val _token: MutableLiveData<Token> = MutableLiveData()
    val token: LiveData<Token>
        get() = _token

    private val _categories: MutableLiveData<List<Category>> = MutableLiveData()
    val categories: LiveData<List<Category>>
        get() = _categories

    private val _tvs: MutableLiveData<List<Tv>> = MutableLiveData()
    val tvs: LiveData<List<Tv>>
        get() = _tvs

    private val _tv: MutableLiveData<Tv> = MutableLiveData()
    val tv: LiveData<Tv>
        get() = _tv

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    init {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getToken()) {
                is Result.Succes -> {
                    _token.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    fun getTvCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTvCategories()) {
                is Result.Succes -> {
                    _categories.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    fun getTvsByCategoryId(categoryId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTvsByCategoryId(categoryId)) {
                is Result.Succes -> {
                    _tvs.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    fun getTvById(tvId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTvById(tvId)) {
                is Result.Succes -> {
                    _tv.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }
}
