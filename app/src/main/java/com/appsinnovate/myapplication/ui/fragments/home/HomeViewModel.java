package com.appsinnovate.myapplication.ui.fragments.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsinnovate.myapplication.model.get_continent_byId.ContinentByIdResponseModel;
import com.appsinnovate.myapplication.model.get_continent_byId.Country;
import com.appsinnovate.myapplication.network.ApiClient;
import com.appsinnovate.myapplication.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    private Disposable disposable;
    private MutableLiveData<List<Country>> _mutableLiveCountries = new MutableLiveData<>();
    public LiveData<List<Country>> liveCountries = _mutableLiveCountries;
    private List<Country> countriesList = new ArrayList<>();
    private ApiService service = ApiClient.getClient().create(ApiService.class);
    private List<String> continentImageUrls = new ArrayList<>();

    public HomeViewModel() {
        fillContinentImages();
        service.getContinentsIds()
                .flatMap(response -> Observable.fromIterable(response.getContinents_ids()))
                .concatMapEager(this::getContinentById)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ContinentByIdResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(ContinentByIdResponseModel continentByIdResponseModel) {
                        if (!disposable.isDisposed()) {
                            if (continentByIdResponseModel.getStatus() == 1) {
                                countriesList.add(new Country(0, continentByIdResponseModel.getContinent().getContinentName(), continentImageUrls.get(continentByIdResponseModel.getContinent().getId() - 1)));
                                countriesList.addAll(continentByIdResponseModel.getContinent().getCountries());
                                _mutableLiveCountries.setValue(countriesList);
                            } else {
                                Log.e("error", continentByIdResponseModel.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void fillContinentImages() {
        //africa
        continentImageUrls.add("https://www.smartertravel.com/uploads/2017/08/Africa-Hero-1400x500.jpg");
        //asia
        continentImageUrls.add("https://www.nationalgeographic.com/content/dam/expeditions/destinations/asia/Asia/hero-asia.adapt.1900.1.jpg");
        //europe
        continentImageUrls.add("https://www.maxpixel.net/static/photo/1x/Architecture-Europe-City-Landmark-Stockholm-Sweden-455787.jpg");
        //north
        continentImageUrls.add("https://www.uhcglobal.com/media/1113/global_markets_northamerica_.jpg?crop=0,0,0,0&cropmode=percentage&width=840&height=420&rnd=132107864460000000");
        //south
        continentImageUrls.add("http://www.orangejourneys.com.au/cproot/6849/10/South-America_w1920_w2000.jpg");
    }

    private Observable<ContinentByIdResponseModel> getContinentById(Integer id) {
        return service.getContinentsByIds(id);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}